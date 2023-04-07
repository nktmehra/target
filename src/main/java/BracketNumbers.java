import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BracketNumbers {

    public static void main(String[] args) {
        System.out.println(bracketNumbers("(())("));
    }

    static List<Integer> bracketNumbers(String s){
        int count = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='('){
                count++;
                stack.push(count);
                list.add(count);
            }else{
                list.add(stack.pop());
            }
        }
        return list;
    }
}
