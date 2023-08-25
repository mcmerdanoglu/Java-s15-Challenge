package LibraryRecords.LibraryMember;

public class Graduated extends Member implements Reader{

    public Graduated(int memberId, String name, String surname, Membership membership, String address, long mobile,
                     boolean currentlyHasBorrowed, int currentBorrowedCount) {
        super(memberId, name, surname, membership, currentlyHasBorrowed, currentBorrowedCount);

    }

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
