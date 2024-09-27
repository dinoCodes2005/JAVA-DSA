

class Solution {
    public long getCount(long n)
    {
        return (n*(n+1)/2)%1000000007;
    }
    public int numSub(String s) {
        long count=0;
        boolean beforeOne = true;
        for (int i = 0; i < s.length(); i++) 
        {
            if(s.charAt(i)=='1')
            {
                if(beforeOne==true)
                {
                    count++;
                    beforeOne=false;
                }
                else if(i==s.length()-2)
                {
                    if(s.charAt(i)==s.charAt(i+1))
                    {
                        count+=2;
                    }
                    else
                    {
                        count++;
                    }
                }
                else if(i<s.length()-1 && beforeOne==false)
                {
                    count++;
                }
                else 
                continue;
            }
            else
            {
                count=(count+getCount(count))%1000000007;
                beforeOne=false;
            }
        }
        return (int)count;
    }

    public int divide(int dividend, int divisor) {
        int quotient=0;
        if(dividend>0)
        {
            while(dividend>1)
            {
                for(int i=1;i<=divisor;i++)
                {
                    dividend--;
                }
                quotient++;
            }
        }
        return quotient;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        // System.out.println(obj.longestPalindrome("babad"));
        // System.out.println(obj.numSub("0110111"));
        System.out.println(obj.divide(10, 3));
    }
}