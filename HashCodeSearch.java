/* SOLUTION
 * Write a program HashCodeSearch to search a file to see if you can find 
 * two words that have the same hash code. Read the file with a Scanner 
 * and use a data structure that maps the hashcode to a set of words 
 * with that hashcode. At the end, print out words that have the same 
 * hash code on the same line in lexicographical order. 
 * (That will be any set with a length greater than 1)
 */
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class HashCodeSearch
{
   public static void main(String[] args) throws IOException 
   {
      //print out words that have the same 
      //hash code on the same line in lexicographical order.
      Map<Integer, TreeSet<String>> hashCodeToStringMap = new HashMap<>();
      

      String filename = "war_and_peace.txt";
      Scanner scan = new Scanner(new File(filename));      
      scan.useDelimiter("[^A-Za-z0-9_]+");
      
      int wordCount = 0;
      while (scan.hasNext())
      {
          //Get word
          String word = scan.next();
          //Get word's hashcode
          Integer hashCode = word.hashCode();
          //Make a TreeSet of a list of words
          TreeSet<String> wordList;
          //Check if current map contains word's hashcode
          if (hashCodeToStringMap.containsKey(hashCode))
          {
             //if yes, get the current list of words
             wordList = hashCodeToStringMap.get(hashCode);
          }
          else
          {
             //if no, create a new TreeSet
             wordList = new TreeSet<String>();
          }
          //add the word to the wordList
          wordList.add(word);
          //put it in the map
          hashCodeToStringMap.put(hashCode, wordList);
          //increment the number of words
          wordCount++;
      }
      
      //print strings with same hashcode
      double duplicates = 0;
      for (Integer key : hashCodeToStringMap.keySet())
      {
         //only get word list sets greater than 1 word
         if (hashCodeToStringMap.get(key).size() > 1)
         {
            //Print the values
            System.out.println(hashCodeToStringMap.get(key));
            //count the duplicates
            duplicates++;
         }
      }
      scan.close();
      
      //print the duplicate hashcodes
      if (wordCount > 0)
          System.out.println(duplicates/wordCount);
   }
}