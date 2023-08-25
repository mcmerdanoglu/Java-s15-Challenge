package LibraryRecords.ReadableMaterial;

public enum Language {
    TURKISH(1, "Turkish"),
    ENGLISH(2, "English"),
    FRENCH(3, "French"),
    RUSSIAN(4, "Russian");
    private int index;
    private String language;

    private String secondLanguage;

    Language(int index, String language) {
        this.index = index;
        this.language = language;
    }

    //Dictionary Category'si için 2. dil seçeneği ihtimal dahilinde olduğu için 2. constructor yazıldı!!!
    Language(int index, String language, String secondLanguage){
        this(index, language);
        this.secondLanguage=secondLanguage;
    }

    public int getIndex() {
        return index;
    }

    public String getLanguage() {
        return language;
    }

    public String getSecondLanguage() {
        return secondLanguage;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setSecondLanguage(String secondLanguage) {
        this.secondLanguage = secondLanguage;
    }

    public static Language fromIndex(int index) {
        for (Language lang : Language.values()) {
            if (lang.index == index) {
                return lang;
            }
        }
        return TURKISH;
    }
}
