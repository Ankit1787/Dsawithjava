package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val=val;
        this.left=null;
        this.right=null;

    }
    TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
          this.left = left;
          this.right = right;
      }
      static class BinaryTree{
        static int index=-1;
          public static TreeNode buildTree(Integer[] arr) {
              if (arr.length == 0 || arr[0] == null) return null;

              TreeNode root = new TreeNode(arr[0]);
              Queue<TreeNode> queue = new LinkedList<>();
              queue.offer(root);

              int i = 1;
              while (!queue.isEmpty() && i < arr.length) {
                  TreeNode current = queue.poll();

                  // Left child
                  if (i < arr.length && arr[i] != null) {
                      current.left = new TreeNode(arr[i]);
                      queue.offer(current.left);
                  }
                  i++;

                  // Right child
                  if (i < arr.length && arr[i] != null) {
                      current.right = new TreeNode(arr[i]);
                      queue.offer(current.right);
                  }
                  i++;
              }

              return root;
          }
      }


    public static String levelOrderTraversal(TreeNode root){
     List<List<Integer>> list = new ArrayList<>();
     Queue<TreeNode> queue = new LinkedList<>();
     if(root==null){
         return list.toString();
     }
     queue.add(root);
     queue.add(null);
        List<Integer> temp = new ArrayList<>();

        while(!queue.isEmpty()){
         TreeNode currNode= queue.remove();
         if(currNode==null){
             list.add(new ArrayList<>(temp));
             temp.clear();
             if (!queue.isEmpty()) {
                 queue.add(null);
             }
         }
         else{
             temp.add(currNode.val);
             if(currNode.left!=null)queue.add(currNode.left);
             if(currNode.right!=null)queue.add(currNode.right);

         }
     }
    return list.toString();

    }
    public static String levelOrderTraversal2(TreeNode root){
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null){
            return list.toString();
        }
        queue.add(root);
        queue.add(null);
        List<Integer> temp = new ArrayList<>();

        while(!queue.isEmpty()){
            TreeNode currNode= queue.remove();
            if(currNode==null){
                list.add(new ArrayList<>(temp));
                temp.clear();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            }
            else{
                temp.add(currNode.val);
                if(currNode.left!=null)queue.add(currNode.left);
                if(currNode.right!=null)queue.add(currNode.right);

            }
        }
        return list.toString();

    }

    // preorder traversal to verify the built tree
public static void preorder(TreeNode root) {
    if (root == null) {

        return;
    }
    System.out.print(root.val + " ");
    preorder(root.left);
    preorder(root.right);
}
public  static void levelOrder(TreeNode node){
        if(node==null)return ;
        Queue<TreeNode> queue =new LinkedList<>();
        queue.add(node);
        queue.add(null);
        while(!queue.isEmpty()){
            TreeNode currNode =queue.remove();
            if(currNode==null){
                System.out.println();
                if(!queue.isEmpty()){
                    queue.add(null);
                }


            }else{
                System.out.print(currNode.val+" ");
                if(currNode.left!=null)queue.add(currNode.left);
                if(currNode.right!=null)queue.add(currNode.right);
            }
        }

}


    public static void main(String[] args) {
        Integer[] nodes = {3,9,20,null,null,15,7};
        BinaryTree tree = new BinaryTree();
        TreeNode node =tree.buildTree(nodes);
        System.out.println(node);
//        preorder(node);
        levelOrder(node);
        System.out.println(levelOrderTraversal(node));
        System.out.println(levelOrderTraversal2(node));

    }
}
