package org.jjmyth.Util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;





public class EncryptTools {
	/**
	 *   AES加解密
	 * 
	 * 
	 */
	 private static final String AES = "AES";  
	  
	    private static final String CRYPT_KEY = "YUUAtestYUUAtest";  
	  
	    /** 
	     * 加密 
	     *  
	     * @param encryptStr 
	     * @return 
	     */  
	    public static byte[] encrypt(byte[] src, String key) throws Exception {  
	        Cipher cipher = Cipher.getInstance(AES);  
	        SecretKeySpec securekey = new SecretKeySpec(key.getBytes(), AES);  
	        cipher.init(Cipher.ENCRYPT_MODE, securekey);//设置密钥和加密形式  
	        return cipher.doFinal(src);  
	    }  
	  
	    /** 
	     * 解密 
	     *  
	     * @param decryptStr 
	     * @return 
	     * @throws Exception 
	     */  
	    public static byte[] decrypt(byte[] src, String key)  throws Exception  {  
	        Cipher cipher = Cipher.getInstance(AES);  
	        SecretKeySpec securekey = new SecretKeySpec(key.getBytes(), AES);//设置加密Key  
	        cipher.init(Cipher.DECRYPT_MODE, securekey);//设置密钥和解密形式  
	        return cipher.doFinal(src);  
	    }  
	      
	    /** 
	     * 二行制转十六进制字符串 
	     *  
	     * @param b 
	     * @return 
	     */  
	    public static String byte2hex(byte[] b) {  
	        String hs = "";  
	        String stmp = "";  
	        for (int n = 0; n < b.length; n++) {  
	            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));  
	            if (stmp.length() == 1)  
	                hs = hs + "0" + stmp;  
	            else  
	                hs = hs + stmp;  
	        }  
	        return hs.toUpperCase();  
	    }  
	  
	    public static byte[] hex2byte(byte[] b) {  
	        if ((b.length % 2) != 0)  
	            throw new IllegalArgumentException("长度不是偶数");  
	        byte[] b2 = new byte[b.length / 2];  
	        for (int n = 0; n < b.length; n += 2) {  
	            String item = new String(b, n, 2);  
	            b2[n / 2] = (byte) Integer.parseInt(item, 16);  
	        }  
	        return b2;  
	    }  
	      
	    /** 
	     * 解密 
	     *  
	     * @param data 
	     * @return 
	     * @throws Exception 
	     */  
	    public final static String AESDecrypt(String data) {  
	        try {  
	            return new String(decrypt(hex2byte(data.getBytes()),  
	                    CRYPT_KEY));  
	        } catch (Exception e) {  
	        }  
	        return null;  
	    }  
	  
	    /** 
	     * 加密 
	     *  
	     * @param data 
	     * @return 
	     * @throws Exception 
	     */  
	    public final static String AESEncrypt(String data) {  
	        try {  
	            return byte2hex(encrypt(data.getBytes(), CRYPT_KEY));  
	        } catch (Exception e) {  
	        }  
	        return null;  
	    }  
	    
	    
	    
	    public static String SHA256Encrypt(String info) { 
	        MessageDigest md = null; 
	        try { 
	            md = MessageDigest.getInstance("SHA-256"); 
	        } catch (NoSuchAlgorithmException e) { 
	            e.printStackTrace(); 
	        } 
	        if (null != md) { 
	            byte[] origBytes = info.getBytes(); 
	            md.update(origBytes); 
	            byte[] digestRes = md.digest(); 
	            String digestStr = getDigestStr(digestRes); 
	            return digestStr; 
	        }

	        return null; 
	    }

	    private static String getDigestStr(byte[] origBytes) { 
	        String tempStr = null; 
	        StringBuilder stb = new StringBuilder(); 
	        for (int i = 0; i < origBytes.length; i++) { 
	            // System.out.println("and by bit: " + (origBytes[i] & 0xff)); 
	            // System.out.println("no and: " + origBytes[i]); 
	            // System.out.println("---------------------------------------------"); 
	            // 这里按位与是为了把字节转整时候取其正确的整数，java中一个int是4个字节 
	            // 如果origBytes[i]最高位为1，则转为int时，int的前三个字节都被1填充了 
	            tempStr = Integer.toHexString(origBytes[i] & 0xff); 
	            if (tempStr.length() == 1) { 
	                stb.append("0"); 
	            } 
	            stb.append(tempStr);

	        } 
	        return stb.toString(); 
	    }
	    
	    
	    

}
