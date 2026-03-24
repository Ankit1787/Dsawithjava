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
    }
    public static ListNode reverseBrute(ListNode head){


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
    public static ListNode addTwoList(ListNode l1 ,ListNode l2){

        ListNode l3;
        int carry =0;

        int sum = l1.val+l2.val;
        System.out.println(sum+" sum"+sum%10);
        l3= new ListNode(sum%10);
         carry =sum/10;
         ListNode curr=l3;
         l1=l1.next;
         l2=l2.next;
         while(l1!=null&&l2!=null){
              sum = l1.val+l2.val+carry;
             System.out.println(sum+" sum"+sum%10);
             curr.next= new ListNode(sum%10);
             carry =sum/10;
             l1=l1.next;
             l2=l2.next;
             curr=curr.next;

         }
        while(l1!=null){
             sum = l1.val+carry;
            System.out.println(sum+" sum"+sum%10);
            curr.next= new ListNode(sum%10);
            carry =sum/10;
            l1=l1.next;
            curr=curr.next;

        }
        while(l2!=null){
             sum = l2.val+carry;
            curr.next= new ListNode(sum%10);
            carry =sum/10;
            l2=l2.next;
            curr=curr.next;

        }
         return l3.next;

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
    public static void linkedlistCycle2(ListNode head){
        ListNode slow=head;
        ListNode fast=head;

      // detect the loop
        while(fast!=null&&fast.next!=null ){
          fast=fast.next.next;
          slow=slow.next;
          if(slow==fast){
             break;

          }

        }

        slow=head;
//        find starting point of the loop
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        while(fast.next!=slow){
            fast=fast.next;
        }





    }
    public static ListNode removeCycle(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null ){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                slow=head;
                while (slow.next != fast.next) {
                    slow = slow.next;
                    fast = fast.next;

                }
                fast.next=null;

                return head;
            }


        }
        return null;
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

    static ListNode add1ToLinkedList(ListNode head){
       if(head==null)return null;
         head=reverse(head);
         ListNode curr=head;
         int carry =1;
        while(curr!=null){
            int sum = curr.val+carry;
            curr.val= sum%10;
            carry =sum/10;

            if (carry == 0) break;

            if (curr.next == null && carry > 0) {
                curr.next = new ListNode(carry);
                carry = 0;
                break;
            }
            curr=curr.next;

        }
        return reverse(head);

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

    public static ListNode findIntersection(ListNode list1,ListNode list2){
       int size1=0;
       int size2=0;
       ListNode curr=list1;
       ListNode curr2=null;
       while(curr!=null){
           size1++;
         curr=curr.next;

       }
       curr=list2;
       while(curr!=null){
           size2++;
         curr=curr.next;

       }
       if(size1==0 || size2==0)return null;
       if(size1==size2){
           curr=list1;

           curr2=list2;
           while(curr!=null){
               if(curr==curr2){
                   return curr;
               }
               curr=curr.next;
               curr2=curr2.next;


           }
       }
       if(size1>size2){
           int pos =size1-size2;
           curr=list1;

           for(int i=0;i<pos;i++){
               curr=curr.next;
           }
           curr2=list2;
           while(curr!=null){
               if(curr==curr2){
                   return curr;
               }
               curr=curr.next;
               curr2=curr2.next;


           }

       }
       else{
           int pos =size2-size1;
           curr2=list2;

           for(int i=0;i<pos;i++){
               curr2=curr2.next;
           }
           curr=list1;
           while(curr!=null){
               if(curr==curr2){
                   return curr;
               }
               curr=curr.next;
               curr2=curr2.next;


           }
       }
        System.out.println(size1+" " +size2);


        return null;
    }

     public static ListNode removeElements(ListNode head,int val){
        while(head.val==val){
            head=head.next;
        }
        ListNode curr =head;
        while(curr.next != null){
            if(curr.next.val==val){
                curr.next=curr.next.next;
            }
            else{
                curr=curr.next;
            }
        }

        return head;


     }
     public static ListNode removeElements2(ListNode head,int val){
      ListNode dummy = new ListNode(-1);
      dummy.next=head;
        ListNode curr =dummy;
        while(curr.next!=null){
            if(curr.next.val==val){
                curr.next=curr.next.next;
            }
            else{
                curr=curr.next;
            }
        }

        return dummy.next;


     }
    public static void mergeSort(int[] arr, int left, int right) {

        if(left >= right) return;

        int mid = (left + right) / 2;


        mergeSort(arr, left, mid);

        mergeSort(arr, mid + 1, right);
        System.out.println("after Left"+left+" right"+right+"mid "+mid);
    }
     public static ListNode sortList(ListNode head){
        if(head==null)return null;
       ListNode curr =head;
       List <Integer> list = new ArrayList<>();
       while(curr!=null){
           list.add(curr.val);
           curr=curr.next;

       }
       Collections.sort(list);
       ListNode temp = new ListNode(list.getFirst());
       curr=temp;
       for(int i=1;i<list.size();i++){
           curr.next=new ListNode(list.get(i));
           curr=curr.next;


       }
       return temp;

     }

    public static ListNode removeDuplicated(ListNode head){
        if(head==null)return null;

        ListNode curr =head.next;
        ListNode prev =head;
        while(curr!=null){
            if(curr.val==prev.val &&prev.next!=null){
                curr=curr.next;
              prev.next=prev.next.next;

            }
            else{
                prev=curr;
                curr=curr.next;
            }

        }

        return head;

    } public static ListNode removeDuplicated2(ListNode head){
        if(head==null)return null;
        Set <Integer> set = new HashSet<>();

        ListNode curr =head;
        ListNode prev =null;
        while(curr!=null){
            if(set.contains(curr.val)){
                prev.next =curr.next;
            }
            else{
                set.add(curr.val);

                prev=curr;
            }
            curr = curr.next;

        }

        return head;

    }


    static void fun(int n){
        if(n == 0) return;

        System.out.println("Start " + n);

        fun(n-1);

        System.out.println("End " + n);
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
//        ListNode node =new ListNode(1);
//        node.next=new ListNode(2);
//        node.next.next=new ListNode(3);
//        node.next.next.next=new ListNode(3);
//        node.next.next.next.next=new ListNode(4);
//        node.next.next.next.next.next=new ListNode(5);

//        two list
//        ListNode node1 =new ListNode(1);
//        ListNode node2 =new ListNode(7);
//        node1.next=new ListNode(2);
//        node1.next.next=new ListNode(3);
//        node1.next.next.next=new ListNode(4);
//        node1.next.next.next.next=new ListNode(5);
//
//
//        node2.next=new ListNode(8);
//        node2.next.next=new ListNode(9);
//        node2.next.next.next=node1.next.next;

//        node1.next.next.next.next.next=new ListNode(5);


//        System.out.println(Solution(node));
//        printList(node);
//        ListNode head =reverseBrute(node);
//        ListNode head =middelOfList(node);
//        printList(head);
//        ListNode res = removenthNode(node,1);
//        ListNode res = removenthNode2(node,2);
//        printList(res);


//        two list
//        printList(node1);
//        printList(node2);
//          ListNode res =findIntersection(node1,node2);
//        printList(res);

//        remove linked list elements

//        ListNode node =new ListNode(6);
//        node.next=new ListNode(6);
//        node.next.next=new ListNode(3);
//        node.next.next.next=new ListNode(3);
//        node.next.next.next.next=new ListNode(6);
//        node.next.next.next.next.next=new ListNode(6);
//        printList(node);
//
//        ListNode res =removeElements2(node,6);
//        printList(res);


//        sort the list
//        ListNode node =new ListNode(4);
//        node.next=new ListNode(2);
//        node.next.next=new ListNode(1);
//        node.next.next.next=new ListNode(3);
//
//        printList(node);
//
//        ListNode res =sortList(node);
//        printList(res);
//        int [] arr = {4,2,1,3};
//        mergeSort(arr,0,arr.length-1);


//        remove duplicates from the list

//        ListNode node =new ListNode(1);
//        node.next=new ListNode(1);
//        node.next.next=new ListNode(1);
//        node.next.next.next=new ListNode(3);
//        node.next.next.next.next=new ListNode(4);
//
//        printList(node);

//        ListNode res =removeDuplicated(node);

//           ListNode res =removeDuplicated2(node);

//        printList(res);


//        ListNode node =new ListNode(12);
//        node.next=new ListNode(11);
//        node.next.next=new ListNode(12);
//        node.next.next.next=new ListNode(21);
//        node.next.next.next.next=new ListNode(41);
//        node.next.next.next.next.next=new ListNode(43);
//        node.next.next.next.next.next.next=new ListNode(21);
//
//        printList(node);
//
////        ListNode res =removeDuplicated(node);
//
//        ListNode res =removeDuplicated2(node);
//
//        printList(res);

////        add 1 to a linkedlist
//
//        ListNode node =new ListNode(9);
//        node.next=new ListNode(9);
//        node.next.next=new ListNode(9);
//
//
//        printList(node);
//
////        ListNode res =removeDuplicated(node);
//
//        ListNode res =add1ToLinkedList(node);
//
//        printList(res);


        //        add two linkedlist

        ListNode node1 =new ListNode(9);
        node1.next=new ListNode(9);
        node1.next.next=new ListNode(9);
        node1.next.next.next=new ListNode(9);
        node1.next.next.next.next=new ListNode(9);
        node1.next.next.next.next.next=new ListNode(9);
        node1.next.next.next.next.next.next=new ListNode(9);

        ListNode node2 =new ListNode(9);
        node2.next=new ListNode(9);
        node2.next.next=new ListNode(9);
        node2.next.next.next=new ListNode(9);


        printList(node1);
        printList(node2);

//        ListNode res =removeDuplicated(node);

        ListNode res =addTwoList(node1,node2);

        printList(res);


    }
}
