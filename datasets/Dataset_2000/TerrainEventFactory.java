public class TerrainEventFactory implements AllBinaryEventObjectFactoryInterface
{
    public TerrainEventFactory()
    {
    }
    public AllBinaryEventObject getInstance()
    {
        return new TerrainEvent();
    }
}