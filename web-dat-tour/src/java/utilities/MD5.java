/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 *
 * @author AT
 */
/**
 *
 * @author TranBinhAn
 */
import java.io.UnsupportedEncodingException; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 

public class MD5 
{     
    private static String convertedToHex(byte[] data) 
    { 
        StringBuffer buf = new StringBuffer();
        
        for (int i = 0; i < data.length; i++) 
        { 
            int halfOfByte = (data[i] >>> 4) & 0x0F;
            int twoHalfBytes = 0;
            
            do 
            { 
                if ((0 <= halfOfByte) && (halfOfByte <= 9)) 
                {
                    buf.append( (char) ('0' + halfOfByte) );
                }
                
                else 
                {
                    buf.append( (char) ('a' + (halfOfByte - 10)) );
                }

                halfOfByte = data[i] & 0x0F;

            } while(twoHalfBytes++ < 1);
        } 
        return buf.toString();
    } 

    public static String getMD5(String text) 
    throws NoSuchAlgorithmException, UnsupportedEncodingException  
    { 
        MessageDigest md;
        md = MessageDigest.getInstance("MD5");
        byte[] md5 = new byte[64];
        md.update(text.getBytes("UTF-8"), 0, text.length());
        md5 = md.digest();
        return convertedToHex(md5);
    } 
}