public class User {
	private String username = "";
	private String password = "";

	/**
	 * 
	 * User constructor
	 * 
	 * @param username The username of the user
	 * @param password The password of the user
	 * 
	 */
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/**
	 * 
	 * username getter method
	 * 
	 * @return The username
	 * 
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * 
	 * username setter method
	 * 
	 * @param newUsername The new username
	 * 
	 */
	public void setUsername(String newUsername) {
		this.username = newUsername;
	}

	/**
	 * 
	 * password getter method
	 * 
	 * @return The password
	 * 
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * 
	 * password setter method
	 * 
	 * @param newPassword The new password
	 * 
	 */
	public void setPassword(String newPassword) {
		if (isValidPassword(newPassword)) {
			this.password = newPassword;
		}
	}

	/**
	 * 
	 * A method to check if the password meets the conditions
	 * 
	 * @param entered The password the user entered
	 * @return If it is valid, true. Otherwise, false.
	 * 
	 */
	public boolean isValidPassword(String entered) {
		if (entered.length() >= 8) {
			boolean isLetter = false;
			boolean isSymbol = false;
			boolean isNumber = false;
			for (int i = 0; i < entered.length(); i++) {
				int intValue = (entered.charAt(i)) - '0';
				if (Character.isLetter(entered.charAt(i))) {
					isLetter = true;
				} else if (intValue == 0 || intValue == 1 || intValue == 2 || intValue == 3 || intValue == 4
						|| intValue == 5 || intValue == 6 || intValue == 7 || intValue == 8 || intValue == 9) {
					isNumber = true;
				} else {
					isSymbol = true;
				}
			}
			if (isLetter && isNumber && isSymbol) {
				return true;
			}
		}
		return false;
	}
}