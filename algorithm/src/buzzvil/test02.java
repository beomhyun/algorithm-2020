package buzzvil;

public class test02 {
	public static int programmerStrings(String s) {

		int p = 0, r = 0, o = 0, g = 0, a = 0, m = 0, e = 0;

		int startIndex = 0;
		int endIndex = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == 'p') {
				p++;
			} else if (c == 'r') {
				r++;
			} else if (c == 'o') {
				o++;
			} else if (c == 'g') {
				g++;
			} else if (c == 'a') {
				a++;
			} else if (c == 'm') {
				m++;
			} else if (c == 'e') {
				e++;
			}
			if (p >= 1 && r >= 3 && o >= 1 && g >= 1 && a >= 1 && m >= 2 && e >= 1) {
				startIndex = i + 1;
				break;
			}
		}
		p = 0;
		r = 0;
		o = 0;
		g = 0;
		a = 0;
		m = 0;
		e = 0;

		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);

			if (c == 'p') {
				p++;
			} else if (c == 'r') {
				r++;
			} else if (c == 'o') {
				o++;
			} else if (c == 'g') {
				g++;
			} else if (c == 'a') {
				a++;
			} else if (c == 'm') {
				m++;
			} else if (c == 'e') {
				e++;
			}
			if (p >= 1 && r >= 3 && o >= 1 && g >= 1 && a >= 1 && m >= 2 && e >= 1) {
				endIndex = i - 1;
				break;
			}
		}

		return endIndex - startIndex + 1;
	}
}
