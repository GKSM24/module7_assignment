package Power;

/**
 * Given "a" an integer or float value, and b as an integer value,
 * Find a power b.
 *
 * @author Siva Sankar
 */

public class Power {
    /**
     * This method finds a^b where both a and b are integers.
     * @param  a, the base
     * @param  b, the exponential
     * @return a^b which is a long value.
     */
    public static long pow(int a, int b) {
        long result = 1;
        for (int itr = 1; itr <= b; itr++){
            result *= a;
        }
        return result;
    }

    /**
     * This method finds a^b where variable a is a float
     * and b is an integer.
     * @param  a, the base
     * @param  b, the exponential
     * @return a^b which is a double value.
     */
    public static double pow(float a, int b) {
        double result = 1;
        for (int itr = 1; itr <= b; itr++){
            result *= a;
        }
        return result;
    }
}
