package top.monoliths.frame;

/**
 * frame scene
 * 
 * @version 1.0
 * @author monoliths
 */
public class FrameScene {

    @SuppressWarnings("unused")
    private final String type = getClass().getSimpleName().replaceFirst(
            String.valueOf(getClass().getSimpleName().charAt(0)),
            String.valueOf(getClass().getSimpleName().charAt(0)).toLowerCase());

    /**
     * background image
     */
    private String background;

    /**
     * in express
     */
    private TransitionType expressInType;

    /**
     * out express
     */
    private TransitionType expressOutType;

    public String getBackground() {
        return background;
    }

    public TransitionType getExpressInType() {
        return expressInType;
    }

    public TransitionType getExpressOutType() {
        return expressOutType;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public void setExpressInType(TransitionType expressInType) {
        this.expressInType = expressInType;
    }

    public void setExpressOutType(TransitionType expressOutType) {
        this.expressOutType = expressOutType;
    }

    /**
     * set background and delay
     * 
     * @param background image path
     */
    public FrameScene(String background) {
        setBackground(background);
        setExpressInType(TransitionType.FEED);
        setExpressOutType(TransitionType.FEED);
    }

    /**
     * set background and delay
     * 
     * @param background image path
     * @param delay      time pan sec
     */
    public FrameScene(String background, TransitionType in, TransitionType out) {
        setBackground(background);
        setExpressInType(in);
        setExpressOutType(out);
    }

}

enum TransitionType {
    FEED, ROTATE, SCALE, TRANSLATION
}
