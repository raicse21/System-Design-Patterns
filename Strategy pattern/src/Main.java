public class Main {
    public static void main(String[] args) {

        String customerType = "VIP";

        DiscountStrategy discountStrategy;
        if(customerType.equalsIgnoreCase("VIP")){
            discountStrategy = new PercentageDiscount(20);
        }else if(customerType.equalsIgnoreCase("NewCustomer")){
            discountStrategy = new FlatDiscount(50);
        }else{
            discountStrategy = new NoDiscount();
        }

        ShoppingCart cart = new ShoppingCart(discountStrategy);

        double price = 200;
        double finalPrice = cart.calculateFinalPrice(price);
        System.out.println("Final price after " + customerType +" discount is: " + finalPrice);
    }
}
/*
Advantages of Using Strategy Pattern
1. Extensibility:
    New discount strategies can be added easily by creating new classes that
    implement the DiscountStrategy interface. No changes required in ShoppingCart class

2. Separation of Concern:
    Each discount strategy encapsulates its own logic. The ShoppingCart class doesn't need
    to know the details of how each discount is applied.

3. Flexibility:
    The discount strategy can be changed dynamically at runtime, allowing for easy adaptation
    to business rules.

4. Open/Closed Principle:
    The strategy pattern adheres to the open/close principle. You can add new discount strategies
    without modifying existing codes. The code is open for Extension but closed for modification.
*/