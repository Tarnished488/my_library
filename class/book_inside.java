package my_library;

public class book_inside extends book_outside {
    private int location;
    private String category;
    private int periodOfValidity;

    public book_inside() {
        super();
    }



    public book_inside(String title, java.sql.Date purchaseDay, float price, String version, String author,
                       int location, String category, int periodOfValidity) {
        super(title, purchaseDay, price, version, author);
        this.location = location;
        this.category = category;
        this.periodOfValidity = periodOfValidity;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPeriodOfValidity() {
        return periodOfValidity;
    }

    public void setPeriodOfValidity(int periodOfValidity) {
        this.periodOfValidity = periodOfValidity;
    }

    @Override
    public String toString() {
        return "book_inside{" +
                "location=" + location +
                ", category='" + category + '\'' +
                ", periodOfValidity=" + periodOfValidity +
                ", title='" + getTitle() + '\'' +
                ", purchaseDay=" + getPurchaseDay() +
                ", price=" + getPrice() +
                ", version='" + getVersion() + '\'' +
                ", author='" + getAuthor() + '\'' +
                '}';
    }
}
