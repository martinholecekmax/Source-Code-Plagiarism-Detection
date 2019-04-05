public class SpeedLimitDataPoint {
    
    private final double x;
    
    private final double speedlimit;
    
    public SpeedLimitDataPoint(Map<String, String> map) {
        this.x = Double.parseDouble(map.get("x"));
        this.speedlimit = Double.parseDouble(map.get("speedlimit_kmh")) / 3.6;
    }
    
    public double getPosition() {
        return x;
    }
    
    public double getSpeedlimit() {
        return speedlimit;
    }
}