// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution {
  public String removeKdigits(String num, int k) {
    if (num.length() == k) return "0";
    Stack<Character> stack = new Stack<>();
    for(char c: num.toCharArray()) {
      while(!stack.isEmpty() && k>0 && stack.peek().compareTo(c) > 0) {
        stack.pop();
        k--;
      }
      stack.push(c);
    }
    while(!stack.isEmpty() && k>0) {
      stack.pop();
      k--;
    }
    StringBuilder result = new StringBuilder();
    while(!stack.isEmpty()) {
      result.append(stack.pop());
    }
    result.reverse();
    int i = 0;
    while(i<result.length() && result.charAt(i) == '0') {
      i++;
    }
    result = new StringBuilder(result.substring(i));
    return (result.length() == 0) ? "0" : result.toString();
  }
}