package vn.edu.vinaenter.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class StringUtil {
	
	public String md5(String str){
		MessageDigest md;
		String result = "";
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			BigInteger bi = new BigInteger(1, md.digest());
			
			result = bi.toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static String dateFormat(Timestamp timestamp) {
		String formattedDate = new SimpleDateFormat("dd/MM/yyyy").format(timestamp);
		return formattedDate;	
	}
	
	public static String getDay(Timestamp timestamp) {
		String formattedDate = new SimpleDateFormat("dd").format(timestamp);
		return formattedDate;	
	}
	
	public static String getMonth(Timestamp timestamp) {
		String formattedDate = new SimpleDateFormat("MM").format(timestamp);
		return formattedDate;	
	}

}
