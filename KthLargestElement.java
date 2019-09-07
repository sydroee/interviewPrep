/* Problem: Kth Largest Element in an Array (LC 215)
* Find the kth largest element in an unsorted array.
* Note that it is the kth largest element in the sorted order, not the kth distinct element.
*/
class KthLargestElement
{
  //super simple solution
  //space O(1)
  //time O(n*logn) average.
  public static int findKthLargest(int[] nums, int k)
  {
        Arrays.sort(nums);
        int index = nums.length - k;
        return(nums[index]);
  }
  //will add other solns but getting this one out.
}
