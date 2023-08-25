package LibraryRecords.ReadableMaterial;

public enum Category {
        BOOK(1, "Book"),
        MAGAZINE(2, "Magazine"),
        DICTIONARY(3, "Dictionary");

        private int index;
        private String category;

        Category(int index, String category) {
            this.index = index;
            this.category = category;
        }

    public int getIndex() {
        return index;
    }

    public String getCategory() {
        return category;
    }
}
