class Solution {
    public boolean squareIsWhite(String coordinates) {
        
        int t = coordinates.charAt(0)-'a' + Integer.parseInt(String.valueOf(coordinates.charAt(1)));
        
        return t%2==0;
    }
}