class Solution {
    public boolean isAnagram(String s, String t) {
        
        char[] source = s.toCharArray();
        Arrays.sort(source);
        char[] target = t.toCharArray();
        Arrays.sort(target);
        return Arrays.equals(source,target);
    }
}