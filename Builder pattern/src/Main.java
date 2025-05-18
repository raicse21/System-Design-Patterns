
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
This can be achieved by @Builder annotation


*/