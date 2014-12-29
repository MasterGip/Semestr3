package ru.kfu.itis;

/**
 * Created by mg on 27.12.14.
 */
public class Book {
    private int id;
    private String author;
    private String film;
    private String comment;
    private int pages;
    private String Company;
    private int year;
    private double cost;
    private boolean cdrom;
    private String iNNProducer;



    public Book(int id,
                String film,
                String author,
                String comment,
                int pages,
                String company,
                int year,
                double cost,
                boolean cdrom,
                String iNNProducer) {

        this.id = id;
        this.author = author;
        this.film = film;
        this.comment = comment;
        this.pages = pages;
        Company = company;
        this.year = year;
        this.cost = cost;
        this.cdrom = cdrom;
        this.iNNProducer = iNNProducer;

    }

    public String getiNNProducer() {
        return (iNNProducer!=null)?iNNProducer:" - ";
    }

    public String getId() {
        return id + "";
    }

    public String getAuthor() {
        return author;
    }

    public String getFilm() {
        return film;
    }

    public String getComment() {
        return comment;
    }

    public String getPages() {
        return pages + "";
    }

    public String getCompany() {
        return Company;
    }

    public String getYear() {
        return year + "";
    }

    public String getCost() {
        return cost + "";
    }

    public String getCdrom() {
        return (cdrom)? "В наличии" : "Отсутствует";
    }
}
