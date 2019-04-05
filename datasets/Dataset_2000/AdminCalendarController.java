@Controller
@RequestMapping("EDIT")
public class AdminCalendarController {
	private CalendarStore calendarStore;
	@Required
	@Resource(name="calendarStore")
	public void setCalendarStore(CalendarStore calendarStore) {
		this.calendarStore = calendarStore;
	}
	
	@RequestMapping(params = "action=administration")
	public String showAdministration(RenderRequest request) {
		return "/adminCalendars";
	}
	
	@ActionMapping(params = "action=deleteSharedCalendar")
	public void deleteSharedCalendar(ActionRequest request,
			ActionResponse response, @RequestParam("calendarId") Long id) {
				PredefinedCalendarDefinition def = calendarStore.getPredefinedCalendarDefinition(id);
		calendarStore.deleteCalendarDefinition(def);
				response.setRenderParameter("action", "administration");
	}
	
	@ModelAttribute("calendars")
	public List<PredefinedCalendarDefinition> getPredefinedCalendars() {
		return calendarStore.getPredefinedCalendarDefinitions();
	}
}