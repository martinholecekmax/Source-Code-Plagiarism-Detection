public class SlideBarsForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;
    
	public String sliderBar1 = null;
	public String sliderBar2 = null;
	public String sliderBar3 = null;
	
	 public String getSliderBar1() {
		return sliderBar1;
	}
	
	 public void setSliderBar1(String sliderBar1) {
		this.sliderBar1 = sliderBar1;
	}
	
	 public String getSliderBar2() {
		return sliderBar2;
	}
	
	 public void setSliderBar2(String sliderBar2) {
		this.sliderBar2 = sliderBar2;
	}
	
	 public String getSliderBar3() {
		return sliderBar3;
	}
	
	 public void setSliderBar3(String sliderBar3) {
		this.sliderBar3 = sliderBar3;
	}
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.sliderBar1 = null;
		this.sliderBar2 = null;
		this.sliderBar3 = null;
	}
}