package com.sofia.Offer.Array;

/**
*@Author: Sofia
*@Date: 2019/6/4 14:00
*@Description:  找一维数组中的重复数字，在长度为n的数组里，所有数字都在0 ~ n-1范围内
 *                利用数组下标与值，将对应的值放进对应的下标中，
 *                时间O（n），空间O（1）
*/
public class FindDuplicate {

    /*
    * 可以修改数组的
    * */
    public static boolean duplicate(int[] nums){

        if (nums.length == 0 || nums == null)
            return false;

        int len = nums.length;
        int temp;
        for (int i = 0; i < len; i++){
            while (nums[i] != i && nums[i] < len){
                if (nums[i] == nums[nums[i]])
                    return true;
                else{
                    temp = nums[nums[i]];
                    nums[nums[i]] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return false;
    }

    /*
    * 当不可以修改数组时，考虑到O（1）的空间复杂度，数组数字范围在1-n 中，长度为n+1
    * */
    public static int getDuplication(int[] nums){

        if (nums == null || nums.length == 0)
            return -1;
        int end = nums.length - 1;
        int start = 0;
        while (start <= end){
            int mid = ((end - start) >> 1) + start;
            int count = counting(nums,start,mid);
            if (start == end){
                if (count > 1)
                    return start;
                else
                    break;
            }
            if (count > (mid - start + 1)){
                end = mid;
            }else
            {
                start = mid + 1;
            }

        }
        return 0;
    }

     public static int counting(int[] arr, int l, int r){

        if (arr == null || arr.length == 0)
            return 0;
        int count = 0;
        for (int i  = 0; i < arr.length; i++){
            if (arr[i] >= arr[l] && arr[i] <= arr[r]){
                ++count;
            }
        }
        return count;
     }


/*
*  二维数组中的查找
*  选取数组查找范围内的右上角数字（可缩小范围），也可以选取左下角的数字，
* */

    public static boolean find (int[][] arr, int rows, int columns, int number){

        boolean found = false;
        if (arr != null && rows > 0 && columns > 0){
            int row = 0;
            int column = columns - 1;
            while (row < rows && column >= 0){
                if (arr[row][column] == number){
                    found = true;
                    break;
                }
                else if (arr[row][column] > number){
                    --column;
                }
                else
                    ++row;
            }
        }
        return found;
    }

    public static void main(String[] args) {

        int[] a = {2,1,3,4,5,5,3};
        int[][] ab = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(find(ab,4,4,7));
      //System.out.println(getDuplication(a));
       // System.out.println(FindDuplicate.duplicate(a));
    }

}
