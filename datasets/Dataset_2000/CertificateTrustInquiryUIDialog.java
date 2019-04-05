public class CertificateTrustInquiryUIDialog extends MessageDialog {
	public static boolean promptUser(Shell shell, String title, String message, CertPath certPath) {
		String[] buttonLabels = new String[] { IDialogConstants.YES_LABEL, IDialogConstants.NO_LABEL, Messages.certificate_details_with_dots };
		CertificateTrustInquiryUIDialog dlg = new CertificateTrustInquiryUIDialog(shell, title, null, message, WARNING, buttonLabels, 2, certPath);
		return dlg.open() == 0;
	}
	private final CertPath certPath;
	private CertificateTrustInquiryUIDialog(Shell shell, String title, Image image, String msg, int type, String[] labels, int index,
			CertPath certPath) {
		super(shell, title, image, msg, type, labels, index);
		this.certPath = certPath;
	}
	@Override
	protected void buttonPressed(int buttonId) {
		if (buttonId != 2)
			super.buttonPressed(buttonId);
		else
						MessageDialog.openInformation(this.getShell(), Messages.certificate_details, certPath.toString());
	}
}