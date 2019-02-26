import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class TextCondensor
{
   private ArrayList<String> words; 
   
   public TextCondensor(ArrayList<String> file)
   {
      words = file;
   }
   
   //which removes any duplicates and returns an Set<String> containing 
   //words without duplicates and in alphabetical order. Think Set
   public Set<String> condenseText() 
   {
      Set<String> newWords = new TreeSet<>();
      
      for (String word : words)
      {
         if (!newWords.contains(word))
            newWords.add(word);
      }
            
      return newWords;
      
   }
   
   //which gets the number of unique elements in the text. 
   //Do this efficiently without duplicating code already written. 
   //Do not use an unnecessary instance variable.
   public int condensedSize() 
   {   
      return condenseText().size();
   }
   
   //which sets a new list of text
   public void setList(ArrayList<String> newText) 
   {
      words = newText;
   }
}
