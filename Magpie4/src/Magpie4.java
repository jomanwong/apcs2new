/**
 * 
 * @author Joman
 * 
 * @period APCS2
 * 
 */

public class Magpie4 {

	//Get a default greeting and return a greeting
	public String getGreeting() {
		return "Hello, let's talk.";
	}

	/**
	 * Gives a response to a user statement
	 * takes in user statement
	 * response based on the rules given
	 */
	public String getResponse(String statement) {
		String response = "";
		if(statement == null){
			response = "Did you say something? I didn't hear you.";
		}
		statement = statement.toLowerCase();
		if (findKeyword("i think not", statement, 0) >= 0){
			response = "Why not?";
		}else if (findKeyword("she is my mother", statement, 0) >= 0
				|| findKeyword("he is my father", statement, 0) >= 0
				|| findKeyword("she is my sister", statement, 0) >= 0
				|| findKeyword("he is my brother", statement) >= 0) {
			response = "Tell me more about your family.";
		}else if(findKeyword("mr. lathem is my apes teacher", statement, 0) >= 0
				|| findKeyword("ms. dryer is my apcs teacher", statement, 0) >= 0
				|| findKeyword("mr. hensley is my english teacher", statement, 0) >=0){
			response = "Sounds like a good teacher.";
		}else if(findKeyword("i'm great", statement, 0) >= 0 
				|| findKeyword("i am doing good", statement, 0) >= 0){
			response = "Nice, good to know.";
		}else if(findKeyword("hi", statement, 0) >=0
				|| findKeyword("hello", statement, 0) >= 0 
				|| findKeyword("hey there", statement, 0) >= 0){
			response = "Hi, how are you doing?";
		}else if (findKeyword(statement, "i want to", 0) >= 0) { 	// Responses which require transformations
			response = transformIWantToStatement(statement);
		}else if (findKeyword(statement, "i want", 0) >= 0){
			response = transformIwantStatement(statement);
		}else if(findKeyword(statement, "i ", 0) >= 0 && findKeyword(statement, " you", 0) >= 0){
			response = transformIYou(statement);
		}else{
			// Look for a two word (you <something> me)
			// pattern
			int psn = findKeyword(statement, "you", 0);

			if (psn >= 0 && findKeyword(statement, "me", psn) >= 0) {
				response = transformYouMeStatement(statement);
			} else {
				response = getRandomResponse();
			}
		}
		return response;
	}

	private String transformIYou(String statement){
		// Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals(".")) {
			statement = statement.substring(0, statement.length() - 1);
		}
		int psn = findKeyword(statement, "i", 0);
		String restOfStatement = statement.substring(psn + 6).trim();
		return "Would you really be happy if you had " + restOfStatement + "?";
	}

	private String transformIwantStatement(String statement){
		// Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals(".")) {
			statement = statement.substring(0, statement.length() - 1);
		}
		int psn = findKeyword(statement, "i want", 0);
		String restOfStatement = statement.substring(psn + 6).trim();
		return "Would you really be happy if you had " + restOfStatement + "?";
	}

	/**
	 * Take a statement with "I want to <something>." and transform it into
	 * "What would it mean to <something>?"
	 * 
	 * @param statement
	 *            the user statement, assumed to contain "I want to"
	 * @return the transformed statement
	 */
	private String transformIWantToStatement(String statement) {
		// Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals(".")) {
			statement = statement.substring(0, statement.length() - 1);
		}
		int psn = findKeyword(statement, "i want to", 0);
		String restOfStatement = statement.substring(psn + 9).trim();
		return "What would it mean to " + restOfStatement + "?";
	}

	/**
	 * Take a statement with "you <something> me" and transform it into
	 * "What makes you think that I <something> you?"
	 * 
	 * @param statement
	 *            the user statement, assumed to contain "you" followed by "me"
	 * @return the transformed statement
	 */
	private String transformYouMeStatement(String statement) {
		// Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals(".")) {
			statement = statement.substring(0, statement.length() - 1);
		}

		int psnOfYou = findKeyword(statement, "you", 0);
		int psnOfMe = findKeyword(statement, "me", psnOfYou + 3);

		String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe)
				.trim();
		return "What makes you think that I " + restOfStatement + " you?";
	}

	/**
	 * Search for one word in phrase. The search is not case sensitive. This
	 * method will check that the given goal is not a substring of a longer
	 * string (so, for example, "I know" does not contain "no").
	 * 
	 * parameter: statement
	 *            the string to search
	 * parameter: goal
	 *            the string to search for
	 * parameter: startPos
	 *            the character of the string to begin the search at
	 * return the index of the first occurrence of goal in statement or -1 if
	 *         it's not found
	 */
	private int findKeyword(String statement, String goal, int startPos) {
		String phrase = statement.trim();
		// The only change to incorporate the startPos is in the line below
		int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);

		// Refinement--make sure the goal isn't part of a word
		while (psn >= 0) {
			// Find the string of length 1 before and after the word
			String before = " ", after = " ";
			if (psn > 0) {
				before = phrase.substring(psn - 1, psn).toLowerCase();
			}
			if (psn + goal.length() < phrase.length()) {
				after = phrase.substring(psn + goal.length(),
						psn + goal.length() + 1).toLowerCase();
			}

			// If before and after aren't letters, we've found the word
			if (before.equals(" ") && after.equals(" ")) {
				return psn;
			}
			// The last position didn't work, so let's find the next, if there
			// is one.
			psn = phrase.indexOf(goal.toLowerCase(), psn + 1);

		}

		return -1;
	}

	/**
	 * Search for one word in phrase. The search is not case sensitive. This
	 * method will check that the given goal is not a substring of a longer
	 * string (so, for example, "I know" does not contain "no"). The search
	 * begins at the beginning of the string.
	 * 
	 * takes in the string to search
	 * takes in the string to search for
	 * returns the index of the first occurrence of goal in statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal) {
		return findKeyword(statement, goal, 0);
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * 
	 * @return a non-committal string
	 */
	private String getRandomResponse() {
		final int NUMBER_OF_RESPONSES = 7;
		double r = Math.random();
		int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
		String response = "";

		if (whichResponse == 0) {
			response = "Interesting, tell me more.";
		} else if (whichResponse == 1) {
			response = "Hmmm.";
		} else if (whichResponse == 2) {
			response = "Do you really think so?";
		} else if (whichResponse == 3) {
			response = "You don't say.";
		}else if (whichResponse == 4){
			response = "Do you wanna try something new?";
		}else if(whichResponse == 5){
			response = "hahaha";
		}else if(whichResponse == 6){
			response = "What do you do all day, talking to programs?";
		}

		return response;
	}

}
