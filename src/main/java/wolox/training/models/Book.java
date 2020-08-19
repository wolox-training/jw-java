package wolox.training.models;

public class Book {

    private long id;

    private String genre;

    private String author;

    private String image;

    private String title;

    private String subtitle;

    private String pubisher;

    private String year;

    private String pages;

    private String isbn;

    public Book() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
