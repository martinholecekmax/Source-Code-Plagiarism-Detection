public class BlurMaskFilter_Delegate extends MaskFilter_Delegate {
            @Override
    public boolean isSupported() {
        return false;
    }
    @Override
    public String getSupportMessage() {
        return "Blur Mask Filters are not supported.";
    }
        @LayoutlibDelegate
     static int nativeConstructor(float radius, int style) {
        BlurMaskFilter_Delegate newDelegate = new BlurMaskFilter_Delegate();
        return sManager.addNewDelegate(newDelegate);
    }
    }