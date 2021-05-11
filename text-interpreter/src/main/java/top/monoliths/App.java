package top.monoliths;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

import com.deepoove.poi.XWPFTemplate;
import com.google.gson.Gson;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class App {

    public static Log log = LogFactory.getLog(App.class);

    public static void main(String[] args) {

        String sl = ": AIWdjnk";
        String[] sld = sl.split(":");
        
        log.info(sld.length);

        Gson gson = new Gson();

        try (XWPFTemplate template = XWPFTemplate
                .compile("C:\\Users\\Administrator\\Downloads\\冰川三明治.台词版-release.docx");
                FileWriter fWriter = new FileWriter("output.txt")) {
            template.getXWPFDocument().getParagraphs().forEach((els) -> {
                if (els != null) {
                    try {
                        String line = Pattern.compile("\\s*|\t|\r|\n|　").matcher(els.getText()).replaceAll("");
                        if (line != null && !line.equals("")) {
                            String[] dataList = line.split("：");
                            if (dataList.length <= 1) {
                                
                            }

                            fWriter.write(line);
                            fWriter.write("\n");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (FileNotFoundException e) {
            log.error("err", e.fillInStackTrace());
            e.printStackTrace();
        } catch (Exception e) {
            log.error("err", e.fillInStackTrace());
            e.printStackTrace();
        }
    }
}
