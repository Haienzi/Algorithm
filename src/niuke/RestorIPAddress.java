package niuke;

import java.util.ArrayList;
import java.util.List;

public class RestorIPAddress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String string = "25525511135";
        List<String> resIps = restoreAddresses(string);
        for (String string2 : resIps) {
			System.out.println(string2);
		}
	}
	
	public static List<String> restoreAddresses(String s){
		List<String> res = new ArrayList<>();
		if(s.length()<4 || s.length()>12) 
			return res;
		dfs(s, "", res, 0);
		return res;
		
	}
	//深度优先搜索
	public static void dfs(String s,String temp,List<String> res,int count) {
		if(count == 3 && isValid(s)) { //递归终止条件
			res.add(temp + s);
		}
		for(int i=1;i<4&& i<s.length();i++) {
			String subString = s.substring(0, i);
			if(isValid(subString)) {
				dfs(s.substring(i), temp + subString + ".", res, count+1);
			}
		}
	}
	//判断是否合法
	public static boolean isValid(String s) {
		//如果第一位取出来的是0 那么就判断整个字符串是否是0，不是的情况都是非法的 001,010,03 都是非法的
		if(s.charAt(0) == '0')
		{
			return s.equals("0");
		}
		
		int num = Integer.parseInt(s);
		return num>0 && num<=255;
	}

}
