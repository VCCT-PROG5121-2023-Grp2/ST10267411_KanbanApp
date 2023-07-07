/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package kanbanfinal;

/**
 *
 * @author User
 */
public class KanbanFInal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        worker wk = new worker();
        while (true) { //displays kanban task app if login sucessful
            if (wk.signIn()) {
                wk.displayTaskApp();
            }
        }

    }
    
}
// -----------------------------------------------End of File-------------------------------------------------------------------//
