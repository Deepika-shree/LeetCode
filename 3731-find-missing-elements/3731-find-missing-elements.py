#test
class Solution:
    def findMissingElements(self, nums: List[int]) -> List[int]:
        # Handle empty input case safely
        if not nums:
            return []
            
        # The smallest and largest elements define the full range boundaries
        min_val = min(nums)
        max_val = max(nums)
        
        # Convert to a set for O(1) membership lookups
        num_set = set(nums)
        
        # Collect all numbers within the range that are missing from the set
        missing = [x for x in range(min_val, max_val + 1) if x not in num_set]
        
        return missing
