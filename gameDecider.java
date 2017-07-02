//Version 1 of gameDecider no database version and no local storage

//import statements
import java.util.Scanner;
import java.io.Console;


public class gameDecider
{

  public static void main(String [] args)
  {
      //Variables

      //String username = "";
      //char password[];
      //String users[] = new String[5]; 
      String users[] = {"ebonmm","boobs","taco","tits","clits"}; 
      String passwords[] = {"Spiral117", "A", "B", "C", "D"};
      String Games[] = new String[10];
      String choice;

			//authentication variables
			int isPass; // = 0 if authenticated = 1 if authentication failed and must get user again
			int isUser; // = returns location in array if a valid user, = 0 if not in system then ask to add

      // initializing local scanner
      Scanner in = new Scanner(System.in);
      //calling intro and getting username and password
      intro();
      String username = getUser();
      char password[] = getPass();
			//printlines(2);

      //System.out.println(password);

			//authenticating user
			isUser = authUser(username,users);
			if (isUser == -1)
			{
				GIAS(2,0);
				System.out.print("Sorry but username: " + username + " is not found would you like to create an account? (Y/N) \n");
			} 
			
			isPass = authPass(password, passwords, isUser);
			if (isPass == 0)
			{
				GIAS(2,0);
				System.out.print("You are now logged in\n");
			}


      //Menu
      menu();
      
      //getting user menu selection
      GIAS(2,1); System.out.print("choice = ");
      choice = in.nextLine();
      //System.out.println(choice);
      switch(choice)
      {
        case "Show":
                GIAS(2,0);
                System.out.println("entered show"); 
                break;
        case "Random": 
                GIAS(2,0);
                System.out.println("entered Random");
                break;
        case "Add":
                GIAS(2,0); 
                System.out.println("entered Add");
                break;
        case "Remove": 
                GIAS(2,0);
                System.out.println("entered Remove");
                break;
        default:
              GIAS(2,0);
              System.out.println("Please select a valid menu option");
      }


    
    


    

  }
  public static void intro()
  {
    System.out.println("Welcome to Hell!!!\n");
  }

  public static String getUser()
  {
    System.out.print("*Enter username: ");
    Scanner scanner = new Scanner(System.in);
    String username = scanner.nextLine();
    return username;
  }

   public static char[] getPass()
  {
    Console cnsl = null;
    char something[] = new char[25];


    try
    {
      cnsl = System.console();

      if (cnsl != null)
      {
        char[] password = cnsl.readPassword(" *password");
        System.out.println("password is: " + password.toString() );
        return password;
      }
    

    }catch (Exception ex)
        {
          ex.printStackTrace();
        }
    return something;
  }


  /*
  * authentication of the user
    retuns int which will be used to determine what happens next 
    i if it finds the user in the array/database
    1 user not found, ask if they would like to add a user--> call create new user

  */
  public static int authUser(String username, String[] users)
  {
		for (int i =0; i<users.length; i++)
    {
      if(username.equals(users[i]) == true)
      {
        //System.out.println("entered if username = true" + i);
				return i;
      }
    }


    return -1;
  }



  /*
    authentication of the password
    returns int to determine what to do next
    0 password authentication successful
    1 invalid password give user 10 tries to get the password right before exiting and starting over
  */
  public static int authPass(char[] pass, String[] passwords, int passArrayLocation)
  {
    //local variables
    String enteredPass = "";
    Console cnsl;

		//local scanner
		Scanner in = new Scanner(System.in);


		for (int i = 0; i<10; i++)
		{
      if(passwords[passArrayLocation].equals(new String(pass)) == true || enteredPass.equals(passwords[passArrayLocation]) == true )
      {
        return 0;
      }
			else
			{
				System.out.println("Invalid password please try again, " + (10-i) + " tries remaining");
				//System.out.print("\nPlease re-enter password: ");
				enteredPass = in.nextLine();
			}
    }


    return -1;

  }



  public static void menu()
  {
    GIAS(3,0);
    System.out.print("Please select an option below\n");
    GIAS(1,0);
    System.out.print(" @ Show list of games\n");
    GIAS(1,1);
    System.out.print(" @ Random mode\n");
    GIAS(1,1);
    System.out.print(" @ Add game to list\n");
    GIAS(1,1);
    System.out.print(" @ Remove game from list\n");
  }

	public static void GIAS(int a, int b)
	{
		for (int i = 0; i < a-1; i++)
		{
		System.out.println("	*");
    }
  
    //System.out.print("B=" + b);
		if (b < 1)
    {
      System.out.print("	*");
    }
    else if (b == 1)
    { 
      System.out.print("        *");
    }
    else
    {

    }
	}

  
  

}
