/*
* Implement a method to perform basic string compression using the counts
* of repeated characters. aabcccccaaa would become a2b1c5a3, if the compressed
* string would not be smaller than the original than return the original
* CTCI 1.6
*/
class CompressString
{
    public compressString(String s1)
    {
        //use string builder to create the new striing
        //string concatonation in java is terribly inefficient,
        //string builder should always be used.
        StringBuilder compressed = new StringBuilder();
        int count = 1;
        compressed.append(s1.charAt(0));
        for(int i = 1; i < s1.length(); i++)
        {
            if(s1.charAt(i) != s1.charAt(i-1))
            {
                compressed.append(count);
                compressed.append(s1.charAt(i))
                count = 1;
            }
            else
            {
                count++;
            }
        }
    }
}
