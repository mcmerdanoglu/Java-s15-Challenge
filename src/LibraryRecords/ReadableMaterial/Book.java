package LibraryRecords.ReadableMaterial;

public class Book extends Readable{

    private String author;

    public Book(int uniqId, int coeqId, String title, int pageCount, double price, boolean isOccupied,
                int edition, Category category, Language language, String author) {
        super(uniqId, coeqId, title, pageCount, price, isOccupied, edition,category, language);
        this.author=author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
