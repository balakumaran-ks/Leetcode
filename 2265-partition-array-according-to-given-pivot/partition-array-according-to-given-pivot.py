class Solution:
    def pivotArray(self, nums: List[int], pivot: int) -> List[int]:
        small = []
        p = []
        large = []
        for num in nums:
            if num<pivot:
                small.append(num)
            elif num==pivot:
                p.append(num)
            else:
                large.append(num)
        return small+p+large