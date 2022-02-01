package p4_queue_stack;

import java.util.*;

public class p1t20ValidParentheses {
    public static void main(String[] args) {
        String s="(()[}{})";
        System.out.println(isValid(s));

    }
    public static boolean isValid(String s) {
        HashMap<Character,Character> pairMap=new HashMap<>(){{
            put(')','(');
            put(']','[');
            put('}','{');
        }};
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            //если открывающаяся
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
                stack.push(s.charAt(i));
            }
            //если закрывающаяся
            else if(s.charAt(i)==')'||s.charAt(i)==']'||s.charAt(i)=='}'){
               if(stack.empty()) return false;
               Character element=stack.pop();//открывающаяся тут
               if(element!=pairMap.get(s.charAt(i))) return false;
            }
        }
        if(stack.empty()) return true;
        else return false;

    }
}
