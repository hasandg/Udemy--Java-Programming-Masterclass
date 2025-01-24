/**
 * Created by : hdag
 * Date: 8.08.2019
 * Time: 17:42
 */
public class LargestPrime {
    public static void main(String[] args) {
      /*  System.out.println(getLargestPrime(21));
        System.out.println(getLargestPrime(217));
        System.out.println(getLargestPrime(0));*/
        System.out.println(getLargestPrime(45));

    }

    public static int getLargestPrime(int num) {

        if (num < 2) {
            return -1;
        }

        int largestPrime = -1;

        for (int i = 2; i < num; i++)
            if (num % i == 0) {
                for (int j = 2; j < Math.sqrt(i); j++)
                    if (i % j == 0) {
                        System.out.println("i % j == 0" + "i: " + i + " j: " + j);
                        break;
                    } else {
                        System.out.println("i: " + i + " j: " + j);
                        if (largestPrime < i) {
                            largestPrime = i;
                        }
                    }
            }
        return largestPrime;
    }
}
