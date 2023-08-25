package LibraryRecords.ReadableMaterial;

public class Magazine extends Readable{

    private String publisher;

   // private int opus; // derginin sayısı

    public Magazine(int uniqId, int coeqId, String title, int pageCount, double price, boolean isOccupied,
                    int edition, Category category, Language language, String publisher /*, int opus*/) {
        super(uniqId, coeqId, title, pageCount, price, isOccupied, edition,category,  language);
        this.publisher=publisher;
      // this.opus=opus;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

  /*  public int getOpus() {
        return opus;
    }

    public void setOpus(int opus) {
        this.opus = opus;
    }
    */

}

