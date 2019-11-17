package perceptron;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author marce
 */
public class GraficoPonto {

    //criar o dataset
    public XYDataset createDataSet(List<Ponto> listPointClass1, List<Ponto> listPointClass2) {
        XYSeriesCollection dataset = new XYSeriesCollection();

        //Class 1 (X,Y) series  
        XYSeries series1 = new XYSeries("Class 1");
        for (Ponto p : listPointClass1) {
            series1.add(p.getX(), p.getY());
        }
        dataset.addSeries(series1);

        //Class 2 (X,Y) series  
        XYSeries series2 = new XYSeries("Class 2");
        for (Ponto p : listPointClass2) {
            series2.add(p.getX(), p.getY());
        }

        dataset.addSeries(series2);

        return dataset;
    }

    //criar o grafico de barras
    public JFreeChart createListChartPonto(XYDataset dataSet) {

        JFreeChart chartPoints = ChartFactory.createScatterPlot(
                "Perceptron Points",
                "X", "Y", dataSet);

        XYPlot plot = chartPoints.getXYPlot();
        // plot.setBackgroundPaint(Color.white);

        return chartPoints;
    }

    //criar o grafico completo
    public ChartPanel criarGrafico(List<Ponto> listPointClass1, List<Ponto> listPointClass2) {
        XYDataset dataSet = this.createDataSet(listPointClass1, listPointClass2); //dados do grafico
        JFreeChart grafico = this.createListChartPonto(dataSet);
        ChartPanel painelDoGrafico = new ChartPanel(grafico); //configurações do grafico
        painelDoGrafico.setPreferredSize(new Dimension(400, 400)); //tamanho do grafico

        return painelDoGrafico;
    }

}
