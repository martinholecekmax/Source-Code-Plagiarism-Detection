final class Prism2Record {
    static final int HDR_LENGTH = 4;
    
    static final int getRecordLength(byte[] src, int srcOfs) {
        return LittleEndian.getInt16(src, srcOfs + 0);
    }
    
    static final void setRecordLength(byte[] dst, int dstOfs, int recordLength) {
        LittleEndian.setInt16(dst, dstOfs + 0, recordLength);
    }
    
    static final int getRecordRID(byte[] src, int srcOfs) {
        return LittleEndian.getInt16(src, srcOfs + 2);
    }
    
    static final void setRecordRID(byte[] dst, int dstOfs, int rid) {
        LittleEndian.setInt16(dst, dstOfs + 2, rid);
    }
}