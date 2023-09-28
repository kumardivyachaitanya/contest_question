class Solution {
    public String smallestSubsequence(String s) {
        int[] freq=new int[26];
        boolean vis[]=new boolean[26];
        Stack<Character>stk=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        for(char ch:s.toCharArray()){
            freq[ch-'a']--;
            if(vis[ch-'a']){
                continue;
            }
            while(!stk.isEmpty()&&stk.peek()>ch&&freq[stk.peek()-'a']>0){
                char rem=stk.pop();
                vis[rem-'a']=false;

            }
            stk.push(ch);
            vis[ch-'a']=true;
        }
        while(!stk.isEmpty()){
            sb.append(stk.pop());

        }
        return sb.reverse().toString();
    }
}
