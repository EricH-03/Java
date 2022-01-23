public class Diff21 {
   /* This is just practice to get used to Java Syntax
   
Given an int n, return the absolute difference between n and 21, except return double the absolute difference if n is over 21.
    
    */
    
    public static void main(String[] args) {
      
        int expected = 2;
        System.out.println("expected: " +expected +", actual: " +diff21(19));
        
       expected = 11;
       System.out.println("expected: " +expected +", actual: " +diff21(10));
            
       expected = 58;
       System.out.println("expected: " +expected +", actual: " +diff21(50));
            
       expected = 18;
       System.out.println("expected: " +expected +", actual: " +diff21(30));
          }
    
  public static int diff21(int n) {
    int diff = 21-n;
      
      if(diff<0){
        diff = -2*diff;
      }
    
    return diff;
  }   
}
