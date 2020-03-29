package crema;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class test04 {
	public static int droppedRequests(List<Integer> requestTime) {
		int answer = 0;

		Queue<Integer> tenSecondsQue = new LinkedList<Integer>();
		Queue<Integer> oneMinuteQue = new LinkedList<Integer>();
		int sumTenSeconds = 0;
		int sumOneMinute = 0;
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();

		for (int i = 0; i < requestTime.size(); i++) {
			int time = requestTime.get(i);
			if (map.containsKey(time)) {
				int count = map.get(time);
				map.put(time, count + 1);
			} else {
				map.put(time, 1);
			}
		}

		for (int key : map.keySet()) {
			int count = map.get(key);
			int remove = count < 3 ? 0 : count - 3;
			tenSecondsQue.add(key);
			oneMinuteQue.add(key);

			while (true) {
				boolean check1 = false;
				boolean check2 = false;
				int peekTenSeconds = tenSecondsQue.peek();
				if (key - peekTenSeconds > 10) {
					sumTenSeconds -= map.get(tenSecondsQue.poll());
					check1 = true;
				}
				int peekOneMinute = oneMinuteQue.peek();
				if (key - peekOneMinute > 60) {
					sumOneMinute -= map.get(tenSecondsQue.poll());
					check2 = true;
				}

				if (!check1 && !check2) {
					break;
				}
			}

			remove = sumTenSeconds + count - remove <= 20 ? remove : sumTenSeconds + count - remove - 20;
			remove = sumOneMinute + count - remove <= 20 ? remove : sumOneMinute + count - remove - 60;
			
			answer += remove;
		}

		return answer;
	}
}
