class Solution:
    def bitwiseComplement(self, n: int) -> int:
        if n<=0:
            return 1
        b = len(bin(n)[2:])-bin(n)[2:].index('1')
        return int(math.pow(2,b))-1-n if int(math.pow(2,b))-1-n>=0 else 0