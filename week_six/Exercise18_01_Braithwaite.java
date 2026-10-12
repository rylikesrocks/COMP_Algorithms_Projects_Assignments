import java.math.BigInteger;

public class Exercise18_01_Braithwaite {

//Recursion method

    public static BigInteger factorial(BigInteger n) {
        if(n.equals(BigInteger.ZERO)){
            return BigInteger.ONE;
        }else{
            return n.multiply(factorial(n.subtract(BigInteger.ONE)));
        }
    }

//Testing

    public static void main(String[] args) {
        BigInteger newBig = new BigInteger("25");
        BigInteger newBigTwo = new BigInteger("50");
        BigInteger newBigPrettyBig = new BigInteger("100");
        BigInteger newBigReallyBig = new BigInteger("1000"); // for fun!

//Uncomment to test recursion! (probably not all 4 at the same time, unless you like big numbers!)

        //System.out.println(factorial(newBig));
        System.out.println(factorial(newBigTwo));
        //System.out.println(factorial(newBigPrettyBig));
        //System.out.println(factorial(newBigReallyBig));

    }
}
