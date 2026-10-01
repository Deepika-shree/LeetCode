class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char element: s.toCharArray()){
            if(element=='(' || element=='[' || element=='{'){
                stack.push(element);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                char top=stack.pop();
                if(element==')' && top=='('){
                }else if (element == ']' && top == '[') {
                }
                else if (element == '}' && top == '{') {
                }
                else {
                    return false;
                }
                    }
                }
    return stack.isEmpty();
    }
}