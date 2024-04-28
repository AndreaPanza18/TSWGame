package model;

public class Game {
    private int id;
    private String name;
    private String category;

    private Double price;

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public String getCategory(){
        return category;
    }

    public Double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
