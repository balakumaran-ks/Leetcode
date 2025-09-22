class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        strs.sort()
        ans=""
        for i in range(len(strs[0])):
            if strs[0][i]==strs[len(strs)-1][i]:
                ans+=strs[0][i]
            else:
                return ans
        return ans