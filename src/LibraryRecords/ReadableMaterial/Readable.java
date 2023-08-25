package LibraryRecords.ReadableMaterial;

public class Readable {

    private int uniqId; // okunabilir materyalleri ayrıcan özel idsi
    private int coeqId; // aynı okunabilir materyallerin kendilerine has inner idsi
    private String title;
    private int pageCount;
    private double price;
    private boolean isOccupied;
    private int edition;
    private Category category;
    private Language language; //enum olarak bir deneyelim
    private Language secondLanguage;

    public Readable(int uniqId, int coeqId, String title, int pageCount, double price, boolean isOccupied, int edition, Category category, Language language) {
        this.uniqId = uniqId;
        this.coeqId =coeqId;
        this.title = title;
        this.pageCount = pageCount;
        this.price = price;
        this.isOccupied = isOccupied;
        this.edition =edition;
        this.category = category;
        this.language = language;
    }

    public Readable(int uniqId, int coeqId, String title, int pageCount, double price, boolean isOccupied,
                    int edition, Category category, Language language, Language secondLanguage){
        this(uniqId,coeqId,title,pageCount,price,isOccupied,edition,category,language);
        this.secondLanguage=secondLanguage;
    }

    public int getUniqId() {
        return uniqId;
    }

    public void setUniqId(int uniqId) {
        this.uniqId = uniqId;
    }

    public int getCoeqId() {
        return coeqId;
    }

    public void setCoeqId(int coeqId) {
        this.coeqId = coeqId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Language getSecondLanguage() {
        return secondLanguage;
    }

    public void setSecondLanguage(Language secondLanguage) {
        this.secondLanguage = secondLanguage;
    }

    @Override
    public String toString() {
        StringBuilder readableBuilder = new StringBuilder();
        readableBuilder.append("Uniq ID: ").append(uniqId).append(" ");
        readableBuilder.append("Coeq ID: ").append(coeqId).append(" ");
        readableBuilder.append("Title: ").append(title).append(" ");
        readableBuilder.append("Page Count: ").append(pageCount).append(" ");
        readableBuilder.append("Price: ").append(price).append(" ");
        readableBuilder.append("Is Occupied: ").append(isOccupied).append(" ");
        readableBuilder.append("Edition: ").append(edition).append(" ");
        readableBuilder.append("Category: ").append(category.getCategory()).append(" ");
        readableBuilder.append("Language: ").append(language.getLanguage()).append(" ");

        if (category == Category.DICTIONARY) {
            Language secondLang = secondLanguage != null ? secondLanguage : Language.TURKISH; //updatelerde null pointer exception hatası için default atandı.
            readableBuilder.append("Second Language: ").append(secondLanguage.getLanguage());
        }

        return readableBuilder.toString();
    }
}
