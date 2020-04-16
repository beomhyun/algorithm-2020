package 카카오2019겨울인턴;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 호텔방배정 {
	public static long[] solution(long k, long[] room_number) {
		long[] answer = new long[room_number.length];
		Map<Long, Long> map = new HashMap<>();
		for (int i = 0; i < room_number.length; i++) {
			long tmp = room_number[i];
			List<Long> list = new ArrayList<Long>();

			if (!map.containsKey(tmp)) {
				map.put(tmp, tmp + 1);
				answer[i] = tmp;
			} else {
				long parent = map.get(tmp);
				list.add(parent);
				while (true) {
					if (!map.containsKey(parent)) {
						map.put(parent, parent + 1);
						answer[i] = parent;
						break;
					} else {
						list.add(parent);
						parent = map.get(parent);
					}
				}
				for (long l : list) {
					map.put(l, parent + 1);
				}
			}

		}
		return answer;
	}

	public static void main(String[] args) {
		long k = 10;
		long[] room_number = { 1, 3, 4, 1, 3, 1 };
		System.out.println(solution(k, room_number));
	}
}
