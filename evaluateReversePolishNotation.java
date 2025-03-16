// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution {
  public int evalRPN(String[] tokens) {
    // Edge cases
    if(tokens == null || tokens.length == 0) return 0;
    Stack<Integer> stack = new Stack<>();
    for(String token: tokens) {
      if(token.equals("+")) {
        stack.push(stack.pop() + stack.pop());
      } else if(token.equals("*")) {
        stack.push(stack.pop() * stack.pop());
      } else if(token.equals("-")) {
        int first = stack.pop();
        int second = stack.pop();
        stack.push(second - first);
      } else if(token.equals("/")) {
        int first = stack.pop();
        int second = stack.pop();
        stack.push(second / first);
      } else {
        int answer = Integer.valueOf(token);
        stack.push(answer);
      }
    }
    return stack.pop();
  }
}