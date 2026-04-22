class Solution:
    def twoEditWords(self, queries: List[str], dictionary: List[str]) -> List[str]:
        res = []
        for q in queries:
            for d in dictionary:
                # Count mismatches at the same position
                diffs = 0
                for i in range(len(q)):
                    if q[i] != d[i]:
                        diffs += 1
                
                if diffs <= 2:
                    res.append(q)
                    break # Found a match, move to next query
        return res