public class PlanItemListener extends EntityListener {
    @Override
    public void onItemSpawn(ItemSpawnEvent event) {
	PlanArea area = BuildingPlanner.plugin.areaManager.getAffectedArea(event.getLocation().getBlock());
	if (area == null) {
	    return;
	}
		if (area.isCommitted()) {
	    return;
	}
	if (!area.isPlannedBlock(event.getLocation().getBlock())) {
	    area.addOriginalBlock(event.getLocation().getBlock(), true);
	    return;
	}
		event.setCancelled(true);
	        super.onItemSpawn(event);
    }
}