@Controller
@RequestMapping("/viewPenalty.ftl")
@SessionAttributes("formBean")
public class ViewPenaltyController {
    @Autowired
    private PenaltyServiceFacade penaltyServiceFacade;
    @Autowired
    private ConfigurationServiceFacade configurationServiceFacade;
    protected ViewPenaltyController() {
            }
    public ViewPenaltyController(final PenaltyServiceFacade penaltyServiceFacade) {
        this.penaltyServiceFacade = penaltyServiceFacade;
    }
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showPenalty(@RequestParam Integer penaltyId) {
        ModelAndView modelAndView = new ModelAndView("viewPenalty");
        AccountingConfigurationDto configurationDto= this.configurationServiceFacade.getAccountingConfiguration();
        modelAndView.addObject("penalty", this.penaltyServiceFacade.getPenalty(penaltyId));
        modelAndView.addObject("GLCodeMode",  configurationDto.getGlCodeMode());
        return modelAndView;
    }
}