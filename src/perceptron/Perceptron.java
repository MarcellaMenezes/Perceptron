package perceptron;

import java.util.List;

/**
 *
 * @author marce
 */
public class Perceptron {

    private Equacao eqc;
    private List<Ponto> listPontos;
    private double taxaAprendizado;

    public Perceptron(Equacao eqc, List<Ponto> listPontos, double taxaAprendizado) {
        this.eqc = eqc;
        this.listPontos = listPontos;
        this.taxaAprendizado = taxaAprendizado;
    }

    public Equacao getEqc() {
        return eqc;
    }

    public void setEqc(Equacao eqc) {
        this.eqc = eqc;
    }

    public List<Ponto> getListPontos() {
        return listPontos;
    }

    public void setListPontos(List<Ponto> listPontos) {
        this.listPontos = listPontos;
    }

    public double getTaxaAprendizado() {
        return taxaAprendizado;
    }

    public void setTaxaAprendizado(double taxaAprendizado) {
        this.taxaAprendizado = taxaAprendizado;
    }

}
