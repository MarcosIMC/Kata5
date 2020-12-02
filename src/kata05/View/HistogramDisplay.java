package kata05.View;

import javax.swing.JPanel;
import kata05.Model.Histogram;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay extends ApplicationFrame{
    Histogram<String> histogram = new Histogram<>();

    public HistogramDisplay(Histogram<String> histogram, String title) {
      super(title);
      this.histogram = histogram;
      this.setContentPane(createPanel());
      this.pack();
    }
    
    public void execute() {
        this.setVisible(true);
    }

    private JPanel createPanel() {
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        return chartPanel;
    }

    private JFreeChart createChart(DefaultCategoryDataset dataSet) {
        JFreeChart freeChart = ChartFactory.createBarChart3D("JfreeChart Histogram", "emails domains", "nº emails", dataSet, PlotOrientation.VERTICAL, false, false, rootPaneCheckingEnabled);
                return freeChart;
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        int other = 0;
        for (String key : histogram.keySet()) {
            if(histogram.get(key) == 1){
                other++;
            }else{
                dataSet.addValue(histogram.get(key), "", key);    
            }

        }
        dataSet.addValue(other, "", "others");
        return dataSet;
    }
}
