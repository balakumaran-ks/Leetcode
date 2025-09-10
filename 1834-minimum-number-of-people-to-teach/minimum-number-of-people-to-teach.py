class Solution:
    def minimumTeachings(self, n: int, languages: List[List[int]], friendships: List[List[int]]) -> int:
        need = set()
        for u, v in friendships:
            u, v = u - 1, v - 1
            if not (set(languages[u]) & set(languages[v])):
                need.add(u)
                need.add(v)
        
        ans = len(languages) + 1
        for lang in range(1, n + 1):
            cans = sum(1 for person in need if lang not in languages[person])
            ans = min(ans, cans)
        
        return ans