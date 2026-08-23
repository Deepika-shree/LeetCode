class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        //Store all existing numbers for quick lookup
        HashSet<Integer> set= new HashSet<>();
        for(int ele: nums) set.add(ele);

        // Find all missing integers in the given range
        List<Integer> missingInt = new ArrayList<>();
        for(int j=lower;j<=upper;j++){
            if(!set.contains(j)) missingInt.add(j);
        }

        // Group consecutive missing integers into ranges
        int i=0;
        while(i<missingInt.size()){
            int start =missingInt.get(i);
            int end =start;

            while(i+1 < missingInt.size() && missingInt.get(i+1) == end+1){
                i++;
                end =missingInt.get(i);
            }
            
            List<Integer> group = new ArrayList<>();
            group.add(start);
            group.add(end);

            ans.add(group);
            i++;
            
        }
        return ans;
    }
}