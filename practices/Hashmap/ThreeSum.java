package practices.Hashmap;

public List<List<Integer>>threeSum(int[]nums){int n=nums.length;List<List<Integer>>ans=new ArrayList<>();Set<List<Integer>>s=new HashSet<>();

for(int i=0;i<n;i++){for(int j=i+1;j<n;j++){for(int k=j+1;k<n;k++){if(nums[i]+nums[j]+nums[k]==0){List<Integer>trip=Arrays.asList(nums[i],nums[j],nums[k]);Collections.sort(trip); // sort
                                                                                                                                                                                   // triplet

if(!s.contains(trip)){s.add(trip);ans.add(trip);}}}}}return ans;}

// ✅ Main method for VS Code testing
public static void main(String[]args){ThreeSum sol=new ThreeSum();int[]nums={-1,0,1,2,-1,-4};

List<List<Integer>>res=sol.threeSum(nums);System.out.println(res);
// Expected: [[-1, -1, 2], [-1, 0, 1]]
}}import