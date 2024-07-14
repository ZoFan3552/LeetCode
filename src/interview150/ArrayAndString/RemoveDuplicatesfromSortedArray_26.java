package interview150.ArrayAndString;

public class RemoveDuplicatesfromSortedArray_26 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int stay = 0 , move = 0;
        int res = 1;
        while (move < n){
            while (move < n && nums[stay] == nums[move] ){
                move++;
            }
            if (move < n){
                nums[stay + 1] = nums[move];
                res++;
                stay++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int res = new RemoveDuplicatesfromSortedArray_26().removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
        System.out.println(res);
    }
}
