public class SourcePatientNamePIDTransformer implements PIDTransformer {
    @Override
    public void fromHL7(String hl7Data, PatientInfo patientInfo) {
        notNull(patientInfo, "patientInfo cannot be null");
        patientInfo.setName(Hl7v2Based.parse(hl7Data, XpnName.class));
    }
    @Override
    public List<String> toHL7(PatientInfo patientInfo) {
        notNull(patientInfo, "patientInfo cannot be null");
        String name = Hl7v2Based.render(patientInfo.getName());
        return (name == null) ? null : Collections.singletonList(name);
    }
}