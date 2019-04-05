public abstract class PriorityLocalQuickFixWrapper implements LocalQuickFix {
  private LocalQuickFix fix;
  private PriorityLocalQuickFixWrapper(@NotNull LocalQuickFix fix) {
    this.fix = fix;
  }
  @NotNull
  @Override
  public String getName() {
    return fix.getName();
  }
  @NotNull
  @Override
  public String getFamilyName() {
    return fix.getFamilyName();
  }
  @Override
  public void applyFix(@NotNull Project project, @NotNull ProblemDescriptor descriptor) {
    fix.applyFix(project, descriptor);
  }
  private static class HighPriorityLocalQuickFixWrapper extends PriorityLocalQuickFixWrapper implements HighPriorityAction {
    protected HighPriorityLocalQuickFixWrapper(@NotNull LocalQuickFix fix) {
      super(fix);
    }
  }
  private static class NormalPriorityLocalQuickFixWrapper extends PriorityLocalQuickFixWrapper {
    protected NormalPriorityLocalQuickFixWrapper(@NotNull LocalQuickFix fix) {
      super(fix);
    }
  }
  private static class LowPriorityLocalQuickFixWrapper extends PriorityLocalQuickFixWrapper implements LowPriorityAction {
    protected LowPriorityLocalQuickFixWrapper(@NotNull LocalQuickFix fix) {
      super(fix);
    }
  }
  @NotNull
  public static LocalQuickFix highPriority(@NotNull LocalQuickFix fix) {
    return new HighPriorityLocalQuickFixWrapper(fix);
  }
  @NotNull
  public static LocalQuickFix normalPriority(@NotNull LocalQuickFix fix) {
    return new NormalPriorityLocalQuickFixWrapper(fix);
  }
  @NotNull
  public static LocalQuickFix lowPriority(@NotNull LocalQuickFix fix) {
    return new LowPriorityLocalQuickFixWrapper(fix);
  }
}