package top.monoliths.ti.frame;


/**
 * @version 1.0
 * @author monoliths
 */
public class SceneDescription {

    @SuppressWarnings("unused")
    private final String type = getClass().getSimpleName().replaceFirst(
            String.valueOf(getClass().getSimpleName().charAt(0)),
            String.valueOf(getClass().getSimpleName().charAt(0)).toLowerCase());

    /**
     * an scene discryption paragraph
     */
    private String description;

    /**
     * delay time
     */
    private Integer delay;

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    public String getDescription() {
        return description;
    }

    public Integer getDelay() {
        return delay;
    }
    
    /**
     * just an scene discryption paragraph
     * 
     * @param description
     */
    public SceneDescription(String description) {
        setDescription(description);
    }

    /**
     * just an scene discryption paragraph
     * 
     * @param description
     * @param delay
     */
    public SceneDescription(String description, Integer delay) {
        setDelay(delay);
        setDescription(description);
    }
    
}
