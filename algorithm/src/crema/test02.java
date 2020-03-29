package crema;

import java.util.List;

public class test02 {
	public static int getMostVisited(int n, List<Integer> sprints) {
		// Write your code here
		int[] position = new int[n + 1];
		for (int i = 1; i < sprints.size(); i++) {
			int start = sprints.get(i - 1);
			int end = sprints.get(i);

			if (start < end) {
				for (int j = start; j <= end; j++) {
					position[j]++;
				}
			} else {
				for (int j = end; j <= start; j++) {
					position[j]++;
				}
			}
		}
		int max = 0;
		int answer = 0;

		for (int i = position.length - 1; i >= 1; i--) {
			if (max <= position[i]) {
				max = position[i];
				answer = i;
			}
		}
		return answer;
	}
}
