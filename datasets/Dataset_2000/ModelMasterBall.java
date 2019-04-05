public class ModelMasterBall extends ModelPokeball {
	public ModelMasterBall() {
		super();
		ModelRenderer MRight = new ModelRenderer(this, 6, 26);
		MRight.addBox(-1.7F, -1.1F, -3.1F, 1, 1, 0);
		MRight.setRotationPoint(0F, 0F, 0F);
		MRight.setTextureSize(32, 32);
		MRight.mirror = true;
		setRotation(MRight, 0F, 0F, 0.6283185F);
		ModelRenderer MLeft = new ModelRenderer(this, 6, 26);
		MLeft.addBox(-1.1F, -1.7F, -3.1F, 1, 1, 0);
		MLeft.setRotationPoint(0F, 0F, 0F);
		MLeft.setTextureSize(32, 32);
		MLeft.mirror = true;
		setRotation(MLeft, 0F, 0F, 0.9424778F);
		MLeft.mirror = false;
		Hinge.addChild(MRight);
		Hinge.addChild(MLeft);
	}
}