
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        System.out.print("Choose a natural number: ");

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        if (n > 1000 | n <= 0)
        {
            System.out.println("Shit happens..");
            System.exit(0);
        }

        int result = SuperPrimeCounter(n);
        System.out.println("Super prime number counter: " + result);
        in.close();
    }

    private static boolean isPrime(int n) // prime number check
    {
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        for (int i = 5; i * i <= n; i += 6)
        {
            if (n % i == 0 || n % (i + 2) == 0)
            {
                return false;
            }
        }
        return true;
    }

    private static int reverseNumber (int n) // reverse function
    {
        int reversedNumber = 0;
        while (n != 0)
        {
            int number = n % 10;
            reversedNumber = reversedNumber * 10 + number;
            n = n / 10;
        }
        return reversedNumber;
    }

    private static boolean isSuperPrime(int n)
    {
        return isPrime(n) && isPrime(reverseNumber(n));
    }

    public static int SuperPrimeCounter(int n) // super prime number counter
    {
        int superCounter = 0;
        for (int i = 1; i <= n; i++)
        {
            if (isSuperPrime(i))
            {
                System.out.println(i);
                superCounter++;
            }
        }
        return superCounter;
    }
}