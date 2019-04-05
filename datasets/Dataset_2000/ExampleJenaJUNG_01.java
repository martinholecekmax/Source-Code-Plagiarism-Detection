public class ExampleJenaJUNG_01 {
		public static void main(String[] args) {
        FileManager fm = FileManager.get();
        fm.addLocatorClassLoader(ExampleJenaJUNG_01.class.getClassLoader());
        Model model = fm.loadModel("data/data.nt");
        Graph<RDFNode, Statement> g = new JenaJungGraph(model);
        Layout<RDFNode, Statement> layout = new FRLayout<RDFNode, Statement>(g);
        int width = 1400;
        int height = 800;
        layout.setSize(new Dimension(width, height));
        VisualizationImageServer<RDFNode, Statement> viz = new VisualizationImageServer<RDFNode, Statement>(layout, new Dimension(width, height));
        RenderContext<RDFNode, Statement> context = viz.getRenderContext();
        context.setEdgeLabelTransformer(Transformers.EDGE);
        context.setVertexLabelTransformer(Transformers.NODE);
        viz.setPreferredSize(new Dimension(width, height));
        Image img = viz.getImage(new Point(width/2, height/2), new Dimension(width, height));
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bi.createGraphics();
                g2d.setColor(Color.white);
        g2d.fillRect(0, 0, width, height);
                g2d.setColor(Color.white);
        g2d.drawImage(img, 0, 0, width, height, Color.blue, null);
        try {
                        ImageIO.write(bi, "PNG", new File("/tmp/graph.png"));
            System.out.println("Image saved");
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }
}