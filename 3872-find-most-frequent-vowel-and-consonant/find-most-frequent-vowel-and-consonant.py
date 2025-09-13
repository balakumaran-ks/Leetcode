class Solution(object):
    def maxFreqSum(self, s):
        """
        :type s: str
        :rtype: int
        """
        h={} 
        for i in s: 
            if i in h: 
                h[i]+=1 
            else:
                h[i]=1
        cm=0 
        vm=0
        v=("aeiou")
        for i in h: 
            if i in v: 
                vm=max(vm,h[i]) 
            else:
                cm=max(cm,h[i])
        return vm+cm
        