package ���α׷��ӽ�;

public class ���￡���輭��ã�� {
	public String solution(String[] seoul) {
		int index = 0;
		for (int i = 0; i < seoul.length; i++) {
			if(seoul[i].equals("Kim")) {
				index = i;
				break;
			}
		}
		String answer = "�輭���� "+index+"�� �ִ�";
		return answer;
	}
}
