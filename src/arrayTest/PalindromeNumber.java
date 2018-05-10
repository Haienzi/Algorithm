package arrayTest;
/**
 * 判断一个数字是否是回文数
 * @author mqh
 * O(1)的空间所以不能用字符串反转的方法
 *
 */
public class PalindromeNumber {
    public boolean isPalindomeNumber(int number)
    {
    	 if(number<0)
    	        return false;
    	    int div = 1;
    	    while(div<=number/10)
    	        div *= 10;
    	    while(number>0)
    	    {
    	        if(number/div!=number%10)//判断最高位和最低位的数据是否相等
    	            return false;
    	        number = (number%div)/10;
    	        div /= 100;
    	    }
    	    return true;
    }
}
