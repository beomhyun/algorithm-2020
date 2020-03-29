package EST;

import java.util.ArrayList;

public class test03 {
	static int answer;

	public int solution(int[] A) {
		answer = 0;
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < A.length; i++) {
			list.add("" + A[i]);
		}
		if (isAestheticallyPleasing(list)) {
			return 0;
		}
		for (int i = 0; i < A.length; i++) {
			list.remove(i);

			if (isAestheticallyPleasing(list)) {
				answer++;
			}
			list.add(i, "" + A[i]);
		}
		if (answer == 0) {
			answer = -1;
		}
		return answer;
	}

	public static boolean isAestheticallyPleasing(ArrayList<String> list) {
		boolean check = true;
		for (int i = 1; i < list.size() - 1; i++) {
			if ((Integer.parseInt(list.get(i)) > Integer.parseInt(list.get(i - 1))
					&& Integer.parseInt(list.get(i)) > Integer.parseInt(list.get(i + 1)))
					|| (Integer.parseInt(list.get(i)) < Integer.parseInt(list.get(i - 1))
							&& Integer.parseInt(list.get(i)) < Integer.parseInt(list.get(i + 1)))) {
				continue;
			} else {
				check = false;
				break;
			}
		}
		return check;
	}

	public static void main(String[] args) {
		int[] A = { 3, 3, 5, 3, 7 };
		test03 test = new test03();
		System.out.println(test.solution(A));
	}
}
