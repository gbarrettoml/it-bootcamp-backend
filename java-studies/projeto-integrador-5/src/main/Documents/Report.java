package main.Documents;

public class Report extends Document{
    private int pages;
    private String author;
    private String reviewer;
    private String size;

    public Report(int pages, String author, String reviewer, String size) {
        this.pages = pages;
        this.author = author;
        this.reviewer = reviewer;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Report{" +
                "pages=" + pages +
                ", author='" + author + '\'' +
                ", reviewer='" + reviewer + '\'' +
                ", large='" + size + '\'' +
                '}';
    }
}
