class Solution:
    def nthUglyNumber(self, n: int) -> int:
        ugly = [1,2,3,4,5]
        if n==1:
            return 1
        elif n<=5:
            return ugly[n-1]
        else:
            st2 = [6,8,10]
            st3 = [6,9,12]
            st5 = [10,15,20]
            while len(ugly)!=n:
                last_ugly = ugly[-1]
                if 2*last_ugly not in st2:
                    st2.append(2*last_ugly)
                if 3*last_ugly not in st3:
                    st3.append(3*last_ugly)
                if 5*last_ugly not in st5:
                    st5.append(5*last_ugly)
                if st2[0]<=st3[0] and st2[0]<=st5[0]:
                    if st2[0] not in ugly:
                        ugly.append(st2[0])
                    if st2[0]==st3[0]:
                        if st2[0]==st5[0]:
                            st5.pop(0)
                        st3.pop(0)
                    st2.pop(0)
                elif st3[0]<=st2[0] and st3[0]<=st5[0]:
                    if st3[0] not in ugly:
                        ugly.append(st3[0])
                    if st2[0]==st3[0]:
                        if st3[0]==st5[0]:
                            st5.pop(0)
                        st2.pop(0)
                    st3.pop(0)
                else:
                    if st5[0] not in ugly:
                        ugly.append(st5[0])
                    if st5[0]==st2[0]:
                        if st5[0]==st3[0]:
                            st3.pop(0)
                        st2.pop(0)
                    st5.pop(0)
            return ugly[n-1]


            
