package top.monoliths.frame;

/**
 * role dialogue
 * 
 * @version 1.0
 * @author monoliths
 */
public class RoleDialogue {

    @SuppressWarnings("unused")
    private final String type = getClass().getSimpleName().replaceFirst(
            String.valueOf(getClass().getSimpleName().charAt(0)),
            String.valueOf(getClass().getSimpleName().charAt(0)).toLowerCase());

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
     * default auto stay time limit
     */
    private Integer delay;

    public Integer getDelay() {
        return delay;
    }

    public String[] getAside() {
        return aside;
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
        setVerticalDrawing(null);
    }

    /**
     * #3
     * complate add
     * 
     * @param name character name
     * @param verticalDrawing character header
     * @param section character words
     * @param aside list of character's expression and action
     */
    public RoleDialogue(String name, String verticalDrawing, String section, String[] aside) {
        setName(name);
        setVerticalDrawing(verticalDrawing);
        setSection(section);
        setAside(aside);
    }

}
