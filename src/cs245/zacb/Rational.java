package cs245.zacb;

/** This class allows you to create a Rational object**/
public class Rational {
    private int numerator;
    private int denominator;

    /** The default constructor for Rational() will default numerator and denominator to 1 **/
    public Rational() {
        numerator = 1;
        denominator = 1;
    }

    /** With this constructor, the user is able to enter their own numerator and denominators
     * @param numerator the numerator
     * @param denominator the denominator
     * @throws IllegalArgumentException the numerator or denominator both must be positive**/
    public Rational(int numerator, int denominator) {
        if (numerator >= 1) {
            this.numerator = numerator;
        } else {
            throw new IllegalArgumentException("Numerator must be positive.");
        }

        if (denominator > 0) {
            this.denominator = denominator;
        } else {
            throw new IllegalArgumentException("Denominator must be positive.");
        }
    }

    /** This method will implicitly be called whenever a Rational is treated as a string.
     *  It will be printed as 'numerator'/'denominator'**/
    public String toString() {
        return numerator + "/" + denominator;
    }

    /** This method, when called, will reduce a Rational by its greatest common factor.
     * @return This method returns a new Rational**/
    public Rational reduce(){
        int gcf = GCF(this.numerator, this.denominator);
        int newNumerator = this.numerator/gcf;
        int newDenominator = this.denominator/gcf;

        return new Rational(newNumerator, newDenominator);
    }

    private static int GCF(int a, int b){
        if (b == 0){
            return a;
        }
        else{
            return (GCF(b, a%b));
        }
    } //This formula is Euclid's Algorithm. Citation: (https://en.wikipedia.org/wiki/Euclidean_algorithm)

    /** This method, when called, allows the user to add two fractions
     *
     * @param that this is the Rational you are adding to the Rational that called this method.
     * @return This method returns a new reduced Rational
     */
    public Rational add(Rational that){
        int sharedDenominator = this.denominator*that.denominator;
        int addedNumerator = (this.numerator*that.denominator) + (that.numerator * this.denominator);
        Rational finalFraction = new Rational(addedNumerator, sharedDenominator);
        return finalFraction.reduce();
    }

    /** This method, when called, allows the user to multiply two fractions
     *
     * @param that this is the rational you are multiplying to the Rational that called this method.
     * @return This method returns a new reduced Rational
     */
    public Rational multiply(Rational that){
        int newNumerator = this.numerator * that.numerator;
        int newDenominator = this.denominator * that.denominator;
        Rational finalFraction = new Rational(newNumerator, newDenominator);
        return finalFraction.reduce();
    }


}