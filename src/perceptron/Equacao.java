package perceptron;

/**
 *
 * @author marcella menezes
 */
public class Equacao {
    private double w0, w1, w2;

    public Equacao(double w0, double w1, double w2) {
        this.w0 = w0;
        this.w1 = w1;
        this.w2 = w2;
    }

    public double getW0() {
        return w0;
    }

    public void setW0(double w0) {
        this.w0 = w0;
    }

    public double getW1() {
        return w1;
    }

    public void setW1(double w1) {
        this.w1 = w1;
    }

    public double getW2() {
        return w2;
    }

    public void setW2(double w2) {
        this.w2 = w2;
    }
    
}
