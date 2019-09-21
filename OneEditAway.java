/*
* Check to see if s1 is one edit away from s2.
* You can chose to remove a value, replace a value or add a value to s1 to make
* it equal to s2
* CTCI 1.5
*/

class OneEditAway
{
    public boolean oneEditAway(String s1, String s2)
    {
        int lengthDifference = s1.length() - s2.length();
        if(lengthDifference == 1)
        {
            // if s1 is larger than s2, you must remove something from s1
            // to make it equal to s2
            checkRemove(s1, s2);
        }
        else if(lengthDifference == -1)
        {
            //if s2 is larger than s1 than you must add something to s1
            //(or remove something from s2) to make these strings equal
            checkRemove(s2,s1);
        }
        else if(lengthDifference == 0)
        {
            // These strings are the same length so s1 must have a value replaced
            //to equal s2.
            checkReplace(s1,s2);
        }
        //if these values are different in length by more than one they are
        //not one edit away.
        else
            return false;
    }
    private boolean checkRemove(String s1, String s2)
    {
        //Create a pointer to keep track of your position in s1
        //since it is larger, this prevents any out of bounds issues.
        int p1 = 0;
        boolean edit = false;
        for(int i = 0; i < s2.length; i++)
        {
            if(s1.charAt(p1) != s2.charAt(p2))
            {
                if(edit)
                    return false;
                edit = true;
                //we need to check the current value against p2's next value
                //so we counter-act the loop.
                i--;
            }
            p1++;
        }
        return true;
    }
    private boolean checkReplace(String s1, String s2)
    {
        boolean edit = false;
        for(int i = 0; i < s1.length(); i++)
        {
            if(s1.charAt(i) != s2.charAt(i))
            {
                if(edit)
                    return false;
                edit = true;
            }
        }
        return true;
    }
}
