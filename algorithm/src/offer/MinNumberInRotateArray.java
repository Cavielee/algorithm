package offer;

/**
 * 6.����ת�������С����
 * ����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء� 
 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1��
 * NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
 * ˼·��
 * ͨ�����ַ��ҵ��м�Ԫ��
 * ������м�Ԫ�ش�����һ��Ԫ������СֵΪarray[midIndex+1]
 * ������м�Ԫ��С����һ��Ԫ������СֵΪarray[midIndex]
 * �ٻ�ڳ������ҵ���СԪ��
 * 
 * ��δ�ҵ���СԪ�أ����ж���СԪ����mid����߻����ұߣ�ͨ����mid����һ��Ԫ����maxIndex�Ƚϣ�
 * ����ѭ�����ַ�
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
				// ���mid��ߵĴ��ڵ���maxIndex����֤����СԪ����mid�ұ�
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
