class Solution {
    public int[] twoSum(int[] nums, int target) {
      HashMap<Integer, Integer> numMap = new HashMap<>();
      for(int i=0; i<nums.length; i++){
        int secondNum = target - nums[i];
        if(numMap.containsKey(secondNum)){
            return new int[] {numMap.get(secondNum), i};
        }
       
            numMap.put(nums[i],i);
        
      }
      return new int[] {};
    }
}