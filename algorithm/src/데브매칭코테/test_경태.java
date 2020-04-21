package 데브매칭코테;

public class test_경태 {
	static int[] standard, clone;
	static int interval, result;

	public static void main(String[] args) {
		int[] numbers = { 10, 40, 30, 20 };
		int k = 20;

		solution(numbers, k);
	}

	public static void init(int[] numbers, int k) {
		standard = numbers.clone(); // 깊은 복사

		interval = k;
		result = Integer.MAX_VALUE;
	}

	public static void solution(int[] numbers, int k) {
		init(numbers, k); // 전역변수 초기화
		dfs(numbers, 0); // 모든경우의 수 구하기

		if (result == Integer.MAX_VALUE) { // 결과값이 변하지 않았다는 것은 인접한 경우의 수가 없었다는 것
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
	}

	public static void dfs(int[] numbers, int depth) {
		if (depth == numbers.length) {
			if (Interval(numbers)) { // 간격이 K이하인가?
				clone = numbers.clone(); // SelectSwap 에 numbers가 들어가면 모든경우의수를 구하는데 혼란이 올수 있기때문에 깊은복사를 통해 섞여도 상관없는 배열을
											// 선언
				result = Math.min(result, SelectSwap());
			}
			return;
		}

		for (int i = depth; i < numbers.length; i++) {
			swap(numbers, i, depth);
			dfs(numbers, depth + 1);
			swap(numbers, i, depth);
		}
	}

	public static void swap(int[] numbers, int a, int b) {
		int temp = numbers[a];
		numbers[a] = numbers[b];
		numbers[b] = temp;
	}

	public static int SelectSwap() { // 전역변수 clone 과 standard 를 비교하여 선택스왑
		int res = 0;
		boolean two_check = false;

		for (int i = 0; i < clone.length; i++) {
			if (clone[i] == standard[i]) { // 일치할경우 넘어감
				continue;
			} else {
				two_check = false;
				for (int j = i + 1; j < clone.length; j++) {
					if (clone[i] == standard[j] && standard[i] == clone[j]) { // 자리를 바꿧을때 두자리 모두 일치하는 경우를 우선해서 탐색
						res++;
						swap(clone, i, j);
						two_check = true;
						break;
					}
				}
				if (!two_check) { // 위에서 두가지 모두 일치하는 경우가 없었을경우 하나만 일치하는경우를 찾아 스왑
					for (int j = i + 1; j < clone.length; j++) {
						if (clone[j] == standard[i]) { // 하나만 일치시킬경우 i번째자리를 일치시켜야함, j번째자리를 일치시킬경우 i를 패스하고 넘어가므로 제대로
														// 동작하지않음
							res++;
							swap(clone, i, j);
							break;
						}
					}
				}

			}
		}
		return res;
	}

	public static boolean Interval(int[] numbers) {
		for (int i = 1; i < numbers.length; i++) {
			if (Math.abs(numbers[i] - numbers[i - 1]) > interval) {
				return false;
			}
		}
		return true;
	}
}
