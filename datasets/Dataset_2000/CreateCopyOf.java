public class CreateCopyOf extends SubjectQuestion {
	private java.util.Vector m_copies = new java.util.Vector();
	@Override
	public Class getValueClass() {
		return edu.cmu.cs.stage3.alice.core.Model.class;
	}
	@Override
	protected Object getValue(edu.cmu.cs.stage3.alice.core.Transformable subjectValue) {
		Class[] classesToShare = {edu.cmu.cs.stage3.alice.core.TextureMap.class, edu.cmu.cs.stage3.alice.core.Geometry.class};
		edu.cmu.cs.stage3.alice.core.Model original = (edu.cmu.cs.stage3.alice.core.Model) subject.getTransformableValue();
		edu.cmu.cs.stage3.alice.core.Model copy = (edu.cmu.cs.stage3.alice.core.Model) original.HACK_createCopy(null, original.getParent(), -1, classesToShare, null);
		m_copies.addElement(copy);
		return copy;
	}
	@Override
	protected void started(edu.cmu.cs.stage3.alice.core.World world, double time) {
		super.started(world, time);
		m_copies.clear();
	}
	@Override
	protected void stopped(edu.cmu.cs.stage3.alice.core.World world, double time) {
		super.stopped(world, time);
		for (int i = 0; i < m_copies.size(); i++) {
			edu.cmu.cs.stage3.alice.core.Model copy = (edu.cmu.cs.stage3.alice.core.Model) m_copies.elementAt(i);
			copy.vehicle.set(null);
						copy.removeFromParent();
								}
		m_copies.clear();
	}
}