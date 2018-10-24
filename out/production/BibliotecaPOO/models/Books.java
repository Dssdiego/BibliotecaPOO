package models;

public class Books {
    String title;
    String author;
    String isbn;
    String category;
    int pages;

    public Books(String title, String author, String isbn, String category, int pages) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.category = category;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getCategory() {
        return category;
    }

    public int getPages() {
        return pages;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}