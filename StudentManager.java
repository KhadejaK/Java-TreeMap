import java.util.Map;
import java.util.TreeMap;

public class StudentManager
{
   Map<String, String> student;
   
   public StudentManager()
   {
      student = new TreeMap<>();
   }

   //adds the student name and grade to the map
   public void add(String name, String grade) 
   {
      student.put(name, grade);
   }
   
   //removes the association of this name and gpa
   public void remove(String name) 
   {
      student.remove(name);
   }
   
   //gets the number of students in the class
   public int getClassSize() 
   {
      return student.size();
   }
   
   //gets the names of the students in alphabetical 
   //order and their grades in the format below
   public String getPrintableRoster() 
   {
      String names = "";
      for (String key : student.keySet())
      { 
         names += key + ": " + student.get(key) + "\n";
      }
      return names;
   }  
}
