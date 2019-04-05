public class MVChunk {
    public int x;
    public int z;
    public MVChunk(Chunk ch){
        this.x = ch.getX();
        this.z = ch.getZ();
    }
    public MVChunk(int x, int z){
        this.x = x;
        this.z = z;
    }
    @Override
    public int hashCode(){
        return ( (x&0xFFFF) <<16) + (z&0xFFFF);
    }
    @Override
    public boolean equals(Object e){
        return (e instanceof MVChunk) && (e.hashCode()==hashCode());
    }
}