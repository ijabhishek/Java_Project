/* In this Code there are three tenant there names are like Amit, Abhishek, Mirtunjay
 * I got to type of bills 1. electricity bill  2. water bill
 * Motar bill and other EXpense will be vary to amount.
 * 
 * In the end we can find per person bill amount.
 * Let's try!
 * 
 * Please let me know if we can make it more easy .....Thank you
 * 
 * Easy ...
 * ---------------------Have fun -----------------Have a great day----------------------------
*/


import java.util.Scanner;

public class ebill_projcet {
    public static void main(String[] args) {

        try {

            Scanner input = new Scanner(System.in);
            System.out.println("Enter your Electricity bill amount: ");
            float ebill = input.nextFloat();

            System.out.println("Enter your water bill amount: ");
            float wbill = input.nextFloat();

            System.out.println("Enter your other expenses: ");
            float oexp = input.nextFloat();

            System.out.println("Enter Amit's bill reading: ");
            float amit_br = input.nextFloat();

            System.out.println("Enter Mirtunjay's bill reading: ");
            float mirtunjay_br = input.nextFloat();

            System.out.println("Enter Abhishek's bill reading: ");
            float abhishek_br= input.nextFloat();

            System.out.println("Enter Motar's bill reading: ");
            float motar_br= input.nextFloat();


            float avg_bill_amt = ebill/(amit_br + mirtunjay_br + abhishek_br + motar_br);
            float motar_bill_pr_person = (avg_bill_amt * motar_br)/3;

            float amit_bill_amount = (amit_br*avg_bill_amt) + (wbill/3) + (oexp/3) + motar_bill_pr_person;
            float mirtunjay_bill_amount = (mirtunjay_br*avg_bill_amt) + (wbill/3) + (oexp/3) + motar_bill_pr_person;
            float abhishek_bill_amount = (abhishek_br*avg_bill_amt) + (wbill/3) + (oexp/3) + motar_bill_pr_person;


            System.out.println("Amit's bill Amount is: " +amit_bill_amount);
            System.out.println("Mirtunjay's bill Amount is: " +mirtunjay_bill_amount);
            System.out.println("Abhishek's bill Amount is: " +abhishek_bill_amount);


        } catch(Exception e) {
            System.out.println("Smothing went worng!");

        }



    }

}