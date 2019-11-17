package perceptron;

/**
 *
 * @author marce
 */
public class Reta extends Ponto {

    private double x2, y2;

    public Reta(double x, double y, double x2, double y2) {
        super(x, y, 0);
        this.x2 = x2;
        this.y2 = y2;
    }

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }

}
