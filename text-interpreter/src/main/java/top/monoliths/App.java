package top.monoliths;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

import com.deepoove.poi.XWPFTemplate;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import top.monoliths.frame.RoleDialogue;
import top.monoliths.frame.SceneDescription;

public class App {

    public static Log log = LogFactory.getLog(App.class);

    public static void main(String[] args) {
        JsonObject data = new JsonObject();
        JsonArray bodyList = new JsonArray();

        try (XWPFTemplate template = XWPFTemplate
                .compile("C:\\Users\\Administrator\\Downloads\\冰川三明治.台词版-release.docx");
                FileWriter textOutputFile = new FileWriter("textOutputFile.txt");
                FileWriter jsonOutputFile = new FileWriter("jsonOutputFile.json");
                FileWriter ignoreOutputFile = new FileWriter("ignoreOutputFile.txt");) {
                    template.getXWPFDocument().getParagraphs();
            template.getXWPFDocument().getParagraphs().forEach((els) -> {
                if (els != null) {
                    try {
                        // text line analyze business logic
                        String line = Pattern.compile("\\s*|\t|\r|\n|　").matcher(els.getText()).replaceAll("");
                        if (line != null && !line.equals("")) {
                            // if not null
                            Gson element = new Gson();
                            String[] dialogSplit = line.split("：");
                            if (dialogSplit.length <= 1) {
                                // is not dialog
                                String[] sceneRight = line.split("（");
                                if (sceneRight.length > 1) {
                                    // have scene description
                                    String[] sceneLeft = sceneRight[1].split("）");
                                    String sceneBody = sceneLeft[0];
                                    JsonElement el = element.toJsonTree(new SceneDescription(sceneBody));
                                    bodyList.add(el);
                                    // bodyList.add(el);

                                    // log.info(el);

                                    element = null;

                                } else {
                                    log.info("ignore: " + line);
                                    ignoreOutputFile.write(line + "\n");
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
                                
                                JsonElement el = element.toJsonTree(new RoleDialogue(head, body, asideBody, effectBody));
                                bodyList.add(el);

                                // log.info(el);

                                element = null;
                            }
                            // output to text
                            textOutputFile.write(line + "\n");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            // use Gson to format output
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            data.add("frameList", bodyList);
            jsonOutputFile.write(gson.toJson(data));
        } catch (FileNotFoundException e) {
            log.error("err", e.fillInStackTrace());
            e.printStackTrace();
        } catch (Exception e) {
            log.error("err", e.fillInStackTrace());
            e.printStackTrace();
        }
    }
}
