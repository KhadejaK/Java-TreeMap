//SOLUTION
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

//SHOW
public class IndexMaker
{
   public static void main(String[] args) throws FileNotFoundException
   {
      String filename = "ProcessRectangle.java"; //SUB "PaintJobCalculator.java"
//HIDE
      Scanner scan = new Scanner(new File("reserved.txt"), "UTF-8"); 

      //get the keywords
      Set<String> keywords = new HashSet<String>();
      while (scan.hasNext())
      {
         keywords.add(scan.next());

      }
      scan.close();

      int lineNumber = 1;
      Map<String, Set<Integer>> index = new TreeMap<>();
      scan = new Scanner(new File(filename), "UTF-8");
      
      while (scan.hasNextLine())
      {
         String nextLine = scan.nextLine();
         Scanner lineScanner = new Scanner(nextLine);
         lineScanner.useDelimiter("[^A-Za-z_]+");
         while (lineScanner.hasNext())
         {
            String word = lineScanner.next();
            if (!keywords.contains(word)) //this word is not a keyword
            {
               Set<Integer> integerSet = index.get(word);
               if (integerSet == null) // this word not in the map yet
               {
                  integerSet = new TreeSet<Integer>(); //create a set to hold the line numbers
               }
               integerSet.add(lineNumber);
               index.put(word, integerSet);
            }      
         }
         lineScanner.close();
         lineNumber++;
      }
      scan.close();   
      
      Set<String> keySet = index.keySet(); //get all the keys
      for (String key : keySet)
      {
         System.out.print(key + ": ");
         Set<Integer> lineNumbers = index.get(key);

         System.out.println(lineNumbers);
      }
//SHOW
   }
}