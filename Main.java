/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BankingSystem;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Main {
    //private static int AccountNumber;

    /**
     * 
     */
    public static void main(String[] args) throws IOException   {

        Main_Menu();
        // TODO code application logic here
    }

    public static void Main_Menu(){

       System.out.println("===== WELCOME =====");
       System.out.println("        TO        ");
       System.out.println("    THE TTC BANK   ");
       System.out.println("");
       System.out.println("Main Menu");
       System.out.println("");
       System.out.println("1. Create a New Account");
       System.out.println("2. Edit a Customer");
       System.out.println("3. Account Balance");
       System.out.println("4. Deposit Money");
       System.out.println("5. Withdraw Money");
       System.out.println("6. Fund Transfer");
       System.out.println("7. Exit");
       System.out.println("");
       System.out.println("Enter The Choise");

       try {
            InputStreamReader a = new InputStreamReader(System.in);
            BufferedReader bf = new BufferedReader(a);
            String foo = bf.readLine();

            int userEntered = Integer.parseInt(foo);

            switch (userEntered){

                case 1: Create_Account();
                    break;
                case 2: Edit_Customer();
                    break;
                case 3: Account_Balance();
                    break;
                case 4: Deposit_Money();
                    break;
                case 5: Withdraw_Money();
                    break;
                case 6: Fund_Transfer();
                    break;
                case 7: Exit();
                    break;
                default: Main_Menu();
                    break;
               }
            }

        catch (IOException e) {
           
         }

        }


    public static void Create_Account() throws IOException  {
            int AccountNumber = 0;
            //while(AccountNumber<= 10){
            int Accno = AccountNumber;
            //AccountNumber=Accno;



            Scanner bf = new Scanner(System.in);
            System.out.println("Please enter the Nic Number of the member: ");
            String nic = bf.nextLine();
            System.out.println("");
            //int Accno = AccountNumber;
            System.out.println("Please enter account type : ");
            String AccType = bf.nextLine();
            System.out.println("Please enter the Name of the member: ");
            String name = bf.nextLine();
            System.out.println("");
            System.out.println("Please enter the Address of the member: ");
            String address = bf.nextLine();
            System.out.println("");
            System.out.println("Please enter the Telephone number of the member: ");
            String tp = bf.nextLine();
            String tp1 = tp.toString();
            String Date = getDate();
            System.out.println("Please enter the initial amount to be deposited: ");
            String Bal = bf.nextLine();
            double Balance = Double.parseDouble(Bal);
            Customer ff = new Customer(nic,AccType,name,address,tp1);
            ff.writeToFile();
            String Nic1 = nic;
            Account hh = new Account(Nic1,Accno,AccType,Date,Balance);
                
            hh.writeToFile();
            System.out.println("Member is added successfully");
            hh.Update_AcNumbers(1);
              

            try {
                                 
                FileInputStream in = new FileInputStream ("D:\\BankingSystem\\Account\\AccountNumbers.txt");
                FileOutputStream out = new FileOutputStream ("D:\\BankingSystem\\Account\\AccountNumbers.txt");

                int c = in.read();
                Accno = c + Accno;
                out.write(Accno);
                AccountNumber += 1;

                in.close();
                out.close();
                  //System.out.println(c);

//                ObjectInputStream out = new ObjectInputStream (in);
//                hh = (Account)out.readObject();
                }
              
           
            finally {
            
            }

            System.out.println("");
            System.out.println("");
            System.out.println("");

            Main_Menu();
            
            //System.out.print("Please enter the Date Joint: ");
            //String datej = bf.readLine();
            //System.out.println("");
            //System.out.print("Has member payed the registartion fee(Y/N): ");
            //String fee = bf.readLine();
            //System.out.println("");
            //Accountt NewMember = new Accountt (name,nic,address,Integer.parseInt(tele),datej);
            //NewMember.writeToFile();
            
//            AccountCount AccountNumber1 = new AccountCount();
//            int AcNumber = AccountNumber1.AccountNumber();
//
//            String Count =Integer.toString(AcNumber);
//
//            AccountNumber1.updateAcCnt(Count);
            String date = getDate();

  

    }

   public static void Edit_Customer(){

     }


    public static void Account_Balance(){

    }





     public static void Deposit_Money(){

        //double Amount = 0;
        //double Balance = 0;
        try {
            InputStreamReader a = new InputStreamReader(System.in);
            BufferedReader bf = new BufferedReader(a);
            System.out.println("Enter the Acoount Number");
            String foo = bf.readLine();
            Account deposit = new Account(foo);

            System.out.println("Enter the Diposit Amount");
            String Amt = bf.readLine();
            double Amount = Double.parseDouble(Amt);
            String Bal = deposit.getBalance();
            double Balance = Double.parseDouble(Bal);

            Balance += Amount;
            
            String NewBalance = String.valueOf(Bal);
            deposit.setBalance(NewBalance);

            System.out.println("The New Balance is" + NewBalance );

           

        }
        catch (IOException e) {
          
        }
     }






     public static void Withdraw_Money(){
//        double Balance = 0;
//        double Amount = 0;
        try {
            InputStreamReader a = new InputStreamReader(System.in);
            BufferedReader bf = new BufferedReader(a);
            System.out.println("Enter the Acoount Number");
            String foo = bf.readLine();
            Account Withdraw = new Account(foo);
            
            System.out.println("Enter the Withdraw Amount");
            String Amt = bf.readLine();
            double Amount = Double.parseDouble(Amt);
            String Bal = Withdraw.getBalance();
            double Balance = Double.parseDouble(Bal);


            if (Balance > Amount) {
                Balance -= Amount;
                String NewBalance = String.valueOf(Balance);
                Withdraw.setBalance(NewBalance);
                System.out.println("The New Balance is" + NewBalance );
            }
            
            else
                System.out.println("Insufficient funds");
            }

            catch (IOException e) {
                
            }

       }





     public static void Fund_Transfer(){

        try {
            InputStreamReader a = new InputStreamReader(System.in);
            BufferedReader bf = new BufferedReader(a);
            System.out.println("Enter the Acoount Number");
            String mb = bf.readLine();
            Account FundTransfer1 = new Account(mb);
            
            System.out.println("Enter the Acoount Number you want to Transfer money");
            String fee = bf.readLine();
            
            System.out.println("Enter the Amount you want to Transfer");
            String Amt = bf.readLine();
            double Amount = Double.parseDouble(Amt);
            String TransBalance1 = FundTransfer1.getBalance();
            double Balance1 = Double.parseDouble(TransBalance1);


            if (Balance1 > Amount) {
                Balance1 -= Amount;
                String NewBalance1 = String.valueOf(Balance1);
                FundTransfer1.setBalance(NewBalance1);
                System.out.println("The New Balance is" + NewBalance1 );

                Account FundTransfer2 = new Account(fee);
                String TransBalance2 = FundTransfer2.getBalance();
                
                double Balance2 = Double.parseDouble(TransBalance2);
                Balance2 += Amount;
                String NewBalance2 = String.valueOf(Balance2);
                FundTransfer2.setBalance(NewBalance2);
                System.out.println("The New Balance of Transferred Account is" + NewBalance2);
      
            }
            
            else  {
                System.out.println("Insufficient funds");
                System.out.println("");
                System.out.println("Do you want to do the fund Transfer again?");
                System.out.println("");
                System.out.println("");
                System.out.println("1. To continue");
                System.out.println("2. To Exit");
                String lo = bf.readLine();

                int userEntered = Integer.parseInt(lo);

                switch (userEntered){

                case 1: Fund_Transfer();;
                    break;
                case 2: Exit();
                    break;

            }
            }
         }
            catch (IOException e) {
                
            }
         
     }


public static void WriteToFile()throws IOException{

}

    

       

     public static void Exit(){
     Main_Menu();
     }

   

   

    private static String getDate() {
        Calendar date =Calendar.getInstance();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy.MM.dd");
        Calendar yearBack=(Calendar) date.clone();
        String year=dateFormat.format(yearBack.getTime());
        return year;

    }





}
