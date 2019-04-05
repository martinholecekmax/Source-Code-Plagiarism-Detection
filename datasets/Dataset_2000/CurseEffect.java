@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CurseEffect")
public class CurseEffect extends EffectTemplate
{
	@Override
	public void applyEffect(Effect effect)
	{
			}
	@Override
	public void calculate(Effect effect)
	{
		effect.increaseSuccessEffect();
	}
}