/* Problem: Reverse String
* Write a function that reverses a string.
* The input string is given as an array of characters char[].
* Do not allocate extra space for another array,
* you must do this by modifying the input array in-place with O(1) extra memory
*/

class ReverseString
{
  //Space O(1)
  //Time O(n)
  public static void reverseString(char[] s)
  {
        //helper function for ease of recursive call, only if s is valid.
        if(s != null)
            helper(s, 0, s.length-1);

  }
  private void helper(char[] s, int p1, int p2)
  {
      // when the pointer cross then all letters have been swapped and can return.
      if(p1 >= p2)
      {
          return;
      }
      else
      {
          //swap letters in place and move both "pointers".
          char temp = s[p1];
          s[p1] = s[p2];
          s[p2] = temp;
          helper(s, ++p1, --p2);
      }
  }
}
