import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;

public class Teacher extends Account{

    private ArrayList<course> teachingCourses;
    private ArrayList<Integer> givenRates;
    private ArrayList<String> givenComments;

    public Teacher(String username, String password) {
        super(username, password);
        this.teachingCourses = new ArrayList<>();
        this.givenRates = new ArrayList<>();
        this.givenComments = new ArrayList<>();
        Hogwarts.addTeacher(this);
    }
    public static boolean teacherLogin (String enteredUsername, String enteredPassword){
        if (Hogwarts.findTeacher(enteredUsername) != null){
            return Hogwarts.findTeacher(enteredUsername).validatePassword(enteredPassword);
        }
        return false;
    }

    @Override
    public void showDashboard(){
        while (true) {
            System.out.println("Hey professor " + this.username + " !");
            System.out.println("Your dashboard :");
            System.out.println("1 - Take Courses                  2 - Score Students ");
            System.out.println("3 - View Teaching Courses         4 - View Course's List of Students ");
            System.out.println("5 - Display Your Score            6 - Display your comments ");
            System.out.println("7 - log out ");
            System.out.println("Please choose a number : ");

            Scanner In = new Scanner(System.in);
            int enteredNumber = In.nextInt();

            switch (enteredNumber){


                case 1:
                    Scanner in1 = new Scanner(System.in);
                    System.out.println("please Enter the name of the course you want to teach : ");
                    String courseName =  in1.nextLine();
                    this.takeCourse(courseName);
                    break;


                case 2:
                    Scanner in2 = new Scanner(System.in);
                    System.out.println("please Enter the name of the course you want to Score for : ");
                    String SelectedCourse =  in2.nextLine();
                    if (Hogwarts.findCourse(SelectedCourse) != null) {
                        boolean flag = false;
                        for (course Course : teachingCourses) {
                            if (Course.getCourseName().equals(SelectedCourse)) {
                                flag = true;
                                Course.setStudentsScore();
                                break;
                            }
                        }
                        if (!flag) System.out.println("You don't teach this course!");
                    }
                    else System.out.println("This course is not existed!");
                    break;



                case 3:
                    this.viewTeachingCourses();
                    break;



                case 4:
                    Scanner in4 = new Scanner(System.in);
                    System.out.println("please Enter the name of the course you want to teach : ");
                    String selectedCourse =  in4.nextLine();
                    this.viewSelectedCourseStudents(selectedCourse);
                    break;



                case 5:
                    int sum = 0;
                    for (int i = 0; i < givenRates.size(); i++) {
                        sum += givenRates.get(i);
                    }
                    int average = sum/givenRates.size();
                    System.out.println("The average of your Scores: " + average);
                    break;



                case 6:
                    System.out.println("These are comments has been left for you :");
                    for (int i = 0; i < givenComments.size() ; i++) {
                        System.out.println(i + " - ");
                        System.out.println(givenComments.get(i));
                    }
                    break;

                default:break;
            }
            if (enteredNumber == 7) break;
        }
    }

    public void takeCourse(String courseName){
        if(Hogwarts.findCourse(courseName) != null){
            course wantedCourse = Hogwarts.findCourse(courseName);
            wantedCourse.setCourseTeacher(this);
            this.teachingCourses.add(wantedCourse);
        }
    }

    public void showTeacherScore(){}

    public void viewTeachingCourses(){
        for (course teachingCourse : teachingCourses) {
                System.out.println(teachingCourse.toString());
            }
    }

    public void viewSelectedCourseStudents(String  courseName){
        for (course selectedCourse : Hogwarts.getAllCourses()) {
            if (selectedCourse.getCourseName().equals(courseName)) {
                System.out.println(selectedCourse.getCourseStudents().toString());
                break;
            }
        }
    }


    public void addGivenRates(Integer givenRate) {
        this.givenRates.add(givenRate);
    }

    public ArrayList<String> getGivenComments() {
        return givenComments;
    }

    public void addGivenComments(String givenComments) {
        this.givenComments.add(givenComments);
    }


}
