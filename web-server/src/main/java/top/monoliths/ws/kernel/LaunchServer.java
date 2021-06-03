package top.monoliths.ws.kernel;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import top.monoliths.ws.server.HttpServer;

public class LaunchServer {
    private static final String configPath = "web-config.json";

    private static final Log LOG = LogFactory.getLog(LaunchServer.class);

    public static void launch() throws JsonSyntaxException, FileNotFoundException, EOFException, IOException, Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(configPath)));
        StringBuffer data = new StringBuffer();
        bufferedReader.lines().forEach(line -> {
            // filter special characters
            String textLine = Pattern.compile("\\s*|\t|\r|\n|　").matcher(line).replaceAll("");
            // if line not null
            if (textLine != null && !textLine.equals("")) {
                // add text to list
                data.append(textLine);
            }
        });
        bufferedReader.close();

        /**
         * load config data inctance
         */
        Gson gson = new Gson();
        ConfigData configData = gson.fromJson(data.toString(), ConfigData.class);
        LOG.info(configData.toString());

        /**
         * get HttpServer Inctance and run
         */
        HttpServer server = new HttpServer(configData);
        server.start();
    }
}
