class Solution {
    public int minimumRightShifts(List<Integer> nums) {
        int n=nums.size();
        int pivotid=0;
        int count=0;
        for(int i=1;i<n;i++){
            if(nums.get(i-1)>nums.get(i)){
                pivotid=i;
                count++;
            }
        }
        if(count>1){
            return -1;
        }
        if(count==0){
            return 0;
        }
        if(nums.get(n-1)>nums.get(0)){
            return -1;
        }
        return n-pivotid;
    }
}
