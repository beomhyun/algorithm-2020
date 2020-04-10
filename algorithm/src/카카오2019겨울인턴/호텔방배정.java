package īī��2019�ܿ�����;

import java.util.HashSet;
import java.util.Set;

public class ȣ�ڹ���� {
	public long[] solution(long k, long[] room_number) {
		long[] answer = new long[room_number.length];
		Set<Long> set = new HashSet();
		for (int i = 0; i < answer.length; i++) {
			answer[i] = findRoom(set, room_number[i], k);
		}
		return answer;
	}

	public static long findRoom(Set<Long> set, long wanted, long k) {
		if (!set.contains(wanted)) {
			set.add(wanted);
			return wanted;
		}
		long index = wanted;
		while (index <= k) {
			if (!set.contains(index)) {
				set.add(index);
				return index;
			} else {
				index++;
			}
		}
		return 0;
	}
}
