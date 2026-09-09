class Solution {
    boolean isCorrect(int[] have, int[] needed){
        for(int i=0; i< 256; i++){
        if(have[i] < needed[i]) return false;
        }
        return true;
    }
    public String minWindow(String s, String t) {
        int result=Integer.MAX_VALUE; 
        int[] have = new int[256];
        int[] needed = new int[256];
        for( int i=0; i< t.length(); i++){
            needed[t.charAt(i)]++;
        }
        int left=0; int start=0;
        for(int right=0; right < s.length(); right ++){
            have[s.charAt(right)]++;
            while(isCorrect(have,needed)){
            int len = right - left + 1;
            if(result > len){
                result = len;
                start = left;           
            }
            have[s.charAt(left)]--;
            left++;
            }
           
        }
        return result == Integer.MAX_VALUE ?  "" : s.substring(start ,  result + start);
        
        
    }
}