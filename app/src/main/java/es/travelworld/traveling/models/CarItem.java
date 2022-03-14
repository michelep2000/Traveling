package es.travelworld.traveling.models;

public class CarItem {
    public String color;
    public String name;
    public String price;
    public int image;

    public CarItem(String color, String name, String price, int image) {
        this.color = color;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


}
