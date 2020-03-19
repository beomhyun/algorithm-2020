package ฤฺลื;

public class test03 {
	public static int solution(int number, int[] firecracker) {
		int[] flower = new int[number];

		for (int i = number - 1; i >= 0; i--) {
			int distance = firecracker[i];
			int index = i - distance;
			if (index < 0) {
				distance += index;
				index = 0;
			}
//			flower[index] = flower[index] > distance ? flower[index] : distance;
			flower[index] = Math.max(flower[index], distance);
		}

		int answer = 0;

		for (int i = 0; i < flower.length; i++) {
			System.out.print(flower[i] + " ");
		}
		System.out.println();

		for (int i = 0; i < flower.length; i++) {
			if (flower[i] == 0)
				answer++;
			else {
				i += flower[i] - 1;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		int number = 2;
		int[] firecracker = { 0, 1 };
		System.out.println(solution(number, firecracker));
	}
}
