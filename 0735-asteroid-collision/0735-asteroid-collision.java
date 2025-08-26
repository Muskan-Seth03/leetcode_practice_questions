//using stack    TC:O(n)    SC:O(n)
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            boolean destroyed = false;

            if (asteroid > 0) {
                // Positive asteroids → just push
                stack.push(asteroid);
            } else {
                // asteroid < 0 → check for collisions
                while (!stack.isEmpty() && stack.peek() > 0) {
                    if (stack.peek() < -asteroid) {
                        stack.pop(); // Top smaller → destroyed
                        continue;    // Keep checking
                    } else if (stack.peek() == -asteroid) {
                        stack.pop(); // Both destroyed
                    }
                    destroyed = true; // Incoming asteroid destroyed
                    break;
                }

                if (!destroyed) {
                    stack.push(asteroid); // Survives
                }
            }
        }

        // Convert stack to result array
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
