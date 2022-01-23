public class CountEvens{
    /*
    
Return the number of even ints in the given array.
No Test Cases, but it has been tested and works */
    public static void main(String[] args) {
      
      
          }

          public int countEvens(int[] nums) {
            int count = 0;
            
            for(int i = 0; i<nums.length; i++){
              if(nums[i]%2 == 0){
                count++;
              }
            }
            return count;
          }
           
}