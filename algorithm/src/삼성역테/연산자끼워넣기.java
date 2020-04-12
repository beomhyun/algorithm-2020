package 삼성역테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 연산자끼워넣기 {
	static final String plus = "plus";
	static final String minus = "minus";
	static final String multiplication = "multiplication";
	static final String division = "division";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] nums = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		List<String> list = new ArrayList<>();
		int tmp = Integer.parseInt(st.nextToken());
		for (int i = 0; i < tmp; i++) {
			list.add(plus);
		}
		tmp = Integer.parseInt(st.nextToken());
		for (int i = 0; i < tmp; i++) {
			list.add(minus);
		}
		tmp = Integer.parseInt(st.nextToken());
		for (int i = 0; i < tmp; i++) {
			list.add(multiplication);
		}
		tmp = Integer.parseInt(st.nextToken());
		for (int i = 0; i < tmp; i++) {
			list.add(division);
		}
		
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		boolean[] used = new boolean[list.size()];
		dfs(nums, list, used, 0, nums[0]);
		
		System.out.println(max);
		System.out.println(min);
	}

	static int min;
	static int max;

	public static void dfs(int[] nums, List<String> list, boolean[] used, int k, int sol) {
		if (k == list.size()) {
			if (sol < min) {
				min = sol;
			}
			if (sol > max) {
				max = sol;
			}
			return;
		}

		for (int i = 0; i < list.size(); i++) {
			if (used[i]) {
				continue;
			}
			String tmp = list.get(i);
			int preSol = sol;
			used[i] = true;
			if (tmp.equals(plus)) {
				sol += nums[k + 1];
				dfs(nums, list, used, k + 1, sol);
			} else if (tmp.equals(minus)) {
				sol -= nums[k + 1];
				dfs(nums, list, used, k + 1, sol);
			} else if (tmp.equals(multiplication)) {
				sol *= nums[k + 1];
				dfs(nums, list, used, k + 1, sol);
			} else if (tmp.equals(division)) {
				sol /= nums[k + 1];
				dfs(nums, list, used, k + 1, sol);
			}
			sol = preSol;
			used[i] = false;
		}
	}
}
