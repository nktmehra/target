public class Chargebees {

    public static void main(String[] args) {
        chargeBees();
    }

    static void chargeBees() {
        String s = "aaannkiiitttt";
        int count = 1;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                count++;
            } else if (s.charAt(i) != s.charAt(i + 1) && count == 1) {
                System.out.println(s.charAt(i) + " " + count);
            } else {
                if (s.charAt(i) != s.charAt(i + 1) && count >= 2) {
                    System.out.println(s.charAt(i) + " " + count);
                    count = 1;
                }
            }
        }
    }
}
