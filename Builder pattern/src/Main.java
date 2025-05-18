
/*
You have an Order class with many Optional fields. What pattern would you use
to create immutable Order objects efficiently ?

Scenario : Creating immutable Order objects with Optional fields
*/
class Order{
    private final int id;
    private final String customerName;
    private final String shoppingAddress;
    private final String product;
    private final double amount;

    private Order(Builder builder){
        this.id = builder.id;
        this.customerName = builder.customerName;
        this.shoppingAddress = builder.shoppingAddress;
        this.product = builder.product;
        this.amount = builder.amount;
    }

    public int getId(){
        return this.id;
    }

    public String getCustomerName(){
        return this.customerName;
    }

    public String getShoppingAddress(){
        return this.shoppingAddress;
    }

    public String getProduct(){
        return this.product;
    }

    public double getAmount(){
        return this.amount;
    }

    // This is core of Builder pattern.
    // It mirrors the fields in main class but with non-final mutable fields.

    public static class Builder{
        private int id;
        private String customerName;
        private String shoppingAddress;
        private String product;
        private double amount;

        //Setter for builder(can be chained)
        //These methods set individual fields in builder.
        public Builder setId(int id){
            this.id= id;
            return this;
        }

        public Builder setCustomerName(String customerName){
            this.customerName = customerName;
            return this;
        }

        public Builder setShoppingAddress(String shoppingAddress){
            this.shoppingAddress = shoppingAddress;
            return this;
        }

        public Builder setProduct(String product){
            this.product = product;
            return this;
        }

        public Builder setAmount(double amount){
            this.amount = amount;
            return this;
        }

        //Build method create the immutable order object
        //This is where actual Order object is created.
        //It passes this(the builder object) into the private constructor of Order
        public Order build(){
            return new Order(this);
        }

    }

}


public class Main {
    public static void main(String[] args) {

        Order order = new Order.Builder()
                .setId(21)
                .setCustomerName("Rishikesh Rai")
                .setShoppingAddress("Delhi")
                .build();

        System.out.println(order.getCustomerName());
        System.out.println(order.getShoppingAddress());
        System.out.println(order.getAmount());
    }
}

/*
This can be achieved by @Builder annotation -> defined in Lombok
It internally generates
1. A static inner class called Builder
2. Setter-like methods in builder class for  each field
3. A build() method that can create main object
4. A builder() static method in Order class to get an instance of builder

In case of annotation code will be like:-

Order order = new Order.builder()
                .id(21)
                .customerName("Rishikesh Rai")
                .shoppingAddress("Delhi")
                .build();


Advantages of Builder pattern:-
1. Immutability:
    By using a Private constructor and only allowing object creation through
    the builder, you ensure that the object is immutable once it is built.

2. Readability and Maintainability:
    The builder's method chaining makes it easy to read and understand the code, and the
    builder pattern improves maintainability by keeping the creation process separate from the
    object's implementation.

3. Flexibility with Optional fields:
    The builder pattern handles optional fields effectively.You can choose which fields to
    set without needing to worry about the order of parameters or overloading the
    constructors with many parameters.

4. Preventing Constructor Overloading
    Instead of having multiple constructors with different parameter combinations, the builder
    pattern provides a more flexible and clean way to manage different object configuration.

*/