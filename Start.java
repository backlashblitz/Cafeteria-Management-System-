import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.*;
import java.util.*;

public class Start {

    public static void main(String args[]) {
        CanteenManagement cm = new CanteenManagement();
        FileReadnWrite createUser = new FileReadnWrite();
        boolean choice = true;
        Scanner sc = new Scanner(System.in);		//created an object reference of Scanner class
        Scanner sc2 = new Scanner(System.in);
        Scanner reader = new Scanner(System.in);
        Student s = new Student();			//created an object reference of child class
        AutomatedFoodandBraverage afb = new AutomatedFoodandBraverage();		//created an object reference of an associated class of the child class
        FileReadnWrite frw = new FileReadnWrite();		//created an object reference of an IO class

        while (choice) {
            System.out.println("Welcome to EWU Automated Food & Braverage Service!\n");
            System.out.println("1. Read Terms And Condition.");
            System.out.println("2. Student Registration Or Login.");
            System.out.println("3. EWU Automated Food & Braverage Service: ");
            System.out.println("4. Items Management service: ");
            System.out.println("5. Show All Registered Students				");
            System.out.println("6. EXIT\n");

            int first = 0;		//expected ineger values
            boolean t1 = false;

            while (!t1) //while loop when true
            {
                try //if user is not inputing an integer
                {
                    System.out.print("	Please Select An Option: ");
                    first = sc.nextInt();
                    t1 = true;
                } catch (InputMismatchException e) //found runtime exception : InputMismatchException
                {
                    String str1 = sc.nextLine();
                    System.out.println("	Invaild Input!\n");
                }
            }
            switch (first) {
                case 1:
                    FileReadnWrite term = new FileReadnWrite();
                    term.termsCondition();
                    break;

                case 2:
                    System.out.println("Welcome to Student Registration Or Login. \n");
                    System.out.println("1. Register New Student.");
                    System.out.println("2. Login Student.");
                    System.out.println("3. Cancel Registration.");
                    System.out.println("4. Back.\n");
                    int second = 0;
                    boolean t2 = false;
                    while (!t2)
					try {
                        System.out.print("Please Select An Option: ");
                        second = sc.nextInt();
                        t2 = true;
                    } catch (InputMismatchException e) {
                        String str2 = sc.nextLine();
                        System.out.println("Invaild Input!\n");
                    }

                    switch (second) {
                        case 1:
                            System.out.println("Provide Student Information To Register.\n");

                            createUser.createAccount(s);

                            FileReadnWrite StuInf = new FileReadnWrite();
                            StuInf.writeInFile(s.getName(),s);
                            StuInf.writeInFile(s.getId(),s);
                            StuInf.writeInFile(s.getPassword(),s);
                            afb.insertStudent(s);
                            afb.getStudent(s.getId());
                            afb.showAllStudents();
                            break;

                        case 2:
                            System.out.print("Enter Student Name: ");
                            String name = sc.next();
                            System.out.print("Enter Password: ");
                            String p = sc.next();
                            createUser.login(name,p);
                            break;

                        case 3:
                            System.out.print("Enter Student ID: ");
                            String id = sc.next();
                            afb.removeStudent(afb.getStudent(id));
                            System.out.println("Mr. " + s.getName() + " Has Cancelled His Registration.\n");
                            System.out.println("The Remaining Balance " + s.getBalance() + "TK Will Be Adjusted During Next Semester Course Registration.\n");
                            break;

                        default:
                            System.out.println("Invalid Input.");
                            break;
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    String id = sc.next();
                    System.out.print("Enter Student name: ");
                    String name = sc.next();
                    System.out.print("Enter Password: ");
                    String p = sc.next();
                    if (createUser.login(name,p)==true) {
                        String id1 = s.getId();
                        String p1 = s.getPassword();		//as child class has inherited the only abstract class
                        int b1 = s.getBalance();
                        System.out.println("Food & Braverage Menu:\n");
                        System.out.println("1. Breakfast Items.");
                        System.out.println("2. Lunch Items.");
                        System.out.println("3. Braverage Items.");
                        System.out.println("4. Balance Information.");
                        System.out.println("5. View Transaction Histrory.");
                        System.out.println("6. Back.\n");
                        int third = 0;
                        boolean t3 = false;
                        while (!t3)
                            try {
                                System.out.print("Please Select An Option: ");
                                third = sc.nextInt();
                                t3 = true;
                            }catch (InputMismatchException e) {
                                    String str3 = sc.nextLine();
                                    System.out.println("Invaild Input!\n");
                                }

                                switch (third) {
                                    case 1:
                                        System.out.println("You Have Chosen Breakfast Items. \n");
                                        System.out.println("1. Shingara.(5tk)");
                                        System.out.println("2. Cream Bread.(10tk)");
                                        System.out.println("3. Back.\n");
                                        int bfi = 0;
                                        boolean t4 = false;
                                        while (!t4)
										try {
                                            System.out.print("Please Select An Option: ");
                                            bfi = sc.nextInt();
                                            t4 = true;
                                            System.out.print("Please select Quantity: ");
                                            cm.quantity = sc.nextInt();

                                        } catch (InputMismatchException e) {
                                            String str4 = sc.nextLine();
                                            System.out.println("Invaild Input!\n");
                                        }

                                        if (bfi == 1) {
                                            cm.singara -= cm.quantity;
                                            afb.getStudent(id1).buyAnItem(5 * cm.quantity);
                                            frw.writeInFile("Deducted " + 5 * cm.quantity + "TK for Buying" + cm.quantity + " Singara from: " + id,s);
                                            System.out.println("Please collect your Singara.\n");
                                        } else if (bfi == 2) {
                                            cm.bread -= cm.quantity;
                                            afb.getStudent(id1).buyAnItem(10 * cm.quantity);
                                            frw.writeInFile("Deducted " + 10 * cm.quantity + "TK for Buying" + cm.quantity + " Cream Bread from: " + id,s);
                                            System.out.println("Please collect your Cream Bread.\n");
                                        } else if (bfi == 3) {
                                            continue;
                                        } else {
                                            System.out.println("Please Enter Correct Option!\n");
                                        }
                                        break;

                                    case 2:
                                        System.out.print("You Have Chosen Lunch Items. \n");
                                        System.out.println("1. Plain Rice with Chicken Curry.(60tk)");
                                        System.out.println("2. Plain Rice with Fish Curry.(60tk)");
                                        System.out.println("3. Chicken Biriani.(70tk)");
                                        System.out.println("4. Egg Fried Rice with Fried Chicken.(80tk)");
                                        System.out.println("5. Back.\n");
                                        int li = 0;
                                        boolean t5 = false;
                                        while (!t5)
										try {
                                            System.out.print("Please Select An Option: ");
                                            li = sc.nextInt();
                                            t5 = true;
                                        } catch (InputMismatchException e) {
                                            String str5 = sc.nextLine();
                                            System.out.println("Invaild Input!\n");
                                        }

                                        if (li == 1) {
                                            afb.getStudent(id1).buyAnItem(60);
                                            frw.writeInFile("Deducted " + 60 + "TK for Buying Plain Rice with Chicken Curry from: " + id,s);
                                            System.out.println("Please collect your Plain Rice with Chicken Curry.\n");
                                        } else if (li == 2) {
                                            afb.getStudent(id1).buyAnItem(60);
                                            frw.writeInFile("Deducted " + 60 + "TK for Buying Plain Rice with Fish Curry from: " + id,s);
                                            System.out.println("Please collect your Plain Rice with Fish Curry.\n");
                                        } else if (li == 3) {
                                            afb.getStudent(id1).buyAnItem(70);
                                            frw.writeInFile("Deducted " + 70 + "TK for Buying Chicken Biriani from: " + id,s);
                                            System.out.println("Please collect your Chicken Biriani.\n");
                                        } else if (li == 4) {
                                            afb.getStudent(id1).buyAnItem(80);
                                            frw.writeInFile("Deducted " + 80 + "TK for Egg Fried Rice with Fried Chicken from: " + id,s);
                                            System.out.println("Please collect your Egg Fried Rice with Fried Chicken.\n");
                                        } else if (li == 5) {
                                            break;
                                        } else {
                                            System.out.println("Please Enter Correct Option!");
                                        }
                                        System.out.println("");
                                        break;

                                    case 3:
                                        System.out.println("You Have Chosen beverage items.\n");
                                        System.out.println("1. Water.(15tk)");
                                        System.out.println("2. CocaCola.(20tk)");
                                        System.out.println("3. Back.\n");
                                        int bi = 0;
                                        boolean t6 = false;
                                        while (!t6)
										try {
                                            System.out.print("Please Select An Option: ");
                                            bi = sc.nextInt();
                                            t6 = true;
                                            System.out.print("Please select Quantity: ");
                                            cm.quantity = sc.nextInt();
                                        } catch (InputMismatchException e) {
                                            String str6 = sc.nextLine();
                                            System.out.println("Invaild Input!\n");
                                        }

                                        if (bi == 1) {
                                            cm.water -= cm.quantity;
                                            afb.getStudent(id1).buyAnItem(15 * cm.quantity);
                                            frw.writeInFile("Deducted " + 15 * cm.quantity + "TK for buying" + cm.quantity + " Water from: " + id,s);
                                            System.out.println("Please collect your Water.\n");
                                        } else if (bi == 2) {
                                            cm.drinks -= cm.quantity;
                                            afb.getStudent(id1).buyAnItem(20 * cm.quantity);
                                            frw.writeInFile("Deducted " + 20 * cm.quantity + "TK for buying" + cm.quantity + " CocaCola from: " + id,s);
                                            System.out.println("Please collect your CocaCola.\n");
                                        } else if (bi == 3) {
                                            break;
                                        } else {
                                            System.out.println("Please Enter Correct Option!");
                                        }
                                        System.out.println("");
                                        break;

                                    case 4:
                                        System.out.println("You Chose Balance Information.\n");
                                        System.out.println("1. Check Your Current Balance.");
                                        System.out.println("2. Request For Credit.\n");
                                        int bic = 0;
                                        boolean t7 = false;
                                        while (!t7)
										try {
                                            System.out.print("Please Select An Option: ");
                                            bic = sc.nextInt();
                                            t7 = true;
                                        } catch (InputMismatchException e) {
                                            String str7 = sc.nextLine();
                                            System.out.println("Invaild Input!\n");
                                        }

                                        if (bic == 1) {
                                            System.out.println("Your Current Balance is: " + afb.getStudent(id1).getBalance() + "TK");
                                        } else if (bic == 2) {
                                            afb.getStudent(id1).addMoney(500);
                                        } else {
                                            System.out.println("Invalid Input.");
                                        }
                                        break;

                                    case 5:
                                        frw.readFromFile();
                                        break;

                                    case 6:
                                        System.out.println("Have a nice day!");
                                        break;

                                    default:
                                        System.out.println("Invalid Input");
                                        break;
                                }
                            }
                    else {
                        System.out.println("Please Register to EWU Automated Food & Braverage Service First!\n");
                    }
                    break;
                case 4:
                    System.out.println("Welcome to Food items management.\n");
                    System.out.println("1. Add Items");
                    System.out.println("2. Show Available Items");
                    System.out.println("3. Back.\n");
                    int fourth = 0;
                    boolean t8 = false;
                    while (!t8)
					try {
                        System.out.print("Please Select An Option: ");
                        fourth = sc.nextInt();
                        t8 = true;
                    } catch (InputMismatchException e) {
                        String str8 = sc.nextLine();
                        System.out.println("Invaild Input!\n");
                    }
                    switch (fourth) {
                        case 1:
                            System.out.println("Select quantity: ");
                            int q = sc.nextInt();

                            cm.addItems(q);
                            break;
                        case 2:
                            cm.displayLeft();
                            break;
                        default:
                            System.out.println("Invalid input");
                    }break;

                case 5:
                    System.out.println("This Students registered the Service ");
                    afb.showAllStudents();
                    break;

                case 6:
                    System.out.println("Thank you for Using EWU Food & Braverage Service!\n");
                    System.exit(0);

                default:
                    System.out.println("Invalid Input!\n");
                    break;
            }
        }
    }
}
