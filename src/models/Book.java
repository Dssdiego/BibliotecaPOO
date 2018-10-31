package models;

public class Book {
    String objectId;
    String title;
    String author;
    int launchYear;
    String category;
    int pages;

    public Book(String objectId, String title, String author, int launchYear, String category, int pages) {
        this.objectId = objectId;
        this.title = title;
        this.author = author;
        this.launchYear = launchYear;
        this.category = category;
        this.pages = pages;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
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
