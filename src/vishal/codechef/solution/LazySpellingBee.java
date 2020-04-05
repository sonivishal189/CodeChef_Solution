package vishal.codechef.solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LazySpellingBee {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			String s = br.readLine();
			long ans = solve(s);
			System.out.println("Case #" + i + ": " + ans);
		}
		br.close();
	}

	private static long solve(String s) {
		int len = s.length();
		long ans = 1;
		int mod = 1000000007;
		if (len == 1) {
			return ans;
		}
		if (s.charAt(0) != s.charAt(1)) {
			ans = 2;
		}
		for (int i = 1; i < len - 1; i++) {
			ans = (ans * multipleCount(s.charAt(i - 1), s.charAt(i), s.charAt(i + 1))) % mod;
		}
		if (s.charAt(len - 1) != s.charAt(len - 2)) {
			ans = (ans * 2) % mod;
		}
		return ans;
	}

	private static int multipleCount(char a, char b, char c) {
		if (a == b && b == c)
			return 1;
		if (a == b || b == c || a == c)
			return 2;
		return 3;
	}

}
