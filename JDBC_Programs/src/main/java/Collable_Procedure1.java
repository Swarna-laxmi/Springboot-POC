
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Collable_Procedure1
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        try(sc;)
        {
            try
            {
                System.out.println("Enter Account Number");
                Long accno=Long.parseLong(sc.nextLine());
                System.out.println("Enter Name");
                String name=sc.nextLine();
                System.out.println("Enter Balance");
                Float bal=Float.parseFloat(sc.nextLine());
                System.out.println("Enter Account type");
                String acctype=sc.nextLine();
                System.out.println("Enter City");
                String city=sc.nextLine();
                System.out.println("Enter State");
                String state =sc.nextLine();
                System.out.println("Enter Pincode");
                int pin=Integer.parseInt(sc.nextLine());
                System.out.println("Enter MailId");
                String mid=sc.nextLine();
                System.out.println("Enter phone numer");
                Long phn=Long.parseLong(sc.nextLine());

                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@(description= (retry_count=20)(retry_delay=3)(address=(protocol=tcps)(port=1521)(host=adb.us-sanjose-1.oraclecloud.com))(connect_data=(service_name=g469e49167f7d39_l3aezo9sbix8sdbu_low.adb.oraclecloud.com))(security=(ssl_server_dn_match=yes)))","admin","Swarna@786,.");
                CallableStatement cs=con.prepareCall("{call BankCustomer1(?,?,?,?,?,?,?,?,?)}");

                //loading data into procedure
                cs.setLong(1,accno);
                cs.setString(2,name);
                cs.setFloat(3,bal);
                cs.setString(4,acctype);
                cs.setString(5,city);
                cs.setString(6,state);
                cs.setInt(7,pin);
                cs.setString(8,mid);
                cs.setLong(9,phn);

                cs.execute();

                System.out.println("Cutomer Details added successfully");
                con.close();

            }
            catch(Exception e)
            {
                System.out.println(e.toString());
            }

        }
    }
}
