package org.springframework.security.core.userdetails.util;

import java.security.MessageDigest;



/**
 * @author gfl
 * 
 */
public class MD5 {
	public String str2MD5(String _str) {
        char hexDigits[] = {
                           '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                           'a', 'b', 'c', 'd',
                           'e', 'f'};
        try {
            byte[] strTemp = _str.getBytes();
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }
    
    // 16λ
    public  String str2MD5to16byte(String _str) {
     return new MD5().str2MD5(_str).substring(8, 24);
    }
    
	public static void main(String[] args) {
		System.out.println(new MD5().str2MD5("admin"));
	}
}
