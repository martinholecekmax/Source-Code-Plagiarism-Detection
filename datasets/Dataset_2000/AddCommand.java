public class AddCommand extends Command {
	public AddCommand () {
		super("AddChild");
	}
	public boolean canExecute() {
		boolean ret=false;
		if (m_newParent != null && m_oldParent != null &&
				m_child != null &&
				m_newParent != m_oldParent) {
			ret = true;
		}
		return(ret);
	}
	public void execute() {
		java.util.List list=ModelSupport.getChildren(m_oldParent);
				if (m_child instanceof RoleEvent &&
				m_role != null) {
			m_oldRole = (Role)((RoleEvent)m_child).getRole();
			((RoleEvent)m_child).setRole(m_role);
		}
		m_oldIndex = list.indexOf(m_child);
		ModelSupport.removeChild(m_oldParent, m_child);
		ModelSupport.addChild(m_newParent, m_child, m_index);
	}
	public void redo() {
		execute();
	}
	public void setChild(Object child) {
		m_child = child;
	}
	public void setNewParent(Object parent) { 
		m_newParent = parent;
	}
	public void setOldParent(Object parent) { 
		m_oldParent = parent;
	}
	public void setRole(Role participant) {
		m_role = participant;
	}
	public void setIndex(int index) {
		m_index = index;
	}
	public void undo() {
		ModelSupport.removeChild(m_newParent, m_child);
				if (m_child instanceof RoleEvent &&
				m_role != null) {
			((RoleEvent)m_child).setRole(m_oldRole);
		}
		ModelSupport.addChild(m_oldParent, m_child, m_oldIndex);
	}
	private Object m_newParent;
	private Object m_oldParent;
	private Object m_child;
	private int m_oldIndex=0;
	private int m_index=-1;
	private Role m_role=null;
	private Role m_oldRole=null;
}