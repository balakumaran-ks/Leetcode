class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        result = []
        i = 0
        while i < len(nums):
            first = nums[i]
            last = nums[i]
            while i < len(nums) - 1 and nums[i] == nums[i+1] - 1:
                i+= 1
                last = nums[i]

            if first == last:
                result.append(str(first))
            else:
                result.append(f'{first}->{last}')
            i+=1
        return result