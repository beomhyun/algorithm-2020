package EST;

import java.util.HashMap;
import java.util.Map;

public class test04 {
	public String solution(String S, String C) {
		StringBuilder str = new StringBuilder();
		String[] names = S.split("; ");
		final String company = "@" + C.toLowerCase() + ".com";

		Map<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < names.length; i++) {
			String[] fullName = names[i].split(" ");
			String emailName = "" + fullName[fullName.length - 1] + "_" + fullName[0];
			emailName = emailName.replace("-", "");
			if (map.containsKey(emailName)) {
				int count = map.get(emailName);
				map.put(emailName, count + 1);
				emailName += count;
			} else {
				map.put(emailName, 2);
			}
			StringBuilder email = new StringBuilder("<" + emailName + company + ">");
			if (i != names.length - 1) {
				email.append("; ");
			}
			str.append(names[i] + " " + email.toString().toLowerCase());
		}

		return str.toString();
	}

	public static void main(String[] args) {
		test04 test = new test04();
		System.out.println(test.solution(
				"John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker",
				"Test"));

	}
}
