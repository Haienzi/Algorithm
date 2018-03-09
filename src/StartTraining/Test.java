package StartTraining;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class Test {
	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   long ms = 671684;
		   long ms1 = 607222 ;
		    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
	        formatter.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
	        String hms = formatter.format(416970);
	        String hms1 = formatter.format(710036);
	        System.out.println(hms);
	        System.out.println(hms1);
	         //��ʦ���������ExecutorService������һ��
	}
}
