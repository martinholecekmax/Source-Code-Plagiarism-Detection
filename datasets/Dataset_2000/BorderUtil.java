public class BorderUtil {
	public static List<CellBorder> getOuterBorder(List<WorldCoord> worldCoords) {
		List<CellBorder> borderCoords = new ArrayList<CellBorder>();
		for (WorldCoord worldCoord : worldCoords) {
			CellBorder border = new CellBorder(worldCoord, new boolean[] {
					!worldCoords.contains(worldCoord.add(-1, 0)),
					!worldCoords.contains(worldCoord.add(-1, -1)),
					!worldCoords.contains(worldCoord.add(0, -1)),
					!worldCoords.contains(worldCoord.add(1, -1)),
					!worldCoords.contains(worldCoord.add(1, 0)),
					!worldCoords.contains(worldCoord.add(1, 1)),
					!worldCoords.contains(worldCoord.add(0, 1)),
					!worldCoords.contains(worldCoord.add(-1, 1)) });
			if (border.hasAnyBorder())
				borderCoords.add(border);
		}
		return borderCoords;
	}
	public static List<CellBorder> getPlotBorder(List<WorldCoord> worldCoords) {
		List<CellBorder> borderCoords = new ArrayList<CellBorder>();
		for (WorldCoord worldCoord : worldCoords) {
			CellBorder border = getPlotBorder(worldCoord);
			borderCoords.add(border);
		}
		return borderCoords;
	}
	public static CellBorder getPlotBorder(WorldCoord worldCoord) {
		return new CellBorder(worldCoord, new boolean[] {
				true, true, true, true, true, true, true, true });
	}
}