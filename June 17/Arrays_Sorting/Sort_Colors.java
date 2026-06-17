class Solution {
    public void sortColors(int[] nums) {
        int i=-1;
        int j=nums.length;
        int k=0;

        while(k<j){
            if(nums[k]==0){
                i++;
                swap(nums,i,k);
                 k++;

            }
            else if(nums[k]==1){
                k++;
            }else{
                j--;
                swap(nums,j,k);
            }
        }

       
    }
     public void swap(int [] nums,int i,int j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
}