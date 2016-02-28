package org.jjmyth.Util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;





public class EncryptTools {
	/**
	 *   AES�ӽ���
	 * 
	 * 
	 */
	 private static final String AES = "AES";  
	  
	    private static final String CRYPT_KEY = "YUUAtestYUUAtest";  
	  
	    /** 
	     * ���� 
	     *  
	     * @param encryptStr 
	     * @return 
	     */  
	    public static byte[] encrypt(byte[] src, String key) throws Exception {  
	        Cipher cipher = Cipher.getInstance(AES);  
	        SecretKeySpec securekey = new SecretKeySpec(key.getBytes(), AES);  
	        cipher.init(Cipher.ENCRYPT_MODE, securekey);//������Կ�ͼ�����ʽ  
	        return cipher.doFinal(src);  
	    }  
	  
	    /** 
	     * ���� 
	     *  
	     * @param decryptStr 
	     * @return 
	     * @throws Exception 
	     */  
	    public static byte[] decrypt(byte[] src, String key)  throws Exception  {  
	        Cipher cipher = Cipher.getInstance(AES);  
	        SecretKeySpec securekey = new SecretKeySpec(key.getBytes(), AES);//���ü���Key  
	        cipher.init(Cipher.DECRYPT_MODE, securekey);//������Կ�ͽ�����ʽ  
	        return cipher.doFinal(src);  
	    }  
	      
	    /** 
	     * ������תʮ�������ַ��� 
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
	            throw new IllegalArgumentException("���Ȳ���ż��");  
	        byte[] b2 = new byte[b.length / 2];  
	        for (int n = 0; n < b.length; n += 2) {  
	            String item = new String(b, n, 2);  
	            b2[n / 2] = (byte) Integer.parseInt(item, 16);  
	        }  
	        return b2;  
	    }  
	      
	    /** 
	     * ���� 
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
	     * ���� 
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
	            // ���ﰴλ����Ϊ�˰��ֽ�ת��ʱ��ȡ����ȷ��������java��һ��int��4���ֽ� 
	            // ���origBytes[i]���λΪ1����תΪintʱ��int��ǰ�����ֽڶ���1����� 
	            tempStr = Integer.toHexString(origBytes[i] & 0xff); 
	            if (tempStr.length() == 1) { 
	                stb.append("0"); 
	            } 
	            stb.append(tempStr);

	        } 
	        return stb.toString(); 
	    }
	    
	    
	    

}
