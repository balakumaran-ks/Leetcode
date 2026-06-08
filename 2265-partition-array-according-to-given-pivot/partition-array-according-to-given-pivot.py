class Solution:
    def pivotArray(self, nums: List[int], pivot: int) -> List[int]:
        small = []
        large = []
        for num in nums:
            if num<pivot:
                small.append(num)
            elif num>pivot:
                large.append(num)
        return small+[pivot]*(len(nums)-(len(small)+len(large)))+large