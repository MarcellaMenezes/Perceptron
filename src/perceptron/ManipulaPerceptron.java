package perceptron;

import java.util.ArrayList;
import java.util.List;
import jdk.nashorn.internal.runtime.ListAdapter;

public class ManipulaPerceptron {

    public static double CalculaY(Equacao equacao, Ponto p) {
        return equacao.getW0() + equacao.getW1() * p.getX() + equacao.getW2() * p.getY();
    }

    //f(x) >0 é C1, f(x) <= 0 é C2
    public static boolean verificaSePontoNaClasseCerta(Ponto p, double valorCaculadoY) {
        if ((p.getClassPoint() == 1 && valorCaculadoY > 0) || (p.getClassPoint() == 2 && valorCaculadoY <= 0)) {
            return true;
        } else {
            System.out.println("Ponto X:" + p.getX() + " y:" + p.getY() + " Na Classe errada");
            return false;
        }
    }

    public static boolean verificaSeTemPontosQueNPertencemReta(List<Ponto> listPoints, Equacao eqc) {
        for (Ponto p : listPoints) {
            if ((p.getClassPoint() == 1 && CalculaY(eqc, p) <= 0) || (p.getClassPoint() == 2 && CalculaY(eqc, p) > 0)) {
                return true;
            }
        }
        return false;
    }

    /*w(t+1) = w(t) – n Xi >0  mas pertence a C2
    w(t+1) = w(t)   +  n Xi <=0  mas pertence a C1*/
    public static Equacao novaEquacao(Perceptron perceptron, Ponto pontoDoErro, double valorCalculadoY) {
        if (pontoDoErro.getClassPoint() == 1 && valorCalculadoY <= 0) {
            double w0 = perceptron.getEqc().getW0() + perceptron.getTaxaAprendizado();
            double w1 = perceptron.getEqc().getW1() + perceptron.getTaxaAprendizado() * pontoDoErro.getX();
            double w2 = perceptron.getEqc().getW2() + perceptron.getTaxaAprendizado() * pontoDoErro.getY();
            return new Equacao(w0, w1, w2);
        } else {
            double w0 = perceptron.getEqc().getW0() - perceptron.getTaxaAprendizado();
            double w1 = perceptron.getEqc().getW1() - perceptron.getTaxaAprendizado() * pontoDoErro.getX();
            double w2 = perceptron.getEqc().getW2() - perceptron.getTaxaAprendizado() * pontoDoErro.getY();
            return new Equacao(w0, w1, w2);
        }
    }

    /* x2=0 e  X1=(-W2*X2 -W0)/W1
       x1=0 e  X2=(-W1*X1-W0)/W2
     */
    public static List<Ponto> pontosParaNovaReta(Equacao novaEquacao) {
        List<Ponto> listaDeDoisPontos = new ArrayList<>();

        if (novaEquacao.getW1() == 0 && novaEquacao.getW2() != 0) {//W0 + W2*X2
            listaDeDoisPontos.add(new Ponto(0, -novaEquacao.getW0() / novaEquacao.getW2(), 0)); //x1==0  x2==-w0/w2
            listaDeDoisPontos.add(new Ponto(novaEquacao.getW0(), 0, 0)); //x2==0 x1==W0
        } else if (novaEquacao.getW2() == 0 && novaEquacao.getW1() != 0) {//W0 +W1*X1;
            listaDeDoisPontos.add(new Ponto(0, novaEquacao.getW0(), 0)); //x1==0 x1==W0 
            listaDeDoisPontos.add(new Ponto(-novaEquacao.getW0() / novaEquacao.getW1(), 0, 0)); //x2==0 x1==W0
        } else {
            listaDeDoisPontos.add(new Ponto(0, -novaEquacao.getW0() / novaEquacao.getW2(), 0)); //x1==0 w0/w1
            listaDeDoisPontos.add(new Ponto(-novaEquacao.getW0() / novaEquacao.getW1(), 0, 0));  //x2==0 w0/w2
        }
        for (Ponto p : listaDeDoisPontos) {
            System.out.println("X = " + p.getX() + " Y= " + p.getY());
        }
        return listaDeDoisPontos;
    }

    public static List<Reta> calcularPerceptron(Perceptron perceptron) {
        List<Reta> listReta = new ArrayList<>();
        List<Ponto> listPontos = perceptron.getListPontos();
        Equacao eqc = perceptron.getEqc();
        Equacao eqcNova = eqc;

        while (verificaSeTemPontosQueNPertencemReta(listPontos, eqcNova)) {
            for (Ponto p : listPontos) {
                double valorY = CalculaY(eqcNova, p);
                if (verificaSePontoNaClasseCerta(p, valorY) == false) {
                    eqcNova = novaEquacao(perceptron, p, valorY);
                    perceptron.setEqc(eqcNova);
                    System.out.println("Equacao nova: W0=" + eqcNova.getW0()
                            + " W1=" + eqcNova.getW1() + " W2=" + eqcNova.getW2());
                    List<Ponto> novosPontos = pontosParaNovaReta(eqcNova);

                    listReta.add(new Reta(novosPontos.get(0).getX(),
                            novosPontos.get(0).getY(),
                            novosPontos.get(1).getX(),
                            novosPontos.get(1).getY()));
                }
            }
            int i = 0;
            for (Reta r : listReta) {
                System.out.println("Reta " + i + ": P1(" + r.getX() + "," + r.getY() + ") (" + r.getX2() + "," + r.getY2() + ")");
                i++;
            }
        }
        return listReta;
    }
}
