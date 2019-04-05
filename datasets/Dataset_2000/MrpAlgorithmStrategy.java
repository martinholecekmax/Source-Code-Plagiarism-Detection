public interface MrpAlgorithmStrategy {
    boolean isApplicableFor(final MrpAlgorithm algorithm);
    Map<Entity, BigDecimal> perform(final Map<Entity, BigDecimal> productComponentQuantities, final Set<Entity> nonComponents,
            MrpAlgorithm algorithm, final String type);
}