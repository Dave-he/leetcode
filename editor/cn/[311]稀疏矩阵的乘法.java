//给你两个 稀疏矩阵 A 和 B，请你返回 AB 的结果。你可以默认 A 的列数等于 B 的行数。 
//
// 请仔细阅读下面的示例。 
//
// 
//
// 示例： 
//
// 输入：
//
//A = [
//  [ 1, 0, 0],
//  [-1, 0, 3]
//]
//
//B = [
//  [ 7, 0, 0 ],
//  [ 0, 0, 0 ],
//  [ 0, 0, 1 ]
//]
//
//输出：
//
//     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
//AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
//                  | 0 0 1 |
// 
// Related Topics 数组 哈希表 矩阵 👍 57 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int[][] multiply(int[][] A, int[][] B) {
        if (A.length == 0 || B.length == 0) {
            return new int[0][0];
        }
        int[][] res = new int[A.length][B[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = calculate(A, B, i, j);
            }
        }
        return res;
    }

    private int calculate(int[][] A ,int[][] B, int row, int col) {
        int sum = 0;
        for (int j = 0; j < A[row].length; j++) {
            sum = sum + A[row][j] * B[j][col];
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
