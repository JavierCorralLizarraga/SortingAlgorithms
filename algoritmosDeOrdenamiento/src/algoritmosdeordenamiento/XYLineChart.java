package algoritmosdeordenamiento;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import java.util.ArrayList;

public class XYLineChart extends JFrame {
  
  public XYLineChart(String title, String xaxis, String yaxis, ArrayList<Double> tiempoCompa, int[] tamanio) {
    super(title);
    // Create dataset
    XYDataset dataset = createDataset(, tiempoCompa, tamanio);
    // Create chart
    JFreeChart chart = ChartFactory.createXYLineChart(
        title,
        xaxis,
        yaxis,
        dataset,
        PlotOrientation.VERTICAL,
        true, true, false);
    // Create Panel
    ChartPanel panel = new ChartPanel(chart);
    setContentPane(panel);
  }

  private XYDataset createDataset(String nombreData, ArrayList<Double> tiempoCompa, int[] tamanio) {
    XYSeriesCollection dataset = new XYSeriesCollection();

    XYSeries series = new XYSeries(nombreData);
    int i=0;
    while(!tiempoCompa.isEmpty()){
	series.add(tiempoCompa.remove(0), tamanio[i]);
	i++;
    }
    //Add series to dataset
    dataset.addSeries(series);
    return dataset;
  }
}
