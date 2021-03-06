
public class Magpie2 {

	//Get a default greeting and return a greeting	
	public String getGreeting() {
		return "Hello, let's talk.";
	}

	/**
	 * Gives a response to a user statement
	 * takes in a user statement
	 * returns a response based on given rules
	 */
	public String getResponse(String statement) {
		String response = "";
		if (statement.indexOf("no") >= 0) {
			response = "Why not?";
		}else if (statement.indexOf("mother") >= 0
				|| statement.indexOf("father") >= 0
				|| statement.indexOf("sister") >= 0
				|| statement.indexOf("brother") >= 0) {
			response = "Tell me more about your family.";
		}else if(statement.indexOf("lathem") >= 0
				|| statement.indexOf("dryer") >= 0
				|| statement.indexOf("hensley") >=0){
			response = "Sounds like a good teacher.";
		}else if(statement.indexOf("great") >= 0 
				|| statement.indexOf("good") >= 0){
			response = "Nice, good to know.";
		}else if(statement.length() == 0){
			response = "Did you say something? I didn't hear you.";
		}else if(statement.indexOf("hi") >=0
				|| statement.indexOf("hello") >= 0 
				|| statement.indexOf("hey") >= 0){
			response = "Hi, how are you doing?";
		} else {
			response = getRandomResponse();
		}
		return response;
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
