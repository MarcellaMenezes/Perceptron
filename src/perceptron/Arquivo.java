package perceptron;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcella menezes
 */
public class Arquivo {

    public static Perceptron lerEGravarPontos() {
        try {
            FileReader arq = new FileReader("pontos.txt");
            BufferedReader lerArq = new BufferedReader(arq);

            double taxaAprendizado = Double.parseDouble(lerArq.readLine());//taxa de Aprendizadi

            String linhaEquacao = lerArq.readLine(); //le a equacao
            System.out.println(linhaEquacao);
            String equacaoVet[] = linhaEquacao.split(";");
            System.out.println("Vet[" + 0 + "] " + equacaoVet[0]);
            Equacao equacao = new Equacao(Double.parseDouble(equacaoVet[0]),
                    Double.parseDouble(equacaoVet[1]),
                    Double.parseDouble(equacaoVet[2]));

            String linhaPonto = lerArq.readLine(); //le cada linha onde tem ponto
            List<Ponto> listPontos = new ArrayList<Ponto>(); //cria a lista de pontos

            for (int i = 0; linhaPonto != null; i++) { //roda enquanto tiver pontos
                String coordernadas[] = linhaPonto.split(";");
                Ponto pontoLido = new Ponto(Integer.parseInt(coordernadas[0]),
                        Integer.parseInt(coordernadas[1]),
                        Integer.parseInt(coordernadas[2]));
                listPontos.add(pontoLido);
                System.out.println(coordernadas[0] + " " + coordernadas[1] + "" + coordernadas[2]);

                linhaPonto = lerArq.readLine(); //p ler a proxima linha, no for
            }
            arq.close(); //se a linha = null, fecha o arquivo

            return new Perceptron(equacao, listPontos, taxaAprendizado); //lista de poontos

        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
            return null;
        }
    }

}
