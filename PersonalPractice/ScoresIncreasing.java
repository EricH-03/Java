public class ScoresIncreasing {
  
    /* 
    Given an array of scores, return true if each score is equal or greater than the one before

    No Test Cases, but it has been tested and works 
    */

    public static void main(String[] args) { 
    }

    public boolean scoresIncreasing(int[] scores) {
        int last = scores[0];
          for(int i = 1; i<scores.length; i++){
            if(last>scores[i]){
              return false;
            }
            last = scores[i];
          }
          return true;
        }
        
    
}
