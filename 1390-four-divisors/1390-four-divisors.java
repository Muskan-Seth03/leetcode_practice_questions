// TC: O(n * sqrt(n))  SC: O(1)
class Solution {
    public int count4DivisorSum(int num)
    {
        int sum=0;
        int count=0;
        for(int i=1; i<= Math.floor(Math.sqrt(num)); i++)
        {
            if(num % i == 0)
            {
                count++;
                sum += i;
            
                if(i != (num/i))
                {
                    sum += (num/i);
                    count++;
                }
            }
            if(count > 4) 
            break;
        }
        return (count == 4)? sum : 0;
    }

    public int sumFourDivisors(int[] nums) {
        int n= nums.length;
        int totalSum=0;
        for(int num: nums)
        {
            totalSum += count4DivisorSum(num);
        }
        return totalSum;        
    }
}