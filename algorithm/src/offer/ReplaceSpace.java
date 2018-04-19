package offer;

/**
 * 替换字符串中的空格
 * 可以直接用String.replace(regex,replace)方法，regex为正则表达式，replace为替换的内容
 * 正则的\s（表示去掉所有空白符）
 * @author Cavielee
 *
 */
public class ReplaceSpace {

	public static String replaceSpace(StringBuffer str) {
		String replaceStr = str.toString().replaceAll("\\s", "%20");
		return replaceStr;
	}

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("we are children");
		System.out.println(replaceSpace(sb));
	}

}
