/*
CC0 1.0 Universal (CC0 1.0) Public Domain Dedication

To the extent possible under law, the author(s) have dedicated all copyright
and related rights to this software to the public domain worldwide. This
software is distributed without any warranty.

You may copy, modify, distribute, and perform the work, even for commercial
purposes, all without asking permission.

For more information, see <https://creativecommons.org/publicdomain/zero/1.0/>
*/
/*
This is free and unencumbered software released into the public domain.

Anyone is free to copy, modify, publish, use, compile, sell, or distribute
this software, either in source code form or as a compiled binary, for any
purpose, commercial or non-commercial, and by any means.

In jurisdictions that recognize copyright laws, the author(s) dedicate any
and all copyright interest in the software to the public domain. We make
this dedication for the benefit of the public at large and to the detriment
of our heirs and successors. We intend this dedication to be an overt act
of relinquishment in perpetuity of all present and future rights to this
software under copyright law.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For more information, please refer to <https://unlicense.org/>
*/
/**
 *
 * @author Rajesh V Pai
 */
package Regression;

//import static Regression.RegressionFreshman.DataArray;
//import static Regression.Regression.DataArrayOutput;
import static Regression.Regression.DataArray;
import static Regression.Regression.DataArrayOutput;
import static Regression.Regression.DataOutputCer;
import static Regression.Regression.DataOutputPredicted;
import static Regression.Regression.DataRegressed;
import static Regression.Regression.DataUncerEntropy;
import static Regression.Regression.DataUncertainity;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.apache.log4j.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.general.SeriesException;
import org.jfree.data.time.Day;
import org.jfree.data.time.Minute;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class TimeSeries_AWT extends ApplicationFrame implements ChangeListener {

    public static Logger log = Logger.getLogger(TimeSeries_AWT.class.getName());
//public static double Visibleizer = 0;
//public static double Separator = 15;
//public static double IOSeparator = 150;
    public static boolean visible = false;
    public static boolean Sigvisible = false;
// Graphis Draw Functions
    public static String title = "GASensex";
    public static JFreeChart chartInp;
    public static JFreeChart chartSigInp;
//public static ChartPanel chartPanel;
    public static JPanel MyJPanel;
    public static JPanel MySigJPanel;
    public static JPanel MyJPanelRealTime;
    public static JFreeChart chartInpRealTime;
    public static ChartPanel chartPanelRealTime;
//public static XYDataset dataset ;
    public static TranslatingXYDataset datasetTransXY;
    public static TranslatingXYDataset datasetSigTransXY;
    public static TimeSeriesCollection Data = new TimeSeriesCollection();
    public static TimeSeriesCollection SignalData = new TimeSeriesCollection();
    public static TimeSeriesCollection DataRealTime = new TimeSeriesCollection();
    public static TimeSeries_AWT demoRealTime;
    public static TimeSeries_AWT demo;
    public static TimeSeries_AWT Signal;
    public static JSlider slider;

    public TimeSeries_AWT(final String title, int InputColumn, int OutputColumn) {
        super(title);

        Data.removeAllSeries();
        datasetTransXY = createDatasetInt(InputColumn, OutputColumn);
        //chartInp = createChart( true, Data ); 
        chartInp = PopulatePanel();
        MyJPanel = new ChartPanel(chartInp, true);

        //chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 370 ) );         
        //chartPanel.setMouseZoomable( true , false ); 
        // JScrollBar Changes 
        MyJPanel.setPreferredSize(new java.awt.Dimension(600, 270));
        //chartPanel.setDomainZoomable(true);
        //chartPanel.setRangeZoomable(true);
        Border border = BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(4, 4, 4, 4),
                BorderFactory.createEtchedBorder());
        MyJPanel.setBorder(border);
        add(this.MyJPanel);

        JPanel dashboard = new JPanel(new BorderLayout());
        dashboard.setBorder(BorderFactory.createEmptyBorder(0, 4, 4, 4));
        // make the slider units "minutes"
        slider = new JSlider(-1000, 1000, 0);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(50);
        slider.setPaintTicks(true);
        this.slider.addChangeListener(this);
        dashboard.add(this.slider);
        add(dashboard, BorderLayout.SOUTH);

    }

    public TimeSeries_AWT(final String title, int InputColumn, int OutputColumn, int dummy, int NoSignal) {
        super(title);

        SignalData.removeAllSeries();
        datasetSigTransXY = createDatasetSignalInt(InputColumn, OutputColumn);
        //chartInp = createChart( true, Data ); 
        chartSigInp = PopulateSigPanel();
        MySigJPanel = new ChartPanel(chartSigInp, true);

        //chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 370 ) );         
        //chartPanel.setMouseZoomable( true , false ); 
        // JScrollBar Changes 
        MySigJPanel.setPreferredSize(new java.awt.Dimension(600, 270));
        //chartPanel.setDomainZoomable(true);
        //chartPanel.setRangeZoomable(true);
        Border border = BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(4, 4, 4, 4),
                BorderFactory.createEtchedBorder());
        MySigJPanel.setBorder(border);
        add(this.MySigJPanel);

        JPanel dashboard = new JPanel(new BorderLayout());
        dashboard.setBorder(BorderFactory.createEmptyBorder(0, 4, 4, 4));
        // make the slider units "minutes"
        slider = new JSlider(-1000, 1000, 0);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(50);
        slider.setPaintTicks(true);
        this.slider.addChangeListener(this);
        dashboard.add(this.slider);
        add(dashboard, BorderLayout.SOUTH);

    }

    public TimeSeries_AWT(final String title, int InputColumn, int OutputColumn, int dummy) {
        super(title);

        DataRealTime.removeAllSeries();
        datasetTransXY = createDatasetIntReal(InputColumn);
        chartInpRealTime = createChartRealTime(false, DataRealTime);
        if (chartInpRealTime != null) {
//           chartPanelRealTime = new ChartPanel( chartInpRealTime , false);
//            chartPanelRealTime.setPreferredSize( new java.awt.Dimension( 560 , 370 ) );         
//            chartPanelRealTime.setMouseZoomable( true , false ); 
//            setContentPane( chartPanelRealTime );

            // JScrollBar Changes 
            chartInpRealTime = PopulatePanel();
            MyJPanelRealTime = new ChartPanel(chartInpRealTime, true);

            //MyJPanelRealTime.setPreferredSize( new java.awt.Dimension( 560 , 370 ) );         
            //chartPanel.setMouseZoomable( true , false ); 
            MyJPanelRealTime.setPreferredSize(new java.awt.Dimension(600, 270));
            //chartPanel.setDomainZoomable(true);
            //chartPanel.setRangeZoomable(true);
            Border border = BorderFactory.createCompoundBorder(
                    BorderFactory.createEmptyBorder(4, 4, 4, 4),
                    BorderFactory.createEtchedBorder());
            MyJPanelRealTime.setBorder(border);
            add(this.MyJPanelRealTime);

            JPanel dashboard = new JPanel(new BorderLayout());
            dashboard.setBorder(BorderFactory.createEmptyBorder(0, 4, 4, 4));
            // make the slider units "minutes"
            slider = new JSlider(-1000, 1000, 0);
            slider.setPaintLabels(true);
            slider.setMajorTickSpacing(50);
            slider.setPaintTicks(true);
            this.slider.addChangeListener(this);
            dashboard.add(this.slider);
            add(dashboard, BorderLayout.SOUTH);

        } else {
            log.error("chartInpRealTime= null");
        }
    }

    private static TranslatingXYDataset createDatasetInt(int Input, int Output) {
        try {
            TimeSeries seriesInput = new TimeSeries("X-BSE Data", Minute.class);
            TimeSeries seriesGAComp = new TimeSeries("Y-GAComputed Data", Minute.class);

            Minute current = new Minute();
            double Visibleizer = 1000.0;
            for (int i = 0; i < DataArray.size(); i++) {
                seriesInput.add(current, DataArray.get(i)[0]);
                seriesInput.removeAgedItems(false);
                if (i < DataArrayOutput.size()) {
                    seriesGAComp.add(current, DataArrayOutput.get(i)[0] + Visibleizer);
                    //seriesGAComp.removeAgedItems(false);
                }

                current = (Minute) current.next();

            }

            Data.addSeries(seriesInput);
            Data.addSeries(seriesGAComp);

        } catch (SeriesException e) {
            System.err.println("Error adding to series");
            log.info("Exception: TimeSeries_AWT");
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        datasetTransXY = new TranslatingXYDataset(Data);
        return datasetTransXY;
    }

    public static TranslatingXYDataset createDatasetIntReal(int Input) {
        try {
            TimeSeries series1 = new TimeSeries("X-BSE Data", Minute.class);
            TimeSeries series2 = new TimeSeries("Y-Regression Data", Minute.class);
            TimeSeries series3 = new TimeSeries("Y-Uncertainity Data", Minute.class);
            TimeSeries series4 = new TimeSeries("Y-Certainity Data", Minute.class);
            TimeSeries series5 = new TimeSeries("Y-EqnRegressed", Minute.class);
            TimeSeries series6 = new TimeSeries("UNCER Y-EqnRegressed", Minute.class);
            TimeSeries series7 = new TimeSeries("UNCEREntropy", Minute.class);
            Minute current = new Minute();
            double Visibleizer = 800.0;
            double Visibleizer1 = 1000.0;
            double Visibleizer2 = 2000.0;
            double Visibleizer3 = 3000.0;
            double Visibleizer4 = 4000.0;
            double Visibleizer5 = 8000.0;
            int Multiplier=1;
            for (int i = 0; ( (i < DataArray.size())
                    &&(i < DataArrayOutput.size())
                    &&(i < DataOutputPredicted.size())
                     ); i++) {
                series1.add(current, DataArray.get(i)[0]);
                series1.removeAgedItems(false);
                if ((i < DataArrayOutput.size())&&(DataArrayOutput.get(i) != null)&&(DataArrayOutput.get(i)[0] != null) ) {
                    series2.add(current, DataArrayOutput.get(i)[0] + Visibleizer1);
                    series2.removeAgedItems(false);
                }
                if ((i < DataOutputCer.size())&&(DataOutputCer.get(i) != null)&&(DataOutputCer.get(i)[0] != null) ) {
                    series3.add(current, Multiplier*DataOutputCer.get(i)[0] );
                    series3.removeAgedItems(false);
                }
                if ((i < DataOutputPredicted.size())&&(DataOutputPredicted.get(i) != null)&&(DataOutputPredicted.get(i)[0] != null) ) {
                    series4.add(current, DataOutputPredicted.get(i)[0] + Visibleizer3);
                    series4.removeAgedItems(false);
                }
                if ((i < DataRegressed.size())&&(DataRegressed.get(i)[0] != null) ) {
                    series5.add(current, DataRegressed.get(i)[0] +Visibleizer4);
                    series5.removeAgedItems(false);
                }
                if ( ( (i) < DataUncertainity.size())&&(DataUncertainity.get(i)[0] != null) ) {
                    series6.add(current, DataUncertainity.get(i)[0]);
                    series6.removeAgedItems(false);
                }
                if ( ( (i) < DataUncerEntropy.size())&&(DataUncerEntropy.get(i)[0] != null) ) {
                    series7.add(current, DataUncerEntropy.get(i)[0]);
                    series7.removeAgedItems(false);
                }
                
                current = (Minute) current.next();

            }
            DataRealTime.addSeries(series1);
            DataRealTime.addSeries(series2);
            DataRealTime.addSeries(series3);
            DataRealTime.addSeries(series4);
            DataRealTime.addSeries(series5);
            DataRealTime.addSeries(series6);
            DataRealTime.addSeries(series7);
        } catch (SeriesException e) {
            System.err.println("Error adding to series");
            log.info("Exception: TimeSeries_AWT");
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        datasetTransXY = new TranslatingXYDataset(DataRealTime);
        return datasetTransXY;
    }

    private JFreeChart createChart(boolean initflag, XYDataset dataset) {

        String FileName = "Regression";
        return ChartFactory.createTimeSeriesChart(
                "FileName-" + FileName,
                "Day",
                "Value",
                datasetTransXY,
                true,
                true,
                true);
    }

    private static JFreeChart createChartRealTime(boolean initflag, XYDataset dataset) {
        String FileName = "BSE -HyperDOECompiler" + " " + "AnalogOutput";

        return ChartFactory.createTimeSeriesChart(
                "DayTradeRealTime" + FileName,
                "Day",
                "Value",
                datasetTransXY,
                true,
                true,
                true);

    }

    public static void Draw(boolean visible, int InputColumn, int OutputColumn) {
        demo.pack();
        RefineryUtilities.positionFrameRandomly(demo);
    }

    public static void DrawRealtime(boolean visible, int InputColumn, int OutputColumn) {

        //chartInp.getXYPlot().setDataset(DataRealTime);
        demoRealTime.pack();
        RefineryUtilities.positionFrameRandomly(demoRealTime);
    }

    public static void refreshChart() {
        MyJPanel.removeAll();
        MyJPanel.revalidate(); // This removes the old chart 
        chartInp = createChartRealTime(false, DataRealTime);
        chartInp.removeLegend();
        ChartPanel chartPanel = new ChartPanel(chartInp);
        chartPanel.repaint(); // This method makes the new chart appear
        chartPanel.updateUI();
    }

    public static void DemoRealTimeExistDraw() {
        // TODO CODE :Update after each Perform_Exp Call
        DataRealTime.removeAllSeries();
        //TimeSeries_AWT.demoRealTime.dispose();
        TimeSeries_AWT.demoRealTime.setTitle("Real Time-Experiment No:" + 1);
        datasetTransXY = TimeSeries_AWT.createDatasetIntReal(0);
        //TimeSeries_AWT.chartInpRealTime.getXYPlot().setDataset(TimeSeries_AWT.chartInpRealTime.getXYPlot().getDataset());
        TimeSeries_AWT.datasetTransXY.datasetRedraw();
        //TimeSeries_AWT.MyJPanelRealTime.repaint();
    }

    public static void DemoExistDraw() {
        // TODO CODE :Update after each Perform_Exp Call
        TimeSeries_AWT.Data.removeAllSeries();

        //TimeSeries_AWT.demo.dispose();
        TimeSeries_AWT.demo.setTitle(TimeSeries_AWT.title + 1);
        TimeSeries_AWT.datasetTransXY = TimeSeries_AWT.createDatasetInt(0, 1);
        TimeSeries_AWT.chartInp.getXYPlot().setDataset(TimeSeries_AWT.chartInp.getXYPlot().getDataset());
        TimeSeries_AWT.datasetTransXY.datasetRedraw();
        //TimeSeries_AWT.MyJPanel.repaint();
    }

    public static void DemoNewDraw() {
        if (TimeSeries_AWT.demo == null) {
            TimeSeries_AWT.demo = new TimeSeries_AWT(TimeSeries_AWT.title, 0, 1);
            TimeSeries_AWT.demo.pack();
            RefineryUtilities.positionFrameRandomly(TimeSeries_AWT.demo);
            TimeSeries_AWT.demo.setVisible(visible);
            visible = false;
        } else {
            TimeSeries_AWT.DemoExistDraw();
        }
    }

    public static void DemoRealTimeNewDraw() {
        visible = true;
        if (TimeSeries_AWT.demoRealTime == null) {
            TimeSeries_AWT.demoRealTime = new TimeSeries_AWT("Real Time-Experiment No:" + 1, 0, 5, 3);
            demoRealTime.pack();
            RefineryUtilities.positionFrameRandomly(demoRealTime);
            TimeSeries_AWT.demoRealTime.setVisible(visible);
            visible = false;
        } else {
            TimeSeries_AWT.DemoRealTimeExistDraw();
        }
    }

    public static void DemoInitialCreate() {
        visible = true;
        if (TimeSeries_AWT.demo == null) {
            TimeSeries_AWT.demo = new TimeSeries_AWT(TimeSeries_AWT.title, 0, 1);
            demo.pack();
            //RefineryUtilities.positionFrameRandomly( demo );
            TimeSeries_AWT.demo.setVisible(visible);
            visible = false;
        } else {
            TimeSeries_AWT.DemoExistDraw();
        }

    }

    public static void DemoFinalDraw() {
        visible = true;
        TimeSeries_AWT.demo = new TimeSeries_AWT(TimeSeries_AWT.title, 0, 1);
        TimeSeries_AWT.demo.pack();
        RefineryUtilities.positionFrameRandomly(TimeSeries_AWT.demo);
        TimeSeries_AWT.demo.setVisible(visible);
        visible = false;
    }

    /**
     * Handles a state change event.
     *
     * @param event the event.
     */
    public void stateChanged(ChangeEvent event) {
        int value = slider.getValue();
        // value is in minutes
        this.datasetTransXY.setTranslate(value * 60 * 1000.0);
    }

    /**
     * Creates the demo chart.
     *
     * @return The chart.
     */
    private JFreeChart PopulatePanel() {
        String[] TmpStr;
        String Mode = "";
        String NetType = "";
        String PredictionType = "";

        PredictionType = "";
        String FileName = " Exchange=" + "BSE"
                + " Stock=" + "HDFC"
                + " decimal places(Paisa) "
                + " Mode=" + Mode
                + " Timeline=" + PredictionType;

        JFreeChart chart1 = ChartFactory.createTimeSeriesChart(
                "DayTrade - " + FileName,
                "Day",
                "Value",
                datasetTransXY,
                true,
                true,
                true
        );

        chart1.setBackgroundPaint(Color.white);
        XYPlot plot = chart1.getXYPlot();
        plot.setOrientation(PlotOrientation.VERTICAL);
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));

        plot.setDomainCrosshairVisible(true);
        plot.setDomainCrosshairLockedOnData(false);
        plot.setRangeCrosshairVisible(false);

        XYItemRenderer renderer = plot.getRenderer();
        renderer.setSeriesPaint(0, Color.red);
        renderer.setSeriesPaint(1, Color.blue);

        renderer.setSeriesPaint(2, Color.GREEN);
        renderer.setSeriesPaint(3, Color.CYAN);
        renderer.setSeriesPaint(4, Color.BLACK);
        renderer.setSeriesPaint(5, Color.YELLOW);
        renderer.setSeriesPaint(6, Color.MAGENTA);
        renderer.setSeriesPaint(7, Color.ORANGE);
        renderer.setSeriesPaint(8, Color.DARK_GRAY);
        renderer.setSeriesPaint(9, Color.BLACK);
        renderer.setSeriesPaint(10, Color.YELLOW);
        renderer.setSeriesPaint(11, Color.BLACK);
        renderer.setSeriesPaint(12, Color.BLACK);
        renderer.setSeriesPaint(13, Color.BLACK);

//renderer.setPaint(Color.black);
        // fix the range
        DateAxis axis = (DateAxis) plot.getDomainAxis();
        //Range range = DatasetUtilities.findDomainBounds(datasetTransXY);
        //axis.setRange(range);
        return chart1;
    }

    public static void SignalNewDraw() {
        if (TimeSeries_AWT.Signal == null) {
            TimeSeries_AWT.Signal = new TimeSeries_AWT(TimeSeries_AWT.title, 0, 1, 3, 2);
            TimeSeries_AWT.Signal.pack();
            RefineryUtilities.positionFrameRandomly(TimeSeries_AWT.Signal);
            TimeSeries_AWT.Signal.setVisible(Sigvisible);
            Sigvisible = false;
        }

    }

    private static TranslatingXYDataset createDatasetSignalInt(int Input, int Output) {
        try {

            TimeSeries series3 = new TimeSeries("AnalogOutput-0", Minute.class);
            TimeSeries series4 = new TimeSeries("AnalogOutput-1", Minute.class);
            Minute current = new Minute();

            double Visibleizer = 1000.0;
            for (int i = 0; i < DataArray.size(); i++) {

                series3.add(current, DataArray.get(i)[0]);
                series3.removeAgedItems(false);

                series4.add(current, DataArray.get(i)[1]);
                series4.removeAgedItems(false);

                current = (Minute) current.next();

            }

            SignalData.addSeries(series3);      //SOALema
            SignalData.addSeries(series4);    //ANOVA

        } catch (SeriesException e) {
            System.err.println("Error adding to series");
            log.info("Exception: TimeSeries_AWT");
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        datasetSigTransXY = new TranslatingXYDataset(SignalData);
        return datasetSigTransXY;
    }

    private JFreeChart PopulateSigPanel() {
        String[] TmpStr;
        String FileName = "BSE SENSEX" + " " + "AnalogOutput";

        JFreeChart chart1 = ChartFactory.createTimeSeriesChart(
                "DayTrade - " + FileName,
                "Day",
                "Value",
                datasetSigTransXY,
                true,
                true,
                true
        );

        chart1.setBackgroundPaint(Color.white);
        XYPlot plot = chart1.getXYPlot();
        plot.setOrientation(PlotOrientation.VERTICAL);
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));

        plot.setDomainCrosshairVisible(true);
        plot.setDomainCrosshairLockedOnData(false);
        plot.setRangeCrosshairVisible(false);

        XYItemRenderer renderer = plot.getRenderer();
        renderer.setSeriesPaint(0, Color.red);
        renderer.setSeriesPaint(1, Color.blue);

        renderer.setSeriesPaint(2, Color.GREEN);
        renderer.setSeriesPaint(3, Color.CYAN);
        renderer.setSeriesPaint(4, Color.DARK_GRAY);
        renderer.setSeriesPaint(5, Color.GREEN);
        renderer.setSeriesPaint(6, Color.MAGENTA);
        renderer.setSeriesPaint(7, Color.ORANGE);
        renderer.setSeriesPaint(8, Color.PINK);
        renderer.setSeriesPaint(9, Color.BLACK);
        renderer.setSeriesPaint(10, Color.YELLOW);
        renderer.setSeriesPaint(11, Color.BLACK);
        renderer.setSeriesPaint(12, Color.BLACK);
        renderer.setSeriesPaint(13, Color.BLACK);

//renderer.setPaint(Color.black);
        // fix the range
        DateAxis axis = (DateAxis) plot.getDomainAxis();
        //Range range = DatasetUtilities.findDomainBounds(datasetTransXY);
        //axis.setRange(range);
        return chart1;
    }
}
