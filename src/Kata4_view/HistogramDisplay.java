package Kata4_view;

import Kata4_model.Histogram;
import java.awt.Dimension;
import java.util.Iterator;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay extends ApplicationFrame{

    private final Histogram histogram;
    private final String title, labelX, labelY;
    
    public HistogramDisplay(Histogram<String> histogram) {
        super("HISTOGRAM");
        this.histogram = histogram;
        this.labelX = "";
        this.labelY = "";
        this.title = "Histogram JFreeChart";
        this.setContentPane(createPanel());
        this.pack();
    }
    
    public HistogramDisplay(Histogram<String> histogram, String labelX, String labelY, String title) {
        super("HISTOGRAM");
        this.histogram = histogram;
        this.labelX = labelX;
        this.labelY = labelY;
        this.title = title;
        this.setContentPane(createPanel());
        this.pack();
    }

    private JPanel createPanel() {
        ChartPanel chartpanel = new ChartPanel(createChart(createDataSet()));
        chartpanel.setPreferredSize(new Dimension(800, 600));
        return chartpanel;
    }

    public void execute() {
        setVisible(true);
    }

    private JFreeChart createChart(DefaultCategoryDataset dataSet) {
        JFreeChart chart = ChartFactory.createBarChart(title,
                                                       labelX,
                                                       labelY,
                                                       dataSet,
                                                       PlotOrientation.VERTICAL,
                                                       false,
                                                       false,
                                                       rootPaneCheckingEnabled);
        return chart;
    }

    private DefaultCategoryDataset createDataSet() {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        
        for (Object key : histogram) {
            dataSet.addValue(histogram.getCount(key),"", key.toString());
        }
        
        return dataSet;
    }
    
}