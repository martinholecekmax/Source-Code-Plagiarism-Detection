public interface DigestableToroidalLifeField {
    
    public boolean isAlive(int x, int y);
    
    public int getWidth();
    
    public int getHeight();
    
    public void setState(int x, int y, boolean state);
    
    public void nextGeneration();
    
    public byte[] getDigest();
}