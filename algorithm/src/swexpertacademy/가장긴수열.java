package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장긴수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());

			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());

			int[] map = new int[1000001];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				map[arr[i]] = 1;
			}

			Arrays.sort(arr);
			for (int i = 0; i < N; i++) {
				int value = arr[i];
				for (int j = 2; j * value <= arr[N - 1]; j++) {
					if (map[value * j] != 0 && map[value * j] <= map[value] + 1) {
						map[value * j] = map[value] + 1;
					}
				}
			}
			int answer = 0;
			for (int i = 0; i < map.length; i++) {
				answer = Math.max(answer, map[i]);
			}
			System.out.println("#" + tc + " " + answer);
		}
	}

}
