import org.apache.commons.codec.digest.DigestUtils;
import java.util.List;
import java.util.ArrayList;

/**
 * Day 1 - Cracks SHA-1 hashes with a given size (seperate method for single character)
 * 
 * @LiamSorta || liamsorta.co.uk || https://github.com/LiamSorta/
 * 
 * Part of a Java Crash Course hosted by Andrew Kay (http://www.andrewkay.name)
 */
public class PasswordCrack
{
    static public void Main(){
        System.out.println(DigestUtils.sha1Hex("hello"));
    }

    static public String GetCrackin(){
        for(int i = 97; i <= 122; i++){
            if((DigestUtils.sha1Hex((char)i + "")).equals("22ea1c649c82946aa6e479e1ffd321e4a318b1b0")){
                return ((char)i+"");
            }
        }
        return "";
    }

    static public void ConvertAndCheck(String str, String hash){
        boolean lol = false;
        String old = str;
        str = DigestUtils.sha1Hex(str);

        if(str.equals(hash)){
            System.out.println(old + " = " + str);
        }
    }

    static public void Check(char[] x, String hash){
        String password = "";
        for(int i = 0; i < x.length; i++){
            password += x[i];
        }        
        ConvertAndCheck(password, hash);
    }

    static public void Password2(int size, String hash){
        char[] password = new char[size];
        String end = "";
        for(int i = 0; i < password.length;i++){
            password[i] = 'a';
            end += 'z';
        }       

        int i = size-1;
        
        while(!String.valueOf(password).equals(end))
        {

            for(int s = i; s >= 0; s--){
                if(password[s] != 'z'){
                    password[s]++;
                    break;
                }
                else{
                    password[s] = 'a';
                }
            }       
            Check(password, hash);
        }
    }
}
