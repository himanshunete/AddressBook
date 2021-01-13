

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
      return " Details of " + firstName + " "+ lastName + " are: " + address + city  +  state  + zip + " , " + phoneNumber1 + phoneNumber2 +" , " + email;

   }
}


public class AddressBookSystemUC2 implements IContactDetails {

   private int numOfPerson = 0;
   private ContactDetails[] contactDetails;
   public AddressBookSystemUC2(){
      contactDetails = new  ContactDetails[3];
   }


   public void addDetails( String firstName,  String LastName,  String address,  String city ,  String state,  int zip,  int phoneNumber1,  int phoneNumber2 ,  String email ){
      contactDetails[ numOfPerson ] = new ContactDetails( firstName, LastName,  address,  city , state,  zip, phoneNumber1, phoneNumber2 ,  email ) ;
      numOfPerson++;
   }

   private void computeDetails(){
      for (int i=0; i< numOfPerson; i++ ){
         System.out.println( contactDetails[i]);
      }
   }

   public static void main(String[] args){
      AddressBookSystemUC2 address = new  AddressBookSystemUC2() ;
      address.addDetails("rock", "johnson", " 27, ladikar layout ,", " pune ,", " delhi ,", 440024 ,  88059, 56103, " him@gmil.com");
      address.addDetails("John", "Cena", " 18, bhagwan nagar ,", " nagpur ,", " maharashtra ,", 440011 ,  88023, 56103, " cen@gmil.com");
      address.addDetails("The", "Undertaker", " 34, naik nagar ,", " mumbai ,", " UP ,", 440023 ,  88059, 37467, " yo@gmil.com");
      address.computeDetails();
  }
}


