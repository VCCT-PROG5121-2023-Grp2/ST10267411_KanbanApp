/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kanbanfinal;

import java.util.ArrayList;
import java.util.Objects;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class taskClass {


    // task ArrayLists
    public ArrayList<String> names = new ArrayList<String>();
    public ArrayList<String> taskNumber = new ArrayList<String>();
    public ArrayList<String> description = new ArrayList<String>();
    public ArrayList<String> developer = new ArrayList<String>();
    public ArrayList<String> duration = new ArrayList<String>();
    public ArrayList<String> ID = new ArrayList<String>();
    public ArrayList<String> Status = new ArrayList<String>();

    // --------------------------------------------------------------------------------------------------------------------------//

    // prompts the user to fill task arrays using JPanel, takes an integer as an
    // arguement for the number of tasks to be entered. Displays all tasks once
    // complete
    public void addTasks(Integer NumberOfTasks) {

        for (int count = 0; count < NumberOfTasks;) {

            JPanel panel = new JPanel();
            JTextField[] fields = new JTextField[5];
            JLabel[] labels = new JLabel[5];
            String[] fieldNames = { "Task Name:", "Description:", "Developer", "Duration", "Status" };

            for (int i = 0; i < fields.length; i++) {
                labels[i] = new JLabel(fieldNames[i]);
                fields[i] = new JTextField(10);
                panel.add(labels[i]);
                panel.add(fields[i]);
            }

            int result = JOptionPane.showConfirmDialog(null, panel, "Enter Values",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                if (checkTaskDescription(fields[1].getText())) {

                    names.add(fields[0].getText());
                    description.add(fields[1].getText());
                    developer.add(fields[2].getText());
                    duration.add(fields[3].getText());
                    Status.add(fields[4].getText());
                    taskNumber.add(String.valueOf(count));

                    ID.add(createTaskID(fields[0].getText(), String.valueOf(count), fields[2].getText()));

                    count += 1;
                } else

                {
                    JOptionPane.showConfirmDialog(null, panel,
                            "Please enter a description with less than 50 characters",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                }

            }

        }
        displayTasks();
    }

    // --------------------------------------------------------------------------------------------------------------------------//

    // Does what it says on the tin. Displays all tasks in the taskClass using
    // JOptionpane
    public void displayTasks() {

        StringBuilder message = new StringBuilder();
        Integer count = 0;

        for (String name : names) {

            int num = count + 1;

            message.append("\nTask #" + num + "\n");
            message.append("Status: ").append(Status.get(count)).append("\n");
            message.append("Developer: ").append(developer.get(count)).append("\n");
            message.append("Task: ").append(name).append("\n");
            message.append("Description: ").append(description.get(count)).append("\n");
            message.append("ID: ").append(ID.get(count)).append("\n");
            message.append("Duration: ").append(duration.get(count)).append("\n");

            count += 1;
        }

        message.append("\nTotalDuration: ").append(returnTotalHours(duration)).append("\n");

        JOptionPane.showMessageDialog(null, message.toString(), "Tasks", JOptionPane.INFORMATION_MESSAGE);

    }

    // --------------------------------------------------------------------------------------------------------------------------//

    // takes task name, number and dev name as parameter and returns task ID
    public static String createTaskID(String taskName, String taskNumber, String developer) {

        StringBuilder taskID = new StringBuilder();

        taskID.append(taskName.charAt(0));
        taskID.append(taskName.charAt(1));

        taskID.append(":");

        taskID.append(taskNumber);

        taskID.append(":");

        int s = developer.length() - 3;

        for (int i = 0; i < 3; i++) {
            taskID.append(developer.charAt(s));
            s++;
        }

        return taskID.toString().toUpperCase();
    }

    // --------------------------------------------------------------------------------------------------------------------------//

    // tasks an array and returns the sum of all values
    public static int returnTotalHours(ArrayList<String> durationArr) {

        int d = durationArr.size();
        int totalHours = 0;

        for (int i = 0; i < d; i++) {
            totalHours += Integer.valueOf(durationArr.get(i));
        }

        return totalHours;
    }

    // --------------------------------------------------------------------------------------------------------------------------//

    // ensures description string contains less than 50 characters
    public static boolean checkTaskDescription(String description) {

        if (description.length() < 50) {
            return true;
        } else {
            return false;
        }

    }

    // --------------------------------------------------------------------------------------------------------------------------//

    public String searchTasksName(String taskName) {

        StringBuilder result = new StringBuilder();
        result.append("Results for " + taskName);
        int size = this.names.size();
        for (int i = 0; i < size; i++) {
            String name = this.names.get(i);

            if (Objects.equals(name, taskName)) {
                result.append("\nTask #" + taskNumber.get(i) + "\n");
                result.append("Status: ").append(Status.get(i)).append("\n");
result.append("Developer: ").append(developer.get(i)).append("\n");
                result.append("Task: ").append(names.get(i)).append("\n");
                result.append("Description: ").append(description.get(i)).append("\n");
                result.append("ID: ").append(ID.get(i)).append("\n");
                result.append("Duration: ").append(duration.get(i)).append("\n");
            }

        }
        return result.toString();
    }

    public void searchTasksDeveloper(String developer) {
        StringBuilder result = new StringBuilder();
        result.append("Results for " + developer);
        int size = this.developer.size();
        for (int i = 0; i < size; i++) {
            String dev = this.developer.get(i);

            if (Objects.equals(dev, developer)) {
                result.append("\nTask #" + taskNumber.get(i) + "\n");
                result.append("Status: ").append(Status.get(i)).append("\n");

                result.append("Task: ").append(names.get(i)).append("\n");
                result.append("Description: ").append(description.get(i)).append("\n");
                result.append("ID: ").append(ID.get(i)).append("\n");
                result.append("Duration: ").append(duration.get(i)).append("\n");
            }

        }

        JOptionPane.showMessageDialog(null, result.toString(), "Search Results:", JOptionPane.INFORMATION_MESSAGE);

    }

    public void deleteTask(String taskName) {

        StringBuilder result = new StringBuilder();
        result.append("Results for " + taskName);

        int size = this.names.size()+1;
        

        for (int count = 0; count < size; count++) {

            String name = names.get(count);

            if (Objects.equals(name, taskName)) {
                result.append("\nTask #" + taskNumber.get(count) + "\n");
                result.append("Status: ").append(Status.get(count)).append("\n");

                result.append("Task: ").append(names.get(count)).append("\n");
                result.append("Description: ").append(description.get(count)).append("\n");
                result.append("ID: ").append(ID.get(count)).append("\n");
                result.append("Duration: ").append(duration.get(count)).append("\n");

                if (menuClass.deleteConfirm(result.toString())) {
                    names.remove(count);
                    description.remove(count);
                    developer.remove(count);
                    duration.remove(count);
                    Status.remove(count);
                    taskNumber.remove(count);
                    
                    JOptionPane.showMessageDialog(null, "Entry “" + taskName + "” successfully deleted", "Delete Task",
                    JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                
                else {return;}

                

            }

            
            
            
        }
        JOptionPane.showMessageDialog(null, "Your search could not be found", "Delete Task",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        
    }

    // --------------------------------------------------------------------------------------------------------------------------//

    public void search(Integer searchType) {
        switch (searchType) {
            case 0:

                String name = JOptionPane.showInputDialog("Enter the name of the task you would like to search for");
                searchTasksName(name);
                break;

            case 1:

                String dev = JOptionPane.showInputDialog("Enter the name of the task you would like to search for");
                searchTasksDeveloper(dev);
                break;
        }

    }

    // --------------------------------------------------------------------------------------------------------------------------//


    public String showDevLongestDuration(){
        StringBuilder result = new StringBuilder();
        
        int size = this.duration.size();
        int longestDuration = 0;
        String longestDev="";
        String longestTask ="";
        
        

        for (int i = 0; i < size; i++) {

            if (longestDuration < Integer.valueOf(duration.get(i))){
                longestDuration = Integer.valueOf(duration.get(i));
                longestDev = developer.get(i);
                longestTask = names.get(i);
            }
        }
                result.append("Task: ").append(longestTask).append("\n");
                result.append("Developer: ").append(longestDev).append("\n");
                result.append("Duration: ").append(longestDuration).append("\n");
        return result.toString();
    }
}

// --------------------------------------------------------------------------------------------------------------------------//
// -----------------------------------------------End of
// File-------------------------------------------------------------------//
