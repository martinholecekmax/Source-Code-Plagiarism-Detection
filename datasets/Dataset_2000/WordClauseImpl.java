public final class WordClauseImpl extends AbstractLeafClause implements WordClause {
    private static final int WEAK_CACHE_INITIAL_CAPACITY = 2000;
    private static final float WEAK_CACHE_LOAD_FACTOR = 0.5f;
    private static final int WEAK_CACHE_CONCURRENCY_LEVEL = 16;
    
    private static final Map<Site,ReferenceMap<String,WordClauseImpl>> WEAK_CACHE
            = new ConcurrentHashMap<Site,ReferenceMap<String,WordClauseImpl>>();
    
    public static WordClauseImpl createWordClause(
            final String term,
            final String field,
            final TokenEvaluationEngine predicate2evaluatorFactory) {
                ReferenceMap<String,WordClauseImpl> weakCache = WEAK_CACHE.get(predicate2evaluatorFactory.getSite());
        if(weakCache == null ){
            weakCache = new ReferenceMap<String,WordClauseImpl>(
                    DFAULT_REFERENCE_MAP_TYPE,
                    new ConcurrentHashMap<String,Reference<WordClauseImpl>>(
                        WEAK_CACHE_INITIAL_CAPACITY,
                        WEAK_CACHE_LOAD_FACTOR,
                        WEAK_CACHE_CONCURRENCY_LEVEL));
            WEAK_CACHE.put(predicate2evaluatorFactory.getSite(), weakCache);
        }
                return createClause(
                WordClauseImpl.class,
                term,
                field,
                predicate2evaluatorFactory,
                weakCache);
    }
    
    protected WordClauseImpl(
            final String term,
            final String field,
            final Set<TokenPredicate> knownPredicates,
            final Set<TokenPredicate> possiblePredicates) {
        super(term, field, knownPredicates, possiblePredicates);
    }
}