class Solution {
    public boolean halvesAreAlike(String s) {

        int mid = s.length() / 2;
        int countA = 0;
        int countB = 0;

        // Count vowels in first half
        for (int i = 0; i < mid; i++) {
            if (isVowel(s.charAt(i))) {
                countA++;
            }
        }

        // Count vowels in second half
        for (int i = mid; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                countB++;
            }
        }

        return countA == countB;
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' ||
               ch == 'o' || ch == 'u' ||
               ch == 'A' || ch == 'E' || ch == 'I' ||
               ch == 'O' || ch == 'U';
    }
}