//KAUE DE JESUS LIVIO CB3005461
//PEDRO PAULO DOS REIS FARIA CB3007278

package TP03;

public class book {
	protected int id;
    protected String title;
    protected String author;
    protected float price;
 
    public book() {
    }
 
    public book(int id) {
        this.id = id;
    }
 
    public book(int id, String title, String author, float price) {
        this(title, author, price);
        this.id = id;
    }
     
    public book(String title, String author, float price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getTitle() {
        return title;
    }
 
    public void setTitle(String title) {
        this.title = title;
    }
 
    public String getAuthor() {
        return author;
    }
 
    public void setAuthor(String author) {
        this.author = author;
    }
 
    public float getPrice() {
        return price;
    }
 
    public void setPrice(float price) {
        this.price = price;
    }
}
