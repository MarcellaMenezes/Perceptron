package perceptron;

import java.awt.Dimension;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
/**
 *
 * @author marce
 */
public class GraficoLinha {

    public DefaultCategoryDataset createDataSet(List<Reta> listReta){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
        int i=1;
        String serie1= "Reta "+1;
 
        for(Reta r: listReta){
            dataset.addValue(r.getX(), serie1, r.getY()+"");
            dataset.addValue(r.getX2(), serie1, r.getY2()+"");
            i++;
            serie1= "Reta "+i;
        }
        return dataset;  
    }
    //criar o grafico de barras
    public JFreeChart createListChart(DefaultCategoryDataset dataSet){
        JFreeChart chartLine = ChartFactory.createLineChart(  
        "Lines Perceptron", // Chart title  
        "Date", // X-Axis Label  
        "Number of Visitor", // Y-Axis Label  
        dataSet  
        );     
        return chartLine;
    }
    
    //criar o grafico completo
    public ChartPanel criarGrafico(List<Reta> list){
        DefaultCategoryDataset dataSet = this.createDataSet(list); //dados do grafico
        JFreeChart grafico = this.createListChart(dataSet);
        ChartPanel painelDoGrafico = new ChartPanel(grafico); //configurações do grafico
        painelDoGrafico.setPreferredSize(new Dimension(400,400)); //tamanho do grafico 
        return painelDoGrafico;
    }
    
}
