package com.sofia.Offer.Array;

/**
*@Author: Sofia
*@Date: 2019/6/11 16:23
*@Description: 替换空格，时间复杂度O（n），先遍历一遍字符串，遍历出i个空格，数组空间扩大i个，从后往前挪动数组
 * 举一反三：合并数组时，需要重复移动数组或字符多次，从后往前复制，减少移动次数，提高效率；
*/
public class ReplaceBlank {

    public void replace(char[] str, int length){

        if(str == null || str.length == 0) {
            return;
        }
        int originalLength = 0;
        int numberOfBlank = 0;
        int jjj = 0;
        int i = 0;
        while(str[i] != '\0'){
            ++originalLength;
            if (str[i] == ' '){   //单引号和双引号区别，
                ++numberOfBlank;
            }
            ++i;
        }
        //newLength  将空格替换成‘%20’后的长度
        int newLength = originalLength + numberOfBlank * 2;
        if (newLength > length){
            return;
        }
        int indexOfOriginal = originalLength;
        int indexOfNew = newLength;
        while (indexOfOriginal >= 0 && indexOfNew > indexOfOriginal){
            if (str[indexOfOriginal] == ' '){
                str[indexOfNew--] = '0';
                str[indexOfNew--] = '2';
                str[indexOfNew--] = '%';
            }else{
                str[indexOfNew--] = str[indexOfOriginal];
            }
            --indexOfOriginal;
        }
    }
}
