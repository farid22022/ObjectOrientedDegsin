

/* 
______________________________________________________________________________________________________________________________________________________
                                    Title : Demonstrating the Dependency Inversion Principle (DIP) 
                                                    Student : Md. Farid Hossen Rehad
                                                     Computer Science & Engineering 
                                                             Discipline
                                                        From Khulna University 
_______________________________________________________________________________________________________________________________________________________
*/

/**
 * Represents the abstraction of a notification service.
 */
interface NotificationService {
    /**
     * Sends a notification.
     *
     * @param message The message to be sent.
     */
    void sendNotification(String message);
}

/**
 * Represents a concrete implementation of a notification service that sends emails.
 */
class EmailNotificationService implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Email notification sent: " + message);
        
    }
}

/**
 * Represents the business logic module that depends on a notification service.
 */
class PaymentProcessor {
    private NotificationService notificationService;

    /**
     * Constructs a PaymentProcessor object with a notification service dependency.
     *
     * @param notificationService The notification service dependency.
     */
    public PaymentProcessor(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    /**
     * Process payment and send a notification using the injected notification service.
     *
     * @param amount The amount of payment.
     */
    public void processPayment(double amount) {
        // Process payment logic here...
        notificationService.sendNotification("Payment processed for amount: $" + amount);
        
    }
}

/**
 * Demonstrates the usage of the Dependency Inversion Principle (DIP) with a new example.
 */
class DIPExample {
    public static void main(String[] args) {
        // Create an email notification service and use it with PaymentProcessor
        NotificationService emailNotificationService = new EmailNotificationService();
        PaymentProcessor paymentProcessor = new PaymentProcessor(emailNotificationService);
        paymentProcessor.processPayment(100.0);
    }
}

/**
 * In the above program, the PaymentProcessor class depends on the abstraction provided by the NotificationService interface,
 * rather than depending directly on concrete implementations. This adherence to the Dependency Inversion Principle (DIP)
 * allows the PaymentProcessor class to be decoupled from specific implementations of the notification service,
 * making the code more flexible and easier to maintain.
 */
