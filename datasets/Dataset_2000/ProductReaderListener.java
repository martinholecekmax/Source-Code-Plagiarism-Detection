public interface ProductReaderListener {
    
    boolean handleBandRasterLineRead(Band destBand,
                                     int destOffsetX, int destOffsetY,
                                     int destWidth, int destHeight,
                                     ProductData destBuffer, int destBufferPos);
    
    boolean handleBandRasterRectRead(Band destBand,
                                     int destOffsetX, int destOffsetY,
                                     int destWidth, int destHeight,
                                     ProductData destBuffer);
}