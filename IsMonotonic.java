/* Problem: Monotonic Array (LC 896)
* An array is monotonic if it is either monotone increasing
* or monotone decreasing.
*
* An array A is monotone increasing if for all i <= j, A[i] <= A[j].
* An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
*
* Return true if and only if the given array A is monotonic.
*/

class isMonotonic {
    public static boolean isMonotonic(int[] A) {
        //check the array size, if empty or of size one it is monotonic
        if(A.length == 1 || A.length == 0)
            return true;
        else if(A[0] < A[1])
            return isIncreasing(A);
        else if(A[0] > A[1])
            return isDecreasing(A);
        else //handles leading duplicates
            return isMonotonic(Arrays.copyOfRange(A,1,A.length));

    }
    //recursively check if the array is increasing, if not return false
    //could easily be done interatively but :shrug:
    private boolean isIncreasing(int[] A)
    {
        if(A.length == 1)
            return true;
        else if(A[0] <= A[1])
            return isIncreasing(Arrays.copyOfRange(A,1,A.length));
        else
            return false;
    }
    //same logic as the above.
    private boolean isDecreasing(int[] A)
    {
        if(A.length == 1)
            return true;
        else if(A[0] >= A[1])
            return isDecreasing(Arrays.copyOfRange(A,1,A.length));
        else
            return false;
    }
}
