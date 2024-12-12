package team.tjusw.elmboot.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CommonUtil {
	

	public static String getCurrentDate() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String dataStr = formatter.format(date);
		return dataStr;
	}

	public static String pullRequestTest(){
		return "pull request test";
	}

	public static String getNextDate(int days) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, days);

		return sdf.format(calendar.getTime());
	}
}
