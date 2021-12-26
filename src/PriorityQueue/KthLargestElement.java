package PriorityQueue;

import java.util.Arrays;

public class KthLargestElement {
    /**Given an integer array nums and an integer k, return the kth largest element in the array.
     Note that it is the kth largest element in the sorted order, not the kth distinct element.
     **/


    class Solution {


        public int findKthLargest(int[] nums, int k) {
            Arrays.sort(nums);

            int counter = 0;
            for(int i = nums.length - 1; i>0; i--){
                if( nums[i - 1] < nums[i] || nums[i - 1] == nums[i] ){
                    counter++;

                }
                if(counter == k) return nums[i];


            }
            return nums[0];


        }
    }
}
