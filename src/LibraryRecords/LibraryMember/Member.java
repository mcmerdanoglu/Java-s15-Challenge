package LibraryRecords.LibraryMember;

public class Member {
    private int memberId;
    private String name;
    private String surname;
    private Membership membership;

    // private Reader reader; membership yerine düşünülebilir.
    private boolean currentlyHasBorrowed;
    private int currentBorrowedCount; /* If student max_limit=5, Else is civil max_limit=3 */

    // private boolean hasPenalty; //fikir olarak!


    public Member(int memberId, String name, String surname, Membership membership, boolean currentlyHasBorrowed, int currentBorrowedCount) {
        this.memberId = memberId;
        this.name = name;
        this.surname = surname;
        this.membership = membership;
        this.currentlyHasBorrowed = currentlyHasBorrowed;
        this.currentBorrowedCount = currentBorrowedCount;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public boolean isCurrentlyHasBorrowed() {
        return currentlyHasBorrowed;
    }

    public void setCurrentlyHasBorrowed(boolean currentlyHasBorrowed) {
        this.currentlyHasBorrowed = currentlyHasBorrowed;
    }

    public int getCurrentBorrowedCount() {
        return currentBorrowedCount;
    }

    public void setCurrentBorrowedCount(int currentBorrowedCount) {
        this.currentBorrowedCount = currentBorrowedCount;
    }


    @Override
    public String toString() {
        StringBuilder memberInfo = new StringBuilder();
        memberInfo.append("Member{")
                .append("memberId=").append(memberId)
                .append(", name='").append(name).append('\'')
                .append(", surname='").append(surname).append('\'')
                .append(", membership=").append(membership)
                .append(", currentlyHasBorrowed=").append(currentlyHasBorrowed)
                .append(", currentBorrowedCount=").append(currentBorrowedCount)
                .append('}')
                .append("\n");
        return memberInfo.toString();
    }
}
