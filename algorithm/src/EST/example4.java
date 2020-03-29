package EST;

public class example4 {
	public int solution(int X, int Y, int D) {
		int answer = (Y - X) / D;
		if((Y - X) % D != 0) answer++;
		return answer;
	}
}
