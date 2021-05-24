package top.monoliths.kernel;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import com.deepoove.poi.XWPFTemplate;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import top.monoliths.frame.FrameScene;
import top.monoliths.frame.RoleDialogue;
import top.monoliths.frame.SceneDescription;
import top.monoliths.frame.SoundItem;
import top.monoliths.frame.SoundItem.FREQUENCY;

/**
 * @since 1.0
 * @author monoliths
 */
public class TextInterpreter {

    public static Log log = LogFactory.getLog(TextInterpreter.class);

    public static enum TEXTTYPE {
        FRAMESCENE, ROLADIALOGUE, SCENEDESCRIPTION, SOUNDITEM, UNKNOWNTYPE
    }

    /**
     * word file path of local memore
     */
    private String wordInputPath;

    /**
     * word paragraphs
     */
    private ArrayList<XWPFParagraph> wordData;

    /**
     * text line of word
     */
    private ArrayList<String> textLines;

    /**
     * to setting wordPath
     * 
     * @param wordPath
     */
    public void setWordPath(String wordPath) {
        this.wordInputPath = wordPath;
    }

    /**
     * to get setting wordPath
     * 
     * @return {@String}
     */
    public String getWordPath() {
        return wordInputPath;
    }

    /**
     * from word file data format to text list
     * 
     * @param wordPath word file's path position only support local
     * @throws FileNotFoundException if file not exist
     * @throws EOFException          file read error
     * @throws NullPointerException  wordPath is null or file is null
     */
    public TextInterpreter(String wordPath)
            throws FileNotFoundException, IOException, EOFException, NullPointerException {
        // construct a template of word
        XWPFTemplate template = XWPFTemplate.compile(wordPath);
        // get paragraphs to wordData
        wordData = new ArrayList<>(template.getXWPFDocument().getParagraphs());
        // construct a List
        textLines = new ArrayList<>();

        // ergodic word line
        wordData.forEach((line) -> {
            // filter special characters
            String textLine = Pattern.compile("\\s*|\t|\r|\n|　").matcher(line.getText()).replaceAll("");
            // if line not null
            if (textLine != null && !textLine.equals("")) {
                // add text to list
                textLines.add(textLine);
            }
        });
    }

    /**
     * 
     * 
     * @return
     * @throws NullPointerException
     */
    public JsonArray toJsonArray() throws NullPointerException {
        JsonArray result = new JsonArray();
        textLines.forEach((textLine) -> {
            Gson gson = new Gson();
            String[] dt;
            switch (getTextType(textLine)) {
                case FRAMESCENE:
                    dt = textLine.split("【")[1].split("】")[0].split("：");
                    result.add(gson.toJsonTree(new FrameScene(dt[1])));
                    break;
                case ROLADIALOGUE:
                    dt = textLine.split("：");
                    String name = dt[0];
                    String[] tdt = dt[1].split("（");
                    String[] aside = new String[1];
                    if (tdt.length > 1) {
                        String[] rdt = tdt[1].split("）");
                        aside[0] = rdt[0];
                    }
                    String section = tdt[0];
                    result.add(gson.toJsonTree(new RoleDialogue(name, section, aside)));
                    break;
                case SCENEDESCRIPTION:
                    dt = textLine.split("（");
                    String[] rdt = dt[1].split("）");
                    String description = rdt[0];
                    result.add(gson.toJsonTree(new SceneDescription(description)));
                    break;
                case SOUNDITEM:
                    dt = textLine.split("【")[1].split("】");
                    String soundName = dt[0].split("：")[1];
                    result.add(gson.toJsonTree(new SoundItem(soundName, FREQUENCY.AROUND)));
                    break;
                case UNKNOWNTYPE:
                    log.warn("ignor: " + textLine);
                    break;
                default:
                    log.warn("ignor: " + textLine);
                    // unknown type
                    break;
            }
            gson = null;
        });
        return result;
    }

    public String toJson() {
        // from toJson load data
        JsonObject data = new JsonObject();
        // format json
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        // create margin element
        data.add("frameList", toJsonArray());
        // get string result
        return gson.toJson(data);
    }

    /**
     * write json data to file
     * 
     * @param jsonOutputPath json file position
     * @return
     * @throws IOException
     * @throws NullPointerException
     * @throws EOFException
     */
    public String toJson(String jsonOutputPath) throws IOException, NullPointerException, EOFException {
        // create file stream
        FileWriter jsonOutputFile = new FileWriter(jsonOutputPath);
        // get data from toJson
        String result = toJson();
        // write to file
        jsonOutputFile.write(result);
        // close file stream
        jsonOutputFile.close();
        // return String of json
        return result;
    }

    /**
     * from text find feature and return type of TEXTTYPE
     * 
     * ##prepar to use regex on next version
     * 
     * @param text an {@String} text line from word file
     * @return a type of TEXTTYPE {@TEXTTYPE}
     */
    public TEXTTYPE getTextType(String text) {
        // use 【 to split string
        String[] actions = text.split("【");
        // true of 【
        if (actions.length > 1) {
            // use ： to split string
            String[] tags = actions[1].split("：");
            if (tags.length > 1) {
                switch (tags[0]) {
                    case "场景":
                        // 场景
                        return TEXTTYPE.FRAMESCENE;
                    case "音乐":
                        // 音乐
                        return TEXTTYPE.SOUNDITEM;
                    default:
                        // use ： to split string
                        actions = text.split("：");
                        if (actions.length > 1) {
                            // 角色对话
                            return TEXTTYPE.ROLADIALOGUE;
                        } else {
                            // unknown type
                            return TEXTTYPE.UNKNOWNTYPE;
                        }
                }
            } else {
                return TEXTTYPE.UNKNOWNTYPE;
            }
        } else {
            actions = text.split("：");
            if (actions.length > 1) {
                // 角色对话
                return TEXTTYPE.ROLADIALOGUE;
            }
            actions = text.split("（");
            // use （ to split string
            if (actions.length > 1) {
                // use ： to split string
                String[] tags = actions[1].split("：");
                if (tags.length <= 1) {
                    // 场景描写
                    return TEXTTYPE.SCENEDESCRIPTION;
                }
            }
            return TEXTTYPE.UNKNOWNTYPE;
        }
    }
}
