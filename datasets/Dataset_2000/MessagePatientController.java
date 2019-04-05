@Controller
@RequestMapping("/module/motechmodule/message-patient")
@SessionAttributes("message")
public class MessagePatientController {
	private static Log log = LogFactory.getLog(MessagePatientController.class);
	@Autowired
	@Qualifier("mobileClient")
	private MessageService messageService;
	@Autowired
	private ContextService contextService;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		String datePattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true, datePattern.length()));
		binder
				.registerCustomEditor(String.class, new StringTrimmerEditor(
						true));
	}
	@ModelAttribute("notificationTypes")
	public List<MessageDefinition> getNotificationTypes() {
		return contextService.getMotechService().getAllMessageDefinitions();
	}
	@ModelAttribute("message")
	public WebMessage getMessage() {
		return new WebMessage();
	}
	@RequestMapping(method = RequestMethod.GET)
	public void viewForm(ModelMap model) {
	}
	@RequestMapping(method = RequestMethod.POST)
	public void submitForm(@ModelAttribute("message") WebMessage message,
			Errors errors, ModelMap model, SessionStatus status) {
		log.debug("Sending Patient Message");
		if (!errors.hasErrors()) {
			String motechIdString = null;
			if (message.getMotechId() != null) {
				motechIdString = message.getMotechId().toString();
			}
			messageService.sendPatientMessage(null, new NameValuePair[0],
					message.getPhoneNumber(), message.getPhoneType(), message
							.getLanguage(), message.getMediaType(), message
							.getNotificationType(), message.getStartDate(),
					message.getEndDate(), motechIdString);
			model.addAttribute("successMsg",
					"motechmodule.Demo.Patient.message.success");
			status.setComplete();
		}
	}
}