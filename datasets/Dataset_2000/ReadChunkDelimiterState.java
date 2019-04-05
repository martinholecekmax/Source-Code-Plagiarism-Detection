public class ReadChunkDelimiterState extends State<Object> {
	public ReadChunkDelimiterState(String name) {
		super(name);
	}
	@Override
	public void onEntry(ChannelBuffer buffer, IcapMessageDecoder icapMessageDecoder) throws DecodingException {
	}
	@Override
	public StateReturnValue execute(ChannelBuffer buffer, IcapMessageDecoder icapMessageDecoder) throws DecodingException {
        for (;;) {
            byte next = buffer.readByte();
            if (next == IcapCodecUtil.CR) {
                if (buffer.readByte() == IcapCodecUtil.LF) {
                    return StateReturnValue.createIrrelevantResult();
                }
            } else if (next == IcapCodecUtil.LF) {
                return StateReturnValue.createIrrelevantResult();
            }
        }
	}
	@Override
	public StateEnum onExit(ChannelBuffer buffer, IcapMessageDecoder icapMessageDecoder, Object decisionInformation) throws DecodingException {
		return StateEnum.READ_CHUNK_SIZE_STATE;
	}
}