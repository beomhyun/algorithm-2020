package buzzvil;

public class test03 {
	public static int perfectSubstring(String s, int k) {
		StringBuilder sb = new StringBuilder(s);
		int answer = 0;
		for (int i = 0; i < sb.length(); i++) {
			for (int j = i; j < sb.length(); j++) {
				boolean check = true;
				boolean overK = false;
				int[] arr = new int[10];			
				String tmp = sb.substring(i, j + 1);
				for (int l = 0; l < tmp.length(); l++) {
					int index = tmp.charAt(l) - '0';
					arr[index]++;
					if(arr[index] > k) {
						check = false;
						overK = true;
						break;
					}
				}
				if(overK)
					break;
				for (int l = 0; l < arr.length; l++) {
					if(arr[l] != 0 && arr[l] != k) {
						check = false;
						break;
					}
				}
				if (check) {
					answer++;
				}
			}
		}
		return answer;
	}

	public static boolean isPerfect(String sb, int k) {
		boolean check = true;
		int[] arr = new int[10];

		for (int i = 0; i < sb.length(); i++) {
			int index = sb.charAt(i) - '0';
			arr[index]++;
			if (arr[index] > k) {
				check = false;
				break;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0 && arr[i] != k) {
				check = false;
				break;
			}
		}

		return check;
	}

	public static void main(String[] args) {

		System.out.println(perfectSubstring("1020122", 2));

	}
}
