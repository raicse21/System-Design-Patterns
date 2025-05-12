import java.util.Scanner;
/*
Your application needs to instantiate different types of Payment Services
like UPI, Credit Card & Paytm based on user Input. How to design this ?

Solution: Factory pattern
*/
interface PaymentService{
    void processPayment(double amount);
}

class UPIPayment implements PaymentService{

    @Override
    public void processPayment(double amount){
        System.out.println("Processing UPI Payment: " + amount );
    }
}

class CreditCardPayment implements PaymentService{

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Credit Card Payment: " + amount);
    }
}

class PaytmPayment implements PaymentService{

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Paytm Payment: "+ amount);
    }
}

class PaymentFactory{

    public static PaymentService getPaymentService(String input) {
        if (input.length() == 0 || input == null) {
            return null;
        }

        if (input.equalsIgnoreCase("UPI")) {
            return new UPIPayment();
        } else if (input.equalsIgnoreCase("CREDIT_CARD")) {
            return new CreditCardPayment();
        } else if (input.equalsIgnoreCase("PAYTM")) {
            return new PaytmPayment();
        }
        return null;
    }
}

public class PaymentApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter your payment method -");
        System.out.println(" UPI / CREDIT_CARD / PAYTM");

        String userInput = sc.next();

        System.out.println("Please enter the transaction amount");
        double amount = sc.nextDouble();

        PaymentService service = PaymentFactory.getPaymentService(userInput);
        service.processPayment(amount);

    }
}

/*
Advantages of Factory pattern
1. Decoupling
    The factory pattern decouples the object creation logic
    from the rest of application. The client code doesn't need to know about
    how payment services are instantiated or what concrete classes are used.

2. Maintainability
    Adding new payment services like Debit card, Digital Rupee,etc. is easy.
    We simply need to create new class that implements PaymentService interface
    and update PaymentFactory to handle the new type. No changes are needed to client
    code.

3. Single Responsibility
    The responsibility of object creation is centralised in the PaymentFactory
    adhering to Single Responsibility Principle(SRP).

4. Extensibility
    The factory pattern allow easy extension of Payment methods without altering the
    core logic.New Payment methods can be added with minimal disruptions.
*/
