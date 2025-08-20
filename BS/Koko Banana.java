public  Koko Banana {
  public static void main(String [] args) {

  }

  public int minEatingSpeed(int [] piles, int h) {
    int start = 1;
    int end = Integer.MIN_VALUE; // for finding largest value in array


    // finding the largest value in the array (finding max)
    for(int i =0; i<piles.length; i++){
      if(piles[i]>end) {
        end = piles[i];
      }
    }
  int ans = -1;
  // apply binary search pm the possible value of K => (1,max(piles))
  while(start <= end) {
    int mid = start + (end-start) /2;
    if(isEatingSpeedValid(piles,mid,h)){
      and = mid;
      end= mid-1;
    }
    else{
      start = mid+1;
    }
  }
  return ans;
  }
 boolean isEatingSpeedvalid(int piles[], int eatingSpeed, int hours){
  int hoursSpend = 0;
  for(int i =0; i<piles.length; i++){
    hoursSpend += piles[i] / eatingSpeed;
    if(piles[i] % eatingSpeed !=0){
      hoursSpend+=1;
    }
    if(hoursSpend > hours){
      return true;
    }
  }
 }



}
