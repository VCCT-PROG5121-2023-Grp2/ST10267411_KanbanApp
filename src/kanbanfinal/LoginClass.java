/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kanbanfinal;

import java.util.ArrayList;
import java.util.Objects;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class LoginClass {
// --------------------------------------------------------------------------------------------------------------------------//

    private ArrayList<String> usernameList = new ArrayList<String>();
    private ArrayList<String> passwordList = new ArrayList<String>();
    private ArrayList<String> firstNameList = new ArrayList<String>();
    private ArrayList<String> lastNameList = new ArrayList<String>();
    

    public LoginClass(){
        usernameList.add("admin");
        passwordList.add("admin");
        firstNameList.add("Administrator");
        lastNameList.add(" ");
    }

        // --------------------------------------------------------------------------------------------------------------------------//


    public void register() {
        String firstName = JOptionPane.showInputDialog(
                            "Please enter your first name");

                    String lastName = JOptionPane.showInputDialog(
                            "Please enter your last name");

                    String userName = JOptionPane.showInputDialog(
                            "Enter a username that contains an underscore, no spaces and is less than 5 characters long");

                    String password = JOptionPane.showInputDialog(
                            "Enter a password that contains:" + System.lineSeparator()
                                    + "At least 8 characters."
                                    + System.lineSeparator() + "A capital letter"
                                    + System.lineSeparator()
                                    + "Contains a number." + System.lineSeparator()
                                    + "Contains a special character");

                    if (LoginClass.checkUserName(userName) && LoginClass.checkPasswordComplexity(password)) {
                        firstNameList.add(firstName);
                        lastNameList.add(lastName);
                        usernameList.add(userName);
                        passwordList.add(password);
                    }
                    JOptionPane.showMessageDialog(null, LoginClass.registerUser(userName, password));
    }

    // --------------------------------------------------------------------------------------------------------------------------//



    public boolean login() {
        String loginUserName = JOptionPane.showInputDialog("Please enter your username");

                    String loginPassword = JOptionPane.showInputDialog("Please enter your password");

                    Boolean loginStatus = LoginClass.loginUser(loginUserName, loginPassword, usernameList,
                            passwordList);

                    Integer userIndex = LoginClass.returnUserIndex(loginUserName, usernameList);

                    String loginMessage = LoginClass.loginMessage(loginStatus, userIndex, firstNameList, lastNameList);

                    JOptionPane.showMessageDialog(null, loginMessage, null, 1);

                    if (loginStatus){
                        return true;
                    }
                    return false;
    }


    // -----------------------------------------------------------------------------------------------------------------------//


    //uses Joptionpane to show a list of users in an array
    public void displayUsers() {
        String output = "";
        for (int i = 0; i < usernameList.size(); i++) {
            String usernames = usernameList.get(i).toString();

            int userNum = i + 1;

            output += "User #" + userNum + ": " + usernames;
        }
        JOptionPane.showMessageDialog(null, output);
    }





        // --------------------------------------------------------------------------------------------------------------------------//






















    // methods used by main class methods

    //returns true or false based on username validity
    public static Boolean checkUserName(String username) {
        if (username.length() < 6 && username.indexOf('_') > -1) {
            return true;
        } else {
            return false;
        }
    }

    // --------------------------------------------------------------------------------------------------------------------------//

    //returns true or false based on password complexity
    public static boolean checkPasswordComplexity(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                hasCapital = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
            if (hasCapital && hasNumber && hasSpecial) {
                return true;
            }
        }
        return false;
    }

    // --------------------------------------------------------------------------------------------------------------------------//

    // Takes username and password as Strings and returns necessary message
    public static String registerUser(String username, String password) {

        boolean usernameTrue = checkUserName(username);
        boolean passwordTrue = checkPasswordComplexity(password);

        if (usernameTrue && passwordTrue) {
            return "Username and password sucessfully captured";
        } else if (usernameTrue) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character";
        } else if (passwordTrue) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        return "Username and password are not correctly formatted";
    }

    // --------------------------------------------------------------------------------------------------------------------------//


    //Returns welcome message with first and last names if login status true, returns incorrect login if false
    public static String returnLoginStatus(Boolean loginStatus, String firstName, String lastName) {
        if (Boolean.TRUE.equals(loginStatus)) {
            return "Welcome " + firstName + " " + lastName + " it is great to see you again. ";
        }
        return "Username or password incorrect, please try again";
    }

    

    // -------------------------------------------------------------------------------------------------------------------------//

    // returns true if a username and password are at the same index values in their
    // respective arraylists
    public static boolean loginUser(String username, String password, ArrayList<String> userNameArray,
            ArrayList<String> passwordArray) {

        int size = userNameArray.size();
        for (int i = 0; i < size; i++) {

            String us = userNameArray.get(i);
            String ps = passwordArray.get(i);
            if (Objects.equals(us, username) && Objects.equals(ps, password)) {
                return true;
            }
        }

        return false;
    }

    // --------------------------------------------------------------------------------------------------------------------------//

    //shows login message
    public static String loginMessage(Boolean loginStatus, Integer userIndex, ArrayList<String> firstNameList,
            ArrayList<String> lastNameList) {

        String firstName = "yes";
        String lastName = "yes";

        if (loginStatus) {

            firstName = firstNameList.get(userIndex);
            lastName = lastNameList.get(userIndex);

            loginStatus = true;

        }
        return LoginClass.returnLoginStatus(loginStatus, firstName, lastName);

    }

    // --------------------------------------------------------------------------------------------------------------------------//

    //returns the index of a user in the userarray
    public static Integer returnUserIndex(String username, ArrayList<String> userNameArray) {

        int size = userNameArray.size() + 1;

        int none = 0;
        for (int i = 0; i < size; i++) {

            String us = userNameArray.get(i);

            if (Objects.equals(us, username)) {
                return i;
            }

        }
        return none;

    }

    

}

// -----------------------------------------------------------------------------------------------------------------------//
// -----------------------------------------------End of File-------------------------------------------------------------------//

