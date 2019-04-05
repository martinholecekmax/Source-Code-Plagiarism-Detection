public class FoodService2Impl implements FoodService2 {
	private FoodService foodService;
	public void setFoodService(FoodService foodService) {
		this.foodService = foodService;
	}
	@Override
	public Food getFood(String name) {
		return foodService.getFood(name);
	}
}