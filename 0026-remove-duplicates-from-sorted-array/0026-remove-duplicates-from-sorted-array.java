class Solution {
    public int removeDuplicates(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int i = 0;
        for (int ele : nums) {
            if (!map.containsKey(ele)) {
                map.put(ele, 1);
                nums[i] = ele;
                i++;
            } else {
                map.put(ele, map.get(ele) + 1);
            }
        }
        return i;
    }
}