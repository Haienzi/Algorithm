package basic_exercise;

/**
 * 01字符串
 * @author mqh
 *
 */
public class T2_01Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	    String[] sNum = new String[32]; 
	    String[] zeros = {"","0000","000","00","0"};//存储补0的字符串
		for(int i = 0; i<32; i++)
		{
			sNum[i] = Integer.toBinaryString(i);//转化为二进制字符串
			//如果不够5位则补零
			if(sNum[i].length() == 1) 
			{
				sNum[i] = zeros[1] + sNum[i];
			}else if(sNum[i].length() == 2) {
				sNum[i] = zeros[2] + sNum[i];
 			}else if(sNum[i].length() == 3) {
 				sNum[i] = zeros[3] + sNum[i];
 			}else if(sNum[i].length() == 4){
				sNum[i] = zeros[4] + sNum[i];
			}
			System.out.println(sNum[i]);
		}
		
	}

}
