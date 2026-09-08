class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1)
            return s.length();
        int[] tracker = new int[256];
        int maxlen = -1;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            tracker[c]++;
            while (tracker[c] > 1) {
                char left = s.charAt(start);
                tracker[left]--;
                if (tracker[c] == 0)
                    break;
                start++;
            }
            maxlen = Math.max(maxlen, i - start + 1);
        }
        return maxlen;
    }
}


