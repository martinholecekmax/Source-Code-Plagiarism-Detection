public class BubbleFitnessFunctor implements FitnessFunctor {
	@Override
	public double score(List<Cluster> clusters) {
        double score = 0;
        for(int i=0; i!=clusters.size(); ++i) {
                                    score += CircleMath.area(clusters.get(i).getRadius());
                        for(int j=i+1; j!=clusters.size(); ++j) {
                score -= 4.0 * CircleMath.intersectionArea(
                        clusters.get(i).getPoint(),
                        clusters.get(j).getPoint(),
                        clusters.get(i).getRadius(),
                        clusters.get(j).getRadius());
            }
        }
        return score;
	}
}