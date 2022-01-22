public class SleepIn{
    /* This is just practice to get used to Java Syntax and Boolean methods since they don't exist in C
    
    The parameter weekday is true if it is a weekday, and the parameter vacation is true if we are on vacation. 
    We sleep in if it is not a weekday or we're on vacation. Return true if we sleep in.
    
    */
    
        public static void main(String[] args) {
      sleepIn(false, false);
      System.out.println("expected true: " +sleepIn(false, false));
      
      sleepIn(true, false);
      System.out.println("expected false: " +sleepIn(true, false));
      
      sleepIn(false, true);
      System.out.println("expected true: " +sleepIn(false, true));
    
        }

      public static boolean sleepIn(boolean weekday, boolean vacation) {
      if(vacation){return true;}
      if(weekday == false){
        return true;}
        return false;
      }
    
      }
