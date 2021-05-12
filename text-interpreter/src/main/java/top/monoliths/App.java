package top.monoliths;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

import com.deepoove.poi.XWPFTemplate;
import com.google.gson.Gson;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import top.monoliths.frame.RoleDialogue;
import top.monoliths.frame.SceneDescription;

public class App {

    public static Log log = LogFactory.getLog(App.class);

    public static void main(String[] args) {
        Gson gson = new Gson();

        try (XWPFTemplate template = XWPFTemplate
                .compile("C:\\Users\\Administrator\\Downloads\\冰川三明治.台词版-release.docx");
                FileWriter fWriter = new FileWriter("output.txt")) {
            template.getXWPFDocument().getParagraphs().forEach((els) -> {
                if (els != null) {
                    try {
                        // text line analyze business logic
                        String line = Pattern.compile("\\s*|\t|\r|\n|　").matcher(els.getText()).replaceAll("");
                        if (line != null && !line.equals("")) {
                            String[] dialogSplit = line.split("：");
                            if (dialogSplit.length <= 1) {
                                // is not dialog
                                String[] sceneRight = line.split("（");
                                if (sceneRight.length > 1) {
                                    // have scene description
                                    String[] sceneLeft = sceneRight[1].split("）");
                                    String sceneBody = sceneLeft[0];

                                    new SceneDescription(sceneBody); //

                                } else {
                                    // ignore
                                }
                            } else {
                                String head = dialogSplit[0];
                                String body = dialogSplit[1];
                                String[] asideBody = null;
                                String[] effectBody = null;

                                String[] asideRight = line.split("（");
                                if (asideRight.length > 1) {
                                    // have frame scene
                                    String[] asideLeft = asideRight[1].split("）");
                                    asideBody = new String[]{asideLeft[0]};
                                }
                                new RoleDialogue(head, body, asideBody, effectBody); //
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
