package top.monoliths.ws;

import java.io.FileNotFoundException;

import com.google.gson.JsonSyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import top.monoliths.ws.kernel.LaunchServer;

/**
 * start server
 *
 */
public class App {
    
    private static final Logger LOG = LoggerFactory.getLogger(App.class);
    public static void main(String[] args) {
        LOG.info("start http server");
        try {
            LaunchServer.launch();
        } catch (JsonSyntaxException e) {
            LOG.error("config json format error", e);
        } catch (FileNotFoundException e) {
            LOG.error("config data file not found", e);
        } catch (Exception e) {
            LOG.error("anothor type error: ", e);
        }
    }
}
