import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Student extends Account{

    private String HogwartsHouse = null;
    private ArrayList<course> myCourses;

    public Student(String username, String password) {
        super(username, password);
        this.myCourses = new ArrayList<>();
        this.takeQuiz();
        Hogwarts.addStudent(this);
    }

    public static boolean studentLogin (String enteredUsername, String enteredPassword){
        if (Hogwarts.findStudent(enteredUsername) != null){
            return Hogwarts.findStudent(enteredUsername).validatePassword(enteredPassword);
        }
        return false;
    }

    @Override
    public void showDashboard(){
        while (true) {
            System.out.println("Hey student " + this.username + " !");
            System.out.println("Your dashboard :");
            System.out.println("1 - take Quiz                    2 - Take course ");
            System.out.println("3 - See all your courses         4 - See all your teachers ");
            System.out.println("5 - sign out");
            System.out.println("Please choose a number : ");

            Scanner In = new Scanner(System.in);
            int enteredNumber = In.nextInt();

            switch (enteredNumber){
                case 1:
                    this.takeQuiz();
                    break;
                case 2:
                    Scanner in = new Scanner(System.in);
                    System.out.println("please Enter course name : ");
                    String enteredName =  in.nextLine();
                    this.enrollCourse(enteredName);
                    break;
                case 3:
                    this.viewMyCourses();
                    break;
                case 4:
                    this.viewMyTeachers();
                    break;
                default:break;

            }
            if (enteredNumber == 5) break;
        }
    }

    @Override
    public String toString() {
        return " username : " + username + '\n' +
                " Hogwarts House : " + HogwartsHouse + '\n';
    }

    public void enrollCourse(String courseName){
        for (int i = 0; i < Hogwarts.getAllCourses().size(); i++) {
            if (Hogwarts.getAllCourses().get(i).getCourseName().equals(courseName)){
                Hogwarts.getAllCourses().get(i).addStudentToCourse(this);
                this.myCourses.add(Hogwarts.getAllCourses().get(i));
                break;
            }
        }
    }
    public void takeQuiz(){
        if(this.HogwartsHouse == null) {
            int randomNum = (int) (Math.random() * 3) + 1;
            switch (randomNum) {
                case 1:
                    this.HogwartsHouse = "Gryffindor";
                case 2:
                    this.HogwartsHouse = "Hufflepuff";
                case 3:
                    this.HogwartsHouse = "Ravenclaw";
                case 4:
                    this.HogwartsHouse = "Slytherin";
            }
        }else System.out.println("You already have a house!");
    }

    public void viewMyCourses(){
        for (course myCourse : myCourses) {
            System.out.println("Student's courses :");
            System.out.println(myCourse.toString());
        }
    }
    public void viewMyTeachers(){
        for (course myCourse : myCourses) {
            System.out.println(myCourse.getCourseTeacher().toString());
        }
    }

    public String getHogwartsHouse() {
        return HogwartsHouse;
    }


}
