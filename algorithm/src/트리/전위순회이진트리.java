package 트리;

import java.util.ArrayList;
import java.util.List;

public class 전위순회이진트리 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(3);
		list.add(4);

		System.out.println(solution(list));
	}

	public static boolean solution(List<Integer> list) {
		if (list.size() == 0)
			return true;
		int root = list.get(0);
		int leftEnd = 0;

		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) > root) {
				leftEnd = i - 1;
				break;
			}
		}

		for (int i = leftEnd + 1; i < list.size(); i++) {
			if (list.get(i) < root)
				return false;
		}
		List<Integer> left = new ArrayList<Integer>();
		List<Integer> right = new ArrayList<Integer>();

		for (int i = 1; i < leftEnd; i++) {
			left.add(list.get(i));
		}
		for (int i = leftEnd + 1; i < list.size(); i++) {
			right.add(list.get(i));
		}

		return (solution(left) & solution(right));
	}
}
