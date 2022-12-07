package spring.io.restfulAPI.Model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "pro_name",nullable = false)
    private String name;

    @Column(name = "pro_code",nullable = false)
    private String code;

    @Column(name = "pro_price")
    private double price;

    @Column(name = "pro_img")
    private String image;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "cat_id",table = "Category")
//    private Category category;

    public Product (){}

    public Product(String name, String code, double price, String image, Category category) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.image = image;
//        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }
}
