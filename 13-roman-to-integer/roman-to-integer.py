class Solution:
    def romanToInt(self, s: str) -> int:
        res=0
        val = {'I' : 1 , 'V' : 5 , 'X' : 10 , 'L' : 50 , 'C' : 100 , 'D' : 500 , 'M' : 1000}
        i=0
        while i < len(s):
            if i == len(s)-1:
                res+=val[s[i]]
            elif s[i]=='I':
                if s[i+1]=='V': 
                    res+=4
                    i+=1
                elif s[i+1]=='X':
                    res+=9
                    i+=1
                else: res+=val[s[i]]
                
            elif s[i]=='X':
                if s[i+1]=='L': 
                    res+=40
                    i+=1
                elif s[i+1]=='C': 
                    res+=90
                    i+=1
                else: res+=val[s[i]]

            elif s[i]=='C':
                if s[i+1]=='D': 
                    res+=400
                    i+=1
                elif s[i+1]=='M':
                    res+=900
                    i+=1
                else: res+=val[s[i]]
            else:
                res+=val[s[i]]

            i+=1
        return res