public class BlastMapping extends BasicFeature {
    private Block queryBlock;
    private Block subjectBlock;
    
    public BlastMapping(Block queryBlock, Block subjectBlock, float percentIden) {
        this.queryBlock = queryBlock;
        this.subjectBlock = subjectBlock;
        this.setStart(Math.min(queryBlock.getStart(), queryBlock.getEnd()));
        this.setEnd(Math.max(queryBlock.getStart(), queryBlock.getEnd()));
        this.setName("[" + subjectBlock.getContig() + ":" + subjectBlock.getStart() + "-" + subjectBlock.getEnd() + "]");
        this.setScore(percentIden);
    }
    public Block getQueryBlock() {
        return queryBlock;
    }
    public Block getSubjectBlock() {
        return subjectBlock;
    }
    @Override
    public String getChr() {
        return queryBlock.getContig();
    }
    public Strand getStrand() {
        return subjectBlock.getStrand();
    }
    public boolean containsQueryPosition(String contig, int position) {
        return queryBlock.containsPosition(contig, position);
    }
    
    public static class Block {
        private String contig;
        private int start;
        private int end;
        Strand strand;
        
        public Block(String contig, int start, int end, Strand strand) {
            this.contig = contig;
            this.start = start;
            this.end = end;
            this.strand = strand;
        }
        public String getContig() {
            return contig;
        }
        public int getStart() {
            return start;
        }
        public int getEnd() {
            return end;
        }
        public Strand getStrand() {
            return strand;
        }
        public boolean containsPosition(String contig, int position) {
            return this.contig.equals(contig) && position >= start && position < end;
        }
    }
}