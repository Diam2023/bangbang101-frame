package top.monoliths.frame;


/**
 * @version 1.0
 * @author monoliths
 */
public class SceneDescription {
    /**
     * an scene discryption paragraph
     */
    private String description;

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    /**
     * just an scene discryption paragraph
     * 
     * @param description
     */
    public SceneDescription(String description) {
        setDescription(description);
    }
}
