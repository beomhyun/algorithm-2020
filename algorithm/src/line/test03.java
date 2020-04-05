package line;

import java.util.ArrayList;
import java.util.List;

public class test03 {
	public int solution(String road, int n) {
		int answer = 0;
		List<Integer> zeroList = new ArrayList<Integer>();
		int usedN = 0;

		int startIndex = 0;
		boolean startCheck = false;

		for (int i = 0; i < road.length(); i++) {
			if (!startCheck && road.charAt(i) == '1') {
				startIndex = i;
			}
			if (road.charAt(i) == '0') {
				zeroList.add(i);
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		boolean[] a = new boolean[300001];

	}
}
