/*
    TODO: Import all the classes that you have defined and make use of them to build the program.
 */


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // TODO: Program starts from here
        // Create first assistant's account.
        System.out.println("Hey! you are first assistant of this school ... please complete your profile :");
        Scanner in = new Scanner(System.in);
        System.out.println("please Enter your username : ");
        String enteredUsername =  in.nextLine();
        System.out.println("please Enter your password : ");
        String enteredPassword =  in.nextLine();
        Assistant firstAssistant = new Assistant(enteredUsername,enteredPassword);
        System.out.println("Your Account is created! ... please log in first to use your credentials.");

        //Show start menu
        runMenu();

    }
    public static void runMenu() {
        // TODO: Menu will be shown here...
        while (true) {
            System.out.println("START MENU : ");
            System.out.println("1 - Assistants Sign up                   2 - Assistants Log in ");
            System.out.println("3 - Teachers Sign up                     4 - Teachers Log in ");
            System.out.println("5 - Students Sign up                     6 - Students Log in ");
            System.out.println("7 - Rate Teachers                        8 - Leave Comments For Teachers ");
            System.out.println("9 - View All Teachers                    10- View All Students ");
            System.out.println("11- View All Courses                     12- View Individual Student Profiles ");
            System.out.println("13- View Individual Course Information   14- Close program");
            System.out.println("Please choose a number : ");

            Scanner In = new Scanner(System.in);
            int enteredNumber = In.nextInt();

            switch (enteredNumber){


                case 1:
                    System.out.println("Only assistants can create a new assistant account!...Please log in to your assistant account first.");
                    break;



                case 2:
                    Scanner in2 = new Scanner(System.in);
                    System.out.println("please Enter your username : ");
                    String enteredAssistantUsername =  in2.nextLine();
                    System.out.println("please Enter your password : ");
                    String enteredAssistantPassword =  in2.nextLine();
                    if(Assistant.assistantLogin(enteredAssistantUsername,enteredAssistantPassword)){
                        Assistant currentUser = new Assistant(enteredAssistantUsername,enteredAssistantPassword);
                        currentUser.showDashboard();
                    }
                    else System.out.println("The username or password is not correct!");
                    break;



                case 3:
                    Scanner in3 = new Scanner(System.in);
                    System.out.println("please Enter your username : ");
                    String newTeacherUsername =  in3.nextLine();
                    System.out.println("please Enter your password : ");
                    String newTeacherPassword =  in3.nextLine();
                    if (Hogwarts.findTeacher(newTeacherUsername) == null){
                        if (!Assistant.newSignUpIsExisted(newTeacherUsername)){
                            if(Assistant.isAllowedSignUp(newTeacherUsername)){
                                new Teacher(newTeacherUsername,newTeacherPassword);
                                System.out.println("Your Account is created! ... please log in first to see your dashboard.");
                            }
                            else{
                                Assistant.addNewSignUps(newTeacherUsername);
                                System.out.println("This username added to the waiting list!...Please sign up after getting access!");
                            }
                        }else System.out.println("This teacher account is already in the waiting list!");
                    }else System.out.println("This teacher account is already existed!");
                    break;


                case 4:
                    Scanner in4 = new Scanner(System.in);
                    System.out.println("please Enter your username : ");
                    String enteredTeacherUsername =  in4.nextLine();
                    System.out.println("please Enter your password : ");
                    String enteredTeacherPassword =  in4.nextLine();
                    if(Teacher.teacherLogin(enteredTeacherUsername,enteredTeacherPassword)){
                        Student currentUser = new Student(enteredTeacherUsername,enteredTeacherPassword);
                        currentUser.showDashboard();
                    }
                    else System.out.println("The username or password is not correct!");
                    break;


                case 5:
                    Scanner in5 = new Scanner(System.in);
                    System.out.println("please Enter your username : ");
                    String newStudentUsername =  in5.nextLine();
                    System.out.println("please Enter your password : ");
                    String newStudentPassword =  in5.nextLine();
                    if (Hogwarts.findStudent(newStudentUsername) == null){
                        new Student(newStudentUsername,newStudentPassword);
                        System.out.println("Your Account is created! ... please log in first to see your dashboard.");
                    }
                    else System.out.println("This student account is already existed!");
                    break;


                case 6:
                    Scanner in6 = new Scanner(System.in);
                    System.out.println("please Enter your username : ");
                    String enteredStudentUsername =  in6.nextLine();
                    System.out.println("please Enter your password : ");
                    String enteredStudentPassword =  in6.nextLine();
                    if(Student.studentLogin(enteredStudentUsername,enteredStudentPassword)){
                        Student currentUser = new Student(enteredStudentUsername,enteredStudentPassword);
                        currentUser.showDashboard();
                    }
                    else System.out.println("The username or password is not correct!");
                    break;


                case 7:
                    Scanner in7 = new Scanner(System.in);
                    System.out.println("please Enter the name of the teacher you wanna rate : ");
                    String enteredTeacherName =  in7.nextLine();
                    if (Hogwarts.findTeacher(enteredTeacherName) != null){
                        Hogwarts.saveTeacherScore(Hogwarts.findTeacher(enteredTeacherName));
                    }
                    else System.out.println("There is not any teacher with this name!");
                    break;


                case 8:
                    Scanner in8 = new Scanner(System.in);
                    System.out.println("please Enter the name of the teacher you wanna leave comment for : ");
                    String TeacherName =  in8.nextLine();
                    if (Hogwarts.findTeacher(TeacherName) != null){
                        Hogwarts.saveTeacherComment(Hogwarts.findTeacher(TeacherName));
                    }
                    else System.out.println("There is not any teacher with this name!");
                    break;

                case 9:
                    System.out.println("These are all teachers :");
                    Hogwarts.viewAllTeachers();
                    break;


                case 10:
                    System.out.println("These are all students :");
                    Hogwarts.viewAllStudents();
                    break;


                case 11:
                    System.out.println("These are all courses :");
                    Hogwarts.viewAllCourses();
                    break;


                case 12:
                    Scanner in12 = new Scanner(System.in);
                    System.out.println("please Enter the name of student you wanna see the profile of : ");
                    String profileOfStudent =  in12.nextLine();
                    if (Hogwarts.findStudent(profileOfStudent) != null){
                        Hogwarts.studentProfile(profileOfStudent);
                    }
                    else System.out.println("This student is not existed!");
                    break;


                case 13:
                    Scanner in13 = new Scanner(System.in);
                    System.out.println("please Enter name of the course : ");
                    String courseName =  in13.nextLine();
                    if (Hogwarts.findCourse(courseName) != null){
                        System.out.println(Hogwarts.findCourse(courseName).toString());
                    }
                    else System.out.println("This course is not existed!");
                    break;


                default:break;
            }
            if (enteredNumber == 14) break;
        }
    }
}
