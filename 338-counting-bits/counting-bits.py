class Solution:
    def countBits(self, n: int) -> List[int]:
        # ans=[]

        # for i in range(n+1):
        #     ans.append(str(bin(i)).count('1'))
        # return ans
        dp = [0]*(n+1)
        sub = 1
        for i in range(1,n+1):
            if sub*2==i:
                sub=i
            dp[i] = dp[i-sub] + 1
        return dp