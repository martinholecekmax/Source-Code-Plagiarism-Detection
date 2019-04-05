public interface CDATransformationService {
	
	@Deprecated
	String transformToHTML(PatientConsent consent)
			throws CdaXmlTransformerException;
	
	@Deprecated
	String transformToHTML(String cdaDocumentContent)
			throws CdaXmlTransformerException;
	
	String transformToHTML(Patient patient, Date validFrom, Date validUntil,
			PatientConsentPolicy policy, CoalaAuthor cauthors)
			throws CdaXmlTransformerException;
	
	String transformToValidPatientConsent(Patient p,
			PatientConsentPolicy policy, CoalaAuthor cauthor,
			DocumentEntry documentEntry);
}