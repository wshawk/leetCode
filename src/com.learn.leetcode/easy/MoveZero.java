package com.learn.leetcode;

import java.util.Arrays;

/**
 * 
 * @author  文松
 *
 * 2019年1月28日下午5:28:39
 */
public class MoveZero {
	
	public static void main(String[] args) {
		int[] nums = {0,1,0,3,12};
		System.out.println(Arrays.toString(moveZero01(nums)));
		System.out.println(Arrays.toString(moveZero02(nums)));
		System.out.println(Arrays.toString(moveZero03(nums)));
          	}
	
	/**
	 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
	 * 示例:
	 * 		输入: [0,1,0,3,12]
	 * 		输出: [1,3,12,0,0]
	 * 说明：
	 * 		必须在原数组上操作，不能拷贝额外的数组。
	 *		尽量减少操作次数。
	 * @return
	 */
	
	public static int[] moveZero01(int[] nums) {
		// 解法1 执行用时20ms 
		int j = 0;
		for(int i=0; i < nums.length; i++) {//遍历数组
			j = i + 1;//取i的下一位
			if (nums[i] == 0) {// 如果元素为0
			while(true) {
				if (j < nums.length) { // 判断j有没有超多数组长度，如果超过就break
					if (nums[j] != 0) {// 找到i后面一个不为0的元素
						 nums[i] = nums[j];// 将不为0的值赋给为0的值
						 nums[j] = 0;// 再将0赋给后面的值
						 break;// 跳出while
					}
					j++;
				}else {
					break;
				}
			}
			}
		}
		 return nums;
	}
	
	public static int[] moveZero02(int[] nums) {
		// 执行用时2ms
			int j = 0; 
			for(int i=0; i < nums.length; i++) {
				if (nums[i] != 0) {// 如果nums[i] != 0
					if (i != j) {
						nums[j] = nums[i];
						nums[i] = 0;
					}
					j++;
				}
			}
		return nums;
	}
	
	public static int[] moveZero03(int[] nums) {
		// 执行用时1ms
        int zeroNum=0;//用来计算0的个数
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){//如果nums[i]=0,zeroNum个数加一
                zeroNum++;
            }else if(zeroNum!=0){//如果nums[i]不等于0,将nums[i]跟前zeroNum个交换，并且将nums[i]赋值为0
                nums[i-zeroNum]=nums[i];  
                nums[i]=0;
            }
        }
		return nums;
	}
}
