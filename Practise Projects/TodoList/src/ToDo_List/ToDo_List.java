package ToDo_List;

import javax.xml.transform.Source;
import java.util.Scanner;

public class ToDo_List {
    static String[] arr = new String[100];
    static Scanner in = new Scanner(System.in);
    static int count = 0;

    public static void addTask(){
        System.out.print("add new task: ");
        in.nextLine();
        String addTask = in.nextLine();
        arr[count] = "[pending]"+addTask;
        count ++;
        System.out.println("task added successfully ");

    }
    public static void viewTask(){
        if (count == 0){
            System.out.println("no task available");
            return;
        }
        System.out.println("Tasks: ");
        for (int i =0 ; i<count;i++){
            System.out.println((1+i)+"."+arr[i]);
        }

    }
    public static void markTaskCompleted(){
        viewTask();
        if (count == 0) return;
        System.out.println("Enter task number to mark as completed: ");
        int tasknum= in.nextInt()-1;
        if (tasknum>=0 && tasknum<count){
            String task = arr[tasknum];
            if (task.startsWith("[Completed]")) {
                System.out.println("Task already completed");
            }
            else {
                task = task.replace("[pending]","[Completed]");
                arr[tasknum]=task;
                System.out.println("task completed good go to next pending task");
            }

        }else {
            System.out.println("Invalid Task number");
        }



    }
    public static void deleteTask(){
        viewTask();
        if (count == 0) return;
        System.out.println("Enter task number to delete: ");
        int tasknum= in.nextInt()-1;
        if (tasknum>0 && tasknum<count){
           for (int i =tasknum;i<count;i++){
               arr[i]=arr[i+1];
           }
           count--;
            System.out.println("task deleted successfully");

        }else {
            System.out.println("Invalid Task number");
        }

    }


    public static void main(String[] args) {
        while (true){
            System.out.println("\n 1.Add Task\n 2.View Task\n 3. Mark Task Completed\n 4.Delete Task\n 5.Exit");
            System.out.println("Enter your choice: ");
            int choice =in.nextInt();
            switch (choice){
                case 1:
                    addTask();
                    break;

                case 2:
                    viewTask();
                    break;

                case 3:
                    markTaskCompleted();
                    break;

                case 4:
                    deleteTask();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid input");
                    System.out.println("please select given options ");

            }
        }
    }

}
