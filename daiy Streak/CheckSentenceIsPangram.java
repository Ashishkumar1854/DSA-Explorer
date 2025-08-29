// Daily Streak Practice File
public class CheckSentenceIsPangram {
    // Function to check pangram
    public static boolean checkIfPangram(String sentence) {
        boolean[] alpha = new boolean[26];

        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                alpha[ch - 'a'] = true;
            }
        }

        // Check if all alphabets are covered
        for (int i = 0; i < 26; i++) {
            if (!alpha[i]) {
                return false;
            }
        }
        return true;
    }

    // Main method with example
    public static void main(String[] args) {
        String s1 = "thequickbrownfoxjumpsoverthelazydog"; // pangram
        String s2 = "leetcode"; // not pangram

        System.out.println("Sentence 1 is Pangram? " + checkIfPangram(s1));
        System.out.println("Sentence 2 is Pangram? " + checkIfPangram(s2));
    }
}
