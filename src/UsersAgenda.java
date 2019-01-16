/**
* The UsersAgenda program implements a class that
* can be used to create users' agendas.
*
* @author AnderGonzalez
* @version 1.0
* @since 2019-01-16
*/
import java.util.ArrayList;

public class UsersAgenda {
	private ArrayList<User> users = new ArrayList<User>();
	/**

     * users ArrayList getter method

     * @return User type users ArrayList

     */
	public ArrayList<User> getUsers() {
		return this.users;
	}
	/**

     * users ArrayList setter method

     * @param newUsers The new User type ArrayList

     */
	public void setUsers(ArrayList<User> newUsers) {
		this.users = newUsers;
	}
	/**

     * A method to check if the string is composed of just a token or not

     * @param entered The string the user entered
     * @return If it is composed of just a token true. Otherwise, false.

     */
	public boolean isWord(String entered) {
		String[] enteredTokens = entered.split(" ");
		if (enteredTokens.length == 1) {
			return true;
		}
		return false;
	}
	/**

     * A method to check if there is any user with that username

     * @param username The username
     * @return If there was a user with that username, the index of this user. Otherwise, -1.

     */
	public int findUsername(String username) {
		for (int i=0;i<this.users.size();i++) {
			if (this.users.get(i).getUsername().equals(username)) {
				return i;
			}
		}
		return -1;
	}
	/**

     * A method to check if the password meets the conditions

     * @param entered The password the user entered
     * @return If it is valid, true. Otherwise, false.

     */
	public boolean isValidPassword(String entered) {
		if (isWord(entered)) {
			if (entered.length() >= 8) {
				boolean isLetter = false;
				boolean isSymbol = false;
				boolean isNumber = false;
				for (int i = 0; i < entered.length(); i++) {
					int intValue = (entered.charAt(i))-'0';
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
		}
		return false;
	}
	/**

     * A method to add a user to the ArrayList users

     * @param newUser The new user
     * @return If the username and the password meet the conditions to be added as a user, true. Otherwise, false

     */
	public boolean addUser(User newUser) {
		if (findUsername(newUser.getUsername())==-1 && isValidPassword(newUser.getPassword())) {
			this.users.add(newUser);
			return true;
		}
		return false;
	}
	/**

     * A method to log in

     * @param user The user that we will use to log in
     * @return If the user was already in the ArrayList users, true. Otherwise, false.

     */
	public boolean logIn(User user) {
		for (int i=0;i<this.users.size();i++) {
			if (this.users.get(i).getUsername().equals(user.getUsername()) && this.users.get(i).getPassword().equals(user.getPassword())) {
				return true;
			}
		}
		return false;
	}
	/**

     * A method to modify a user from the ArrayList users

     * @param newUser The user we want to modify, but with the password changed.

     */
	public void modifyUser(User newUser) {
		int userIndex=findUsername(newUser.getUsername());
		users.set(userIndex,newUser);
	}
	/**

     * A method to remove a user from the ArrayList users

     * @param remUser The user we will remove
     * @return If the user we want to remove is in the ArrayList users, true. Otherwise, false

     */
	public boolean removeUser(User remUser) {
		if (findUsername(remUser.getUsername())!=-1) {
			this.users.remove(findUsername(remUser.getUsername()));
			return true;
		}
		return false;
	}
}