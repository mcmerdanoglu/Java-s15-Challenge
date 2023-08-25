package LibraryRecords.Librarian;

import LibraryRecords.LibraryMember.Member;
import LibraryRecords.LibraryMember.Membership;
import LibraryRecords.Librarian.AutoLibrarian;
import LibraryRecords.ReadableMaterial.Book;
import LibraryRecords.ReadableMaterial.Category;
import LibraryRecords.ReadableMaterial.Language;

public class Helper {
    public static void generateMockMembers() {
        AutoLibrarian.addMember(1, "John", "Doe", Membership.STUDENT, true, 3);
        AutoLibrarian.addMember(2, "Jane", "Smith", Membership.GRADUATED, false, 0);
        AutoLibrarian.addMember(3, "Michael", "Johnson", Membership.STUDENT, false, 0);
    }

    public static void generateMockReadables() {
        AutoLibrarian.addReadable(1, 2,"Karamazov", 300, 55.5, false,2,Category.BOOK, Language.TURKISH);
        AutoLibrarian.addReadable(2, 2,"Karamazov", 300, 55.5, true,2,Category.BOOK, Language.TURKISH);
        AutoLibrarian.addReadable(3, 2,"Karamazov", 300, 55.5, false,3,Category.BOOK, Language.RUSSIAN);
        AutoLibrarian.addReadable(4, 3,"Martin Eden", 150, 60, true,2,Category.BOOK, Language.TURKISH);
        AutoLibrarian.addReadable(5, 7,"Pasajlar", 30, 50, false,15,Category.MAGAZINE, Language.ENGLISH);
        AutoLibrarian.addReadable(6, 9,"Denemeler", 100, 40, true,4,Category.BOOK, Language.FRENCH);
        AutoLibrarian.addReadable(12,23,"Le clinique de francais", 200,65,true,3,Category.DICTIONARY, Language.FRENCH, Language.ENGLISH);
        AutoLibrarian.addReadable(25,23,"Le clinique de francais", 210,68,false,4,Category.DICTIONARY, Language.FRENCH, Language.ENGLISH);
    }
}
