import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Hogwarts {

    // TODO: Define Attributes
    private static ArrayList<Teacher> allTeachers = new ArrayList<>();
    private static ArrayList<Student> allStudents = new ArrayList<>();
    private static ArrayList<course> allCourses = new ArrayList<>();
    private static ArrayList<Assistant> allAssistants = new ArrayList<>();


    // TODO: Define Functionalities
    public static void viewAllTeachers() {
        //TODO
        for (int i = 0; i < allTeachers.size(); i++) {
            System.out.print(i + ") ");
            System.out.println(allTeachers.get(i).toString());
        }
    }

    public static void viewAllStudents() {
        //TODO
        for (int i = 0; i < allStudents.size(); i++) {
            System.out.print(i + ") ");
            System.out.println(allStudents.get(i).toString());
        }
    }

    public static void viewAllCourses() {
        //TODO
        for (int i = 0; i < allCourses.size(); i++) {
            System.out.print(i + ") ");
            System.out.println(allCourses.get(i).toString());
            allCourses.get(i).viewCourseStudent();
        }
    }

    public static course findCourse(String courseTitle){
        for (int i = 0; i < Hogwarts.getAllCourses().size(); i++) {
            if (Hogwarts.getAllCourses().get(i).getCourseName().equals(courseTitle)){
                return Hogwarts.getAllCourses().get(i);
            }
        }
        return null;
    }

    public static Teacher findTeacher(String TeacherName){
        for (int i = 0; i < Hogwarts.getAllTeachers().size(); i++) {
            if (Hogwarts.getAllTeachers().get(i).username.equals(TeacherName)){
                return Hogwarts.getAllTeachers().get(i);
            }
        }
        return null;
    }

    public static Student findStudent(String StudentName){
        for (int i = 0; i < Hogwarts.getAllStudents().size(); i++) {
            if (Hogwarts.getAllStudents().get(i).username.equals(StudentName)){
                return Hogwarts.getAllStudents().get(i);
            }
        }
        return null;
    }

    public static Assistant findAssistant(String AssistantName){
        for (int i = 0; i < Hogwarts.getAllAssistants().size(); i++) {
            if (Hogwarts.getAllAssistants().get(i).username.equals(AssistantName)){
                return Hogwarts.getAllAssistants().get(i);
            }
        }
        return null;
    }
    public static void teacherProfile(String Username){
        for (Teacher selectedObject : allTeachers) {
            if (selectedObject.username.equals(Username)){
                System.out.println(selectedObject.toString());
                break;
            }
        }
    }

    public static void studentProfile(String Username){
        for (Student selectedObject : allStudents) {
            if (selectedObject.username.equals(Username)){
                System.out.println(selectedObject.toString());
                selectedObject.viewMyCourses();
                break;
            }
        }
    }

    public static void saveTeacherScore(Teacher selectedTeacher){
        Scanner in = new Scanner(System.in);
        System.out.println("please Enter a number between 0 to 10 to rate selected teacher : ");
        int givenRate =  in.nextInt();
        selectedTeacher.addGivenRates(givenRate);
    }

    public static void saveTeacherComment(Teacher selectedTeacher){
        Scanner in = new Scanner(System.in);
        System.out.println("please leave your comment : ");
        String givenComment = in.nextLine();
        selectedTeacher.addGivenComments(givenComment);
    }

    public static void removeStudent(String studentName){
        for (Student student : allStudents){
            if (student.username.equals(studentName)){
                allStudents.remove(student);
                break;
            }
        }
    }
    public static void removeTeacher(String teacherName){
        for (Teacher teacher : allTeachers){
            if (teacher.username.equals(teacherName)){
                allTeachers.remove(teacher);
                break;
            }
        }
    }

    public static ArrayList<Teacher> getAllTeachers() {
        return allTeachers;
    }

    public static void addTeacher(Teacher newTeacher) {
        Hogwarts.allTeachers.add(newTeacher);
    }

    public static ArrayList<Student> getAllStudents() {
        return allStudents;
    }

    public static void addStudent(Student newStudent) {
        Hogwarts.allStudents.add(newStudent);
    }

    public static ArrayList<course> getAllCourses() {
        return allCourses;
    }

    public static void addCourse(course newCourse) {
        Hogwarts.allCourses.add(newCourse);
    }

    public static ArrayList<Assistant> getAllAssistants() {
        return allAssistants;
    }

    public static void addAssistant(Assistant newAssistant) {
        Hogwarts.allAssistants.add(newAssistant);
    }
}
