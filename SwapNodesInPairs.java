/*
* Problem: Swap Nodes in Pairs
* Given a linked list, swap every two adjacent nodes and return its head.
* You may not modify the values in the list's nodes, only nodes itself may be changed.
*
* PSA: The comments were kinda annoying to write would HIGHLY recommend
* drawing this out because that is the only way to really see what is
* going on.
*/
class SwapNodesinPairs
{
  public static ListNode swapPairs(ListNode head)
  {
        //if we call swapPairs on null or there is only one node no swap
        if(head == null || head.next == null)
            return head;
        else
        {
            //blaaah this was annoying pointer things.
            //so we can't lose the value of head.next
            ListNode temp = head.next;
            // we give the pointer head.next to head.next.next(temp.next)
            // to start the swap
            head.next = temp.next;
            // temp.next is still pointing to *the original* head.next.next
            // we need it to point to head.
            temp.next = head;
            //now that we have taken care of pointer things we can finally set
            // head to temp (or the original head.next)
            head = temp;
            //all that annoying pointer stuff is needed for this
            // head.next.next was maintained just for us to make this function call
            head.next.next = swapPairs(head.next.next);
            // once this returns all subsequent nodes have been swapped and we done
            // FINALLY.
            return head;
        }

    }
}
//just a node...
public class ListNode
{
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
