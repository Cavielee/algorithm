package offer;

/**
 * 6.求旋转数组的最小数字
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。 
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 思路：
 * 通过二分法找到中间元素
 * ①如果中间元素大于下一个元素则最小值为array[midIndex+1]
 * ②如果中间元素小于上一个元素则最小值为array[midIndex]
 * ①或②成立则找到最小元素
 * 
 * ③未找到最小元素，则判断最小元素在mid的左边还是右边（通过用mid的上一个元素与maxIndex比较）
 * 继续循环二分法
 * @author Cavielee
 *
 */
public class MinNumberInRotateArray {

	public int minNumberInRotateArray(int[] array) {
		int min = 0;
		int midIndex;
		int minIndex = 0;
		int maxIndex = array.length - 1;
		while (minIndex < maxIndex) {
			midIndex = (minIndex + maxIndex) >> 1;
			if (array[midIndex] > array[midIndex + 1]) {
				min = array[midIndex + 1];
				break;
			} else if (array[midIndex] < array[midIndex - 1]) {
				min = array[midIndex];
				break;
			} else {
				// 如果mid左边的大于等于maxIndex，则证明最小元素在mid右边
				if (array[midIndex - 1] >= array[maxIndex]) {
					minIndex = midIndex + 1;
				} else {
					maxIndex = midIndex - 1;
				}
			}
		}
		return min;
	}

	public static void main(String[] args) {
		MinNumberInRotateArray minNumberInRotateArray = new MinNumberInRotateArray();
		int[] arr = new int[]{1,1,1,0,1};
		System.out.println(minNumberInRotateArray.minNumberInRotateArray(arr));
	}

}
