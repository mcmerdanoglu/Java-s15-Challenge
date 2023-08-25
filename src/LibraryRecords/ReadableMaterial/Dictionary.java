package LibraryRecords.ReadableMaterial;

public class Dictionary extends Readable {

    private String association;

    public Dictionary(int uniqId, int coeqId, String title, int pageCount, double price, boolean isOccupied,
                      int edition, Category category, Language language, String association) {
        super(uniqId, coeqId, title, pageCount, price, isOccupied, edition, category, language);
        this.association=association;

    }

    public String getAssociation() {
        return association;
    }

    public void setAssociation(String association) {
        this.association = association;
    }
}
