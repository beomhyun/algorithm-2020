package EST;

public class excample1 {
	public static int solution(int N) {
		String binaryNumber = Integer.toBinaryString(N);
		System.out.println(binaryNumber);
		int answer = 0;
		
		boolean check = false;
		int preIndex = 0;
		for (int i = 0; i < binaryNumber.length(); i++) {
			if(binaryNumber.charAt(i) == '1') {
				check = true;
				if(check) {
					answer = Math.max(answer, i - preIndex - 1);
					preIndex = i;
				}
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		System.out.println(solution(15));
	}
}
