package niuke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class ScoreSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			String string;
			while ((string = reader.readLine()) != null) {
				int count = Integer.parseInt(string);
				int sortType = Integer.parseInt(reader.readLine());
				ArrayList<ScoreInfo> scoreInfos = new ArrayList<>();
				for(int i=0;i<count;i++)
				{
					String line = reader.readLine();
					String[] partInfo = line.split(" ");
					String userName = partInfo[0];
					int score = Integer.parseInt(partInfo[1]);
					ScoreInfo scoreInfo = new ScoreInfo(userName, score);
					scoreInfos.add(scoreInfo);
				}
				Collections.sort(scoreInfos);
			
				if(sortType == 0) {
					Collections.reverse(scoreInfos);
				}
				for(ScoreInfo scoreInfo:scoreInfos) {
					System.out.println(scoreInfo);
				}
			}
		}catch (IOException e) {
			// TODO: handle exception
		}

	}

}
class ScoreInfo implements Comparable<ScoreInfo>{
	private String userName;
	private int score;
	public ScoreInfo(String userName,int score)
	{
		this.userName = userName;
		this.score = score;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return (userName+" "+score);
	}
	@Override
	public int compareTo(ScoreInfo o) {
		// TODO Auto-generated method stub
		if(o.score > score) {
			return -1;
		}
		if(o.score <score) {
			return 1;
		}
		return  0;
	}
}
