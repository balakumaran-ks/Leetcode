class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        ans = 0
        mx = 52
        for i in range(len(nums)):
            if nums[i]==val:
                nums[i]=mx
                ans+=1
        nums.sort()
        return len(nums)-ans