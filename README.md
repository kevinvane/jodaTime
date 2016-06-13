

[JodaOrg/joda-time](https://github.com/JodaOrg/joda-time)一个面向 Java 平台的易于使用的开源时间/日期库,令时间和日期值变得易于管理、操作和理解.

所以尝试简单执行一下代码

``
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
``

更多例子在

[http://www.joda.org/joda-time](http://www.joda.org/joda-time/ )

[http://www.ibm.com/developerworks/cn/java/j-jodatime.html](http://www.ibm.com/developerworks/cn/java/j-jodatime.html)

