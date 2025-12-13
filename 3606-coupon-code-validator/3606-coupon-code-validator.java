//T.C : O(n*l + nlogn) where n = code.size() and l = average length of codes
//S.C : O(n)
class Solution {

    private boolean checkValidCode(String code) {
        if (code == null || code.isEmpty()) {
            return false;
        }

        for (char ch : code.toCharArray()) {
            if (!Character.isLetterOrDigit(ch) && ch != '_') {
                return false;
            }
        }
        return true;
    }

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        Map<String, Integer> mp = new HashMap<>();
        mp.put("electronics", 0);
        mp.put("grocery", 1);
        mp.put("pharmacy", 2);
        mp.put("restaurant", 3);

        // stores {businessLineNumberValue, code}
        List<Pair> temp = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {
            if (isActive[i]
                    && mp.containsKey(businessLine[i])
                    && checkValidCode(code[i])) {

                temp.add(new Pair(mp.get(businessLine[i]), code[i]));
            }
        }

        // sort by businessLineOrder, then by code
        Collections.sort(temp);

        List<String> result = new ArrayList<>();
        for (Pair p : temp) {
            result.add(p.code);
        }

        return result;
    }

    // Helper class to mimic pair<int, string>
    private static class Pair implements Comparable<Pair> {
        int lineNumber;
        String code;

        Pair(int lineNumber, String code) {
            this.lineNumber = lineNumber;
            this.code = code;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.lineNumber != other.lineNumber) {
                return Integer.compare(this.lineNumber, other.lineNumber);
            }
            return this.code.compareTo(other.code);
        }
    }
}