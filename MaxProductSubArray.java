import java.util.Arrays;

class MaxProductSubArray {
    public int maxProduct(int[] nums) {
        int res = Arrays.stream(nums).max().getAsInt();
        int currMin=1;
        int currMax=1;

        for (int i=0; i< nums.length; i++) {
            if (nums[i]==0) {
                currMin=1;
                currMax=1;
                continue;
            }
            int temp = nums[i] * currMax;
            currMax = Math.max(temp, Math.max(nums[i]*currMin, nums[i]));
            currMax = Math.min(temp, Math.min(nums[i]*currMin, nums[i]));
            res = Math.max(currMax, res);
        }
        return res;
    }
}