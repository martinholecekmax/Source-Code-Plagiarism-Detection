public class EvidenceEvidenceContextsEditPart extends ConnectionNodeEditPart
		implements ITreeBranchEditPart {
	
	public static final int VISUAL_ID = 4009;
	
	public EvidenceEvidenceContextsEditPart(View view) {
		super(view);
	}
	
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new EvidenceEvidenceContextsItemSemanticEditPolicy());
	}
	
	protected Connection createConnectionFigure() {
		return new EvidenceEvidenceContextsFigure();
	}
	
	public EvidenceEvidenceContextsFigure getPrimaryShape() {
		return (EvidenceEvidenceContextsFigure) getFigure();
	}
	
	public class EvidenceEvidenceContextsFigure extends PolylineConnectionEx {
		
		public EvidenceEvidenceContextsFigure() {
			this.setForegroundColor(THIS_FORE);
		}
	}
	
	static final Color THIS_FORE = new Color(null, 0, 0, 0);
}