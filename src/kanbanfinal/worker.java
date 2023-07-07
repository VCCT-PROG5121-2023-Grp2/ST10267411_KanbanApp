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
public class worker {


    taskClass tc = new taskClass();
    LoginClass lg = new LoginClass();

    // --------------------------------------------------------------------------------------------------------------------------//

    // provides UI for registration and login, loops til login successful
    public Boolean signIn() {

        Boolean finished = false;
        while (!finished) {

            int choice = menuClass.loginMenu();

            switch (choice) {
                case 0:
                    // Registration code
                    lg.register();
                    break;

                case 1:
                    // login code

                    if (lg.login()) {
                        finished = true;
                    }

                    break;
            }

        }
        return finished;
    }

    // -------------------------------------------------------------------------------------------------------------------------//

    // displays task app
    public void displayTaskApp() {

        Boolean quit = false;

        while (!quit) {

            switch (menuClass.taskMenu()) // show task menu dialog, returns:
            // 0 - add task,
            // 1 - search task by dev or name,
            // 2 - search and delete a task,
            // 3 - show all tasks
            // 4 - show dev and task with longest duration
            // 5 - signs out
            {
                case 0: // add tasks

                    int numTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks would you like to add?"));

                    tc.addTasks(numTasks);

                    break;

                case 1: // search by dev or name

                    tc.search(menuClass.searchMenu());

                    break;

                case 2: // delete by task name
                    String taskName = JOptionPane.showInputDialog("Enter the name of the task you would like to delete");
                    tc.deleteTask(taskName);
                    break;

                case 3: // show all tasks
                    tc.displayTasks();
                    break;

                case 4: // show dev longest duration
                    
                    String longestTask = tc.showDevLongestDuration();
                    JOptionPane.showMessageDialog(null, longestTask, "Longest Task",
                    JOptionPane.INFORMATION_MESSAGE);
                    break;

                case 5: // signs out
                    quit = true;
                    break;

            }

        }

    }
}

// ------------------------------------------------------------------------------------------------------------------//
// -----------------------------------------------End of
// File-------------------------------------------------------------------//
