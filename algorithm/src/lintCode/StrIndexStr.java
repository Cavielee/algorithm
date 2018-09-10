package lintCode;

/**
 * 从字符串A中查找字符串B 如果存在，则返回第一个出现的字符串B位置 如果不存在返回 -1
 * 
 * @author CavieLee
 *
 */
public class StrIndexStr {
	public int strStr(String source, String target) {
		// 校验参数
		if (source == null || target == null || source.length() < target.length()) {
			return -1;
		}
		if (target.length() == 0) {
			return 0;
		}
		// 最多可以比较的次数
		int max = source.length() - target.length();
		char[] sourceArray = source.toCharArray();
		char[] targetArray = target.toCharArray();
		// 目标第一个字符
		char first = targetArray[0];
		for (int i = 0; i <= max; i++) {
			// 查找source与目标第一个字符相同所在的下标
			if (sourceArray[i] != first) {
				while (++i <= max && sourceArray[i] != first)
					;
			}
			if (i <= max) {
				// 判断target剩余的字符是否全匹配
				int j;
				for (j = 1; j < targetArray.length; j++) {
					// 如果不匹配则跳出
					if (sourceArray[i + j] != targetArray[j]) {
						break;
					}
				}
				// 如果匹配则j应该等于targetArray.length
				if (j == targetArray.length) {
					return i;
				}
			}
		}
		return -1;
		// return source.indexOf(target);
	}
}
