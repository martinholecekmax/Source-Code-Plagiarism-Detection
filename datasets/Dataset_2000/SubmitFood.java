public class SubmitFood extends Page
{
	@FindBy(id = "food_brand")
	public WebElement fieldFoodBrand;
	@FindBy(id = "food_description")
	public WebElement fieldFoodDescription;
	@FindBy(xpath = "	public WebElement btnContinue;
	@FindBy(xpath = "	public WebElement labelError;
	private TopMainMenu topMainMenu;
	public SubmitFood(WebDriver driver)
	{
		super(driver);
		initURL("/food/submit");
		initReportPrefix("SubmitFood");
		topMainMenu = PageFactory.initElements(driver, TopMainMenu.class);
	}
	
	public SubmitFoodExtended submitFood(String foodBrand, String foodDescr)
	{
		type("field Food Brand", fieldFoodBrand, foodBrand);
		type("field Food Description", fieldFoodDescription, foodDescr);
		click("btn continue", btnContinue);
		return PageFactory.initElements(driver, SubmitFoodExtended.class);
	}
	
	public TopMainMenu getTopMainMenu()
	{
		return topMainMenu;
	}
	public void setTopMainMenu(TopMainMenu topMainMenu)
	{
		this.topMainMenu = topMainMenu;
	}
}