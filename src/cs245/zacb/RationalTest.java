package cs245.zacb;

public class RationalTest {

    public static void main(String[] args) {
        Rational base = new Rational();
        System.out.println("This is the default constructor's output: " + base + "\n");

        Rational half = new Rational(1,2);
        System.out.println("Creating 1/2 with the second constructor: " + half + "\n");

        Rational threeFourths = new Rational(3,4);
        System.out.println("Creating another fraction: " + threeFourths + "\n");

        Rational twoSixths = new Rational(2,6);
        Rational reduction = twoSixths.reduce();
        System.out.println("Original Fraction: " + twoSixths + ". Reduced Fraction: " + reduction + "\n");

        Rational sum = half.add(threeFourths);
        System.out.println("Adding 1/2 and 3/4: " + sum + "\n");

        Rational product = half.multiply(threeFourths);
        System.out.println("Multiplying 1/2 and 3/4: " + product + "\n");


    }
}
