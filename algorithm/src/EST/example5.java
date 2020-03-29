package EST;

public class example5 {
    public int solution(int[] A) {
    	boolean[] B = new boolean[100001];
    	for (int i = 0; i < A.length; i++) {
			B[A[i]] = true;
		}
    	
    	int answer = 0;
    	for (int i = 1; i < B.length; i++) {
			if(!B[i]) {
				answer = i;
				break;
			}
		}
    	return answer;
    }
}
