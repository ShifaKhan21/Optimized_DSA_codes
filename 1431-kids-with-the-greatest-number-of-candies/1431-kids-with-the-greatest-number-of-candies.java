class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies=0;
        List<Boolean> result = new ArrayList<>(); 
        for(int candy = 0; candy<candies.length; candy++){
            maxCandies =  Math.max(maxCandies, candies[candy]);
        }
        for(int i=0; i<candies.length; i++){
            if(candies[i]+extraCandies>=maxCandies){
                result.add(true);
            }
            else result.add(false);
        }
        return result;
    }
}