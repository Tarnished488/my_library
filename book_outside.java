package my_library;

import java.sql.Date;

public class book_outside {
	private String title;
    private Date purchaseDay;
    private float price;
    private String version;
    private String author;
public book_outside(){
}
public book_outside(String title, Date purchaseDay, float price, String version, String author) {
    this.title = title;
    this.purchaseDay = purchaseDay;
    this.price = price;
    this.version = version;
    this.author = author;
}
public String getTitle() {
    return title;
}

public void setTitle(String title) {
    this.title = title;
}

public Date getPurchaseDay() {
    return purchaseDay;
}

public void setPurchaseDay(Date purchaseDay) {
    this.purchaseDay = purchaseDay;
}

public float getPrice() {
    return price;
}

public void setPrice(float price) {
    this.price = price;
}

public String getVersion() {
    return version;
}

public void setVersion(String version) {
    this.version = version;
}

public String getAuthor() {
    return author;
}

public void setAuthor(String author) {
    this.author = author;
}
@Override
public String toString() {
    return "book_outside{" +
            "title='" + title + '\'' +
            ", purchaseDay=" + purchaseDay +
            ", price=" + price +
            ", version='" + version + '\'' +
            ", author='" + author + '\'' +
            '}';
}
}