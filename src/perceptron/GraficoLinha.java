package perceptron;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author marce link apoio http://zetcode.com/java/jfreechart/
 */
public class GraficoLinha {

    public XYSeriesCollection createDataSet(List<Reta> listReta) {
        XYSeriesCollection dataset = new XYSeriesCollection();;
        int i = 1;

        for (Reta r : listReta) {
            XYSeries serie3 = new XYSeries("Reta" + i);
            serie3.add(r.getX(), r.getY());
            serie3.add(r.getX2(), r.getY2());
            dataset.addSeries(serie3);
            i++;
        }
        return dataset;
    }

    //criar o grafico de barras
    public JFreeChart createListChart(XYDataset dataSet) {
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Lines Perceptron",
                "",
                "",
                dataSet,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        plot.setRenderer(renderer);
        // plot.setBackgroundPaint(Color.white);

        chart.getLegend().setFrame(BlockBorder.NONE);
        return chart;
    }

    //criar o grafico completo
    public ChartPanel criarGrafico(List<Reta> list) {
        XYSeriesCollection dataSet = this.createDataSet(list); //dados do grafico
        JFreeChart grafico = this.createListChart(dataSet);
        ChartPanel painelDoGrafico = new ChartPanel(grafico); //configurações do grafico
        painelDoGrafico.setPreferredSize(new Dimension(400, 400)); //tamanho do grafico 
        return painelDoGrafico;
    }

}
