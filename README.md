# **Java Cron Job Runner CLI**

A fully functional, feature-rich cron job runner CLI built from scratch in Java, without using any third-party libraries. This tool allows you to schedule and manage tasks using standard cron expressions.

## **Features**
- Parse and validate cron expressions (e.g., `* * * * *`).
- Schedule tasks and execute them at specified intervals.
- CLI interface for adding, listing, and managing tasks.
- Logs task execution details.
- Built entirely with Java standard libraries.


## **Getting Started**

### **Prerequisites**
- Java Development Kit (JDK) 8 or higher.
- A terminal or command prompt.

### **Running the Project**
1. Clone the repository:
   ```bash
   git clone https://github.com/Kei-K23/cron-job-cli
   cd cron-job-cli
   ```

2. Compile the Java files:
   ```bash
   javac -d out src/main/java/org/example/**/*.java
   ```

3. Run the program:
   ```bash
   java -cp out org.example.Main
   ```

## **Usage**

Once the application starts, use the CLI to manage your cron jobs.

### **Options:**
1. **Add Task**: Add a new task with a cron expression and name.
2. **List Tasks**: View all scheduled tasks.
3. **Exit**: Quit the CLI.

### **Example Cron Expression**
| Cron Field       | Value   | Description                     |
|-------------------|---------|---------------------------------|
| Minute           | `*`     | Every minute                   |
| Hour             | `*`     | Every hour                     |
| Day of Month     | `*`     | Every day of the month          |
| Month            | `*`     | Every month                    |
| Day of Week      | `*`     | Every day of the week           |

- **Run every minute**: `* * * * *`

## **Example Workflow**
1. Start the program.
2. Add a task with a cron expression (e.g., `* * * * *`) and a task name.
3. Wait for the task to execute. Logs will appear in the terminal.
4. List tasks to verify scheduling.

## **Future Improvements**
- Add support for persistence (save tasks to a file).
- Allow task removal and updates.
- Implement multi-threading for concurrent task execution.
- Write logs to a file for better tracking.

## **Contributing**
Feel free to fork this repository, submit issues, or contribute by opening a pull request.

## **License**
This project is licensed under the MIT License.