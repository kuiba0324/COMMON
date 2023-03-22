/*
 * @lc app=leetcode.cn id=1480 lang=java
 *
 * [1480] 一维数组的动态和
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    
    public int[] runningSum(int[] nums) {
        int[] retvect = new int[nums.length];
        for(int i=0 ;i<nums.length;++i){
            int[] tempnums=Arrays.copyOfRange(nums ,0,i+1);
            retvect[i]=getsum(tempnums);
        }   
        return retvect;
    }

    public int getsum(int[] nums){
        int retvect=0;
        for(int i : nums){
            retvect+=i;
        }
        return retvect;
    }
}
// @lc code=end

