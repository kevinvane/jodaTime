package jodaTime;


import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.joda.time.Duration;
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
		//initDataTime();
		//currentTime();
		//formatTimeMillis();
		//afterDay();
		//isAfter();
		//isBeforeNow();
		//nowHowLong();
		//millis();
		//calculateTime();
		calculateTimeDuration();
	}
	
	
	/**
	 * 
	 * 计算一个时刻，在X天之后的那个时刻距离现在相差多少天 或者是多少小时等
	 * 用JadaTime的时间跨度来计算(时间跨度类有三个Duration/Period/Interval)
	 * 
	 */
	public static void calculateTimeDuration(){
		
		DateTime dateTime = new DateTime(2016, 6, 12, 13, 0, 0, 0).plusDays(5);
		long now = DateTimeUtils.currentTimeMillis();
		long end = DateTimeUtils.getInstantMillis(dateTime);

		//Duration duration = new Duration(now,end);
		Duration duration = new Duration(new DateTime(),dateTime);
		long hourDuration = duration.getStandardHours();
		long dayDuration = duration.getStandardDays();
		System.out.println("hourDuration = "+hourDuration);
		System.out.println("dayDuration = "+dayDuration);
	}
	
	
	/**
	 * 
	 * 计算一个时刻，在X天之后的那个时刻距离现在相差多少天 
	 * 自己通过毫秒计算
	 * 
	 */
	public static void calculateTime(){

		final long oneDayMillis = 24*60*60*1000;

		DateTime dateTime = new DateTime(2016, 6, 12, 13, 0, 0, 0).plusDays(5);
		long now = DateTimeUtils.currentTimeMillis();
		long end = DateTimeUtils.getInstantMillis(dateTime);
		//long end = DateTimeUtils.getInstantMillis(dateTime) + 5*oneDayMillis;
		
		long millis = now - end;
		
		System.out.println(now +" - " + end + " = " + millis);
		
		
		millis = Math.abs(millis) ;
		System.out.println("Math.abs(millis)="+Math.abs(millis));
		
		float temp = (float)millis/(float)oneDayMillis;
		System.out.println("millis/oneDayMillis = "+millis+" / "+oneDayMillis+" = "+temp);
		
		int days = Math.round(temp);
		System.out.println("days="+days);
		/**
		 	1466061161300 - 1466139600000 = -78438700
			Math.abs(millis)=78438700
			millis/oneDayMillis = 78438700 / 86400000 = 0.9078554
			days=1
		 */
	}
	
	/**
	 * 获取时间的毫秒
	 */
	public static long millis(){
		DateTime dateTime = new DateTime(2016, 6, 12, 17, 0, 0, 0);
        long instantMillis = DateTimeUtils.getInstantMillis(dateTime);
        System.out.println(instantMillis);
        return instantMillis;
	}
	
	/**
	 * 距离现在有多少天(以相差24小时为准)
	 */
	public static void nowHowLong(){
		DateTime dateTime = new DateTime(2016, 6, 12, 14, 0, 0, 0);
        long instantMillis = DateTimeUtils.getInstantMillis(dateTime);
        long millis = DateTimeUtils.currentTimeMillis()-instantMillis;
        System.out.println(DateTimeUtils.currentTimeMillis()-instantMillis);
        System.out.println(Math.round(millis/(24*60*60*1000)));//24*
	}
	/**
	 * 一个[时刻]，计算5天之后的[时刻]是在现在(now)的前面还是后面
	 */
	public static void isAfter(){

		String timestamp = "1465707600000";
		DateTime dateTime = new DateTime(Long.valueOf(timestamp));
		//DateTime dateTime = new DateTime(2016, 6, 12, 0, 0, 0, 0);
		System.out.println(dateTime.toString());
		
		DateTime dateTime5 = dateTime.plusDays(2);
		System.out.println(dateTime5.toString());
		
		boolean isBefore = dateTime5.isBeforeNow();
		System.out.println("时间过了吗？"+isBefore);
	}
	
	/**
	 * 一个时刻跟现在比较，它是否已经过去了
	 */
	public static void isBeforeNow(){

		DateTime dateTime = new DateTime(2016, 6, 12, 0, 0, 0, 0);
		
		boolean isBefore = dateTime.isBeforeNow();
		System.out.println(dateTime.toString() + "已过去?  isBeforeNow:"+isBefore);
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
