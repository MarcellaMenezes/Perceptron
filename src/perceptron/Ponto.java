package perceptron;

public class Ponto {
    private double x;
    private double y;
    private int classPoint;

    public Ponto(double x, double y, int classPoint) {
        this.x = x;
        this.y = y;
        this.classPoint = classPoint;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getClassPoint() {
        return classPoint;
    }

    public void setClassPoint(int classPoint) {
        this.classPoint = classPoint;
    }

    
    
}
