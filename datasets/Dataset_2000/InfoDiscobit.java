public class InfoDiscobit {
	private GraphNode infoBit;
	
	public static InfoDiscobit createInstance(GraphNode node) {
		Lock l = node.readLock();
		l.lock();
		try {
			Iterator<Resource> types = node.getObjects(RDF.type);
			while(types.hasNext()) {
				if (types.next().equals(DISCOBITS.InfoDiscoBit)){
					return new InfoDiscobit(node);
				}
			}
			return null;
		} finally {
			l.unlock();
		}
	}
	InfoDiscobit(GraphNode infoBit) {
		this.infoBit = infoBit;
	}
	public String getContentType() {
		Lock readLock = infoBit.readLock();
		readLock.lock();
		try {
			Iterator<Literal> mediaTypeLits = infoBit.getLiterals(DISCOBITS.mediaType);
			if (mediaTypeLits.hasNext()) {
				return mediaTypeLits.next().getLexicalForm();
			}
		} finally {
			readLock.unlock();
		}
		return null;
	}
	public byte[] getData() {
		byte[] result = null;
		Lock readLock = infoBit.readLock();
		readLock.lock();
		try {
			Iterator<Literal> mediaTypeLits = infoBit.getLiterals(DISCOBITS.infoBit);
			if (mediaTypeLits.hasNext()) {
				final Literal literalValue = mediaTypeLits.next();
				if (literalValue instanceof TypedLiteral) {
					result = LiteralFactory.getInstance().createObject(
							(new byte[0]).getClass(), (TypedLiteral) literalValue);
				}
			}
		} finally {
			readLock.unlock();
		}		
		return result;	
	};
}