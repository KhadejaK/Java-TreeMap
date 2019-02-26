import java.util.TreeSet;
import java.util.Set;

public class Sieve
{
   private int upLim;
   
   public Sieve(int upperLimit)
   {
      upLim = upperLimit;
   }
   
   //which returns a set containing all the primes less 
   //than or equal to the upper limit. The numbers should be in 
   //increasing order. Implement the algorithm using a set.   
   public Set<Integer> getPrimes() 
   {
      Set<Integer> primes = new TreeSet<>();
      
      for(int x=2; x<=upLim; x++)
      {
         boolean isPrime = true;
         
         for(int y=2; y<x; y++)
         {
            if (x%y == 0)
            {
               isPrime = false;
               break;
            }   
         }
         
         if(isPrime)
            primes.add(x);
      }
      
      return primes;
   }
   
   //which sets a new upper limit for this sieve
   public void setUpperLimit(int newLimit) 
   {
      upLim = newLimit;
   }
   
   //which returns the number of primes that are less than the upper limit. 
   //Do this efficiently without duplicating code already written. 
   //(That is, this method should call the getPrimes method rather 
   //than finding the primes itself)
   public int primeCount()
   {
      return getPrimes().size();
   }
}
