package ToDo_List;

import java.util.Scanner;

public class ToDo_List {
    private static final int MAX_TASKS = 100; // Define a constant for maximum tasks
    private static String[] tasks = new String[MAX_TASKS];
    private static Scanner scanner = new Scanner(System.in);
    private static int taskCount = 0;

    public static void addTask() {
        System.out.print("Enter new task: ");
        scanner.nextLine(); // Consume leftover newline
        String newTask = scanner.nextLine();
        if (taskCount < MAX_TASKS) {
            tasks[taskCount] = "[Pending] " + newTask;
            taskCount++;
            System.out.println("Task added successfully.");
        } else {
            System.out.println("Task list is full. Cannot add more tasks.");
        }
    }

    public static void viewTasks() {
        if (taskCount == 0) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("Tasks:");
        for (int i = 0; i < taskCount; i++) {
            System.out.println((i + 1) + ". " + tasks[i]);
        }
    }
<<<<<<< HEAD

    public static void markTaskCompleted() {
        viewTasks();
        if (taskCount == 0) return;
        System.out.print("Enter task number to mark as completed: ");
        int taskNum = scanner.nextInt() - 1;
        if (taskNum >= 0 && taskNum < taskCount) {
            if (tasks[taskNum].startsWith("[Completed]")) {
                System.out.println("Task is already completed.");
            } else {
                tasks[taskNum] = tasks[taskNum].replace("[Pending]", "[Completed]");
                System.out.println("Task marked as completed.");
=======
    public static void markTaskCompleted(){
        viewTask();
        if (count == 0) return;
        System.out.println("Enter task number to mark as completed: ");
        int tasknum= in.nextInt()-1;
        if (tasknum>=0 && tasknum<count){
            String task = arr[tasknum];
            if (task.startsWith("[Completed]")) {
                System.out.println("Task already completed");
>>>>>>> e20b22943b6a36dd9a6df599e73825527b04c499
            }
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public static void deleteTask() {
        viewTasks();
        if (taskCount == 0) return;
        System.out.print("Enter task number to delete: ");
        int taskNum = scanner.nextInt() - 1;
        if (taskNum >= 0 && taskNum < taskCount) {
            for (int i = taskNum; i < taskCount - 1; i++) {
                tasks[i] = tasks[i + 1];
            }
            tasks[taskCount - 1] = null; // Clear the last task
            taskCount--;
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Task\n2. View Tasks\n3. Mark Task Completed\n4. Delete Task\n5. Exit");
            System.out.print("Enter your choice: ");
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                scanner.nextLine(); // Clear invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    markTaskCompleted();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please select a number between 1 and 5.");
            }
        }
    }
<<<<<<< HEAD
}
=======

}
>>>>>>> e20b22943b6a36dd9a6df599e73825527b04c499
