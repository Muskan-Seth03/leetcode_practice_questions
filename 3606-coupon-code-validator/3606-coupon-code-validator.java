// TC: O(n * l) for checking if code is valid + O(n log n) for sorting
class Solution {
    private boolean checkValidCode(String code) {
        if (code == null || code.isEmpty()) return false;

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

        // bucket(list) for each business line
        List<String>[] buckets = new ArrayList[4];
        for (int i = 0; i < 4; i++) buckets[i] = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {
            if (isActive[i] && mp.containsKey(businessLine[i]) && checkValidCode(code[i])) {
                int idx = mp.get(businessLine[i]);
                buckets[idx].add(code[i]);
            }
        }

        // sort each list stored in a businessLine category
        for (int i = 0; i < 4; i++) {
            Collections.sort(buckets[i]);
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            result.addAll(buckets[i]);
        }
        return result;
    }
}
