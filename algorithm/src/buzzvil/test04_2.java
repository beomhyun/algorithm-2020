package buzzvil;

import java.util.ArrayList;
import java.util.List;

public class test04_2 {

	static long maxInversions(List<Integer> prices) {
		long count = 0;
		
		for (int i = 0; i < prices.size(); i++) {
			
		}
		return count;
	}

//	static void dfs(List<Integer> prices, int d, int min, int k) {
//		if (d == prices.size()) {
//			if(k >=3) {
//				count += (k-2);
//			}
//			return;
//		}
//		if (min == 1)
//			return;
//		
//		int tmp = prices.get(d);
//		if (tmp < min) {
//			dfs(prices, d + 1, tmp, k + 1);
//		}
//		dfs(prices, d + 1, min, k);
//	}

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
