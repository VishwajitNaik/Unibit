import java.util.*;
public class Subsequence {
   public static String[] subsequence(String input){
    if(input.length() == 0){
        //base case
        String[] output = new String[1];
        output[0] = "";
        return output;
    }
    String[] smallOutput = subsequence(input.substring(1));
    String[] output = new String[smallOutput.length*2];
    
    for(int i=0; i<smallOutput.length; i++) {
        output[i] = smallOutput[i];
        }
        for(int i=0; i<smallOutput.length; i++) {
        output[smallOutput.length + i] = input.charAt(0) + smallOutput[i];
        }
        
         return output;
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String[] output = subsequence(input);
        for (String i : output) {
            System.out.println(i);
        }
   } 
}
