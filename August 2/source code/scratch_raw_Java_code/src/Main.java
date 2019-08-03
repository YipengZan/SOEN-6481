import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
//      arraylist for record history results
        double result;
        ArrayList<Double> rList = new ArrayList<Double>();
        Scanner sc = new Scanner(System.in);
//        press 'start' button to boot calculator
        System.out.println("please press 'start' button to boot calculator");
        String t = sc.next();
        if (t.equals("start")) {
            System.out.println("calculator is booted successfully...");
            while (true) {
                PIcal cal = new PIcal();
                double pai = cal.jishuPI();

//          shift mode option
                System.out.println("please press 'shift' button to switch to scientific mode, otherwise press any button else to enter regular mode");
                Scanner scan8 = new Scanner(System.in);
                String x = scan8.next();
//          user press shift button to enter scientific mode
                if (x.equals("shift")) {
                    System.out.println("calculator is successfully shifted to scientific mode....");
                    System.out.println("**********************************************************");
                    //          user press PI button to calculate PI number
                    System.out.println("press 'PI' button(case sensitive) to calculate PI number,\n" + "or press any button else to leave PI Calculation");
                    Scanner scan7 = new Scanner(System.in);
                    String pi = scan7.next();
                    if (pi.equals("PI")) {
//                       precision control
                        System.out.println("How many decimal digits do you want to retain?");
                        try {
                        Scanner scan10 = new Scanner(System.in);
                        int di = scan10.nextInt();

                        System.out.println("please select precision level from number\n" + "'1e-1' to '1e-15'\n" + "for your PI, otherwise highest precision level number '1e-15' is applied by default");
                        Scanner scan9 = new Scanner(System.in);
                            double f = scan9.nextDouble();
                            if (f == 1e-1 || f == 1e-2 || f == 1e-3 || f == 1e-4 || f == 1e-5
                                    || f == 1e-6 || f == 1e-7 || f == 1e-8 || f == 1e-9 || f == 1e-10
                                    || f == 1e-11 || f == 1e-12 || f == 1e-13 || f == 1e-14 || f == 1e-15) {
                                pai = cal.jishuPI(f);
                                BigDecimal bd = new BigDecimal(pai);
                                pai = bd.setScale(di, BigDecimal.ROUND_HALF_UP).doubleValue();
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("invalid input! default precision is applied now");
                        }
                        System.out.println("π =\n" + pai);
                    }

//              user press ccf button to calculate circular circumference
                    System.out.println("**********************************************************");
                    System.out.println("press 'ccf' button(case sensitive) to get circumference for your circular,\n" + "or press any button else to leave circumference calculation");
                    Scanner scan1 = new Scanner(System.in);
                    String a = scan1.next();
                    if (a.equals("ccf")) {
                        boolean flag = true;
                        double radi = 0;
                        while(flag) {
                            System.out.println("please input the radius of your circular?");
                            flag = false;
                            Scanner scan2 = new Scanner(System.in);
                            try {

                                radi = scan2.nextDouble();
                            } catch (InputMismatchException e) {
                                System.out.println("invalid input! please input number only...");
                                flag = true;
                            }
                        }
                        result = cal.circularCircumference(radi, pai);
                        System.out.println("circumference of this circular =\n" + result);
//                  record calculation result
                        if (rList.size() < 10) {
                            rList.add(result);
                        } else {
                            for (int i = 0; i < 9; i++) {
                                rList.add(i, rList.get(i + 1));
                            }
                            rList.add(result);
                        }
                    }

//              user press area button to calculate circular area
                    System.out.println("**********************************************************");
                    System.out.println("press 'area' button(case sensitive) to get area for your circular,\n" + "or press any button else to leave area calculation");
                    Scanner scan3 = new Scanner(System.in);
                    String b = scan3.next();
                    if (b.equals("area")) {
                            boolean flag = true;
                            double radi = 0;
                            while(flag) {
                                System.out.println("please input the radius of your circular?");

                                flag = false;
                                Scanner scan4 = new Scanner(System.in);
                                try {

                                    radi = scan4.nextDouble();
                                } catch (InputMismatchException e) {
                                    System.out.println("invalid input! please input number only...");
                                    flag = true;
                                }
                            }
                        result = cal.circularArea(radi, pai);
                        System.out.println("area of this circular  =\n" + result);

                        if (rList.size() < 10) {
                            rList.add(result);
                        } else {
                            rList.remove(0);
                            for (int i = 0; i < 9; i++) {
                                rList.add(i, rList.get(i + 1));
                            }
                            rList.add(result);
                        }
                    }

//              user press RC button to get historical resluts
                    System.out.println("**********************************************************");
                    System.out.println("Press 'RC' button(case sensitive) to see 10 historical calculation results,\n" + "or any button else to leave historical results recollection");
                    Scanner scan5 = new Scanner(System.in);
                    String c = scan5.next();
                    if (c.equals("RC")) {
                        if (rList.size() > 10) {
                            double[] arr = new double[10];
                            int indx = 0;
                            for (int idx = rList.size(); idx > rList.size() - 10; idx--) {
                                arr[indx] = rList.get(idx - 1);
                                indx++;
                            }
                            for (int i = arr.length; i > 0; i--) {
                                System.out.println(arr[i - 1]);
                            }
                        } else {
                            for (int idx = 0; idx < rList.size(); idx++) {
                                System.out.println(rList.get(idx));
                            }
                        }
                    }
                    System.out.println("**********************************************************");
                    System.out.println("Press 'end' button(case sensitive) to terminate calculation, or any button else to start another calculation");
                    Scanner scan6 = new Scanner(System.in);
                    String d = scan6.next();
                    if (d.equals("end")) {
                        System.out.println("Thank you for your participation!");
                        exit(0);
                    }
                } else {
//              user choose to use regular calculation
                    RegularCalculator regular = new RegularCalculator();
                    SwingConsole.run(regular, 250, 300);
                    System.out.println("**********************************************************");
                    System.out.println("Press 'end' button(case sensitive) or close calculator UI panel to terminate this calculation");
                    Scanner scan7 = new Scanner(System.in);
                    String d = scan7.next();
                    if (d.equals("end")) {
                        System.out.println("Thank you for your participation!");
                        exit(0);
                    } else {System.out.println("incorrectly input, calculator is re-initiating...");
                    }
                }
            }
        } else {
            System.out.println("You did not hit 'start' button correctly, boot failure, process is terminated...");
            exit(0);
        }


    }
}


