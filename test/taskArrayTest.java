/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import kanbanfinal.taskClass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class taskArrayTest {
    

    
    
    
    
    
    
    @Test
    public void devArrayPopulated(){
        
        taskClass tk = new taskClass();

        tk.names.add("Create Login");
        tk.developer.add("Mike Smith");
        tk.duration.add(String.valueOf(8));
        tk.Status.add("To Do");
        
        tk.names.add("Create Add Features");
        tk.developer.add("Edward Harrison");
        tk.duration.add(String.valueOf(8));
        tk.Status.add("Doing");
        
        tk.names.add("Create Reports");
        tk.developer.add("Samantha Paulson");
        tk.duration.add(String.valueOf(2));
        tk.Status.add("Done");
        
        tk.names.add("Add Arrays");
        tk.developer.add("Glenda Oberholzer");
        tk.duration.add(String.valueOf(11));
        tk.Status.add("To Do");
        
        String expected = "[Mike Smith, Edward Harrison, Samantha Paulson, Glenda Oberholzer]";
        
        assertEquals(expected, tk.developer.toString());
        



    }
       // --------------------------------------------------------------------------------------------------------------------------//

    @Test
    public void longestDurationTest(){
        
        String expected = "Task: Add Arrays\nDeveloper: Glenda Oberholzer\nDuration: 11\n";
        taskClass tk = new taskClass();

        tk.names.add("Create Login");
        tk.developer.add("Mike Smith");
        tk.duration.add(String.valueOf(8));
        tk.Status.add("To Do");
        
        tk.names.add("Create Add Features");
        tk.developer.add("Edward Harrison");
        tk.duration.add(String.valueOf(8));
        tk.Status.add("Doing");
        
        tk.names.add("Create Reports");
        tk.developer.add("Samantha Paulson");
        tk.duration.add(String.valueOf(2));
        tk.Status.add("Done");
        
        tk.names.add("Add Arrays");
        tk.developer.add("Glenda Oberholzer");
        tk.duration.add(String.valueOf(11));
        tk.Status.add("To Do");
        
        System.out.println(tk.showDevLongestDuration()); 
        assertEquals(expected, tk.showDevLongestDuration());
    }
        // --------------------------------------------------------------------------------------------------------------------------//

    @Test
    public void searchTaskNameTest(){
        taskClass tk = new taskClass();

        tk.names.add("Create Login");
        tk.developer.add("Mike Smith");
        tk.duration.add(String.valueOf(8));
        tk.Status.add("To Do");
                tk.description.add("Create Add Task feature to add task users");
        tk.taskNumber.add(String.valueOf("0"));
        tk.ID.add("ABD:1:123");
        
        tk.names.add("Create Add Features");
        tk.developer.add("Edward Harrison");
        tk.duration.add(String.valueOf(8));
        tk.Status.add("Doing");
                tk.description.add("Create Add Task feature to add task users");
        tk.taskNumber.add(String.valueOf("1"));
        tk.ID.add("ABD:1:123");
        
        tk.names.add("Create Reports");
        tk.developer.add("Samantha Paulson");
        tk.duration.add(String.valueOf(2));
        tk.Status.add("Done");
                tk.description.add("Create Add Task feature to add task users");
        tk.taskNumber.add(String.valueOf("2"));
        tk.ID.add("ABD:1:123");
       
        tk.names.add("Add Arrays");
        tk.developer.add("Glenda Oberholzer");
        tk.duration.add(String.valueOf(11));
        tk.Status.add("To Do");
                tk.description.add("Create Add Task feature to add task users");
        tk.taskNumber.add(String.valueOf("3"));
        tk.ID.add("ABD:1:123");
        
        
        
        System.out.println(tk.searchTasksName( "Create Login"));
    }
        // --------------------------------------------------------------------------------------------------------------------------//

    @Test
    public void searchDeveloperTest(){
        taskClass tk = new taskClass();

        tk.names.add("Create Login");
        tk.developer.add("Mike Smith");
        tk.duration.add(String.valueOf(8));
        tk.Status.add("To Do");
                tk.description.add("Create Add Task feature to add task users");
        tk.taskNumber.add(String.valueOf("0"));
        tk.ID.add("ABD:1:123");
        
        tk.names.add("Create Add Features");
        tk.developer.add("Edward Harrison");
        tk.duration.add(String.valueOf(8));
        tk.Status.add("Doing");
                tk.description.add("Create Add Task feature to add task users");
        tk.taskNumber.add(String.valueOf("1"));
        tk.ID.add("ABD:1:123");
        
        tk.names.add("Create Reports");
        tk.developer.add("Samantha Paulson");
        tk.duration.add(String.valueOf(2));
        tk.Status.add("Done");
                tk.description.add("Create Add Task feature to add task users");
        tk.taskNumber.add(String.valueOf("2"));
        tk.ID.add("ABD:1:123");
       
        tk.names.add("Add Arrays");
        tk.developer.add("Glenda Oberholzer");
        tk.duration.add(String.valueOf(11));
        tk.Status.add("To Do");
                tk.description.add("Create Add Task feature to add task users");
        tk.taskNumber.add(String.valueOf("3"));
        tk.ID.add("ABD:1:123");
        
        tk.searchTasksDeveloper("Samantha Paulson");
        
    }
    
        // --------------------------------------------------------------------------------------------------------------------------//

    @Test
    public void deleteTaskTest(){
        taskClass tk = new taskClass();

        tk.names.add("Create Login");
        tk.developer.add("Mike Smith");
        tk.duration.add(String.valueOf(8));
        tk.Status.add("To Do");
                tk.description.add("Create Add Task feature to add task users");
        tk.taskNumber.add(String.valueOf("0"));
        tk.ID.add("ABD:1:123");
        
        tk.names.add("Create Add Features");
        tk.developer.add("Edward Harrison");
        tk.duration.add(String.valueOf(8));
        tk.Status.add("Doing");
                tk.description.add("Create Add Task feature to add task users");
        tk.taskNumber.add(String.valueOf("1"));
        tk.ID.add("ABD:1:123");
        
        tk.names.add("Create Reports");
        tk.developer.add("Samantha Paulson");
        tk.duration.add(String.valueOf(2));
        tk.Status.add("Done");
                tk.description.add("Create Add Task feature to add task users");
        tk.taskNumber.add(String.valueOf("2"));
        tk.ID.add("ABD:1:123");
       
        tk.names.add("Add Arrays");
        tk.developer.add("Glenda Oberholzer");
        tk.duration.add(String.valueOf(11));
        tk.Status.add("To Do");
                tk.description.add("Create Add Task feature to add task users");
        tk.taskNumber.add(String.valueOf("3"));
        tk.ID.add("ABD:1:123");
        
        tk.deleteTask("Create Reports");
        
    }
    
        // --------------------------------------------------------------------------------------------------------------------------//

    @Test
    public void displayTasksTest(){
        taskClass tk = new taskClass();

        tk.names.add("Create Login");
        tk.developer.add("Mike Smith");
        tk.duration.add(String.valueOf(8));
        tk.Status.add("To Do");
                tk.description.add("Create Add Task feature to add task users");
        tk.taskNumber.add(String.valueOf("0"));
        tk.ID.add("ABD:1:123");
        
        tk.names.add("Create Add Features");
        tk.developer.add("Edward Harrison");
        tk.duration.add(String.valueOf(8));
        tk.Status.add("Doing");
                tk.description.add("Create Add Task feature to add task users");
        tk.taskNumber.add(String.valueOf("1"));
        tk.ID.add("ABD:1:123");
        
        tk.names.add("Create Reports");
        tk.developer.add("Samantha Paulson");
        tk.duration.add(String.valueOf(2));
        tk.Status.add("Done");
                tk.description.add("Create Add Task feature to add task users");
        tk.taskNumber.add(String.valueOf("2"));
        tk.ID.add("ABD:1:123");
       
        tk.names.add("Add Arrays");
        tk.developer.add("Glenda Oberholzer");
        tk.duration.add(String.valueOf(11));
        tk.Status.add("To Do");
                tk.description.add("Create Add Task feature to add task users");
        tk.taskNumber.add(String.valueOf("3"));
        tk.ID.add("ABD:1:123");
        
        
        tk.displayTasks();
    }
        // --------------------------------------------------------------------------------------------------------------------------//

    
    
    
    
    
    
    
    
    
}
