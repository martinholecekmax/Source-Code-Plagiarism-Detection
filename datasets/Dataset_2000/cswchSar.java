public class cswchSar extends AllGraph {
    public cswchSar(kSar hissar) {
        super(hissar);
        Title = new String("Contexts");
        t_cswch = new TimeSeries("cswch/s", org.jfree.data.time.Second.class);
        mysar.dispo.put("Contexts switch/s", t_cswch);
    }
    public void add(Second now, Float val1Init) {
        this.t_cswch.add(now, val1Init, do_notify());
        number_of_sample++;
    }
    public XYDataset createcswch() {
        TimeSeriesCollection collectionswpq = new TimeSeriesCollection();
        collectionswpq.addSeries(this.t_cswch);
        return collectionswpq;
    }
    public void addtotree(DefaultMutableTreeNode myroot) {
        mynode=new DefaultMutableTreeNode(new GraphDescription(this, "LINUXCSWCH", this.Title, null));
        mysar.add2tree(myroot,mynode);
    }
    public JFreeChart makegraph(Second g_start, Second g_end) {
                XYDataset cswch = this.createcswch();
        XYItemRenderer minichart1 = new StandardXYItemRenderer();
        minichart1.setBaseStroke(kSarConfig.DEFAULT_STROKE);
        minichart1.setSeriesPaint(0, kSarConfig.color1);
        XYPlot subplot1 = new XYPlot(cswch, null, new NumberAxis("cswch/s"), minichart1);
                CombinedDomainXYPlot plot = new CombinedDomainXYPlot(new DateAxis(""));
        plot.add(subplot1, 1);
        plot.setOrientation(PlotOrientation.VERTICAL);
                JFreeChart mychart = new JFreeChart(this.getGraphTitle(), kSarConfig.DEFAULT_FONT, plot, true);
        if (g_start != null) {
            DateAxis dateaxis1 = (DateAxis) mychart.getXYPlot().getDomainAxis();
            dateaxis1.setRange(g_start.getStart(), g_end.getEnd());
        }
        if (setbackgroundimage(mychart) == 1) {
            subplot1.setBackgroundPaint(null);
        }
        return mychart;
    }
    private TimeSeries t_cswch;
}