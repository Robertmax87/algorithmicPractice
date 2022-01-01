package BinarySearch;

public class InsertPosition {
    /**Given a sorted array of distinct integers and a target value, return the index if the target is found.
     If not, return the index where it would be if it were inserted in order.
     You must write an algorithm with O(log n) runtime complexity.
     **/
    //Do a binarySearch and then if start is more than the end return start because that is the position the
    //number should have been in
    public int searchInsert(int[] nums, int target) {
        return binarySearch(0, nums.length - 1, target, nums);

    }
    public int binarySearch(int start, int end, int target, int[] nums){
        if(start <= end){

            int mid =(end + start)/2;

            if(nums[mid] == target)return mid;

            else if(nums[mid] < target)return binarySearch(mid + 1, end, target, nums);
            else{
                return binarySearch(start, mid - 1, target, nums);
            }
        }
        return start;

    }
}
