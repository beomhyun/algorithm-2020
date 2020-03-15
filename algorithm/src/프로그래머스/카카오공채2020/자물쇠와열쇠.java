package 프로그래머스.카카오공채2020;

public class 자물쇠와열쇠 {
	static boolean isOk = false;
	public static void main(String[] args) {
		int[][] key = { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 1 } };
		int[][] lock = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };

		System.out.println(solution(key, lock));
	}

	public static boolean solution(int[][] key, int[][] lock) {
		int lockLength = lock.length;
		
		int[][] copyLock = new int[lockLength * 3][lockLength * 3];
		
		for (int i = 0; i < lockLength; i++) {
			for (int j = 0; j < lockLength; j++) {
				copyLock[i + lockLength] [j + lockLength] = lock[i][j];
			}
		}
		dfs(key, copyLock, 0);
		return isOk;
	}
	public static void dfs(int[][] key, int[][] lock, int count) {
		
	}
	public int[][] rotate(int[][] key) {
		int length = key.length;
		int[][] tempKey = new int[length][length];
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				tempKey[i][j] = key[length - j - 1][i];
			}
		}
		return tempKey;
	}
}