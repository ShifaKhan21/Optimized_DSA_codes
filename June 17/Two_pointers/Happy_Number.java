class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while(n != 1) {
            if(seen.contains(n)) {
                return false;
            }
            seen.add(n);
        int sum = 0;
        String s = String.valueOf(n);

        for(int i=0; i<s.length(); i++) {
            int dig = s.charAt(i) - '0';
            sum += dig*dig;
        }
        n = sum;
    }
    return true;
    }
}