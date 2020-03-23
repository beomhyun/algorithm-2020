package buzzvil;

import java.util.ArrayList;
import java.util.List;

public class test04 {
	static long maxInversions(List<Integer> prices) {
		long count = 0;
		
		int min = Integer.MAX_VALUE;
		
		for(int num : prices) {
			if(min > num) {
				min = num;
			}
		}
		for (int i = 0; i < prices.size(); i++) {
			int a = prices.get(i);
			if (a == min)
				continue;
			for (int j = i + 1; j < prices.size(); j++) {
				int b = prices.get(j);
				if (b >= a || b == min)
					continue;
				for (int k = j + 1; k < prices.size(); k++) {
					int c = prices.get(k);
					if (c < b) {
						count++;
					}
				}
			}
		}

		return count;
	}

	public static void main(String[] args) {
		List<Integer> prices = new ArrayList<Integer>();

		prices.add(4);
		prices.add(1);
		prices.add(3);
		prices.add(2);
		prices.add(5);

		System.out.println(maxInversions(prices));
	}
}
