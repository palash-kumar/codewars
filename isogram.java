/*
An isogram is a word that has no repeating letters, consecutive or non-consecutive. Implement a function that determines whether a string that contains only letters is an isogram. Assume the empty string is an isogram. Ignore letter case.

isIsogram "Dermatoglyphics" == true
isIsogram "aba" == false
isIsogram "moOse" == false -- ignore letter case


===== TEST CASES 
    @Test
    public void FixedTests() {
        assertEquals(true, isogram.isIsogram("Dermatoglyphics"));
        assertEquals(true, isogram.isIsogram("isogram"));
        assertEquals(false, isogram.isIsogram("moose"));
        assertEquals(false, isogram.isIsogram("isIsogram"));
        assertEquals(false, isogram.isIsogram("aba"));
        assertEquals(false, isogram.isIsogram("moOse"));
        assertEquals(true, isogram.isIsogram("thumbscrewjapingly"));
        assertEquals(true, isogram.isIsogram("")); 
    }
*/

import java.util.*;

public class isogram {
    public static void main(String args[]) {
        
      System.out.println("is isogram? : "+isIsogram("Dermatoglyphics"));
      System.out.println("is isogram? : "+isIsogramEfficient("isogram"));
    }
    

    // Worst case solution
    public class isogram {
        public static boolean  isIsogram(String str) {
            str = str.toLowerCase();
            List<Character> tempList = new ArrayList<Character>();
            char[] strArray = str.toCharArray();
            char temp;
            
            for(int i=0; i < strArray.length; i++){
                temp = strArray[i];
                for(int j=i+1; j < strArray.length; j++){
                    if(temp == strArray[j]){
                        if(!tempList.contains(strArray[j])){
                            tempList.add(temp);
                        }
                    }
                }
            }
        if(tempList.size() > 0)  
            return false;
        else
            return true;
        } 
    }

    // Efficient solution by others
    public static boolean  isIsogramEfficient(String str) {
        return str.length() == str.toLowerCase().chars().distinct().count();
    }
  
}