class Solution {
    public long maxAlternatingSum(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return 0;

        // Find the maximum value in nums to define the range of our Segment Tree
        int maxV = 0;
        for (int x : nums) maxV = Math.max(maxV, x);

        // Segment trees to store max DP values for specific number values
        // tu: stores max up[j] for a given nums[j]
        // td: stores max dn[j] for a given nums[j]
        SegTree tu = new SegTree(maxV);
        SegTree td = new SegTree(maxV);

        long[] up = new long[n];
        long[] dn = new long[n];
        long ans = 0;

        for (int i = 0; i < n; i++) {
            // A subsequence of length 1 is always valid
            up[i] = dn[i] = nums[i];

            // Sliding Window / Distance constraint: 
            // Only add indices that are at least k distance away into the Segment Tree
            int j = i - k;
            if (j >= 0) {
                tu.update(nums[j], up[j]);
                td.update(nums[j], dn[j]);
            }

            // Query the trees for the best previous step
            // For up[i], we need a previous 'down' step where nums[j] < nums[i]
            long bestPrevDown = td.query(1, nums[i] - 1);
            if (bestPrevDown > 0) {
                up[i] = Math.max(up[i], nums[i] + bestPrevDown);
            }

            // For dn[i], we need a previous 'up' step where nums[j] > nums[i]
            long bestPrevUp = tu.query(nums[i] + 1, maxV);
            if (bestPrevUp > 0) {
                dn[i] = Math.max(dn[i], nums[i] + bestPrevUp);
            }

            ans = Math.max(ans, Math.max(up[i], dn[i]));
        }

        return ans;
    }

    // Standard Point Update, Range Maximum Query Segment Tree
    static class SegTree {
        int n;
        long[] tree;

        SegTree(int n) {
            this.n = n;
            this.tree = new long[4 * n + 1];
        }

        void update(int val, long score) {
            update(1, 1, n, val, score);
        }

        private void update(int node, int start, int end, int idx, long score) {
            if (start == end) {
                tree[node] = Math.max(tree[node], score);
                return;
            }
            int mid = (start + end) / 2;
            if (idx <= mid) update(2 * node, start, mid, idx, score);
            else update(2 * node + 1, mid + 1, end, idx, score);
            tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
        }

        long query(int l, int r) {
            if (l > r) return 0;
            return query(1, 1, n, l, r);
        }

        private long query(int node, int start, int end, int l, int r) {
            if (r < start || end < l) return 0;
            if (l <= start && end <= r) return tree[node];
            int mid = (start + end) / 2;
            return Math.max(query(2 * node, start, mid, l, r), 
                            query(2 * node + 1, mid + 1, end, l, r));
        }
    }
}