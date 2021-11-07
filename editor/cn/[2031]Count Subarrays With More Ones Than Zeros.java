//null Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 0 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    class SegTree {
        int N;
        int[] arr;

        SegTree(int n) {
            N = n;
            arr = new int[2 * N + 2];
        }

        void add(int i) {
            i += (N + 1);
            while (i <= 2 * N + 1) {
                arr[i]++;
                i += (i & -i);
            }
        }

        int get(int i) {
            i += (N + 1);
            int ans = 0;
            while (i > 0) {
                ans += arr[i];
                i &= (i - 1);
            }
            return ans;
        }
    }

    public int subarraysWithMoreZerosThanOnes(int[] nums) {
        int n = nums.length;
        long ans = 0;
        int[] count = {0, 0};
        SegTree tree = new SegTree(n);
        tree.add(0);
        for (int item : nums) {
            count[item]++;
            ans += tree.get(count[1] - count[0] - 1);
            tree.add(count[1] - count[0]);
        }
        return (int) (ans % 1000000007);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
