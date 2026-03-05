package Strings;

import java.util.*;

public class Strngs {
    public static String getHash(String s){
        int max=26;
        int [] arr = new int[26];
        StringBuilder hash = new StringBuilder();
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;

        }
        for(int count:arr){
            hash.append(count);
            hash.append("#");
        }
        return hash.toString();


    }
    public static List<List<String>> groupAnagram(String [] strs){
        List<List<String>> list = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for(String s:strs){
            String hash = getHash(s);
            if(!map.containsKey(hash)){
                System.out.println(list.size());
                map.put(hash, list.size());
                list.add(new ArrayList<>());
            }
            list.get(map.get(hash)).add(s);
        }
        System.out.println(map);

        return list;

    }
    public static String LongestCommonSuffix(String [] strs){
        Arrays.sort(strs);
        System.out.println(Arrays.toString(strs));
        StringBuilder str = new StringBuilder();
//        get the first and the last string;
        char [] first =strs[0].toCharArray();
        char  [] last = strs[strs.length-1].toCharArray();

        for(int i=first.length-1;i>0;i--){
            if(first[i]!=last[i]){
                break;
            }
            str.append(first[i]);
        }

        return str.toString();


    }
    public static boolean isPalindrome(String s) {
        String newStr =s.replaceAll("[^A-Za-z0-9]","");
        int n =newStr.length();
        int mid = n/2;
        for(int i=0;i<mid;i++){
            if(newStr.charAt(i)!=newStr.charAt(n-i-1)){
                return false;
            }
        }
        return true;

    }
    public static void main(String[] args) {
        String [] strs={"eat","tea","tan","ate","nat","bat"};
        List<List<String>> res=groupAnagram(strs);
        String [] strs1 ={"flight","tight","fight","sought"};
//        System.out.println(res);
        System.out.println(LongestCommonSuffix(strs1));
        String str ="A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(str));

    }
}
