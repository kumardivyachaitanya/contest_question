import java.util.Stack;

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        boolean[] vis = new boolean[26];
        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']--;
            if (vis[ch - 'a']) {
                continue;
            }

            while (!stk.isEmpty() && stk.peek() > ch && freq[stk.peek() - 'a'] > 0) {
                char rem = stk.pop();
                vis[rem - 'a'] = false;
            }

            stk.push(ch);
            vis[ch - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }

        return sb.reverse().toString();
    }
}
