public class JumpGame {
	 public boolean canJump(int[] A) {
	        	        	        if(A.length==0)
	        	return false;
	        if(A.length==1)
	        	return true;
	        boolean canjump = false;
	        int count = 0;
	        for(int i = A.length-2; i>=0; i--){
	        	if(A[i]>count){ 	        		canjump = true; 	        		count = 0;
	        	}
	        	else{ 	        		canjump = false;
	        		count++;
	        	}
	        }
	        return canjump;
	    }
	
	public static void main(String[] args) {
			}
}