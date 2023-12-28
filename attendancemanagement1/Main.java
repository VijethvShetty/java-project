
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // UserManager userManager = new UserManager();
        AttendanceManager attendanceManager = new AttendanceManager();

        while (true) {
            System.out.println("Student Attendance System");
            System.out.println("1. Login as Admin");
            System.out.println("2. Login as Student");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter admin username: ");
                    String adminUsername = scanner.next();
                    System.out.print("Enter admin password: ");
                    String adminPassword = scanner.next();
                    if (AttendanceManager.isAdminValid(adminUsername, adminPassword)) {
                        adminMenu(attendanceManager);
                    } else {
                        System.out.println("Invalid credentials for admin.");
                    }
                    break;

                case 2:
                    System.out.print("Enter student ID: ");
                    int studentId = scanner.nextInt();
                    System.out.print("Enter student name: ");
                    String studentName = scanner.next();
                    if (AttendanceManager.isStudentValid(studentId, studentName)) {
                        studentMenu(attendanceManager, studentId);
                    } else {
                        System.out.println("Invalid credentials for student.");
                    }
                    break;

                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }


    private static void adminMenu(AttendanceManager attendanceManager) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("1. View all students");
            System.out.println("2. View attendance for a student");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    attendanceManager.viewAllStudents();
                    break;

                case 2:
                    System.out.print("Enter student ID: ");
                    int studentId = scanner.nextInt();
                    attendanceManager.viewAttendance(studentId);
                    break;

                case 3:
                    System.out.println("Logging out as admin.");
                    return;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void studentMenu(AttendanceManager attendanceManager, int studentId) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Student Menu:");
            System.out.println("1. View attendance");
            System.out.println("2. Mark attendance");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    attendanceManager.viewAttendance(studentId);
                    break;

                case 2:
                    attendanceManager.markAttendance(studentId);
                    break;

                case 3:
                    System.out.println("Logging out as student.");
                    return;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}

