public class RomanToInteger
{
    public static void main(String[] args) 
    {
        RomanToInteger obj = new RomanToInteger();
        int output =obj.romanToInt("MCMXIV");
        System.out.println(output);
    }
        public int value(char s)
        {
            if(s=='I')
            return 1;
            if(s=='V')
            return 5;
            if(s=='X')
            return 10;
            if(s=='L')
            return 50;
            if(s=='C')
            return 100;
            if(s=='D')
            return 500;
            if(s=='M')
            return 1000;
            return 0;
        }

        public int romanToInt(String s) {
           int sum=0;

        for(int i=0;i<s.length();i++)
        {
            int s1=value(s.charAt(i));      //stores the first value in the loop 

            if(i+1<s.length())
            {
                int s2=value(s.charAt(i+1));        //stores the next value to the first value in the loop
                if(s1>=s2)                  // in case of VI = 5+1 = 6
                sum+=s1;
                else
                sum-=s1;                    // in case of IV = 5-1 = 4
            }
            else
            sum+=s1;                        // adding the last element left since loop is running wrt i+1
    
    
        }
        return sum;
        }
}