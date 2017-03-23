package engine.resources;

public class Cube {
	protected double x;
	protected double y;
	protected double z;
	protected double size;
	
	public Cube(double x, double y, double z, double size) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.size = size;
	}
	
	public double getX() {
		return x;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public double getZ() {
		return z;
	}
	
	public void setZ(double z) {
		this.z = z;
	}
	
	public double getSize() {
		return size;
	}
	
	public void setSize(double size) {
		this.size = size;
	}
}
