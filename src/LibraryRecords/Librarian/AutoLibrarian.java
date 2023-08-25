package LibraryRecords.Librarian;

import LibraryRecords.LibraryMember.Member;
import LibraryRecords.LibraryMember.Membership;
import LibraryRecords.ReadableMaterial.Category;
import LibraryRecords.ReadableMaterial.Language;
import LibraryRecords.ReadableMaterial.Readable;

import java.util.*;

import static LibraryOperations.MainOperations.addReadable;

public class AutoLibrarian {
    private static Map<Integer, List<Member>> members;
    private static Map<Integer, List<Readable>> readables;

    public AutoLibrarian() {
        members = new HashMap<>();
        readables = new HashMap<>();
    }

    /*MEMBER SIDE OPERATIONS*/

    //IF READABLE BORROWED

    //  void lend();
    //  void receipt();

    //IF READABLE RETURN
    //  void retrieve();
    //  void deposit();


    /*INTRA-LIBRARY (CORE) OPERATIONS*/

    //Also CRUDS CAN BE AUGMENTED FOR MEMBERS BUT JUST AN IDEA FOR NOW. FOR EXP: Update Member info ==> student became graduated...

    /*CRUD*/ //For Readables

    public static Map getAllReadables() {
        return readables;
    }

    //    void getReadableById(); // R

    //   void getReadableByCategory(); // R

    //   void getReadableByName(); // R

    //    void getReadableByAuthor(); // R

    //   void getReadableByKeyWord(); // R

    // void inspectReadable(); // R=> özellikle kitabın hangi kullanıcıda olduğunu anlamak için

    public static void addReadable(int uniqId, int coeqId, String title, int pageCount, double price, boolean isOccupied, int edition, Category category, Language language) {
        Readable newReadable = new Readable(uniqId, coeqId, title, pageCount, price, isOccupied, edition, category, language);
        readables.computeIfAbsent(uniqId, key -> new ArrayList<>()).add(newReadable);
        System.out.println(newReadable);
    }

    public static void addReadable(int uniqId, int coeqId, String title, int pageCount, double price, boolean isOccupied, int edition, Category category, Language language, Language secondLanguage) {
        Readable newReadable = new Readable(uniqId, coeqId, title, pageCount, price, isOccupied, edition, category, language, secondLanguage);
        readables.computeIfAbsent(uniqId, key -> new ArrayList<>()).add(newReadable);
        System.out.println(newReadable);
    }

    public void takeAndAddReadableInput() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter Uniq ID: ");
            int uniqId = scanner.nextInt();
            scanner.nextLine();

            if (readables.containsKey(uniqId)) {
                System.out.println("Readable with Uniq ID " + uniqId + " already exists. Please enter a different ID.");
            } else {
                // Uniq ID is unique, proceed with adding the readable
                System.out.print("Enter Coeq ID: ");
                int coeqId = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter Title: ");
                String title = scanner.nextLine();
                System.out.print("Enter Page Count: ");
                int pageCount = scanner.nextInt();
                System.out.print("Enter Price: ");
                double price = scanner.nextDouble();
                scanner.nextLine(); // Consume the newline character
                System.out.print("Is Occupied (true/false): ");
                boolean isOccupied = scanner.nextBoolean();
                System.out.print("Enter Edition: ");
                int edition = scanner.nextInt();

                System.out.println("Enter category:");
                System.out.println("1. Book");
                System.out.println("2. Magazine");
                System.out.println("3. Dictionary");
                int categoryChoice = scanner.nextInt();
                Category category;

                switch (categoryChoice) {
                    case 1:
                        category = Category.BOOK;
                        break;
                    case 2:
                        category = Category.MAGAZINE;
                        break;
                    case 3:
                        category = Category.DICTIONARY;
                        break;
                    default:
                        System.out.println("Invalid choice. Defaulting to Book.");
                        category = Category.BOOK;
                        break;
                }

                Language primarylanguage = Language.TURKISH; // Default primary language
                Language secondLanguage = null; // Default second language

                if (category == Category.DICTIONARY) {
                    System.out.println("Enter primary language:");
                    for (Language lang : Language.values()) {
                        System.out.println(lang.getIndex() + ". " + lang.getLanguage());
                    }
                    int primaryLanguageChoice = scanner.nextInt();
                    primarylanguage = Language.fromIndex(primaryLanguageChoice);

                    System.out.println("Enter second language:");
                    for (Language lang : Language.values()) {
                        System.out.println(lang.getIndex() + ". " + lang.getLanguage());
                    }
                    int secondLanguageChoice = scanner.nextInt();
                    secondLanguage = Language.fromIndex(secondLanguageChoice);

                    addReadable(uniqId, coeqId, title, pageCount, price, isOccupied, edition, category, primarylanguage, secondLanguage);

                    System.out.println("New readable added successfully.");
                    //System.out.println(readables);
                    break;

                } else {
                    System.out.println("Enter language:");
                    System.out.println("1. Turkish");
                    System.out.println("2. English");
                    System.out.println("3. French");
                    System.out.println("4. Russian");
                    int languageChoice = scanner.nextInt();
                    Language language;

                    switch (languageChoice) {
                        case 1:
                            language = Language.TURKISH;
                            break;
                        case 2:
                            language = Language.ENGLISH;
                            break;
                        case 3:
                            language = Language.FRENCH;
                            break;
                        case 4:
                            language = Language.RUSSIAN;
                            break;
                        default:
                            System.out.println("Invalid choice. Defaulting to Turkish.");
                            language = Language.TURKISH;
                            break;
                    }
                    addReadable(uniqId, coeqId, title, pageCount, price, isOccupied, edition, category, language);

                    System.out.println("New readable added successfully.");
                    //System.out.println(readables);
                    break;
                }
            }
        }
        scanner.close();
    }

    //   void updateReadable(); // U

    public static void takeAndUpdateReadableInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Uniq ID of the readable to update: ");
        int uniqIdToUpdate = scanner.nextInt();
        scanner.nextLine();

        if (readables.containsKey(uniqIdToUpdate)) {
            List<Readable> existingReadables = readables.get(uniqIdToUpdate);

            System.out.println("Updating readable with Uniq ID: " + uniqIdToUpdate);

            for (Readable existingReadable : existingReadables) {
                System.out.print("Do you want to update the Title? (y/n): ");
                if (scanner.nextLine().equalsIgnoreCase("y")) {
                    System.out.print("Enter new Title: ");
                    String newTitle = scanner.nextLine();
                    existingReadable.setTitle(newTitle);
                }

                System.out.print("Do you want to update the Page Count? (y/n): ");
                if (scanner.nextLine().equalsIgnoreCase("y")) {
                    System.out.print("Enter new Page Count: ");
                    int newPageCount = scanner.nextInt();
                    existingReadable.setPageCount(newPageCount);
                    scanner.nextLine(); // Consume the newline character
                }

                System.out.print("Do you want to update the Price? (y/n): ");
                if (scanner.nextLine().equalsIgnoreCase("y")) {
                    System.out.print("Enter new Price: ");
                    double newPrice = scanner.nextDouble();
                    existingReadable.setPrice(newPrice);
                    scanner.nextLine(); // Consume the newline character
                }

                System.out.print("Do you want to update the Is Occupied status? (y/n): ");
                if (scanner.nextLine().equalsIgnoreCase("y")) {
                    System.out.print("Is Occupied (true/false): ");
                    boolean newIsOccupied = scanner.nextBoolean();
                    existingReadable.setOccupied(newIsOccupied);
                    scanner.nextLine(); // Consume the newline character
                }

                System.out.print("Do you want to update the Edition? (y/n): ");
                if (scanner.nextLine().equalsIgnoreCase("y")) {
                    System.out.print("Enter new Edition: ");
                    int newEdition = scanner.nextInt();
                    existingReadable.setEdition(newEdition);
                    scanner.nextLine(); // Consume the newline character
                }

                System.out.print("Do you want to update the Category? (y/n): ");
                if (scanner.nextLine().equalsIgnoreCase("y")) {
                    System.out.println("Enter new category:");
                    System.out.println("1. Book");
                    System.out.println("2. Magazine");
                    System.out.println("3. Dictionary");
                    int newCategoryChoice = scanner.nextInt();
                    Category newCategory;

                    switch (newCategoryChoice) {
                        case 1:
                            newCategory = Category.BOOK;
                            break;
                        case 2:
                            newCategory = Category.MAGAZINE;
                            break;
                        case 3:
                            newCategory = Category.DICTIONARY;
                            break;
                        default:
                            System.out.println("Invalid choice. Defaulting to Book.");
                            newCategory = Category.BOOK;
                            break;
                    }

                    existingReadable.setCategory(newCategory);
                    scanner.nextLine(); // Consume the newline character
                }

                System.out.print("Do you want to update the Language? (y/n): ");
                if (scanner.nextLine().equalsIgnoreCase("y")) {
                    System.out.println("Enter new language:");
                    System.out.println("1. Turkish");
                    System.out.println("2. English");
                    System.out.println("3. French");
                    System.out.println("4. Russian");
                    int newLanguageChoice = scanner.nextInt();
                    Language newLanguage;

                    switch (newLanguageChoice) {
                        case 1:
                            newLanguage = Language.TURKISH;
                            break;
                        case 2:
                            newLanguage = Language.ENGLISH;
                            break;
                        case 3:
                            newLanguage = Language.FRENCH;
                            break;
                        case 4:
                            newLanguage = Language.RUSSIAN;
                            break;
                        default:
                            System.out.println("Invalid choice. Defaulting to Turkish.");
                            newLanguage = Language.TURKISH;
                            break;
                    }

                    existingReadable.setLanguage(newLanguage);
                    scanner.nextLine(); // Consume the newline character
                }

                if (existingReadable.getCategory() == Category.DICTIONARY) {
                    System.out.print("Do you want to update the Second Language? (y/n): ");
                    if (scanner.nextLine().equalsIgnoreCase("y")) {
                        System.out.println("Enter new second language:");
                        System.out.println("1. Turkish");
                        System.out.println("2. English");
                        System.out.println("3. French");
                        System.out.println("4. Russian");
                        int newSecondLanguageChoice = scanner.nextInt();
                        Language newSecondLanguage;

                        switch (newSecondLanguageChoice) {
                            case 1:
                                newSecondLanguage = Language.TURKISH;
                                break;
                            case 2:
                                newSecondLanguage = Language.ENGLISH;
                                break;
                            case 3:
                                newSecondLanguage = Language.FRENCH;
                                break;
                            case 4:
                                newSecondLanguage = Language.RUSSIAN;
                                break;
                            default:
                                System.out.println("Invalid choice. Defaulting to Turkish.");
                                newSecondLanguage = Language.TURKISH;
                                break;
                        }

                        existingReadable.setSecondLanguage(newSecondLanguage);
                        scanner.nextLine(); // Consume the newline character
                    }
                }

                System.out.println("Readable updated successfully:");
                System.out.println(existingReadable);
            }
        } else {
            System.out.println("Readable with Uniq ID " + uniqIdToUpdate + " does not exist.");
        }

        scanner.close();
    }

    public static void deleteReadable(int uniqId) {
        List<Readable> readableList = readables.get(uniqId);
        if (readableList == null) {
            System.out.println("Readable with ID " + uniqId + " not found.");
            return;
        }

        Readable deletedReadable = readableList.get(0); // Assuming uniqId is unique
        readables.remove(uniqId);
        System.out.println("Readable with ID " + uniqId + " has been deleted:");
        System.out.println(deletedReadable);
    }

    public static void takeAndDeleteReadableInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter readable ID to delete:");
        int uniqId = scanner.nextInt();
        scanner.nextLine();

        deleteReadable(uniqId);

        System.out.println(readables);
        scanner.close();
    }


    /*OPERATIONS FOR MEMBER DATA*/

    /*CRUD*/ //For Members

    public static Map getAllMembers() {
        return members;
    }

    public static void addMember(int memberId, String name, String surname, Membership membership, boolean currentlyHasBorrowed, int currentBorrowedCount) {
        Member newMember = new Member(memberId, name, surname, membership, currentlyHasBorrowed, currentBorrowedCount);
        members.computeIfAbsent(memberId, key -> new ArrayList<>()).add(newMember);
        System.out.println(newMember);
    }

    public static void addUserInputMember() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter member ID:");
            int memberId = scanner.nextInt();
            scanner.nextLine();

            if (members.containsKey(memberId)) {
                System.out.println("Member with ID " + memberId + " already exists. Please enter a different ID.");
            } else {
                // Member ID is unique, proceed with adding the member
                System.out.println("Enter member name:");
                String name = scanner.nextLine();

                System.out.println("Enter member surname:");
                String surname = scanner.nextLine();

                System.out.println("Enter membership type:");
                System.out.println("1. Student");
                System.out.println("2. Graduated");
                int membershipChoice = scanner.nextInt();
                Membership membership;

                switch (membershipChoice) {
                    case 1:
                        membership = Membership.STUDENT;
                        break;
                    case 2:
                        membership = Membership.GRADUATED;
                        break;
                    default:
                        System.out.println("Invalid choice. Defaulting to Student.");
                        membership = Membership.STUDENT;
                        break;
                }

                System.out.println("Is member currently borrowing? (true/false):");
                boolean currentlyHasBorrowed = scanner.nextBoolean();
                scanner.nextLine();

                int currentBorrowedCount = 0;
                if (currentlyHasBorrowed) {
                    System.out.println("Enter current borrowed count (up to " + membership.getMax_Limit() + "):");
                    currentBorrowedCount = scanner.nextInt();
                    scanner.nextLine();

                    if (currentBorrowedCount > membership.getMax_Limit()) {
                        System.out.println("Current borrowed count exceeds the membership's maximum limit. Setting to maximum limit.");
                        currentBorrowedCount = membership.getMax_Limit();
                    }
                }

                addMember(memberId, name, surname, membership, currentlyHasBorrowed, currentBorrowedCount);

                System.out.println("New member added successfully.");
                System.out.println(members);
                break;
            }
        }

        scanner.close();
    }
/*
    public static void updateMember(int memberId, String newName, String newSurname, Membership newMembership, boolean newCurrentlyHasBorrowed, int newCurrentBorrowedCount) {
        List<Member> memberList = members.get(memberId);
        if (memberList != null && !memberList.isEmpty()) {
            Member memberToUpdate = memberList.get(0);
            memberToUpdate.setName(newName);
            memberToUpdate.setSurname(newSurname);
            memberToUpdate.setMembership(newMembership);
            memberToUpdate.setCurrentlyHasBorrowed(newCurrentlyHasBorrowed);
            memberToUpdate.setCurrentBorrowedCount(newCurrentBorrowedCount);
            System.out.println("Member with ID " + memberId + " has been updated.");
        } else {
            System.out.println("Member with ID " + memberId + " not found.");
        }
    }
*/
    public static void updateUserInputMember() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter member ID to update:");
        int memberId = scanner.nextInt();
        scanner.nextLine();

        List<Member> memberList = members.get(memberId);
        if (memberList == null || memberList.isEmpty()) {
            System.out.println("Member with ID " + memberId + " not found.");
            return;
        }

        Member memberToUpdate = memberList.get(0); // Assuming memberId is unique like return not a list just a member.

        System.out.println("Updating Member with ID: " + memberId);

        System.out.println("Do you want to update the member name? (yes/no):");
        String updateNameChoice = scanner.nextLine();
        if ("yes".equalsIgnoreCase(updateNameChoice)) {
            System.out.println("Enter new member name:");
            String newName = scanner.nextLine();
            memberToUpdate.setName(newName);
        }

        System.out.println("Do you want to update the member surname? (yes/no):");
        String updateSurnameChoice = scanner.nextLine();
        if ("yes".equalsIgnoreCase(updateSurnameChoice)) {
            System.out.println("Enter new member surname:");
            String newSurname = scanner.nextLine();
            memberToUpdate.setSurname(newSurname);
        }

        System.out.println("Do you want to update the membership type? (yes/no):");
        String updateMembershipChoice = scanner.nextLine();
        if ("yes".equalsIgnoreCase(updateMembershipChoice)) {
            System.out.println("Enter new membership type:");
            System.out.println("1. Student");
            System.out.println("2. Graduated");
            int membershipChoice = scanner.nextInt();
            scanner.nextLine();

            Membership newMembership;
            switch (membershipChoice) {
                case 1:
                    newMembership = Membership.STUDENT;
                    break;
                case 2:
                    newMembership = Membership.GRADUATED;
                    break;
                default:
                    System.out.println("Invalid choice. Keeping the current membership type.");
                    newMembership = memberToUpdate.getMembership();
                    break;
            }
            memberToUpdate.setMembership(newMembership);
        }

        System.out.println("Do you want to update the current borrowing status? (yes/no):");
        String updateBorrowingStatusChoice = scanner.nextLine();
        if ("yes".equalsIgnoreCase(updateBorrowingStatusChoice)) {
            System.out.println("Is member currently borrowing? (true/false):");
            boolean newBorrowingStatus = scanner.nextBoolean();
            scanner.nextLine();
            memberToUpdate.setCurrentlyHasBorrowed(newBorrowingStatus);

            if (newBorrowingStatus) {
                System.out.println("Enter new current borrowed count (up to " + memberToUpdate.getMembership().getMax_Limit() + "):");
                int newBorrowedCount = scanner.nextInt();
                scanner.nextLine();

                if (newBorrowedCount > memberToUpdate.getMembership().getMax_Limit()) {
                    System.out.println("New borrowed count exceeds the membership's maximum limit. Setting to maximum limit.");
                    newBorrowedCount = memberToUpdate.getMembership().getMax_Limit();
                }
                memberToUpdate.setCurrentBorrowedCount(newBorrowedCount);
            } else {
                memberToUpdate.setCurrentBorrowedCount(0);
            }
        }

        System.out.println("Member with ID " + memberId + " has been updated.");
        System.out.println(memberToUpdate);
        scanner.close();
    }

    public static void deleteMember(int memberId) {
        List<Member> memberList = members.get(memberId);
        if (memberList == null) {
            System.out.println("Member with ID " + memberId + " not found.");
            return;
        }

        Member deletedMember = memberList.get(0); // Assuming memberId is unique
        members.remove(memberId);
        System.out.println("Member with ID " + memberId + " has been deleted:");
        System.out.println(deletedMember);
    }

    public static void deleteUserInputMember() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter member ID to delete:");
        int memberId = scanner.nextInt();
        scanner.nextLine();

        deleteMember(memberId);

        System.out.println(members);
        scanner.close();
    }



    /*


    void getMemberByMemberId(); // R

    void getMemberByMembership(); // R

    void getMemberByName(); // R

    void getMemberBySurname(); // R

    void getMemberByBorrowStatus();

     */
}
