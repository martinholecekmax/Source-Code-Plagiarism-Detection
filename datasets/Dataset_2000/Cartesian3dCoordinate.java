public class Cartesian3dCoordinate extends Cartesian2dCoordinate {
	private final double z;
	public Cartesian3dCoordinate(final double x, final double y, final double z) {
		super(x, y);
		this.z = z;
	}
	
	public double getZ() {
		return z;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Cartesian3dCoordinate other = (Cartesian3dCoordinate) obj;
		if (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "Cartesian3dCoordinate [x=" + getX() + ", y=" + getY() + ", z="
				+ z + "]";
	}
}