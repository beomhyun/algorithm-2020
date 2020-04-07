package 카카오2019겨울인턴;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class 크레인인형뽑기게임 {
	public static int solution(int[][] board, int[] moves) {
		Queue<Integer>[] boards = new Queue[board.length];
		for (int i = 0; i < boards.length; i++) {
			boards[i] = new LinkedList<Integer>();
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != 0) {
					boards[j].add(board[i][j]);
				}
			}
		}
		List<String> basket = new ArrayList<>();

		int answer = 0;
		for (int i = 0; i < moves.length; i++) {
			int index = moves[i] - 1;
			if (boards[index].isEmpty()) {
				continue;
			} else {
				int tmp = boards[index].poll();
				if (!basket.isEmpty()) {
					if (Integer.parseInt(basket.get(basket.size() - 1)) == tmp) {
						basket.remove(basket.size() - 1);
						answer += 2;
						continue;
					}
				}
				basket.add("" + tmp);
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };
		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
		System.out.println(solution(board, moves));
	}
}
