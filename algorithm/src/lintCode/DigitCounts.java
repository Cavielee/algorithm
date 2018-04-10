package lintCode;

/**
 * 3.
 * ͳ�����ֳ��ִ���
 * @author Cavielee
 *
 */
public class DigitCounts {

	static int digitCounts(int k, int n) {

		/**
		 * ˼·��
		 * �ֱ����ÿһλ��k���ֵĴ���
		 * ͨ��pow��ʾ��ǰ��λ��temp���������ǰλǰ������digitΪ��ǰλ����
		 * �Ƚ�digit��k���������
		 * ��С�� (temp / 10) * pow 
		 * (temp / 10) * pow  �����ж��ٸ�ʮ����ǰλ��*����ǰλ��������϶��ٸ������� ����ʮλ�ϳ���k����ϵ�����10��
		 * 
		 * �ڵ��� (temp / 10) * pow + (n - temp * pow + 1)
		 * (n - temp * pow + 1) ��Ϊ���ڵ�����������ǰλ�����������+1���Ƕ������һ���֡���k=2��n=223�����㵽��λʱ������23+1��
		 * 
		 * �۴��� (temp / 10 + 1) * pow
		 * (temp / 10 + 1) * pow ������ڣ��������Ϊ�У�temp / 10+1����ʮ����ǰλ
		 */
		// �������
		if (n < 10 && k == 0)
			return 1; 
		int temp = n, cnt = 0, pow = 1;// pow����ǰλ�ĺ����λ�Ƕ��٣�1Ϊ��λ��10Ϊʮλ��100Ϊ��λ
		while (temp != 0) {
			int digit = temp % 10; // ���ݵ�ǰλ������k�Ĵ�С��ϵ�����������ǰλ�ó��ֹ�k�Ĵ���
			if (digit < k)
				cnt += (temp / 10) * pow;
			else if (digit == k)
				cnt += (temp / 10) * pow + (n - temp * pow + 1);
			else {
				if (!(k == 0 && temp / 10 == 0)) // ��k=0ʱ�������λ������ӣ���Ϊ������0����..����
					cnt += (temp / 10 + 1) * pow;
			}
			temp /= 10;
			pow *= 10;
		}
		return cnt;

	}
	
	/**
	 * �����ƽⷨ
	 * ˼·����ÿһ������Ȼ���жϸ�����ÿһλ�Ƿ����k
	 * @param k
	 * @param n
	 * @return
	 */
	static int digitCounts_2(int k, int n) { 
		int sum=0;  
        for(int i=0;i<=n;i++){  
            int num=i;  
            while(num/10!=0){  
                if(num%10==k){  
                    sum++;  
                }  
                num=num/10;  
            }  
            if(num==k)  
            sum++;  
        }  
          
        return sum;  
	}

	public static void main(String[] args) {
//		System.out.println(digitCounts(1, 9));
		System.out.println(digitCounts_2(1, 11));

	}

}
