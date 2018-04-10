package lintCode;

/**
 * 3.
 * 统计数字出现次数
 * @author Cavielee
 *
 */
public class DigitCounts {

	static int digitCounts(int k, int n) {

		/**
		 * 思路：
		 * 分别算出每一位的k出现的次数
		 * 通过pow表示当前的位，temp代表包含当前位前的数，digit为当前位的数
		 * 比较digit与k有三种情况
		 * ①小于 (temp / 10) * pow 
		 * (temp / 10) * pow  代表（有多少个十倍当前位）*（当前位后面能组合多少个数）。 例如十位上出现k能组合的数有10个
		 * 
		 * ②等于 (temp / 10) * pow + (n - temp * pow + 1)
		 * (n - temp * pow + 1) 当为等于的情况，则代表当前位的数后面的数+1就是多出来的一部分。例k=2，n=223，当算到百位时，则多出23+1个
		 * 
		 * ③大于 (temp / 10 + 1) * pow
		 * (temp / 10 + 1) * pow 如果大于，则可以认为有（temp / 10+1）个十倍当前位
		 */
		// 特殊情况
		if (n < 10 && k == 0)
			return 1; 
		int temp = n, cnt = 0, pow = 1;// pow代表当前位的后面低位是多少，1为个位，10为十位，100为百位
		while (temp != 0) {
			int digit = temp % 10; // 根据当前位置数和k的大小关系，可以算出当前位置出现过k的次数
			if (digit < k)
				cnt += (temp / 10) * pow;
			else if (digit == k)
				cnt += (temp / 10) * pow + (n - temp * pow + 1);
			else {
				if (!(k == 0 && temp / 10 == 0)) // 当k=0时，则最高位无须添加，因为不存在0××..的数
					cnt += (temp / 10 + 1) * pow;
			}
			temp /= 10;
			pow *= 10;
		}
		return cnt;

	}
	
	/**
	 * 暴力破解法
	 * 思路遍历每一个数，然后判断该数的每一位是否等于k
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
