package LibraryOperations;

import LibraryRecords.Librarian.AutoLibrarian;
import LibraryRecords.Librarian.Helper;
import LibraryRecords.LibraryMember.Membership;

import java.util.Scanner;

public class MainOperations {
    public static void main(String[] args) {
        System.out.println("-------Library has opened---------");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Library!");
        System.out.println("Who are you?");
        System.out.println("1. I am a Reader");
        System.out.println("2. I am a Librarian");
        System.out.print("Please select an option: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Welcome, Reader!");
                System.out.println("1. Student");
                System.out.println("2. Graduate");
                System.out.print("Please select your membership: ");

                int readerMembership = scanner.nextInt();

                switch (readerMembership) {
                    case 1:
                        System.out.println("Welcome, Student!");
                        break;
                    case 2:
                        System.out.println("Welcome, Graduate!");
                        break;
                    default:
                        System.out.println("Invalid membership. Please select 1 or 2.");
                        break;
                }
                break;

            case 2:
                System.out.println("Welcome, Librarian!");
                librarianMenu();
                break;

            default:
                System.out.println("Invalid choice. Please select 1 or 2.");
                break;
        }
        scanner.close();
    }

    public static void librarianMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Librarian Menu:");
        System.out.println("1. Intra-Library Operations");
        System.out.println("2. Member Side Operations");
        System.out.print("Please select an option: ");

        int librarianChoice = scanner.nextInt();

        switch (librarianChoice) {
            case 1:
                intraLibraryOperations();
                break;
            case 2:
                memberSideOperations();
                break;
            default:
                System.out.println("Invalid choice. Please select 1 or 2.");
                break;
        }

        scanner.close();
    }

    public static void intraLibraryOperations() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Intra-Library Operations:");
        System.out.println("1. Get Readable");
        System.out.println("2. Add Readable");
        System.out.println("3. Update Readable");
        System.out.println("4. Delete Readable");
        System.out.print("Please select an option: ");

        int intraOpChoice = scanner.nextInt();

        AutoLibrarian librarian = new AutoLibrarian();
        Helper.generateMockReadables();

        switch (intraOpChoice) {
            case 1:
                getReadable();
                break;
            case 2:
                librarian.takeAndAddReadableInput();
                break;
            case 3:
                librarian.takeAndUpdateReadableInput();
                break;
            case 4:
                librarian.takeAndDeleteReadableInput();
                break;
            default:
                System.out.println("Invalid choice. Please select 1, 2, 3, or 4.");
                break;
        }

        scanner.close();
    }

    public static void getReadable() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Getting Ways for Readables:");
        System.out.println("1. Get All Readables");
        System.out.println("2. Get Readable by ID");
        System.out.println("3. Get Readable by Category");
        System.out.println("4. Get Readable by Name");
        System.out.println("5. Get Readable by Author");
        System.out.println("6. Get Readable by Keyword");
        System.out.print("Please select a getting way: ");

        int readableOpChoice = scanner.nextInt();

        AutoLibrarian librarian = new AutoLibrarian();
        Helper.generateMockReadables();

        switch (readableOpChoice) {
            case 1:
                librarian.getAllReadables();
                break;
            case 2:
                getReadableByID();
                break;
            case 3:
                getReadableByCategory();
                break;
            case 4:
                getReadableByName();
                break;
            case 5:
                getReadableByAuthor();
                break;
            case 6:
                getReadableByKeyword();
                break;
            default:
                System.out.println("Invalid choice. Please select 1 through 6.");
                break;
        }

        scanner.close();
    }

    public static void getReadableByID() {
        // Implementation for getting readable by ID
    }

    public static void getReadableByCategory() {
        // Implementation for getting readable by category
    }

    public static void getReadableByName() {
        // Implementation for getting readable by name
    }

    public static void getReadableByAuthor() {
        // Implementation for getting readable by author
    }

    public static void getReadableByKeyword() {
        // Implementation for getting readable by keyword
    }

    public static void addReadable(){};

    public static void updateReadable(){};

    public static void deleteReadable(){};

    public static void memberSideOperations() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Member Side Operations:");
        System.out.println("1. Get Member");
        System.out.println("2. Add Member");
        System.out.println("3. Update Member");
        System.out.println("4. Delete Member");
        System.out.print("Please select an option: ");

        int memberOpChoice = scanner.nextInt();

        AutoLibrarian librarian = new AutoLibrarian();
        Helper.generateMockMembers();

        switch (memberOpChoice) {
            case 1:
                librarian.getAllMembers();
                break;
            case 2:
                //AutoLibrarian librarian = new AutoLibrarian();
                //Helper.generateMockMembers();
                librarian.addUserInputMember();
                break;
            case 3:
                librarian.updateUserInputMember();
                break;
            case 4:
                librarian.deleteUserInputMember();
                break;
            default:
                System.out.println("Invalid choice. Please select 1, 2, 3, or 4.");
                break;
        }

        scanner.close();
    }
}