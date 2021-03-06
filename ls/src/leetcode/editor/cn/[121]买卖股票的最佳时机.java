//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。 
//
// 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。 
//
// 注意：你不能在买入股票前卖出股票。 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
// 
//
// 示例 2: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
// Related Topics 数组 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //笨方法
        int cur;
        int tmpMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                cur = prices[j] - prices[i];
                tmpMax = cur > tmpMax ? cur : tmpMax;
            }
        }
        return tmpMax < 0 ? 0 : tmpMax;
    }

     */

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0 || n == 1){
            return 0;
        }
        //记录i以前(包含i)的最小值
        int[] stage = new int[n];
        int tmpMax = Integer.MIN_VALUE;
        int diff;
        stage[0] = prices[0];
        for (int i = 1; i < n; i++){
            stage[i] = Math.min(stage[i-1],prices[i]);
            diff = prices[i] - stage[i];
            tmpMax = diff > tmpMax ? diff : tmpMax;
        }
        return tmpMax;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
