class Solution {
    public static String merge(String a, String b) {
        // If one string contains the other, return the larger one
        if (a.contains(b)) return a;
        if (b.contains(a)) return b;

        int n = a.length();
        int m = b.length();
        int maxOverlap = 0;

        // Find the maximum overlap where suffix of `a` matches prefix of `b`
        for (int len = 1; len <= Math.min(n, m); len++) {
            if (a.substring(n - len).equals(b.substring(0, len))) {
                maxOverlap = len;
            }
        }

        // Merge a + (non-overlapping part of b)
        return a + b.substring(maxOverlap);
    }
    public String minimumString(String a, String b, String c) {
        String[][] permutations = {
            {a, b, c},
            {a, c, b},
            {b, a, c},
            {b, c, a},
            {c, a, b},
            {c, b, a}
        };
        // 3 strings.... 6 permutations

        String result= null;
        for(String perm[]: permutations)
        {
            String firstMerge= merge(perm[0], perm[1]);
            String secondMerge= merge(firstMerge, perm[2]);

            if(result == null || secondMerge.length()< result.length() || 
            (secondMerge.length()== result.length() && secondMerge.compareTo(result)<0))
            {
                result= secondMerge;
            }

        }
        return result;
    }
}