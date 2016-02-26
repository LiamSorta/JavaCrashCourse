import java.io.*;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * Day 1 - Dictianary attack on SHA-1 hashes, wordlist found here: 
 * http://www-01.sil.org/linguistics/wordlists/english/
 * (See wordsEn.txt)
 * 
 * @LiamSorta || liamsorta.co.uk || https://github.com/LiamSorta/
 * 
 * Part of a Java Crash Course hosted by Andrew Kay (http://www.andrewkay.name)
 */
public class DictionaryAttack
{
    static public void Main(String hash) throws FileNotFoundException {
        FileReader wordlistFile = new FileReader ("wordsEn.txt");
        BufferedReader wordlist = new BufferedReader(wordlistFile);
        String word = " ";
        try{ 
            while(word != null){
                word = wordlist.readLine();
                //System.out.println(word);
                if(DigestUtils.sha1Hex(word).equals(hash)){
                                System.out.println(word);
                }
            }

        } catch(IOException ie){
            System.exit(1);
        }
    }
}
