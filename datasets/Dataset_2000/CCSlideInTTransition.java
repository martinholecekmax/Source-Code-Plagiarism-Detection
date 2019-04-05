public class CCSlideInTTransition extends CCSlideInLTransition {
    public static CCSlideInTTransition transition(float t, CCScene s) {
        return new CCSlideInTTransition(t, s);
    }
    public CCSlideInTTransition(float t, CCScene s) {
        super(t, s);
    }
    public void sceneOrder() {
        inSceneOnTop = false;
    }
    
    protected void initScenes() {
        CGSize s = CCDirector.sharedDirector().winSize();
        inScene.setPosition(0, s.height-ADJUST_FACTOR);
    }
    @Override
    public CCIntervalAction action() {
        CGSize s = CCDirector.sharedDirector().winSize();
        return CCMoveBy.action(duration, CGPoint.make(0,-(s.height-ADJUST_FACTOR)));
    }
}