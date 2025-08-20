// public class SpliteArray LargeSum {
  
// }





class Solution {
    // check if its possible to divide array into less than or equal to k
    // if its possible then return true
    public boolean check(int[] nums,int mid,int k) {
        int cnt = 1; // assign sum = mid so cnt = 1
        int sum = mid;
        for(int i: nums) {
            if(sum < i) {
                // sum is less than k 
                // so we need to start another subarray from i element
                sum = mid;
                cnt++;
            }
            sum -= i;
            if(sum < 0) {
                // that means i > mid so no way to divide array into subarray 
                // such that sum of subarray is less than or equal to mid
                return false;
            }
        }
        return cnt <= k;
    }

    // for example 2
    // array = {1,2,3,4,5}
    // total sum is 15 
    // so we can try to find if its possible to 
    // divide array into less than or equal to 2 subarray
    // for sum 1, 2, 3, 4, 5, 6, 7, .. 15
    // mid  =     1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
    // possible = F F F F F F F F T  T  T  T  T  T  T
    // so we need to smallest sum that give true 
    // if we try for all sum 
    // look at constraints 
    // nums[i] is at max 10^6
    // so total sum at worst case is 10^6*1000;
    // total sum is 10^9 
    // so time complexity for brute force is O(total sum * length of array)
    // for worst case it give tle
    

    // we can solve this question using binary search 
    // we can take low to 1 and high to total sum
    // if check function return true that means it is possible 
    // answer so we save that one
    // and try to search in left side
    // otherwise try to find in right side
    public int splitArray(int[] nums, int k) {
        int sum = 0;
        for(int i: nums) {
            sum += i;
        }
        int low = 1,high = sum; // answer always in the range of 0 to sum
        int ans = 0;
        while(low <= high) {
            // binary search 
            int mid = (low+high)/2;
            if(check(nums,mid,k)) {
                // check function return 
                // if its possible to divide array into less than or equal to k subarry 
                // such that sum of every subarray is less than or equal to mid
                // in example 2
                // low = 1 , high = 15
                // so mid = 8
                // so its not possible to divide nums into 2 or less subarray such
                // that sum of every subarray is less than or equal to 8
                // so we assign low = mid +1 ( low = 9)
                // now low = 9,high = 15, mid = 12
                //  so check function give true
                // so 12 is possible answer than we not go on right side because 
                // if we go write side every mid give true
                // but we need to find smallest
                // so we go left side

                ans = mid; // possible answer
                high = mid-1; // find in left range that is low to mid-1
            }
            else {
                low = mid+1;
                // not possible case so try into right side that is mid+1 to high
            }
        }
        return ans;
    }
}

