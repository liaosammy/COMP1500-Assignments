package application;

public class LinearEquation {
    private double a, b, c, d, e, f;

    // Constructor with parameters
    public LinearEquation(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    // Getters
    public double getA() { return a; }
    public double getB() { return b; }
    public double getC() { return c; }
    public double getD() { return d; }
    public double getE() { return e; }
    public double getF() { return f; }

    // Check if the system is solvable
    public boolean isSolvable() {
        return (a * d - b * c) != 0;
    }

    // Calculate x
    public Double getX() {
        if (!isSolvable()) return null;
        return (e * d - b * f) / (a * d - b * c);
    }

    // Calculate y
    public Double getY() {
        if (!isSolvable()) return null;
        return (a * f - e * c) / (a * d - b * c);
    }
}
