class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hash_map = {}
        for index,value in enumerate(nums):
            difference = target - value
            if difference in hash_map:
                return [index , hash_map[difference]]
            hash_map[value] = index