package LinkList;

import java.util.*;

public class LinkLst {

    public static int add1ToList(ListNode head){
        if(head==null){
            return  1;
        }
//        System.out.println(add1ToList(head.next)+" head");
        int res =head.val+add1ToList(head.next);
                System.out.println(res+"res");

        head.val=res%10;
//        System.out.println("after running");
        return res/10;
    }
    public static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr =head;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev= curr;
            curr=next;
        }
        return prev;
    }  public static ListNode reverseBrute(ListNode head){
        ListNode curr = head;
        ListNode newHead;
        ListNode temp;

        Stack<Integer> stack = new Stack<>();
        stack.push(curr.val);
        while(curr.next!=null){
            curr = curr.next;
            System.out.println(curr.val);
            stack.push(curr.val);
        }
        int val =stack.pop();

        newHead= new ListNode(val);
        temp = newHead;

        while(!stack.isEmpty()){
            temp.next = new ListNode(stack.pop());
            temp =temp.next;

        }
        temp.next=null;
        return newHead;
    }
    public static ListNode addOne(ListNode head){
      int carry =add1ToList(head);
      if(carry>0){
          ListNode node =new ListNode(carry);
          node.next=head;
          return node;
      }
      return head;
    }
    static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
     interface  Ankit{
        void walking();
//        void talking();
    }
    public static boolean Solution (ListNode head){
        ListNode slow =head;
        ListNode fast = head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode secondHalf =reverse(slow);
        ListNode firstHalf =head;
        while(secondHalf!=null){
            if(secondHalf.val!=firstHalf.val){
                return false;
            }
            secondHalf =secondHalf.next;
            firstHalf=firstHalf.next;
        }
        printList(head);

        return true;


    }
    public static ListNode middelOfList(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null ){
          fast=fast.next.next;
          slow=slow.next;
        }
        return slow;

    }
    public static ListNode removenthNode(ListNode head,int n){
       int size =0;
       ListNode curr=head;
       if(head==null)return null;
        while(curr!=null){
            size++;
         curr =curr.next;
        }
        if(size==n){
            return head.next;
        }
        curr=head;
        for(int i=1;i<size-n;i++){
           curr=curr.next;

        }
        curr.next =curr.next.next;
        System.out.println(size+" size");
       return head;
    }
    public static ListNode removenthNode2(ListNode head,int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        for(int i=0;i<=n;i++){
            fast=fast.next;

        }

//        while(fast!=null){
//            fast=fast.next;
//            slow=slow.next;
//        }
//       slow.next=slow.next.next;

//       return dummy.next;
       return fast;
    }

    public static void main(String[] args) {
//        ListNode node =new ListNode(9);
//        node.next=new ListNode(9);
//        node.next.next=new ListNode(9);
//
//        printList(node);
//        Ankit obj= () -> System.out.println("walking");
//        node = addOne(node);
//        printList(node);
        ListNode node =new ListNode(1);
        node.next=new ListNode(2);
        node.next.next=new ListNode(3);
//        node.next.next.next=new ListNode(3);
//        node.next.next.next.next=new ListNode(4);
//        node.next.next.next.next.next=new ListNode(5);
//        System.out.println(Solution(node));
        printList(node);
//        ListNode head =reverseBrute(node);
//        ListNode head =middelOfList(node);
//        printList(head);
//        ListNode res = removenthNode(node,1);
        ListNode res = removenthNode2(node,2);
        printList(res);





    }
}
