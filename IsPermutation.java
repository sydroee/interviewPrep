// Determine if a String is a permutation of another String
//
//BONUS: Determine how many times a permutation of one string
//is present in another.
class IsPermutation
{

    public static boolean isPermutation(String s1, String s2)
    {
        //HashMap for tracking the characters and their frequency.
        HashMap<Character, Integer> s1letters = new HashMap<>();
        if(s1.length() != s2.length())
            return false;
        else
        {
            //logic for filling the map in function below.
            fillMap(s1,s1letters);
            for(int i = 0; i < s2.length(); i++)
            {
                char letter = s2.charAt(i);
                //if s2 has a letter that is not in s1 we are done.
                //it is not a permutation.
                if(!s1letters.containsKey(letter))
                    return false;
                else
                {
                    //if the letter is found, decrement the frequency of that
                    //letter because we have found an occurance already.
                    int count = s1letters.get(letter) - 1;
                    //if their are no more occurances, remove letter from
                    //the HashMap.
                    if(count == 0)
                        s1letters.remove(letter);
                    else
                    {
                        //update the count of occurances still yet to find.
                        s1letters.put(letter,count);
                    }
                }
            }
            //if we found all the letters, the map should be empty.
            return s1letters.isEmpty();
        }
    }
    // Fills the HashMap with all the letters in s1.
    private static void fillMap(String s1, HashMap<Character, Integer> map)
    {
        for(int i = 0; i < s1.length(); i++)
        {
            char letter = s1.charAt(i);
            //if the letter is already there increment the occurances.
            if(map.containsKey(letter))
            {
                int count = map.get(letter) + 1;
                map.put(letter,count);
            }
            else
            {
                //if the letter is not there this is the first one.
                map.put(letter, 1);
            }
        }
    }

    //BONUS problem solution
    //Find the amount of permutations of s1 in s2
    public static int totalPerms(String s1, String s2)
    {
        //there are no permutations of s1 in s2 if s2 is smaller.
        if(s2.length() < s1.length())
            return 0;
        //if they are equal or s2 is greater find all permutations.
        else
        {
            int count = 0;
            //only go through s2 up to s2's length - s1's length
            //to avoid any issues with going out of bounds.
            for(int i = 0; i <= s2.length() - s1.length(); i++)
            {
                //create a "window" from i to i+s1.length and check
                //if that is a permutation. if so increment the count.
                String s2SubString = s2.substring(i,i+s1.length());
                if(isPermutation(s2SubString, s1))
                    count++;
            }
            return count;
        }
    }
}
