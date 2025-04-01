class Solution:
    def mostPoints(self, questions: List[List[int]]) -> int:
        n = len(questions)

        dp = [0] * n
        dp[n-1] = questions[n-1][0]

        for i in range(n-2,-1,-1):
            points,brainpower = questions[i]

            next_available_index = min(i + brainpower + 1 , n)
            solve_points = points + (dp[next_available_index] if next_available_index < n else 0)

            skip_points = dp[i+1]

            dp[i] = max(solve_points , skip_points)

        return dp[0]