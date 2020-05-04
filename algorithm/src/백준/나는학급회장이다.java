package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 나는학급회장이다 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		Map<Integer, score> map = new HashMap<>();
		map.put(1, new score());
		map.put(2, new score());
		map.put(3, new score());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			map.get(1).add(Integer.parseInt(st.nextToken()));
			map.get(2).add(Integer.parseInt(st.nextToken()));
			map.get(3).add(Integer.parseInt(st.nextToken()));
		}

		int maxIndex = 0;
		int maxScore = 0;
		boolean sameScore = false;

		for (int index : map.keySet()) {
			int score = map.get(index).sum();
			if (maxScore == score) {
				if (map.get(index).three == map.get(maxIndex).three) {
					if (map.get(index).two == map.get(maxIndex).two) {
						sameScore = true;
					} else if (map.get(index).two > map.get(maxIndex).two) {
						maxIndex = index;
						sameScore = false;
					}
				} else if (map.get(index).three > map.get(maxIndex).three) {
					maxIndex = index;
					sameScore = false;
				}
			} else if (maxScore < score) {
				maxIndex = index;
				maxScore = score;
				sameScore = false;
			}
		}
		if (sameScore) {
			System.out.println(0 + " " + maxScore);
		} else {
			System.out.println(maxIndex + " " + maxScore);
		}
	}

	public static class score {
		int three;
		int two;
		int one;

		public void add(int num) {
			if (num == 1) {
				this.one++;
			} else if (num == 2) {
				this.two++;
			} else if (num == 3) {
				this.three++;
			}
		}

		public int sum() {
			return (this.three * 3) + (this.two * 2) + this.one;
		}
	}
}
