public interface IMocksControl {
    
    <T> T createMock(Class<T> toMock);
    
    <T> T createMock(String name, Class<T> toMock);
    
    void reset();
    
    void resetToNice();
    
    void resetToDefault();
    
    void resetToStrict();
    
    void replay();
    
    void verify();
    
    void checkOrder(boolean state);
    
    void makeThreadSafe(boolean threadSafe);
    
    void checkIsUsedInOneThread(boolean shouldBeUsedInOneThread);
}