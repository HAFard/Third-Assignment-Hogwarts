import java.util.ArrayList;
import java.util.Scanner;

public class Assistant extends Account{


    private static ArrayList<String> newSignUps;
    private static ArrayList<String> allowedSignUps;
    public Assistant(String username, String password) {
        super(username, password);
        Hogwarts.addAssistant(this);
    }

    public static boolean assistantLogin (String enteredUsername, String enteredPassword){
        if (Hogwarts.findAssistant(enteredUsername) != null){
            return Hogwarts.findAssistant(enteredUsername).validatePassword(enteredPassword);
        }
        return false;
    }

    @Override
    public void showDashboard(){
        while (true) {
            System.out.println("Hey assistant " + this.username + " !");
            System.out.println("Your dashboard :");
            System.out.println("1 - Create new assistant account           2 - Create A Course ");
            System.out.println("3 - Remove Teacher Account                 4 - Remove Student Account");
            System.out.println("5 - See all courses & their students       6 - View teacher profile ");
            System.out.println("7 - View student profile                   8 - Allow teachers to sign up ");
            System.out.println("9 - log out ");
            System.out.println("Please choose a number : ");

            Scanner In = new Scanner(System.in);
            int enteredNumber = In.nextInt();

            switch (enteredNumber){


                case 1:
                    Scanner in1 = new Scanner(System.in);
                    System.out.println("please Enter new username : ");
                    String newAssistantUsername =  in1.nextLine();
                    System.out.println("please Enter new password : ");
                    String newAssistantPassword =  in1.nextLine();
                    if (Hogwarts.findAssistant(newAssistantUsername) == null){
                        new Student(newAssistantUsername,newAssistantPassword);
                        System.out.println("New account is created! ... please log in first to see your dashboard.");
                    }
                    else System.out.println("This student account is already existed!");
                    break;


                case 2:
                    Scanner in2 = new Scanner(System.in);
                    System.out.println("please Enter new course title : ");
                    String newCourseName =  in2.nextLine();
                    if (Hogwarts.findCourse(newCourseName) == null){
                        new course(newCourseName);
                        System.out.println("The course created!");
                    }else System.out.println("This course is already existed!");
                    break;



                case 3:
                    Scanner in3 = new Scanner(System.in);
                    System.out.println("please Enter the name of teacher you wanna remove : ");
                    String removedTeacher =  in3.nextLine();
                    if (Hogwarts.findTeacher(removedTeacher) != null){
                        Hogwarts.removeTeacher(removedTeacher);
                        System.out.println("The Teacher removed!");
                    }
                    else System.out.println("This Teacher is not existed!");
                    break;



                case 4:
                    Scanner in4 = new Scanner(System.in);
                    System.out.println("please Enter the name of student you wanna remove : ");
                    String removedStudent =  in4.nextLine();
                    if (Hogwarts.findStudent(removedStudent) != null){
                        Hogwarts.removeStudent(removedStudent);
                        System.out.println("The student removed!");
                    }
                    else System.out.println("This student is not existed!");
                    break;



                case 5:
                    Hogwarts.viewAllCourses();
                    break;



                case 6:
                    Scanner in8 = new Scanner(System.in);
                    System.out.println("please Enter the name of teacher you wanna see the profile of : ");
                    String profileOfTeacher =  in8.nextLine();
                    if (Hogwarts.findTeacher(profileOfTeacher) != null){
                        Hogwarts.teacherProfile(profileOfTeacher);
                    }
                    else System.out.println("This teacher is not existed!");
                    break;



                case 7:
                    Scanner in7 = new Scanner(System.in);
                    System.out.println("please Enter the name of student you wanna see the profile of : ");
                    String profileOfStudent =  in7.nextLine();
                    if (Hogwarts.findStudent(profileOfStudent) != null){
                        Hogwarts.studentProfile(profileOfStudent);
                    }
                    else System.out.println("This student is not existed!");
                    break;



                case 8:
                    this.allowTeacherSignUp();
                    break;

                default:break;
            }
            if (enteredNumber == 9) break;
        }
    }


    public void allowTeacherSignUp(){
        System.out.println("These are new teachers which wanna sign up!");
        for (String newTeacher : newSignUps) {
            System.out.println(newTeacher);
            System.out.println("Do you wanna allow sign up? Y/N");
            Scanner in = new Scanner(System.in);
            String allowFlag = in.next();
            if (allowFlag.equals("Y")){
                allowedSignUps.add(newTeacher);
                newSignUps.remove(newTeacher);
            }
        }
    }

    public static boolean newSignUpIsExisted(String signUpUsername) {
        for (String username : newSignUps){
            if(username.equals(signUpUsername))
                return true;
        }
        return false;
    }

    public static boolean isAllowedSignUp(String signUpUsername){
        for (String username : allowedSignUps){
            if(username.equals(signUpUsername))
                return true;
        }
        return false;
    }

    public static void addNewSignUps(String newSignUp) {
        newSignUps.add(newSignUp);
    }
}

