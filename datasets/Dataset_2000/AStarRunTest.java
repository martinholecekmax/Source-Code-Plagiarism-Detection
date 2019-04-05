public class AStarRunTest {
		public static void main(String[] args) {
						Node start = new Node(new Point(30,16), 0);
			Node end = new Node(new Point(15,15), 0);
						int a = 2;
			int b = 5;
						Node opposition = new Node(new Point(26,17), b);
			opposition.setOpposition(true);
			Node ball = new Node(new Point(15,15), a);
			ball.setBall(true);
						ArrayList<Node> balls = new ArrayList<Node>();
			ArrayList<Node> oppositions = new ArrayList<Node>();
						int boundary = 4;
						for(int i = ball.x - boundary; i < ball.x + boundary; i++){
				for(int j = ball.y - boundary; j < ball.y + boundary; j++){
					Node tempBall = new Node(new Point(i,j), a);
					tempBall.setBall(true);
										balls.add(tempBall);
				}
			}
			for(int i = opposition.x - 2*boundary; i < opposition.x + boundary; i++){
				for(int j = opposition.y - 2*boundary; j < opposition.y + boundary; j++){
					Node tempOpp = new Node(new Point(i,j), b);
					tempOpp.setOpposition(true);
										oppositions.add(tempOpp);
				}
			}
						new AStarRun(29, 58, start, end, balls, oppositions);
		}
}