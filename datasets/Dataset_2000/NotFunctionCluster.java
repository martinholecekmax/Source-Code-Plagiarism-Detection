public class NotFunctionCluster implements FunctionCluster {
    public Set<Function> getSupportedFunctions() {
        Set<Function> set = new HashSet<Function>();
        for (String fn : NotFunction.getSupportedIdentifiers())
            set.add(new NotFunction(fn));
        return set;
    }
}