/*
Count the number of Duplicates

Write a function that will return the count of distinct case-insensitive alphabetic characters and numeric digits that occur more than once in the input string. The input string can be assumed to contain only alphabets (both uppercase and lowercase) and numeric digits.
Example

"abcde" -> 0 # no characters repeats more than once
"aabbcde" -> 2 # 'a' and 'b'
"aabBcde" -> 2 # 'a' occurs twice and 'b' twice (`b` and `B`)
"indivisibility" -> 1 # 'i' occurs six times
"Indivisibilities" -> 2 # 'i' occurs seven times and 's' occurs twice
"aA11" -> 2 # 'a' and '1'
"ABBA" -> 2 # 'A' and 'B' each occur twice


===== TEST CASES 
abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ    ReturnsTwentySix
empty   ReturnsZero
Indivisibilities    ReturnsTwo
abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz    ReturnsTwentySix
abcdeaB     ReturnsTwo
abcdeaa     ReturnsOne
abcdefghijklmnopqrstuvwxyzaaAb      ReturnsTwo
abcdefghijklmnopqrstuvwxyz      ReturnsZero
abcde       ReturnsZero 
*/

import java.util.*;

public class CountingDuplicates {
    public static void main(String args[]) {
      
      System.out.println("no of duplicate character : "+duplicateCount("Indivisibilities"));
      System.out.println("no of duplicate character : "+duplicateCountEfficient("Indivisibilities"));
    }
    
    public static int duplicateCount(String text) {
    
      text = text.toLowerCase();
      List<Character> tempList = new ArrayList<Character>();
      char[] strArray = text.toCharArray();
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
      
      return tempList.size();
    }

// Efficient solution by others
public static int duplicateCountEfficient(String text) {
    int ans = 0;
    text = text.toLowerCase();
    while (text.length() > 0) {
      String firstLetter = text.substring(0,1);
      text = text.substring(1);
      if (text.contains(firstLetter)) ans ++;
      text = text.replace(firstLetter, "");
    }
    return ans;
  }
  
}