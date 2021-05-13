package top.monoliths.kernel;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import com.deepoove.poi.XWPFTemplate;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;

/**
 * @since 1.0
 * @author monoliths
 */
public class TextInterpreter {

    /**
     * word file path of local memore
     */
    private String wordInputPath;

    /**
     * word paragraphs
     */
    private List<XWPFParagraph> wordData;

    /**
     * text line of word
     */
    private List<String> textLines;

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
    public TextInterpreter(String wordPath) throws FileNotFoundException, IOException, EOFException, NullPointerException {
        // construct a template of word
        XWPFTemplate template = XWPFTemplate.compile(wordPath);
        // get paragraphs to wordData
        wordData = template.getXWPFDocument().getParagraphs();
        // construct a List
        textLines = List.of();
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
        textLines.forEach((textLine) -> {
            switch (getTextType(textLine)) {
                case FRAMESCENE:
                    break;
                case ROLADIALOGUE:
                    break;
                case SCENEDESCRIPTION:
                    break;
                case UNKNOWNTYPE:
                    break;
                default:
                    // unknown type
                    break;
            }
        });
        return null;
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
                        return TEXTTYPE.UNKNOWNTYPE;
                }
            } else {
                // aside ignore line
                return TEXTTYPE.UNKNOWNTYPE;
            }
        } else {
            actions = text.split("（");
            // use （ to split string
            if (actions.length > 1) {
                // use ： to split string
                String[] tags = actions[1].split("：");
                if (tags.length > 1) {
                    // 角色对话
                    return TEXTTYPE.ROLADIALOGUE;
                } else {
                    // 场景描写
                    return TEXTTYPE.SCENEDESCRIPTION;
                }
            } else {
                // aside ignore line
                return TEXTTYPE.UNKNOWNTYPE;
            }
        }
    }
}

enum TEXTTYPE {
    FRAMESCENE, ROLADIALOGUE, SCENEDESCRIPTION, SOUNDITEM, UNKNOWNTYPE
}
