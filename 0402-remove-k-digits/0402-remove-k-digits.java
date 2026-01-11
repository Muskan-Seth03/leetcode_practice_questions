// TC: O(n) SC: O(n)
class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for (char ch : num.toCharArray()) {

            // Remove larger digits from stack top
            while (!stack.isEmpty() && k > 0 && stack.peek() > ch) {
                stack.pop();
                k--;
            }

            // Avoid leading zeros
            if (!stack.isEmpty() || ch != '0') {
                stack.push(ch);
            }
        }

        // If k is still > 0, remove from end
        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }

        // If stack is empty, answer is "0"
        if (stack.isEmpty()) {
            return "0";
        }

        // Build result from stack
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }
}
