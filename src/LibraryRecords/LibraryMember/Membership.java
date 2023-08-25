package LibraryRecords.LibraryMember;

public enum Membership {
    STUDENT(1, "Student", 5),
    GRADUATED(2, "Graduated", 3);

    private int index;
    private String membershipType;
    private final int max_Limit;

    Membership(int index, String membershipType, int max_Limit) {
        this.index = index;
        this.membershipType = membershipType;
        this.max_Limit= max_Limit;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public int getMax_Limit() {
        return max_Limit;
    }
}
