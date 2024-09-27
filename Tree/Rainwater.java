import java.util.*;
public class Rainwater {
    int max(int startIndex,int endIndex,int height[])
    {
        int maxValue = Integer.MIN_VALUE;
        for(int i=startIndex;i<endIndex;i++)
        {
            if(height[i]>maxValue)
            maxValue = height[i];
        }
        return maxValue;

    }

    int min(int startIndex,int endIndex,int height[])
    {
        int minValue = Integer.MAX_VALUE;
        for(int i=startIndex;i<endIndex;i++)
        {
            if(height[i]<minValue)
            minValue = height[i];
        }
        return minValue;
    }

    public int maxArea(int[] height) {
        ArrayList<Integer> LeftArea = new ArrayList<>();
        ArrayList<Integer> RightArea = new ArrayList<>();


        int maxLength = max(0,height.length,height);

        String heightInString = "";
        for (int i = 0; i < height.length; i++) {
            heightInString+=Integer.toString(height[i]);
        }

        System.out.println(heightInString
        );
        //left side area
        int indexOfmaxLen = heightInString.indexOf(maxLength);
        for(int i=0;i<indexOfmaxLen;i++)
        {
            LeftArea.add((indexOfmaxLen-i)*(Math.min(height[i],height[indexOfmaxLen])));
        }

        //right side area
        for(int i=indexOfmaxLen+1;i<height.length;i++)
        {
            RightArea.add((i-indexOfmaxLen)*(Math.min(height[i],height[indexOfmaxLen])));
        }

        int maxVolume = Integer.MIN_VALUE;


        for(int i=0;i<LeftArea.size();i++)
        {
            if(LeftArea.get(i)>maxVolume)
            maxVolume=LeftArea.get(i);
        }

        for (int i = 0; i <RightArea.size(); i++)
        {
            if(RightArea.get(i)>maxVolume)
            maxVolume=RightArea.get(i);
        }
        return maxVolume;

    }

    public static void main(String[] args) {
        Rainwater obj = new Rainwater();
        int height[] = {1,8,6,2,5,4,8,3,7};
        System.out.println(obj.maxArea(height));
    }
}
