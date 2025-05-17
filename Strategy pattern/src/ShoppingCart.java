
/*
Your application supports multiple discount type (flat, percentage,No discount).
How would you implement this dynamically ?
*/

interface DiscountStrategy{
    double applyDiscount(double price);
}

class FlatDiscount implements DiscountStrategy{

    private final double discountAmount;

    FlatDiscount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public double applyDiscount(double price) {
        return price - discountAmount;
    }
}

class NoDiscount implements DiscountStrategy{

    @Override
    public double applyDiscount(double price) {
        return price;
    }
}

class PercentageDiscount implements DiscountStrategy{

    private final double discountPercentage;

    PercentageDiscount(double discountPercentage){
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double applyDiscount(double price){
        return price - (price*discountPercentage / 100);
    }

}

public class ShoppingCart {

    private DiscountStrategy discountStrategy;

    public ShoppingCart(DiscountStrategy discountStrategy){
        this.discountStrategy = discountStrategy;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy){
        this.discountStrategy = discountStrategy;
    }

    public double calculateFinalPrice(double originalPrice){
        return this.discountStrategy.applyDiscount(originalPrice);
    }
}
