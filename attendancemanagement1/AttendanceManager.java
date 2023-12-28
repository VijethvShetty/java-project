
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class AttendanceManager {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";
    private static final String USER_FILE = "students.txt";
    private static final String ATTENDANCE_FILE = "attendance.txt";

    public static boolean isAdminValid(String username, String password) {
        return ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password);
    }

    public static boolean isStudentValid(int studentId, String studentName) {
        try (Scanner scanner = new Scanner(new File(USER_FILE))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 2 && Integer.parseInt(parts[0]) == studentId && parts[1].equals(studentName)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void viewAllStudents() {
        try (Scanner scanner = new Scanner(new File(USER_FILE))) {
            System.out.println("List of Students:");
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void viewAttendance(int studentId) {
        try (Scanner scanner = new Scanner(new File(ATTENDANCE_FILE))) {
            System.out.println("Attendance for Student ID " + studentId + ":");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 2 && Integer.parseInt(parts[0]) == studentId) {
                    System.out.println("Date: " + parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void markAttendance(int studentId) {
        try (FileWriter writer = new FileWriter(ATTENDANCE_FILE, true)) {
            String date = getCurrentDate();
            writer.write(studentId + "," + date + "\n");
            System.out.println("Attendance marked for Student ID " + studentId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // You may add more methods as needed

    private String getCurrentDate() {
        LocalDate currentDate = LocalDate.now();
        return currentDate.toString();
    }
}
