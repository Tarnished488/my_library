package my_library.Entity;

import javax.persistence.*;

@Entity
@Table(name = "books_inside")
public class book_inside_mapping {

    @Id
    @Column(name = "Category", nullable = false, length = 15)
    private String category;

    @Column(name = "Period_of_validity")
    private Integer periodOfValidity;

    @Column(name = "Title", length = 255)
    private String title;

    @Column(name = "Shelf", nullable = false)
    private int shelf;

    @Column(name = "`Row`", nullable = false) // Row 是 SQL 保留字
    private int row;

    @Column(name = "Layer", nullable = false)
    private int layer;

    // Getters and Setters

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPeriodOfValidity() {
        return periodOfValidity;
    }

    public void setPeriodOfValidity(Integer periodOfValidity) {
        this.periodOfValidity = periodOfValidity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getShelf() {
        return shelf;
    }

    public void setShelf(int shelf) {
        this.shelf = shelf;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    @Override
    public String toString() {
        return "BooksInside{" +
                "category='" + category + '\'' +
                ", periodOfValidity=" + periodOfValidity +
                ", title='" + title + '\'' +
                ", shelf=" + shelf +
                ", row=" + row +
                ", layer=" + layer +
                '}';
    }
}
