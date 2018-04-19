package offer;

/**
 * È¥³ý¿Õ¸ñ
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
