public class SessionReceiveLargeMessage extends PacketImpl
{
   private MessageInternal message;
   
   private long largeMessageSize;
   private long consumerID;
   private int deliveryCount;
      public SessionReceiveLargeMessage()
   {
      super(PacketImpl.SESS_RECEIVE_LARGE_MSG);
      this.message = new ClientLargeMessageImpl();
   }
   public SessionReceiveLargeMessage(final long consumerID,
                                     final MessageInternal message,
                                     final long largeMessageSize,
                                     final int deliveryCount)
   {
      super(PacketImpl.SESS_RECEIVE_LARGE_MSG);
      this.consumerID = consumerID;
      this.message = message;
      this.deliveryCount = deliveryCount;
      this.largeMessageSize = largeMessageSize;
   }
   public MessageInternal getLargeMessage()
   {
      return message;
   }
   public long getConsumerID()
   {
      return consumerID;
   }
   public int getDeliveryCount()
   {
      return deliveryCount;
   }
   
   public long getLargeMessageSize()
   {
      return largeMessageSize;
   }
   @Override
   public void encodeRest(final HornetQBuffer buffer)
   {
      buffer.writeLong(consumerID);
      buffer.writeInt(deliveryCount);
      buffer.writeLong(largeMessageSize);
      message.encodeHeadersAndProperties(buffer);
   }
   @Override
   public void decodeRest(final HornetQBuffer buffer)
   {
      consumerID = buffer.readLong();
      deliveryCount = buffer.readInt();
      largeMessageSize = buffer.readLong();
      message.decodeHeadersAndProperties(buffer);
      ((ClientLargeMessageInternal)message).setLargeMessageSize(largeMessageSize);
   }
}