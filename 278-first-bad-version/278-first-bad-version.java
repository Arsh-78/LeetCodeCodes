/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start =1,end =n,mid;
      
        
        while(start <=end)
        {
            mid = start + (end-start)/2;
            if(!isBadVersion(mid))
            {
                start = mid +1;
            }
            else if(!isBadVersion(mid-1))
            {
                
                
                    return  mid;
                
            }
            else 
            {
                end = mid-1;
            }
                     
        }
        return -2;
    }
}