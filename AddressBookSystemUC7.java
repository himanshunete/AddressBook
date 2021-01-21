import java.io.*; 
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.util.Scanner;

interface IContactDetails{
   public void addDetails(  String addressBook, String firstName,  String lastName,  String address,  String city ,  String state,  int zip,  int phoneNumber1,  int phoneNumber2 ,  String email );
}



class ContactDetails {
   public final String firstName;
   public final String lastName ;
   public final String address;
   public final String city ;
   public final String state ;
   public final int zip;
   public final int phoneNumber1 ;
   public final int phoneNumber2 ;
   public final String email ;
   public final String addressBook ;


   public ContactDetails( String addressBook, String firstName,  String lastName,  String address,  String city ,  String state,  int zip,  int phoneNumber1 ,  int phoneNumber2,  String email ){
      this.firstName =  firstName;
      this.lastName = lastName ;
      this.address =  address;
      this.city =  city ;
      this.state =  state;
      this.zip =  zip;
      this.phoneNumber1 =  phoneNumber1;
      this.phoneNumber2 =  phoneNumber2;
      this.email = email;
      this.addressBook = addressBook ;
   }

   public String toString(){
      return  " Details of "+ firstName + " "+ lastName + " are: \n" 
                            + "Address: "+ address  +",  City: "+ city  + ",  State:"+  state   + "\n"
                            + "Zip:"+ zip + ",  Phone Number: "+  phoneNumber1 + phoneNumber2 + "\n"
                            + "Email:"+ email + " \n";
         
   }
}


public class AddressBookSystemUC7 implements IContactDetails {

   private int numOfPerson = 0;
   private ArrayList<ContactDetails> contactDetailsList;  
   private Map<String,ContactDetails> contactDetailsMap;
   private ArrayList<  ArrayList<ContactDetails> >  multipleAddressBookList ;
   private Map<String, Map<String,ContactDetails>>  multipleAddressBookMap  ;

   public AddressBookSystemUC7() {
      contactDetailsList = new  ArrayList<ContactDetails>();
      contactDetailsMap = new  HashMap<String, ContactDetails>() ;
      multipleAddressBookList = new ArrayList<  ArrayList<ContactDetails> >() ;
      multipleAddressBookMap = new HashMap<String, Map<String,ContactDetails>>() ;
   }

   public void addDetails( String addressBook, String firstName,  String lastName,  String address,  String city ,  String state,  int zip,  int phoneNumber1,  int phoneNumber2 ,  String email ) {
      ContactDetails contactDetails = new ContactDetails( addressBook, firstName, lastName,  address,  city , state,  zip, phoneNumber1, phoneNumber2 ,  email ) ;
      
      contactDetailsList.add(  contactDetails );
      contactDetailsMap.put( firstName,  contactDetails );
      multipleAddressBookList.add( contactDetailsList );
      multipleAddressBookMap.put( addressBook, contactDetailsMap );

   }

   
   public void addMoreDetails( String addressBook, String firstName,  String lastName,  String address,  String city ,  String state,  int zip,  int phoneNumber1,  int phoneNumber2 ,  String email ){
      ContactDetails contactDetails = new ContactDetails( addressBook, firstName, lastName,  address,  city , state,  zip, phoneNumber1, phoneNumber2 ,  email ) ;
      Collections.addAll(contactDetailsList, contactDetails);
   }

   public void editDetails( String addressBook, String firstName,  String lastName,  String address,  String city ,  String state,  int zip,  int phoneNumber1,  int phoneNumber2 ,  String email){
      ContactDetails contactDetails = new ContactDetails( addressBook, firstName, lastName,  address,  city , state,  zip, phoneNumber1, phoneNumber2 ,  email ) ;
      contactDetailsList.set( 0, contactDetails );


   }
   
   
   public void deleteDetails( String addressBook, String firstName,  String lastName,  String address,  String city ,  String state,  int zip,  int phoneNumber1,  int phoneNumber2 ,  String email){
      ContactDetails contactDetails = new ContactDetails(  addressBook, firstName, lastName,  address,  city , state,  zip, phoneNumber1, phoneNumber2 ,  email ) ;
      contactDetailsList.remove( 2 );
      contactDetailsMap.remove( firstName );


   }




   private void computeDetails(){
      for( int j=0; j< contactDetailsList.size(); j++ ){
        ContactDetails contactDetails = contactDetailsList.get(j);
        System.out.println( "  " );
       }
       System.out.println(" Address Book: ");
       System.out.println(multipleAddressBookMap) ;

   }

   public static void main(String[] args){
      Scanner scn = new Scanner(System.in);     
      String firstName = scn.nextLine();
      String lastName  = scn.nextLine();
      String address  = scn.nextLine();
      String city  = scn.nextLine();
      String state  = scn.nextLine();
      String email  = scn.nextLine();
      String addressBook = scn.nextLine();

      int zip  = scn.nextInt();
      int phoneNumber1  = scn.nextInt();
      int phoneNumber2  = scn.nextInt();






      AddressBookSystemUC7 cricketersDetails = new  AddressBookSystemUC7() ;
      AddressBookSystemUC7 footballersDetails =new  AddressBookSystemUC7() ;
      AddressBookSystemUC7 hockeyplayersDetails =new  AddressBookSystemUC7() ;
      AddressBookSystemUC7 basketballplayersDetails =new  AddressBookSystemUC7() ;

      

      cricketersDetails.addDetails( "Cricket AddBook","Virat", " Kohli " ,  " ldikr lyout ",  " Mumbai ",  " Maharashtra ", 440024,  88059, 56103, " kohli@gmail.com ");
      cricketersDetails.addDetails( "Cricket AddBook"," MS ", " Dhoni ",  " Gulmohr Chowk ",  " Ranchi ",  " Jharkhand ",  440011, 88011, 56102 , " dhoni@gmail.com ");
      cricketersDetails.addDetails( "Cricket AddBook" ,"KL ", " Rahul ",  " Parker Bay ",  " Banglore ",  " Karnataka ", 440017, 88060 , 11103, " rahul@gmail.com ");
      cricketersDetails.computeDetails() ;
      cricketersDetails.deleteDetails( "Cricket AddBook" ,"KL ", " Rahul ",  " Parker Bay ",  " Banglore ",  " Karnataka ", 440017, 88060 , 11103, " rahul@gmail.com ");
      cricketersDetails.computeDetails() ;
      



      footballersDetails.addDetails( "Footbll AddBook","Cristiano", " Ronaldo " ,  " 25, pastino street ",  " Tiego ",  " Portugal ", 234567,  56789, 14567, " ronaldo@gmail.com ");
      footballersDetails.addDetails( "Footbll AddBook"," Leonel ", " Messi ",  " Harbour Street ",  " Lospito ",  " Argentina ",  567456, 54678, 87956 , " messi@gmail.com ");
      footballersDetails.addDetails( "Footbll AddBook" ,"Netmar ", " Junior ",  " statue of Damer ",  " Rio ",  " Brazil ", 78656, 53756 , 23734, " neymar@gmail.com ");
      footballersDetails.computeDetails();

      hockeyplayersDetails.addDetails( "Hockey AddBook","Sandeep", " Singh " ,  " vasant nagar ",  " Chandigarh ",  " Punjab ", 440056,  92345, 13534, " sandeep@gmail.com ");
      hockeyplayersDetails.addDetails( "Hockey AddBook"," Major ", " Dhyanchand ",  " 23, balor park ",  " Banglore ",  " Karnataka ",  440007, 95478, 75467 , " dhyanchand@gmail.com ");
      hockeyplayersDetails.addDetails( "Hockey AddBook" ,"Balbir ", " Singh Senior ",  " Rorgunj ",  " Patiala ",  " Punjab ", 440079, 97157 , 47845, " balbir@gmail.com ");
      hockeyplayersDetails.computeDetails() ;

   
      basketballplayersDetails.addDetails( "Bsketbll AddBook"," Cobe", " Bryant " ,  " Polar Street ",  " LA ",  " California ", 237674 , 53890, 15678, " cobe@gmail.com ");
      basketballplayersDetails.addDetails( "Bsketbll AddBook"," Shack ", " O'Neil ",  " 23, Baker Street ",  " LA ",  " California ",  546783, 53456, 67343 , " shck@gmail.com ");
      basketballplayersDetails.addDetails( "Bsketbll AddBook" ,"Michael ", " Jordan ",  " Blakers ",  " LA ",  " Clifornia ", 64567, 52367 , 96734, " micael@gmail.com ");
      basketballplayersDetails.computeDetails() ;



   }

}
