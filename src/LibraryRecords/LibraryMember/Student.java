package LibraryRecords.LibraryMember;

public class Student extends Member implements Reader{

   // private final int max_Limit; //Başka şekilde veya yerde de yazılabilirdi. Bu şekilde immutable oldu.

    public Student(int memberId, String name, String surname, Membership membership, String address, long mobile,
                   boolean currentlyHasBorrowed, int currentBorrowedCount /*,int max_Limit*/) {
        super(memberId, name, surname, membership, currentlyHasBorrowed, currentBorrowedCount);
       // this.studentId=studentId;
       // this.max_Limit=5; //Bu şekilde immutable oldu.
    }

    /*
    public int getMax_Limit() {
        return max_Limit;
    }
    */
    @Override
    public void borrow() {

    }

    @Override
    public void bringBack() {

    }

    @Override
    public void pay() {

    }

    @Override
    public void payBack() {

    }
}
