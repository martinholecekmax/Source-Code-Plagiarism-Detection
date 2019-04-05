public final class ApplyCaseFoldArg {
    final ScanEnvironment env;
    final CClassNode cc;
    ConsAltNode altRoot;
    ConsAltNode tail;
    public ApplyCaseFoldArg(ScanEnvironment env, CClassNode cc) {
        this.env = env;
        this.cc = cc;
    }
}