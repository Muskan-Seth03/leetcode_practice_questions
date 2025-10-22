class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Queue<String> q= new LinkedList<>();
        q.offer(s);

        Set<String> visited= new HashSet<>();
        visited.add(s);

        String smallestString= s;
        
        // apply bfs
        while(!q.isEmpty())
        {
            String str= q.poll();

            if(smallestString.compareTo(str) > 0)
            {
                smallestString= str;
            }

            StringBuilder s1= new StringBuilder(str);
            StringBuilder s2= new StringBuilder(str);

            // add val of a to string str
            for(int i=1; i < s1.length(); i+=2)
            {
                s1.setCharAt(i, (char)(((s1.charAt(i) - '0' + a) % 10 ) + '0'));
            }

            if(!visited.contains(s1.toString()))
            {
                visited.add(s1.toString());
                q.offer(s1.toString());
            }

            int n = str.length();

            // rotate by b positions
            s2= new StringBuilder(s2.substring(n - b) + s2.substring(0, n - b));

            if(!visited.contains(s2.toString()))
            {
                visited.add(s2.toString());
                q.offer(s2.toString());
            }
        }
        return smallestString;
    }
}