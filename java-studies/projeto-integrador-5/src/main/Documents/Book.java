package main.Documents;

public class Book extends Document {

    private int pages;
    private String author;
    private String title;
    private String gender;

    public Book(int pages, String author, String title, String gender) {
        this.pages = pages;
        this.author = author;
        this.title = title;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Book{" +
                "pages=" + pages +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
