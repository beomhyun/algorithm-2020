package 프로그래머스;

public class a2016년 {
	public static void main(String[] args) {
		System.out.println(solution(1, 1));
	}

	static String[] day = { "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU" };

	public static String solution(int a, int b) {
		int[] dayPerMonth = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int[] startDay = new int[12];
		startDay[0] = 0;
		for (int i = 1; i < startDay.length; i++) {
			startDay[i] = (startDay[i - 1] + dayPerMonth[i - 1] % 7) % 7;
		}
		String answer = day[(startDay[a - 1] + (b - 1) % 7) % 7];

		return answer;
	}
}
