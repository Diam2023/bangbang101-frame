package top.monoliths.frame;

public class SoundItem {

    @SuppressWarnings("unused")
    private final String type = getClass().getSimpleName().replaceFirst(
            String.valueOf(getClass().getSimpleName().charAt(0)),
            String.valueOf(getClass().getSimpleName().charAt(0)).toLowerCase());

    public static enum FREQUENCY {
        ONLYONCE, AROUND
    }

    /**
     * music name
     */
    private String soundName;

    /**
     * voice play mode
     */
    private FREQUENCY around;

    public void setAround(FREQUENCY around) {
        this.around = around;
    }

    public void setName(String name) {
        this.soundName = name;
    }

    public FREQUENCY getAround() {
        return around;
    }

    public String getName() {
        return soundName;
    }

    /**
     * offer sound default once
     * 
     * @param name
     */
    public SoundItem(String name) {
        setAround(FREQUENCY.ONLYONCE);
        setName(name);
    }

    /**
     * offer sound and index frequency
     * 
     * @param name
     * @param around
     */
    public SoundItem(String name, FREQUENCY around) {
        setAround(around);
        setName(name);
    }

}
