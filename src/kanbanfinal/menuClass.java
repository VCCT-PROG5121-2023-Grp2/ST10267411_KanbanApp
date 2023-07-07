/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kanbanfinal;

import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class menuClass {


    // show task menu dialog, returns: 
    //0 - add task, 
    //1 - search task by dev or name, 
    //2 - search and delete a task,
    // 3 - show all tasks
    // 4 - show task with longest duration
    // 5 - signs out

    public static Integer taskMenu() {

        String[] options = {
             "Add Tasks", //0
             "Search Tasks", //1
             "Delete a Task", //2
             "Show All Tasks", //3
             "Longest Task",//4
             "Sign Out"//5
              };
        return JOptionPane.showOptionDialog(null, "Welcome to EasyKanban",
                null, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
                options[0]);
    }

    // --------------------------------------------------------------------------------------------------------------------------//

    // show a dialog with the options and a message, 
    //returns 0 for register and 1 for login
    public static Integer loginMenu() {

        String[] options = { "Register", "Login" };
        return JOptionPane.showOptionDialog(null, "Welcome to EasyKanban",
                "Login Menu",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
                options[0]);
    }


    // --------------------------------------------------------------------------------------------------------------------------//

//confirms if the user would like to delete the selected task
    public static Boolean deleteConfirm(String task){
        String[] options = { "Delete", "Return to Menu" };
            
            int choice = JOptionPane.showOptionDialog(null, task,
                "Login Menu",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
                options[0]);


                if (choice == 0){
                    return true;
                }
                return false;
    }

    // --------------------------------------------------------------------------------------------------------------------------//

    public static int searchMenu(){
        String[] options = { "Search Name", "Search Developer" };

        return JOptionPane.showOptionDialog(null, "Search by name or developer",
                "Search",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
                options[0]);
    }

        // --------------------------------------------------------------------------------------------------------------------------//





}

