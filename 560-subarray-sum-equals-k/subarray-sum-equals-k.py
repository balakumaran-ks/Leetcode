class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        subnum = {0:1}

        total=count=0
        for num in nums:
            total+=num
            if total-k in subnum:
                count+=subnum[total-k]
            subnum[total] = 1+subnum.get(total,0)
        return count