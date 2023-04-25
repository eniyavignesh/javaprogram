package Iterator;


//Define the Iterator interface
interface Iteratorr {
 boolean hasNext();
 int next();
}

//Define the custom collection class that implements the Iterator interface
class IntegerCollection implements Iteratorr {
 private int[] data;
 private int position;
 
 public IntegerCollection(int[] data) {
     this.data = data;
     this.position = 0;
 }
 
 public boolean hasNext() {
     if (position < data.length) {
         return true;
     } else {
         return false;
     }
 }
 
 public int next() {
     int number = data[position];
     position++;
     return number;
 }
}

//Main class to test the implementation
public class IteratorEg {
 public static void main(String[] args) {
     int[] numbers = {1, 2, 3, 4, 5};
     
     IntegerCollection integerCollection = new IntegerCollection(numbers);
     while (integerCollection.hasNext()) {
         int number = integerCollection.next();
         System.out.println(number);
     }
 }
}
