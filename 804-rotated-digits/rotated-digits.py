class Solution:
    def rotatedDigits(self, n: int) -> int:
        res = 0
        for i in range(1, n + 1):
            s = str(i)
            # 1. Must NOT contain 3, 4, or 7
            if any(d in s for d in '347'):
                continue
            # 2. MUST contain at least one of 2, 5, 6, or 9 to change value
            if any(d in s for d in '2569'):
                res += 1
        return res