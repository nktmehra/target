public class BuySellStock {

    public static void main(String[] args) {
        System.out.println(buySellStock(new int[]{7,2,4,1}));
    }

    static int buySellStock(int[] a){
        int max = Integer.MIN_VALUE;
        int profit = 0;
        int min = a[0];

        for(int i =0;i<a.length;i++){
            min = Math.min(a[i],min);
            profit = a[i] - min;
            max = Math.max(profit,max);
        }
        return max;
    }
}
