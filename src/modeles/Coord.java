package modeles;

/**
 * Base pour l'utilisation d'une arrayList de couples (x,y)
 * @author gregoire
 */
public class Coord {
	double x;
	double y;
	String z;
	
	public Coord(double x, double y, String z){
		this.x = x;
		this.y = y;
		this.z = z;
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
	
}
