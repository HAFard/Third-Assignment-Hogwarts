import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class course {

    private String courseName;
    private Teacher courseTeacher;
    private UUID courseID;
    private ArrayList<Student> students;
    private ArrayList<Double> studentsScore;

    public course(String courseName) {
        this.courseName = courseName;
        this.courseID = UUID.randomUUID();
        this.students = new ArrayList<>();
        this.studentsScore = new ArrayList<>();
        this.courseTeacher = null;
        Hogwarts.addCourse(this);
    }

    @Override
    public String toString() {
        return "course Title : " + courseName +"    "+
                "course Teacher : "+courseTeacher+"    "+
                "course ID : " + courseID +'\n';
    }

    public void viewCourseStudent(){
        System.out.println("Enrolled Students :");
        for (Student student : this.students){
            System.out.println("    "+student.toString());
        }
    }

    public void setStudentsScore(){
        Scanner in = new Scanner(System.in);
        System.out.println("please Enter the name of the student you want to Score for : ");
        String selectedStudent =  in.nextLine();
        System.out.println("please Enter the name of the student you want to Score for : ");
        Double studentScore =  in.nextDouble();
        boolean flag = false;
        for (Student student : this.students){
            if (student.username.equals(selectedStudent)) {
                flag = true;
                int indexOfStudent = this.students.indexOf(student);
                this.studentsScore.set(indexOfStudent,studentScore);
                System.out.println(studentScore + " is set for student " + selectedStudent + " !");
                break;
            }
        }
        if (!flag) System.out.println("This student didn't enrolled in this course!");
    }

    public String getCourseName() {
        return courseName;
    }

    public UUID getCourseID() {
        return courseID;
    }

    public ArrayList<Student> getCourseStudents() {
        return students;
    }

    public void addStudentToCourse(Student newstudent) {
        this.students.add(newstudent);
        this.studentsScore.add(0.000001);
    }

    public Teacher getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(Teacher courseTeacher) {
        if (this.courseTeacher == null) {
            this.courseTeacher = courseTeacher;
        }
        else System.out.println("This course already has a teacher!");
    }
}