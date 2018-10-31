package models;

public class Book {
    String title;
    String author;
    int launchYear;
    String category;
    int pages;

    public Book(String title, String author, int launchYear, String category, int pages) {
        this.title = title;
        this.author = author;
        this.launchYear = launchYear;
        this.category = category;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getLaunchYear() {
        return launchYear;
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

    public void setLaunchYear(int launchYear) {
        this.launchYear = launchYear;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
