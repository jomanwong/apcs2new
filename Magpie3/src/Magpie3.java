public class Magpie3 {

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
		if (findKeyword("i think not", statement, 0) >= 0){
			response = "Why not?";
		}else if (findKeyword("she is my mother", statement, 0) >= 0
				|| findKeyword("he is my father", statement, 0) >= 0
				|| findKeyword("she is my sister", statement, 0) >= 0
				|| findKeyword("he is my brother", statement) >= 0) {
			response = "Tell me more about your family.";
		}else if(findKeyword("mr. lathem is my apes teacher", statement, 0) >= 0
				|| findKeyword("ms. dryer is my apcs teacher", statement, 0) >= 0
				|| findKeyword("mr. hensley is my endlish teacher", statement, 0) >=0){
			response = "Sounds like a good teacher.";
		}else if(findKeyword("i'm great", statement, 0) >= 0 
				|| findKeyword("i am doing good", statement, 0) >= 0){
			response = "Nice, good to know.";
		}else if(statement.length() <= 0){
			response = "Did you say something? I didn't hear you.";
		}else if(findKeyword("hi", statement, 0) >=0
				|| findKeyword("hello", statement, 0) >= 0 
				|| findKeyword("hey there", statement, 0) >= 0){
			response = "Hi, how are you doing?";
		} else {
			response = getRandomResponse();
		}
		return response;
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
		// The only change to incorporate the startPos is in
		// the line below
		int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);

		// Refinement--make sure the goal isn't part of a
		// word
		while (psn >= 0) {
			// Find the string of length 1 before and after
			// the word
			String before = " ", after = " ";
			if (psn > 0) {
				before = phrase.substring(psn - 1, psn).toLowerCase();
			}
			if (psn + goal.length() < phrase.length()) {
				after = phrase.substring(psn + goal.length(),
						psn + goal.length() + 1).toLowerCase();
			}

			// If before and after aren't letters, we've
			// found the word
			if (before.equals(" ") && after.equals(" ")) {
				return psn;
			}

			// The last position didn't work, so let's find
			// the next, if there is one.
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
	 * returns a non-committal string
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
