package top.monoliths.frame;

public class SoundItem {

    /**
     * music name
     */
    private String name;

    /**
     * voice play mode
     */
    private FREQUENCY around;
    
    public void setAround(FREQUENCY around) {
        this.around = around;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FREQUENCY getAround() {
        return around;
    }

    public String getName() {
        return name;
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

enum FREQUENCY {
    ONLYONCE,
    AROUND
}