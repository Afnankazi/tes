import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Stack<T> {
    private ArrayList<T> stackList = new ArrayList<>();  
    
    public ArrayList<T> getStackList() {
        return stackList;
    }
    
    public void printStack() {
        for (int i = stackList.size()-1; i >= 0; i--) {
            System.out.println(stackList.get(i));
        }
    }
    
    public boolean isEmpty() {
        return stackList.size() == 0;
    }
    
    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return stackList.get(stackList.size() - 1);
        }
        
    }
    
  
    public void push(T value) {
        stackList.add(value);
    }
    
    public T pop() {
        if (isEmpty()) return null;
        return stackList.remove(stackList.size() - 1);
    }
    
    
    public int size() {
        return stackList.size();
    }
    public static String reversedString(String a ){
        Stack myStack = new Stack();
       for (int i = 0; i <a.length(); i++) {
        myStack.push(a.charAt(i));
       }
        String r ="";
        while (!myStack.isEmpty()) {
            r+= myStack.pop();
        
       }
       return r;
        
    }
    public static boolean isBalancedParentheses(String s){
        Stack m  = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                m.push(s.charAt(i));
            }else{
                if(m.size()!=0){
                    m.pop();
                }
            }
        }
        if(m.size()==0)return true;
     return false;

        
    }
    

    public static boolean isValid(String s) {
        Stack a = new Stack();
        HashMap<Character,Character> m = new HashMap<>();
        m.put(')','(');
        m.put('}','{');
        m.put(']','[');
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                a.push(s.charAt(i));
            }else{
                if(a.size()!=0 && a.peek()==m.get(s.charAt(i))){
                    a.pop();
                }else{
                    return false;
                }
            }
        }
        if(a.size() == 0)return true;
        return false;
    }
     public static void main(String[] args) {
        int x  =5;
        int y = 4;
        String s = "1cdbcbbaaabab";
        if(s.charAt(0)-'0'>'a'-'0' && s.charAt(0)-'0'<'z'-'0' ){
            System.out.println("true");
        }
        System.out.println(s.charAt(0)-'0');
        String[] v = s.split("");
        int val = 0;
        for(int i = 0;i<v.length-1;i++){
            String f = v[i];
            String n = v[i+1];
            
            if(f.equals("a") && n.equals("b") ){
                val+=x;
            }
            else if(f.equals("b")&&n.equals("a")){
                val+=y;
            }
        }    
        int[] nums  ={6,6,1,2,4,5};
        Arrays.sort(nums);

        // Calculate the differences considering up to three changes
        int option1 = nums[nums.length - 1] - nums[3];  // Remove the first three smallest elements
        int option2 = nums[nums.length - 2] - nums[2];  // Remove two smallest and one largest elements
        int option3 = nums[nums.length - 3] - nums[1];  // Remove one smallest and two largest elements
        int option4 = nums[nums.length - 4] - nums[0];  // Remove the first three largest elements

        int result = Math.min(Math.min(option1, option2), Math.min(option3, option4));

     


        String[] a = {"please wait", "continue to fight", "continue to win"};
     
    }
}
    // WRITE PUSH METHOD HERE //
    //                        //
    //                        //
    //                        //
    ////////////////////////////
    
