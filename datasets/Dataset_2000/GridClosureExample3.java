public class GridClosureExample3 {
    
    public static void main(String[] args) throws Exception {
                                                                G.in(args.length == 0 ? null : args[0], new CIX1<Grid>() {
            @Override public void applyx(Grid g) throws GridException {
                                g.run(BROADCAST,
                    new CA() {
                        @Override public void apply() {
                            X.println(">>>>>");
                            X.println(">>>>> Hello Node! :)");
                            X.println(">>>>>");
                        }
                    }
                );
                                X.println(">>>>> Check all nodes for hello message output.");
            }
        });
    }
}