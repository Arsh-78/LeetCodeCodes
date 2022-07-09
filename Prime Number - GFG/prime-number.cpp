// { Driver Code Starts
#include<bits/stdc++.h> 
using namespace std;

 // } Driver Code Ends
class Solution{
public:
    int isPrime(int N){
        // code here
        helper(N,2);
    }
    
    int helper(int n ,int k)
    {
        if(n<2)
        {
            return 0;
        }
        if(n==2 || n==3 || k*k>n)
        {
            return 1;
        }
        else if(n%k==0)
        {
            return  0;
        }
        else
        {
            return helper(n,k+1);
        }
        
        
    }
};


// { Driver Code Starts.
int main() 
{ 
    int t;
    cin>>t;
    while(t--)
    {
        int N;
        cin>>N;
        Solution ob;
        cout << ob.isPrime(N) << endl;
    }
    return 0; 
}  // } Driver Code Ends