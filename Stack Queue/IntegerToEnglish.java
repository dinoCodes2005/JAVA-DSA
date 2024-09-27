import java.util.*;
class IntegerToEnglish {
    public String IntegerToWords(int num) {
        int temp=num;
        int arr[]=new int[10];
        int top=-1;
        int i=0;
        while(temp!=0)
        {
            arr[i]=temp%10;             //storing digits in array reverse order
            temp=temp/10;
            i++;
        }
        int n=arr.length;
        for(int j=0;j<n/2;j++)
        {
            int var=arr[j];
            arr[j]=arr[n-j-1];              //reversing the array
            arr[n-j-1]=temp;
        }

        
    }
}