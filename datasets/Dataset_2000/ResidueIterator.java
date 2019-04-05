class ResidueIterator implements Enumeration<Residue> {
	
	private MoleculeRenderer renderer = null;
	
	private int residueCount = 0;
	
	private int currentResidue = 0;
	
	private Residue residues[] = null;
	
	public ResidueIterator(MoleculeRenderer moleculeRenderer){
		renderer = moleculeRenderer;
		int moleculeCount = renderer.getMoleculeCount();
		residueCount = 0;
		for(int m = 0; m < moleculeCount; m++){
			Molecule molecule = renderer.getMolecule(m);
			int chainCount = molecule.getChainCount();
			for(int c = 0; c < chainCount; c++){
				Chain chain = molecule.getChain(c);
				residueCount += chain.getResidueCount();
			}
		}
		if(residueCount > 0){
			residues = new Residue[residueCount];
			currentResidue = 0;
			for(int m = 0; m < moleculeCount; m++){
				Molecule molecule = renderer.getMolecule(m);
				int chainCount = molecule.getChainCount();
				for(int c = 0; c < chainCount; c++){
					Chain chain = molecule.getChain(c);
					int residueCount = chain.getResidueCount();
					for(int r = 0; r < residueCount; r++){
						Residue residue = chain.getResidue(r);
						residues[currentResidue++] = residue;
					}
				}
			}
		}
		currentResidue = 0;
	}
	
	public boolean hasMoreElements(){
		return currentResidue < residueCount;
	}
	
	public Residue nextElement(){
		if(currentResidue < residueCount)
			return residues[currentResidue++];
		return null;
	}
	
	public Residue getNextResidue(){
		return nextElement();
	}
}