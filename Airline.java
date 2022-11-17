package sqlconnectivity;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Airline {

	public static void main(String[] args) throws ClassNotFoundException {
		try {
			Scanner s=new Scanner(System.in); 
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection c =DriverManager.getConnection("jdbc:mysql://localhost:3306/ksk","root","root");
			Statement st=c.createStatement(); 
			ResultSet r;
			while(true) {
				System.out.println("Enter 0 to exit "); 
				System.out.println("Enter 1 to display Airline details "); 
				System.out.println("Enter 2 to insert a record "); 
				System.out.println("Enter 3 to delete a record "); 
				System.out.println("Enter 4 to update a record ");
				String s1=s.nextLine();
				if(s1.equals("0")) 
					
					break;
				else if(s1.equals("1")) {
					System.out.println("Enter 1 to display all records , 2 to display particular record");
					String s0=s.nextLine();
					if(s0.equals("1")) { 
						r=st.executeQuery("select * from Airline "); 
						while(r.next()) {	
							System.out.println("Passenger Name : "+r.getString(1)+" "+"Flight Name : "+r.getString(2)+" Source : "+r.getString(3)+" Destination : "+r.getString(4)+" Seat Number: "+r.getString(5));
						}
					}
					else if(s0.equals("2")) {
						System.out.println("Enter Seat Number to display the details: "); 
						String s9=s.nextLine();
						r=st.executeQuery("select * from Airline where Seat_Number='"+s9+"'");
						while(r.next()) {
							System.out.println("Passenger Name : "+r.getString(1)+" "+"Flight Name : "+r.getString(2)+" Source : "+r.getString(3)+" Destination : "+r.getString(4)+" Seat Number: "+r.getString(5));
						}
					}
					else
						System.out.println("Enter valid input");
				}
				else if(s1.equals("2")) { 
					System.out.println("Enter Passenger Name : "); 
					String s2=s.nextLine(); 
					System.out.println("Enter Flight Name : "); 
					String s3=s.nextLine(); 
					System.out.println("Enter Source : "); 
					String s4=s.nextLine(); 
					System.out.println("Enter Destination : ");
					String s5=s.nextLine(); 
					System.out.println("Enter Seat Number : "); 
					String s6=s.nextLine(); 
					st.executeUpdate("insert into Airline values('"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"')");
					System.out.println("Values inserted successfully !");
				}
				else if(s1.equals("3")) {
					System.out.println("Enter the Seat Number to delete : "); 
					String s7=s.nextLine();
					st.executeUpdate("delete from Airline where Seat_Number='"+s7+"'"); 
					System.out.println("Record deleted successfully !");
				}
				else if(s1.equals("4")) {
					System.out.println("Enter Seat Number to update "); 
					String s10=s.nextLine();
					System.out.println("Enter column to update(Passenger Name,Flight Name,Source,Destination,Seat Number)");
					String s8=s.nextLine(); 
					String s9=null; 
					if(s8.equals("Seat Number")) {
						System.out.println("Enter new Seat Number :"); 
						s9=s.nextLine();
						st.executeUpdate("update Airline set Seat_Number='"+s9+"' where Seat_Number='"+s10+"'");
						System.out.println("SeatNumber  updated successfully");
					}
					else if(s8.equals("Passenger Name")) { 
						System.out.println("Enter new Passenger Name :"); 
						s9=s.nextLine();
						st.executeUpdate("update Airline set Passenger_Name='"+s9+"'where Seat_Number='"+s10+"'");
						System.out.println("Passenger Name  updated successfully");
					}
					else if(s8.equals("Flight Name")) { 
						System.out.println("Enter new Flight Name :"); 
						s9=s.nextLine();
						st.executeUpdate("update Airline set Flight_Name='"+s9+"' where Seat_Number='"+s10+"'");
						System.out.println("FlightName  updated successfully");
					}
					else
						System.out.println("Enter valid input");
				}
				else
					System.out.println("Enter valid input ");
				}
				s.close();
			}
		catch(Exception e) { 
			System.out.println(e);
		}

	}

}
