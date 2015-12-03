package dto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;





public class SequenceTest {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		
		//ApplicationContext app=new ClassPathXmlApplicationContext("spring-base.xml");
		

		//com.jy.platform.restservice.mybatis.PageInterceptor
		//System.out.println(addZeroForNum("11",4));
	/*	String payAccount = "44.44";
		BigDecimal a=new BigDecimal(payAccount);
		System.out.println(a.negate());*/
/*		Long a=1L;
		Long b=new Long(1);
		System.out.println(a.equals(b));*/
    	String createTime_start ="2011-12-04";
    	String createTime_end ="2012-12-02";
    	
    	SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
    	Date createTimeStart= sdf.parse(createTime_start);
    	Date createTimeEnd= sdf.parse(createTime_end);
    	
    System.out.println(createTimeStart.compareTo(createTimeEnd));
	

	}
	public static String addZeroForNum(String str, int strLength) {
		int strLen = str.length();
		if (strLen < strLength) {
			while (strLen < strLength) {
				StringBuffer sb = new StringBuffer();
				sb.append("0").append(str);// 左补0
				str = sb.toString();
				strLen = str.length();
			}
		}
		return str;
	}

}
