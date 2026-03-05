package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class SlidingWindow {
    public static int maximumSubArraySum(int [] arr,int k){
        int n =arr.length;
        int currentSum=0;
        int left=0;
        int maxSum =0;
        Set<Integer> set = new HashSet<>();
        for(int right=0;right<n;right++){
            while(set.contains(arr[right]) || set.size()==k){
                set.remove(arr[left]);
                currentSum-=arr[left];
                left++;
            }
              currentSum+=arr[right];
               set.add(arr[right]);
               if(set.size()==k){
                   maxSum=Math.max(currentSum,maxSum);

               }

        }
        return maxSum;
    }
    public  static int longestSubString(String s){
        int maxLength =0;

        int n = s.length();
        int left =0;
        Set<Character> set =new HashSet<>();
        for(int right=0;right<n;right++){
            while (set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;

            }
            set.add(s.charAt(right));
            maxLength=Math.max(maxLength,right-left+1);

        }
        return  maxLength;
    }
    public static int minimumSizeSubArray(int [] arr,int target){
        int minimumLength=Integer.MAX_VALUE;
        int currentSum=0;
        int left=0;
        int n =arr.length;
        for(int right=0;right<n;right++){
            currentSum+=arr[right];
            while(currentSum>=target){
                minimumLength=Math.min(right-left+1,minimumLength);
                currentSum-=arr[left];
                left++;

            }
        }
        return minimumLength!=Integer.MAX_VALUE?minimumLength:0;
    }

    public static void main(String[] args) {
        int [] arr= {1,5,4,2,9,9,9};
        int [] nums={2,3,1,2,4,3};
        int target =7;
        int k = 3;
        String s = "abcabcbb";
        System.out.println(maximumSubArraySum(arr,k));
        System.out.println(longestSubString(s));
        System.out.println(minimumSizeSubArray(nums,target));

    }
}
