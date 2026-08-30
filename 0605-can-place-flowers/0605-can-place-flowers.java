class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int result=0;
        for(int i=0; i<flowerbed.length; i++){
            if(flowerbed[i]==0){
               boolean checkLeft = i==0 || flowerbed[i-1]==0;
               boolean checkRight = i==flowerbed.length-1 || flowerbed[i+1]==0;
               if(checkLeft && checkRight){
                flowerbed[i]=1;
                result++;
               }
            }
           
        }
         if(result>=n) return true;
            return false;
    }
}