package src;
import java.util.*;
import java.util.stream.Collectors;

public class Stuffing {
//    static Scanner s = new Scanner(System.in);

    public String CharacterStuffing(String data){
        String frameString="";
       
        //we wil scan the input data and do following
       
        /*
        1. if data is found it is kept as it is.
        2. if flag = # is found, put escape seq=$ before it.
        3. if esc seq=$ is found add one more $ before it.
        */
       
        for(int i=0;i<data.length();i++){
            char ch=data.charAt(i);
            if(ch=='#'){
                //this flag seq in data, so we add $ before it.
               frameString=frameString+'$'+ch;
            }
            else if(ch=='$'){
                //this is esc seq in data, so we add one more $ before it.
                frameString=frameString+'$'+ch;
            }
            else{
                //this is simple data, so keep it as it is.
                frameString+=ch;
            }
        }
       
        //now add flag before and after the string to distinguish frames
        frameString='#'+frameString+'#';
       
        return frameString;
    }
   
   
    public String CharacterDeStuffing(String enString){
        String actualData="";
       
        /*
        1. Ignore first and last flag bytes while scanning.
        2. if $ is detected, then ignore this $ and take the next character into account. It will be either $ or # in actual data
        */
       
        for(int i=0;i<enString.length();i++){
            if(i==0 || i==(enString.length()-1)){
                //simpply skip, as they are flag bits
            }
            else{
                char ch=enString.charAt(i);
                if(ch=='$'){
                    //skip this and take the next character
                    i+=1;
                    char nextch=enString.charAt(i);
                    actualData+=nextch;
                }
                else{
                    actualData+=ch;
                }
            }
           
        }
       
        return actualData;
    }

    // Conversion of string to binary
    static String convertStringToBinary(String input) {

        StringBuilder result = new StringBuilder();
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            result.append(String.format("%8s", Integer.toBinaryString(aChar)) // char -> int, auto-cast
                    .replaceAll(" ", "0") // zero pads
            );
        }
        return result.toString();

    }

    // BitDestuffing Function
    public String BitDestuffing(String stuffedString) {
        int len = 0;
        String result = "";
        for (int i = 0; i < stuffedString.length(); i++) {
            result += stuffedString.charAt(i);
            if (stuffedString.charAt(i) == '1') {
                len++;
                if (len == 5 && i < stuffedString.length() - 2 && stuffedString.charAt(i + 1) == '0'
                        && stuffedString.charAt(i + 2) == '1') {
                    i++;
                    len = 0;
                }
            } else {
                len = 0;
            }

        }
//        System.out.println("After Destuffing : " + result);
        String new_result = "";
        for (int i = 0; i < result.length(); i++) {
            new_result += result.charAt(i);
            if ((i + 1) % 8 == 0) {
                new_result += " ";
            }
        }
        String raw = Arrays.stream(new_result.split(" ")).map(binary -> Integer.parseInt(binary, 2))
                .map(Character::toString).collect(Collectors.joining());

        return raw;
    }

    // BitStuffing Function
    public String BitStuffing(String BinaryString) {
        int len = 0;
        String st = "";
        for (int i = 0; i < BinaryString.length(); i++) {
            if (BinaryString.charAt(i) == '1') {
                len++;
            } else {
                len = 0;
            }
            st += String.valueOf(BinaryString.charAt(i));
            if (len == 5 && i < BinaryString.length() - 1 && BinaryString.charAt(i + 1) == '1') {
                len = 0;
                st += "0";
            }
        }
//        System.out.println("After stuffing : " + st);
        return st; 
    }

    public String BitStuffingDestuffing(String str) {
    	
        String st[] = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String value : st) {
            sb.append(value).append(" ");
        }

        String BinaryString = convertStringToBinary(String.valueOf(sb));
//        System.out.println("Before stuffing : " + BinaryString);
        String s = this.BitStuffing(BinaryString);
        return s;

    }

//    public static void main(String[] args) {
//
//    	Stuffing stf= new Stuffing();
//    	String stuf = stf.CharacterStuffing("hello world");
//    	System.out.println(stuf);
//    	String dStuf = stf.CharacterDeStuffing(stuf);
//    	System.out.println(dStuf);
//    	System.out.println("bit stuffing....");
//    	String bs = stf.BitStuffingDestuffing("hello world");
//    	System.out.println(bs);
//    	String bds = stf.BitDestuffing(bs);
//    	System.out.println(bds);
//    }
}