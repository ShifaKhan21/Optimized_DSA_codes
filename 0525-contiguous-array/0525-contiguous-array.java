class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> store = new HashMap<>();
        int zeros = 0;
        int ones = 0;
        int result = 0;
        for(int i = 0; i <nums.length; i++){
            if(nums[i]==0){
                zeros++; 
            }else ones++;
            int diff = zeros - ones;
            if(diff==0){
                result = Math.max( result , i+1);
            }
            else{
                if(!store.containsKey(diff)){
                    store.put(diff,i);
                }
                else{
                    int prevIdx = store.get(diff);
                    result = Math.max(result, i - prevIdx);
                }
            }
        }
        return result;
    }
}