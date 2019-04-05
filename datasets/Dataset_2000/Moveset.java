public class MoveSet implements Serializable {
    
	@ElementArray
    private String[][] m_moves = null;
    
	@ElementArray
    private int[] m_level = null;
    
    private static final long serialVersionUID = 1L;
    
    private static final MoveSetData m_default = new MoveSetData();
    
    public void mergeMoves(int category, String[] moves) {
        HashSet<String> set = new HashSet<String>(Arrays.asList(m_moves[category]));
        set.addAll(Arrays.asList(moves));
        m_moves[category] = (String[])set.toArray(new String[set.size()]);
    }
    
    public static MoveSetData getDefaultData() {
        return m_default;
    }
    
    public static String getMoveType(int i) {
        switch (i) {
            case 0: return "Level";
            case 1: return "Move Tutor";
            case 2: return "TM";
            case 3: return "HM";
            case 4: return "Egg Group";
        }
        return null;
    }
    
    public String[][] getMoves() {
        return m_moves;
    }
    
    public int[] getNaturalLevels() {
        return m_level;
    }
    
    public MoveSet(String[] natural,
            int[] level,
            String[] tutor,
            String[] tm,
            String[] hm,
            String[] egg) {
        m_level = level;
        m_moves = new String[][] { natural, tutor, tm, hm, egg };
    }
    
    public boolean canLearn(String moveName) {
    	for(int i = 0; i < m_moves.length; i++) {
    		for(int j = 0; j < m_moves[i].length; j++) {
    			if(m_moves[i][j].equalsIgnoreCase(moveName))
    				return true;
    		}
    	}
    	return false;
    }
    
    public MoveSet() {}
}