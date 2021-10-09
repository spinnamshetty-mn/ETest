package com.epidemic;

import java.security.MessageDigest;

public class EncryptPassword {
   
    public String encryptPassword(String password) {

    	 String algorithm = "SHA";
    	 
    	 byte[] plainText = password.getBytes();
    
         try {
             MessageDigest digest = MessageDigest.getInstance(algorithm);
             digest.reset();
             digest.update(plainText);
             byte[] encodedPassword = digest.digest();

             StringBuilder builder = new StringBuilder();
             for (byte b : encodedPassword) {
                 if ((b & 0xff) < 0x10) {
                     builder.append("0");
                 }
                 builder.append(Long.toString(b & 0xff, 16));
             }
             return builder.toString();
         } catch (Exception e) {
             e.printStackTrace();
             return "";
         }
    }
    
    
    
}
