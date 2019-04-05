public class FileProxyProteinSequenceCreator implements
        SequenceCreatorInterface<AminoAcidCompound> {
    CompoundSet<AminoAcidCompound> compoundSet = null;
    File fastaFile = null;
    
    public FileProxyProteinSequenceCreator(File fastaFile,
            CompoundSet<AminoAcidCompound> compoundSet) {
        this.compoundSet = compoundSet;
        this.fastaFile = fastaFile;
    }
    
    public AbstractSequence<AminoAcidCompound> getSequence(String sequence,
            long index) {
        SequenceFileProxyLoader<AminoAcidCompound> sequenceFileProxyLoader = new SequenceFileProxyLoader<AminoAcidCompound>(
                fastaFile, new FastaSequenceParser(), index, sequence.length(),
                compoundSet);
        return new ProteinSequence(sequenceFileProxyLoader, compoundSet);
    }
    
    public AbstractSequence<AminoAcidCompound> getSequence(
            ProxySequenceReader<AminoAcidCompound> proxyLoader, long index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public AbstractSequence<AminoAcidCompound> getSequence(
            List<AminoAcidCompound> list) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}