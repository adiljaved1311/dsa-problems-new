package neetcode.arraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecode {
    public static void main(String[] args) {
        List<String> strs = Arrays.asList("leet","codeded","temperature","high");
        String str = encode(strs);
        List<String> decodedString = decode(str);
        for(String s : decodedString){
            System.out.print(s + ", ");
        }
    }

    public static String encode(List<String> strs){
        StringBuffer encodedString = new StringBuffer();
        for(String str : strs){
            encodedString.append(str.length()).append("#").append(str);
        }
        return encodedString.toString();
    }

    public static List<String> decode(String str){
        List<String> decodedStrings = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int length = Integer.valueOf(str.substring(i,j));
            i = j + 1 + length;
            decodedStrings.add(str.substring(j+1,i));
        }
        return decodedStrings;
    }
}
