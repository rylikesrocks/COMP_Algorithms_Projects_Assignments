
public class Exercise22_01_Braithwaite {
    public static void longestSubstring(String value){
        int len = value.length();
        String longestSequence = "";
        String sequence;   
//Start of O(n^2) loop, resetting the sequence, and "setting up" for i to compare.
        for(int p = 0; p < len; p++){
//Resetting sequence.
            sequence = "";
            sequence = sequence + value.charAt(p);
//Iteration through characters in string, comparing to see if they are exactly one letter apart, breaking the sequence if not.
            for(int i = p + 1; i < len; i++){
                if(value.charAt(i) - value.charAt(i-1) == 1){
                    sequence = sequence + value.charAt(i);
                    if(sequence.length() >= longestSequence.length()){
                        longestSequence = sequence;
                    }
                }else{
                    break;
                }
            }
        }
        System.out.println(longestSequence);
    }
//Testing
    public static void main(String[] args) {
        longestSubstring("abcdefghijklmnopqrstuvhhhh");
        longestSubstring("xyznowiknowmyabcsnexttimewontyousingwithme");
    }
}

/*

My first version os O(n^2) because of the nested for loop. Each iteration through this loop is quadratic, meaning it has to check multiple times within each nested for loop, before going to the outer.
This is relatively inefficient, as the amount of runs keeps growing exponentially, when this problem could be solved more linearly.


My idea was to create a basic for loop and have it loop through the string, then compare the (i) characxter to the (i-1) character, adding it to a longestSequence if i was greater.
Pretty similar to the nested for loop in this example, but the main loop would handle iteration through abcdefg, and various conditionaly statements inside the for loop would handle the sorting.
Basically, just remove the nested for loop and build logic in the form of conditional statements to make it more linear.

*/

// Used Claude for debugging logic explanations.
//https://www.geeksforgeeks.org/dsa/what-does-big-on2-complexity-mean/ for nested for loop help understanding.