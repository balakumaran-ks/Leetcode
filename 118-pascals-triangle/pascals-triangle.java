class Solution {
    List<List<Integer>> mem;
    Solution(){
        mem = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                // If it's the first or last element of the row, it's always 1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // Standard DP: current = (prevRow, j-1) + (prevRow, j)
                    int left = mem.get(i - 1).get(j - 1);
                    int right = mem.get(i - 1).get(j);
                    row.add(left + right);
                }
            }
            mem.add(row);
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i = 0; i < numRows; i++) {
            if(i<this.mem.size()){
                res.add(mem.get(i));
            }else{
                List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                // If it's the first or last element of the row, it's always 1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // Standard DP: current = (prevRow, j-1) + (prevRow, j)
                    int left = res.get(i - 1).get(j - 1);
                    int right = res.get(i - 1).get(j);
                    row.add(left + right);
                }
            }
            res.add(row);
            }
        }
        return res;
    }
}