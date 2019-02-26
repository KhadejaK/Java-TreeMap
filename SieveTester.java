import java.util.Set;

public class SieveTester
{
   public static void main(String[] args)
   {
      Sieve primesFinder = new Sieve(11);
      Set<Integer> primes = primesFinder.getPrimes();
      System.out.println(primes);
      System.out.println("Expected: [2, 3, 5, 7, 11]");
      
      primesFinder.setUpperLimit(101);
      primes = primesFinder.getPrimes();
      System.out.println(primes);
      System.out.println("Expected: [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101]");
      
      primesFinder = new Sieve(10000);
      primes = primesFinder.getPrimes();
      System.out.println(primesFinder.primeCount());
      System.out.println("Expected: 1229");
   }
}