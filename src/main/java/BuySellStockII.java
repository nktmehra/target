public class BuySellStockII {

    public static void main(String[] args) {
        System.out.println(buySellStockII(new int[]{7,2,8,1,9}));
    }

    static int buySellStockII(int[] a){
        int max = 0;
        int profit = 0;
        for(int i = 0;i<a.length-1;i++){
            if(a[i+1]>a[i]){
                profit = a[i+1] - a[i] + profit;
            }
            max = Math.max(max,profit);
        }
        return max;
    }
}
