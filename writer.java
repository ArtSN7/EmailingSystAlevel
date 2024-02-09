import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;   // Import the FileWriter class


public class writer {

	public static void main(String[] args) { // main procedure

        Scanner input = new Scanner(System.in); // adding scanner

        System.out.print("\n\nPlease, input name of the first user: "); // asking to input the first name

        String first_name = input.nextLine(); // getting first name


        System.out.print("\n\nPlease, input name of the second user: "); // asking to input the second name

        String second_name = input.nextLine(); // getting second name

        creating_file_1(first_name, second_name); // calling procedure to create a file
        creating_file_2(first_name, second_name); // calling procedure to create a file

        System.out.println("\n\n-----------------------");
        System.out.println("\n\nGreat! Now you can start chatting.\n");

        System.out.println("Please choose who are you going to send it to:\n\n"); // making user to choose an address
        System.out.println("1." + first_name);
        System.out.println("2." + second_name);

        System.out.print("\nInput the number: ");

        int address = input.nextInt(); // getting the value of the address

        String file_name = "";
        String file_name_1 = "";

        if (address == 2) { // creating a name of the file to which we are going to write

            file_name = first_name + "To" + second_name + ".txt";
            file_name_1 = second_name + "To" + first_name + ".txt";

        } else{

            file_name = second_name + "To" + first_name + ".txt";
            file_name_1 = first_name + "To" + second_name + ".txt";

        }

        create_message(file_name); // now making user to send a text

        System.out.println("\n\nDo you want to read all your emails?\n\n");
        System.out.println("1.YES");
        System.out.println("2.NO");

        System.out.println("Input the number: ");

        int number = input.nextInt();

        if (number == 2){
            System.out.println("Great! CYA!");
        }else{
            reading(file_name_1);
        }

    }


    public static void reading(String file_name){ // reading an email
        try {
            File myObj = new File(file_name);

            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }

            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }


    public static void create_message(String file_name){ // sending an email

        Scanner input = new Scanner(System.in); // adding scanner

        System.out.println("\n\nPlease, input the text you want to send: "); // asking to input the first name

        String text = input.nextLine(); // getting first name

        write_to_file(text + "\n", file_name);



    }


    public static void write_to_file(String text, String file_name){ // writing to the file
        try {
            FileWriter myWriter = new FileWriter(file_name, true);    
            // false for overwriting and true for adding to the existing text
      
            myWriter.write(text);
            myWriter.close();
            System.out.println("\n\nMessage was sent!");
      
          } catch (IOException e) {
            System.out.println("An error occurred. Impossible to send a message!");
            e.printStackTrace();
      
          }



    }
    

    public static void creating_file_1(String name_1, String name_2){ // procedure which is gonna create 2 files 
        try {
            File myObj = new File(name_1 + "To" + name_2 + ".txt");

            if (myObj.createNewFile()) {

              System.out.println("\n\nFile created: " + myObj.getName());

            } else {

              System.out.println("File already exists.");

            }

        } catch (IOException e) {

            System.out.println("An error occurred.");
            e.printStackTrace();

        }



    }

 
    public static void creating_file_2(String name_1, String name_2){ // procedure which is gonna create 2 files 
        try {
            File myObj = new File(name_2 + "To" + name_1 + ".txt");

            if (myObj.createNewFile()) {

              System.out.println("\n\nFile created: " + myObj.getName());

            } else {

              System.out.println("File already exists.");

            }

        } catch (IOException e) {

            System.out.println("An error occurred.");
            e.printStackTrace();

        }

    }


}