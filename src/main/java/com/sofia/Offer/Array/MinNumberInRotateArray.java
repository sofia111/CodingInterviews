package com.sofia.Offer.Array;

/**
*@Author: Sofia
*@Date: 2019/6/18 12:25
*@Description: 旋转数组中的最小数字
*/
public class MinNumberInRotateArray {

    public int minNum(int[] array){

        int start = 0;
        int end = array.length - 1;
        while(start < end){
            int mid = start + (end - start)/2;
            if (array[mid] > array[end])
                start = mid + 1;
            else if (array[mid] == array[end])

                //当后面子数组都是相同值时,直接--;
                end--;
            else
                end = mid;
        }
        return array[start];

    }
}
