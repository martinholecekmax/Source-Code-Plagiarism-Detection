public class _29 extends Arena implements Listener
{
	@EventHandler
	public void onDeath(PlayerDeathEvent event)
	{
		Player player = event.getEntity();
		if (isIn(player, 29))
		{
			player.getWorld().createExplosion(player.getLocation(), 3F);
		}
	}
	
}