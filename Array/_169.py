class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        t = set(nums)
        res , count = 0 ,0
        for i in t:
            if nums.count(i) > len(nums)//2:
                return i
        #     if nums.count(i) > count:
        #         count = nums.count(i)
        #         res = i
        # return res