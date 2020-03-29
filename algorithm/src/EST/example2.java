package EST;

public class example2 {
    public int[] solution(int[] A, int K) {
    	int[] answer = new int[A.length];
    	
    	for (int i = 0; i < answer.length; i++) {
			int index = (i + K) % A.length;
			
			answer[index] = A[i];
		}
    	return answer;
    }
}
