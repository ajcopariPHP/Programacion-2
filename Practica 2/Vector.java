package Ejercicio1;
public class Vector {
	private double x;
	private double y;
	private double z;

 public Vector(double x, double y, double z) {
     this.x = x;
     this.y = y;
     this.z = z;
 	}
 public double getX() { return x; }
 public double getY() { return y; }
 public double getZ() { return z; }

 public double productoPunto(Vector v) {
     return this.x * v.x + this.y * v.y + this.z * v.z;
 	}

 public Vector productoCruz(Vector v) {
     double cx = this.y * v.z - this.z * v.y;
     double cy = this.z * v.x - this.x * v.z;
     double cz = this.x * v.y - this.y * v.x;
     return new Vector(cx, cy, cz);
 	}

 public double norma() {
     return Math.sqrt(x*x + y*y + z*z);
 	}

 public Vector suma(Vector v) {
     return new Vector(this.x + v.x, this.y + v.y, this.z + v.z);
 	}

 public Vector resta(Vector v) {
     return new Vector(this.x - v.x, this.y - v.y, this.z - v.z);
 	}

 @Override
 public String toString() {
     return "(" + x + ", " + y + ", " + z + ")";
 	}
}