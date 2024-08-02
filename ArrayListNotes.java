import java.util.ArrayList;
import java.util.Iterator;


class ArrayListNotes {
  public static void main(String[] args) {
      // ArrayList<String> stringList = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E"));
      ArrayList<String> stringList = new ArrayList<String>();
      // Insertion
      stringList.add("A");
      stringList.add("B");
      stringList.add(2, "C");
      System.out.println(stringList);
      // Access
      System.out.println(stringList.get(2));
      System.out.println(stringList.get(2));
      // Traversal
      for (int i=0; i<stringList.size(); i++) {
          String letter = stringList.get(i);
          System.out.println(letter);
      }
      // for each
      for (String letter: stringList) {
          System.out.println(letter);  
      }
      // Itertor traversal
      Iterator<String> iterator = stringList.iterator();
      while (iterator.hasNext()) {
          String letter = iterator.next();
          System.out.println(letter); 
      }
      // Searching 
      for (String letter: stringList) {
          if (letter.equals("F")) {
              System.out.println("The element is found");
              break;
          }     
      }
      // index of
      int index = stringList.indexOf("C");
      System.out.println("The element is found at index " + index);
      
      // remove
      stringList.remove("1");
      stringList.remove("D");
      System.out.println(stringList);
      
     
  }
}