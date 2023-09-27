
public class Product {
    private String name;
    private double price;
    private String fruitOrVegetable;

    private String productType;


    public Product (String name){
        this.name = name;
    }

    public Product (String name, double price){
        this.name = name;
        this.price = price;
    }

    public Product (String name, double price, String fruitOrVegetable){
        this.name = name;
        this.price = price;
        this.fruitOrVegetable = fruitOrVegetable;
    }

    public Product (String name, double price, String fruitOrVegetable, String productType){
        this.name = name;
        this.price = price;
        this.fruitOrVegetable = fruitOrVegetable;
        this.productType = productType;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFruitOrVegetable(){
        return fruitOrVegetable;
    }

    public void setFruitorVegetable(String fruitOrVegetable){
        this.fruitOrVegetable = fruitOrVegetable;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "\nName of the product: " + name + "." + "\nPrice: " + price + " kr." + "\nPrimarytype: " + fruitOrVegetable +  "\nSecondarytype: " + productType + ".";
    }
}
