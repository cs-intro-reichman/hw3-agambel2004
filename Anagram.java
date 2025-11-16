/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String s1 = preProcess(str1);
    	String s2 = preProcess(str2);

    // check if the length are the same
    	if (s1.length() != s2.length()) {
        return false;
    	}

    //count how many c exits in each string 
    	for (int i = 0; i < s1.length(); i++) {
        	char c = s1.charAt(i);
			int count1 = 0;
        	int count2 = 0;
        	for (int j = 0; j < s1.length(); j++) {
            	if (s1.charAt(j) == c) {
                count1++;
            	}
        	}

        	for (int j = 0; j < s2.length(); j++) {
            	if (s2.charAt(j) == c) {
                count2++;
            	}
        	}

        // check If a letter appears a different number of times 
        if (count1 != count2) {
            return false;
        }
    }

    // All letters match
    return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
	String result = "";

    for (int i = 0; i < str.length(); i++) {
        char currentChar = str.charAt(i);

        // keep only letters, convert to lowercase
        if (Character.isLetter(currentChar)) {
            result += Character.toLowerCase(currentChar);
        }
    }
	return result;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
    	String result = "";
    	String remaining = str;
    	java.util.Random rand = new java.util.Random();

		while (remaining.length() > 0) {
        	int index = rand.nextInt(remaining.length());
        	result += remaining.charAt(index);
        	remaining = remaining.substring(0, index) + 
			remaining.substring(index + 1);
    	}
    return result;
	}
}
