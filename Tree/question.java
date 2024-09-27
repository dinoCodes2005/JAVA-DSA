import java.util.*;

public class question {
    public long getCount(int n)
    {
        return (long)((n*(n+1))/2);
    }
    public long countHomogenous(String s) {
        ArrayList<String> wordLen= new ArrayList<>();
        
        for(int i=0;i<s.length();i++)
        {
                for(int j=i;j<s.length();j++)
                {
                    if(s.charAt(i)!=s.charAt(j))
                    {
                        wordLen.add(s.substring(i,j));
                        i=j-1;
                        break;
                    }

                    if(j==s.length()-1)
                    {
                        wordLen.add(s.substring(i,j+1));
                        i=j;
                    }
                }
        }

        long sum=0;
        long sumEach =0;
        for(int i=0;i<wordLen.size();i++)
        {
            sumEach=getCount(wordLen.get(i).length());
            sum+=sumEach;
        }

        long result=(long)(Math.pow(10,9)+7);
        return sum;

    }
    public static void main(String[] args) {
        question obj = new question();
    }
}

