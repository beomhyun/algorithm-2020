package EST;

public class example01 {
	public int solution(int[] A) {
			boolean[] B = new boolean[1000001];
			
			for (int i = 0; i < B.length; i++) {
				if(A[i] > 0) {
					B[A[i]] = true;
				}
			}
			
			int answer = 1;
			for (int i = 1; i < B.length; i++) {
				if(!B[i]) {
					answer = i;
					break;
				}
			}
			return answer;
    }
}
