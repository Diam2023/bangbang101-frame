package top.monoliths.frame;

/**
 * frame scene
 * 
 * @version 1.0
 * @author monoliths
 */
public class FrameScene {
    /**
     * background image
     */
    private String background;
    
    /**
     * delay time to show
     */
    private Long delayTime;

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

    public Long getDelayTime() {
        return delayTime;
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

    public void setDelayTime(Long delayTime) {
        this.delayTime = delayTime;
    }

    public void setExpressInType(TransitionType expressInType) {
        this.expressInType = expressInType;
    }

    public void setExpressOutType(TransitionType expressOutType) {
        this.expressOutType = expressOutType;
    }
    
    /**
     * set background and delay
     * @param background image path
     * @param delay time pan sec
     */
    public FrameScene(String background, Long delay) {
        setBackground(background);
        setDelayTime(delayTime);
        setExpressInType(TransitionType.FEED);
        setExpressOutType(TransitionType.FEED);
    }

    /**
     * set background and delay
     * @param background image path
     * @param delay time pan sec
     */
    public FrameScene(String background, Long delay, TransitionType in, TransitionType out) {
        setBackground(background);
        setDelayTime(delayTime);
        setExpressInType(in);
        setExpressOutType(out);
    }

}

enum TransitionType {
    FEED,
    ROTATE,
    SCALE,
    TRANSLATION
}
