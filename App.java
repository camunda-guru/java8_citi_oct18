package utility;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LocalDate datenow=LocalDate.now();
		System.out.println(datenow);
		LocalDate datethen=LocalDate.now();
		System.out.println(datethen);
		System.out.println(datethen.compareTo(datenow)==0);
		//print all the time zones
		System.out.println(ZoneId.getAvailableZoneIds());
		ZoneId ausZone=ZoneId.of("Australia/Hobart");
		System.out.println(ausZone.getId());
		LocalDateTime ldt=LocalDateTime.now();
		System.out.println(ldt);
		ZonedDateTime ztime= ZonedDateTime.now(ZoneId.of(ausZone.getId()));
		System.out.println(ztime);
		System.out.println(ChronoUnit.HOURS.between(ldt, ztime));
		LocalTime indtime = LocalTime.now();
		System.out.println(indtime);
		LocalTime austime = LocalTime.now(ausZone);
		System.out.println(austime);
		System.out.println("Asia vs Australia"+indtime.isBefore(austime));// true
		//perform Date calculations		
		LocalDate today=LocalDate.now();
		System.out.println(today.plus(52,ChronoUnit.DAYS));
		System.out.println(today.minus(10,ChronoUnit.DAYS));
		System.out.println(today.getDayOfYear());
		LocalDate bDay = LocalDate.of(1970, Month.DECEMBER, 2);
		 DayOfWeek dayOfWeek = bDay.getDayOfWeek();
		 System.out.println(dayOfWeek); 
		 
		 ZonedDateTime gtime= ZonedDateTime.now(ZoneId.of("Etc/GMT+9"));
			System.out.println(gtime);
			//year, month and day
			Period p = Period.of(5, 6,0);  
			LocalDate test=LocalDate.now();
			System.out.println(test.plus(p));			
			LocalDateTime localDate = LocalDateTime.now();
			ZoneOffset offset = ZoneOffset.of("-02:35");
			gtime= ZonedDateTime.now(offset);
			System.out.println(gtime);
			
	}

}
