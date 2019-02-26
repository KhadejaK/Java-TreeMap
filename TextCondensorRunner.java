import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class TextCondensorRunner
{

   public static void main(String[] args) throws FileNotFoundException
   {
       TextCondensor condensor = new TextCondensor(readFile("humpty.txt"));
       Set<String> condensed = condensor.condenseText();
       System.out.println(condensed);
       System.out.println(condensed.size());
       
//       condensor.setList(readFile("mary.txt"));
//       condensed = condensor.condenseText();
//       System.out.println(condensed);
//       System.out.println(condensed.size());

   }
   
   public static ArrayList<String> readFile(String filename) throws FileNotFoundException
   {
      ArrayList<String> words = new ArrayList<>();
      Scanner scan = new Scanner(new File(filename));
      scan.useDelimiter("[^a-zA-Z']+");
      while (scan.hasNext())
      {
         words.add(scan.next().toLowerCase());
      }
      scan.close();
      return words;
   }
}