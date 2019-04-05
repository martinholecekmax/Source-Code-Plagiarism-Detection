public class EvOpFilterParticleMeasureDouble 
	{
	private Double lower;
	private Double upper;
	private String prop;
	public EvOpFilterParticleMeasureDouble(Double lower, Double upper, String prop)
		{
		this.lower = lower;
		this.upper = upper;
		this.prop = prop;
		}
	
	public ParticleMeasure exec(ParticleMeasure pm)
		{
		return pm.filter(new ParticleMeasure.Filter()
			{
				public boolean acceptParticle(int id, ParticleInfo info)
					{
					double value=info.getDouble(prop);
					if(lower!=null)
						if(value<lower)
							return false;
					if(upper!=null)
						if(value>upper)
							return false;
					return true;
					}
				public boolean acceptFrame(EvDecimal frame)
					{
					return true;
					}
			});
		}
	}