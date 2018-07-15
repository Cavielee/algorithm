package offer;

/**
 * 替换字符串中的空格 可以直接用String.replace(regex,replace)方法，regex为正则表达式，replace为替换的内容
 * 正则的\s（表示去掉所有空白符）
 * 
 * @author Cavielee
 *
 */
public class ReplaceSpace {

	// 正解，借助另一个StringBuilder容器，把原字符串复制到新容器中,遇到' '则添加%20
	public static String replaceSpace_1(StringBuffer str) {
		if (str == null)
			return null;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				sb.append("%20");
			} else {
				sb.append(str.charAt(i));
			}
		}
		return sb.toString();
	}

	// 直接通过正则替换
	public static String replaceSpace(StringBuffer str) {
		String replaceStr = str.toString().replaceAll("\\s", "%20");
		return replaceStr;
	}

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("we are children");
		// System.out.println(replaceSpace(sb));
		System.out.println(replaceSpace_1(sb));
	}

}
