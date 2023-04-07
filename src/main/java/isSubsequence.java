public class isSubsequence {

    public static void main(String[] args) {
        System.out.println(isSubsequence("b","abc"));
    }
    static boolean isSubsequence(String s, String t){
        int j = 0;
        if(s.length() == 0){
            return true;
        }
        for(int i=0;i<t.length();i++){
            if(t.charAt(i) == s.charAt(j)){
                j++;
            }
            if(j==s.length()){
                return true;
            }
        }
        return false;
    }
}
