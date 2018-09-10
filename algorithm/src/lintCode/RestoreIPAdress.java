package lintCode;
import java.util.ArrayList;
import java.util.List;

public class RestoreIPAdress {

	public List<String> restoreIpAddresses(String s) {
		List<String> ips = new ArrayList<>();

		if (s.length() < 4 || s.length() > 12) {
			return ips;
		}

		for (int i = 0; i < 3; i++) {
			String left = s.substring(0, i + 1);
			String right = s.substring(i + 1);
			// left or right is 0
			if (left.charAt(0) == '0') {
				if (left.length() != 1) {
					continue;
				}
			}
			if (Integer.valueOf(left) <= 255) {
				dfs(left, right, ips);
			}
		}

		return ips;
	}

	public static void dfs(String ip, String sub, List<String> ips) {
		int ipNum = ip.split("\\.").length;

		// 如果个数为4个
		if (ipNum == 4) {
			if (!ips.contains(ip)) {
				ips.add(ip);
			}
			return;
		}

		for (int i = 0; i < 3 && i < sub.length(); i++) {
			String left = sub.substring(0, i + 1);
			String right = sub.substring(i + 1);
			// left or right is 0
			if (left.charAt(0) == '0') {
				if (left.length() != 1) {
					continue;
				}
			}

			if (Integer.valueOf(left) <= 255 && right.length() >= (4 - ipNum - 1)
					&& right.length() <= ((4 - ipNum - 1) * 3)) {
				String newIP = ip + "." + left;
				dfs(newIP, right, ips);
			}

		}
	}
}
