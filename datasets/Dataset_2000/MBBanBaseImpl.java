public abstract class MBBanBaseImpl extends MBBanModelImpl implements MBBan {
	
	public void persist() throws SystemException {
		if (this.isNew()) {
			MBBanLocalServiceUtil.addMBBan(this);
		}
		else {
			MBBanLocalServiceUtil.updateMBBan(this);
		}
	}
}