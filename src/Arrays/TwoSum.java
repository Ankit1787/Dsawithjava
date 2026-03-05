package Arrays;

import LinkList.ListNode;

import java.util.*;

public class TwoSum {
    public static int [] calcTwoSum(int [] arr,int target){
        Map <Integer,Integer> map = new HashMap<>();
        int [] newArr =new int [2];

        for(int i=0;i<arr.length;i++){
            int index =target-arr[i];
            if(map.containsKey(index)){
                newArr[0]=map.get(index);
                newArr[1]=i;
                return newArr;
            }
            map.put(arr[i],i);
        }
        return newArr;


    }
    public static int buyAndSell(int []arr){
        int maxProfit=0;
        int left=0;
        for(int right=0;right<arr.length;right++){
            int prof=arr[right]-arr[left];
            maxProfit=Math.max(maxProfit,prof);
            if(prof<0) left=right;
        }
        return maxProfit;

    }
    public static int findDuplicate(int []arr){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                return  arr[i];
            }
            map.put(arr[i],i);


        }
        return -1;
    }
    public static int [] productsum(int [] arr){
        int [] arr1= new int[arr.length];
        int [] arr2= new int[arr.length];
        int prod1=1;
        int prod2=1;
        int n =arr.length;
        arr1[0]=1;
        arr2[n-1]=1;
        for(int i=1;i<n;i++){
            prod1=prod1*arr[i-1];
            arr1[i]=prod1;
            prod2=prod2*arr[n-i];
            arr2[n-i-1]=prod2;
        }
        for(int i=0;i<n;i++){
            arr[i]=arr1[i]*arr2[i];
        }
        return arr;
    }
    public static int maxSum(int [] arr){
        int currSum =arr[0];
        int maxSum =arr[0];

        for(int i=1;i<arr.length;i++){
            currSum = Math.max(arr[i],currSum+arr[i]);
            maxSum = Math.max(maxSum,currSum);

        }
        return maxSum;

    }
    public static int maxProduct(int [] arr){

        int minProd =arr[0];
        int maxProd =arr[0];
        int result =arr[0];
        for(int i=1;i<arr.length;i++){
            int temp = maxProd; // store before updating

            maxProd = Math.max(arr[i],Math.max(arr[i]*maxProd,arr[i]*minProd));
            minProd = Math.min(arr[i],Math.min(arr[i]*temp,arr[i]*minProd));
            result =Math.max(result,maxProd);

        }
        return maxProd;

    }
    public static int searchInRotated(int [] arr,int target){
        int left =0;
        int right =arr.length-1;
        while(left<=right){
            int mid= left+(right-left)/2;
            System.out.println((right-left)/2);
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]>=arr[left]){
                if(arr[left]<=target&&target<=arr[mid]){
                     right=mid-1;
                }
                else{
                    left=mid+1;
                }


            }
            else {
                if(arr[right]>=target&&target>=arr[mid]){
                    left=mid+1;
                }
                else{
                    right=mid-1;
                }
            }
        }
        return -1;
    }
    public static int [][] mergeIntervals(int [][] intervals){
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int n =intervals.length;
        int e =0;
        int [][] res =new int[n][2];
        res[0]=intervals[0];
        for(int i=1;i<n;i++){
            if(intervals[i][0]<=res[e][1]){
                res[e][1]=Math.max(res[e][1],intervals[i][1]);
            }
            else{
                e++;
                res[e]=intervals[i];
            }
        }
        return Arrays.copyOfRange(res,0,e+1);

    }
    public static int [][] mergeIntervals2(int [][] intervals){
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int n = intervals.length;
        List <int []> list = new ArrayList<>();
        int [] current=intervals[0];
        list.add(current);
        for(int [] interval:intervals){
            if(interval[0]<=current[1]){
                current[1]=Math.max(interval[1],current[1]);

            }
            else{
                current=interval;
                list.add(current);
            }
        }

        return list.toArray(new int[list.size()][]);
    }
    public static int [][] insertInterval(int [][] intervals,int[] interval){
        int n =intervals.length;

        List<int []> res =new ArrayList<>();
        int i=0;
        while(i<n&&intervals[i][1]<interval[0]){
            res.add(intervals[i]);
            i++;
        }
        System.out.println(i+" index"+n+" n ");

        while(i<n&&intervals[i][0]<=interval[1]){
            System.out.println("this running");
            interval[0]=Math.min(interval[0],intervals[i][0]);
            interval[1]=Math.max(interval[1],intervals[i][1]);
           i++;
        }
        res.add(interval);
        System.out.println(i+" index"+n+" n ");
        while(i<n){
            res.add(intervals[i]);
            i++;
        }


        return res.toArray(new int [i][]);

    }
    public static int nonOverlapping(int [][] intervals){
        int n =intervals.length;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int count=0;

        int  prev =intervals[0][1];
        for(int i=1;i<n;i++){
            if(intervals[i][0]<prev){
              count++;
              prev=Math.min(intervals[i][1],prev);
                System.out.println("if count "+count+"prev "+prev+" index"+i);
            }
            else{
                prev=intervals[i][1];
                System.out.println("else count "+count+"prev "+prev+" index"+i);

            }

        }
        return count;





    }


    public static void main(String[] args) {
//        int [] arr ={2,2,11,7};
//
//        int target = 9;
//        int [] newarr =calcTwoSum(arr,target);
//        for(int item :newarr){
//            System.out.println(item);
//        }
//        int [] prices = {7,1,5,3,6,4};
//        System.out.println(buyAndSell(prices));
//        int [] prodArr = {1,2,3,4};
//        int [] res= productsum(prodArr);
//        for(int elm:res){
//            System.out.println(elm);
//        }
//        int [] arr ={-2};
//        System.out.println(maxProduct(arr));

// int [] duparr = {1,3,4,2,2};
//        System.out.println(findDuplicate(duparr));
//        int [] newArr= {4, 5, 6, 7, 0, 1, 2};
//        System.out.println(searchInRotated(newArr,0));

//        int [] []intervals={{1,3},{2,6},{8,10},{15,18}};
////        int[][] res =mergeIntervals(intervals);
//        int[][] res =mergeIntervals2(intervals);
//        System.out.println(Arrays.deepToString(res));

        int [] []intervals2={{1,3},{6,9}};
        int [] interval ={2,5};

//        int[][] res =mergeIntervals(intervals2);
//        int[][] res2 =insertInterval(intervals2,interval);
//        System.out.println(Arrays.deepToString(res2));

          int [][] intervals3={{1,2},{1,2},{1,2}};
        int res2 =nonOverlapping(intervals3);
        System.out.println(res2);



    }
}
