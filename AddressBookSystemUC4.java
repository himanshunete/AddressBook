import java.io.*; 
import java.util.*;
import java.util.HashMap;
import java.util.Map;

interface IContactDetails{
   public void addDetails(  String firstName,  String LastName,  String address,  String city ,  String state,  int zip,  int phoneNumber1,  int phoneNumber2 ,  String email );
}

class ContactDetails{
   public final String firstName;
   public final String lastName ;
   public final String address;
   public final String city ;
   public final String state ;
   public final int zip;
   public final int phoneNumber1 ;
   public final int phoneNumber2 ;

   public final String email ;



   public ContactDetails( String firstName,  String lastName,  String address,  String city ,  String state,  int zip,  int phoneNumber1 ,  int phoneNumber2,  String email ){
      this.firstName =  firstName;
      this.lastName = lastName ;
      this.address =  address;
      this.city =  city ;
      this.state =  state;
      this.zip =  zip;
      this.phoneNumber1 =  phoneNumber1;
      this.phoneNumber2 =  phoneNumber2;

      this.email = email;

   }

   public String toString(){
      return " Details of " + firstName + " "+ lastName + " are: \n" 
                            + "Address: "+ address + "\n"
                            + "City: "+ city   + "\n"
                            + "State:"+  state   + "\n"
                            + "Zip:"+ zip   + "\n"
                            + "Phone Number: "+  phoneNumber1 + phoneNumber2  + "\n"
                            + "Email:"+ email;
                                   
   }
}


public class AddressBookSystemUC4 implements IContactDetails {

   private int numOfPerson = 0;
   private ArrayList<ContactDetails> contactDetailsList;  
   private Map<String,ContactDetails> contactDetailsMap; 

   public AddressBookSystemUC4(){
      contactDetailsList = new  ArrayList<>();
      contactDetailsMap = new  HashMap<>() ;
      
   } 


   public void addDetails( String firstName,  String LastName,  String address,  String city ,  String state,  int zip,  int phoneNumber1,  int phoneNumber2 ,  String email ){
      ContactDetails contactDetails = new ContactDetails( firstName, LastName,  address,  city , state,  zip, phoneNumber1, phoneNumber2 ,  email ) ;
      contactDetailsList.add(  contactDetails );
      contactDetailsMap.put( firstName,  contactDetails );      
          

   }

   public void editDetails( String firstName,  String LastName,  String address,  String city ,  String state,  int zip,  int phoneNumber1,  int phoneNumber2 ,  String email){
      ContactDetails contactDetails = new ContactDetails( firstName, LastName,  address,  city , state,  zip, phoneNumber1, phoneNumber2 ,  email ) ;
      contactDetailsList.set( 0, contactDetails );
      contactDetailsMap.replace( firstName,  contactDetails );


   }



   private void computeDetails(){
      for (int i=0; i< contactDetailsList.size(); i++ ){
         ContactDetails contactDetails = contactDetailsList.get(i);
         System.out.println( contactDetails);
         System.out.println( "  " );

      }
      


   }



   public static void main(String[] args){

      AddressBookSystemUC4 contct = new  AddressBookSystemUC4() ;
         contct.addDetails( "Himshu", " Nete " ,  " ldikr lyout ",  " Pune ",  " Maharashtra ", 440024,  88059, 56103, " himanshuneteh@gmail.com ");
         contct.addDetails( " Rock ", " Johnson ",  " 23, Baker Street ",  " LA ",  " California ",  440011, 88011, 56102 , " rock@gmail.com ");
         contct.addDetails( " Rahul ", " Singh ",  " Naik Nagar ",  " Mumbai ",  " Maharashtra ", 440017, 88060 , 11103, " rahulsingh@gmail.com ");
         contct.computeDetails() ;

         contct.editDetails( "Himshu", " Nete " ,  " ldikr lyout ",  " Nagpur ",  " Maharashtra ", 440024,  88059, 56103, " himanshuneteh@gmail.com ");
         contct.computeDetails() ;
      

   }

}
