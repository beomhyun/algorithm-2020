package ฤฺลื;

public class test02 {
	public static boolean solution(String s1, String s2) {
		if (s1.length() > s2.length())
			return false;
		if (s1.equals(s2))
			return true;
		if (s1.length() == s2.length() && !s1.equals(s2))
			return false;
		int s1Index = 0;
		int s2Index = 0;

		boolean answer = true;
		System.out.println(s1);
		System.out.println(s2);
		while (s1Index < s1.length()) {
			char s1Char = s1.charAt(s1Index);
			char s2CHar = s2.charAt(s2Index);
			System.out.println(s1Char);
			System.out.println(s2CHar);
			System.out.println();
			if (s1Char == s2CHar) {
				if (s1Index + 1 < s1.length() && s1Char == s1.charAt(s1Index + 1)) {
					s1Index++;
					s2Index++;
					continue;
				}
				boolean end = true;
				for (int i = s2Index; i < s2.length(); i++) {
					if (s2.charAt(i) != s1Char) {
						s2Index = i;
						end = false;
						break;
					}
				}
				if (end) {
					s2Index = s2.length();
				}
			} else {
				answer = false;
				break;
			}
			s1Index++;
		}
		System.out.println(s2Index);
		System.out.println(s2.length());
		if (s2Index < s2.length())
			answer = false;
		return answer;
	}

	public static void main(String[] args) {
		String s1 = "aa";
		String s2 = "aab";
		System.out.println(solution(s1, s2));
	}
}
