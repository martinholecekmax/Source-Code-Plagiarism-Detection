@Ds(entity = CalendarEventStatus.class, jpqlWhere = "  e.eventType = 'meeting' ", sort = { @SortField(field = CalendarEventStatusMeetingLovDs.fNAME) })
public class CalendarEventStatusMeetingLovDs extends
        AbstractTypeLov<CalendarEventStatus> {
    public static final String fEVENTTYPE = "eventType";
    @DsField()
    private String eventType;
    public CalendarEventStatusMeetingLovDs() {
        super();
    }
    public CalendarEventStatusMeetingLovDs(CalendarEventStatus e) {
        super(e);
    }
    public String getEventType() {
        return this.eventType;
    }
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
}