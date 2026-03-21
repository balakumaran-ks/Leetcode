class Solution:
    def myAtoi(self, s: str) -> int:
        digits = ' 1234567890-+'
        ans = 0
        isread = False
        isNeg = 1
        for c in s:
            if (ans*isNeg)<(-2**31) or ans>(2**31)-1:
                return 2**31-1 if isNeg==1 else -2**31
            if c==' ':
                if isread==False:
                    continue
                else:
                    return ans*isNeg
            if c not in digits:
                return ans*isNeg
            else:
                if c=='+' or c=='-':
                    if isread==True:
                        return ans*isNeg
                    else:
                        isread=True
                        if c=='-':
                            isNeg = -1
                else:
                    ans = ans*10 + int(c)
                    isread = True
        
        ans = ans*isNeg
        if ans<-2**31 or ans>2**31-1:
            if ans<0:
                ans = -2**31
            else:
                ans = 2**31-1
        return ans
            
