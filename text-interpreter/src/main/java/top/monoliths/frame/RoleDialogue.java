package top.monoliths.frame;

/**
 * role dialogue
 * 
 * @version 1.0
 * @author monoliths
 */
public class RoleDialogue {
    /**
     * role's name
     */
    private String name;

    /**
     * role's image
     */
    private String verticalDrawing;

    /**
     * main body sentence
     */
    private String section;

    /**
     * list of character's expression and action
     */
    private String[] aside;

    /**
     * list effect of character's action
     */
    private String[] effect;

    /**
     * default auto stay time limit
     */
    private Integer delay;

    public Integer getDelay() {
        return delay;
    }

    public String[] getAside() {
        return aside;
    }

    public String[] getEffect() {
        return effect;
    }

    public String getName() {
        return name;
    }

    public String getSection() {
        return section;
    }

    public String getVerticalDrawing() {
        return verticalDrawing;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    public void setAside(String[] aside) {
        this.aside = aside;
    }

    public void setEffect(String[] effect) {
        this.effect = effect;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setVerticalDrawing(String verticalDrawing) {
        this.verticalDrawing = verticalDrawing;
    }

    /**
     * #1
     * 
     * @param name character name
     * @param section character words
     */
    public RoleDialogue(String name, String section) {
        setName(name);
        setSection(section);
        setAside(null);
        setEffect(null);
        setVerticalDrawing(null);
    }

    /**
     * #2
     * 
     * @param name character name
     * @param section character words
     * @param aside list of character's expression and action
     */
    public RoleDialogue(String name, String section, String[] aside) {
        setName(name);
        setSection(section);
        setAside(aside);
        setEffect(null);
        setVerticalDrawing(null);
    }

    /**
     * #3
     * 
     * @param name character name
     * @param section character words
     * @param aside list of character's expression and action
     * @param effect list effect of character's action
     */
    public RoleDialogue(String name, String section, String[] aside, String[] effect) {
        setName(name);
        setSection(section);
        setAside(aside);
        setEffect(effect);
        setVerticalDrawing(null);
    }

    /**
     * #4
     * complate add
     * 
     * @param name character name
     * @param verticalDrawing character header
     * @param section character words
     * @param aside list of character's expression and action
     * @param effect list effect of character's action
     */
    public RoleDialogue(String name, String verticalDrawing, String section, String[] aside, String[] effect) {
        setName(name);
        setVerticalDrawing(verticalDrawing);
        setSection(section);
        setAside(aside);
        setEffect(effect);
    }

}
