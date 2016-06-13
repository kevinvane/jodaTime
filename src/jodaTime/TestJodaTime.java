package jodaTime;


import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.joda.time.LocalDate;


/***
 * https://github.com/JodaOrg/joda-time
 * http://www.ibm.com/developerworks/cn/java/j-jodatime.html
 * http://www.joda.org/joda-time/
 * 
 */
public class TestJodaTime {

	public static long time = Long.valueOf("1465798229208");

	public static void main(String[] args) {
		
		//System.out.println(System.currentTimeMillis());
		initDataTime();
		//currentTime();
		//formatTimeMillis();
		//afterDay();
	}
	
	/**
	 * 初始化一个时刻
	 */
	public static void initDataTime(){
		DateTime dateTime = new DateTime(2000, 1, 1, 0, 0, 0, 0);
		System.out.println(dateTime.toString());
		//2000-01-01T00:00:00.000+08:00
	}
	
	/**
	 * 距离 时间戳 45 天之后的某天在下一个月的当前周的最后一天的日期
	 */
	public static void afterDay(){
		
		DateTime dateTime = new DateTime(time);
		System.out.println(dateTime.plusDays(45).plusMonths(1).dayOfWeek()
				  .withMaximumValue().toString("E MM/dd/yyyy HH:mm:ss.SSS"));
		
		System.out.println(dateTime.plusDays(5)
				  .toString("E MM/dd/yyyy HH:mm:ss.SSS"));
	}
	
	/**
	 * 把一个毫秒的时间戳转换为日期
	 */
	public static void formatTimeMillis(){
		
		//生成某个随意的时刻的对象
		DateTime dateTime = new DateTime(time);
		System.out.println(dateTime.toString("yyyy-MM-dd HH:mm:ss"));
	}
	
	public static void currentTime(){
		
		System.out.println("时间戳："+DateTimeUtils.currentTimeMillis());
		
		DateTime dateTime = new DateTime();
        System.out.println("带有时区："+dateTime.toString());
        
        LocalDate localDate = new LocalDate();
        System.out.println("不带有时区："+localDate.toString());
        
	}
}
