class Solution {
    public boolean rotateString(String s, String goal) {

        // Lengths must be equal
        if (s.length() != goal.length()) {
            return false;
        }

        // Check if goal is present inside s + s
        String doubled = s + s;

        return doubled.contains(goal);
    }
}