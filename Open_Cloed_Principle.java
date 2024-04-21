
/* 
______________________________________________________________________________________________________________________________________________________
                                    Title : Demonstrating the Open/Closed Principle (OCP)  
                                                    Student : Md. Farid Hossen Rehad
                                                     Computer Science & Engineering 
                                                             Discipline
                                                        From Khulna University 
_______________________________________________________________________________________________________________________________________________________

*/

/**
 * Represents a discount strategy.
 */
interface DiscountStrategy {
    /**
     * Calculates the discount for a given price.
     *
     * @param price The original price.
     * @return The discounted price.
     */
    double applyDiscount(double price);
}

/**
 * Represents a flat discount strategy.
 */
class FlatDiscount implements DiscountStrategy {
    private double discountAmount;

    /**
     * Constructs a flat discount strategy with the given discount amount.
     *
     * @param discountAmount The fixed discount amount.
     */
    public FlatDiscount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public double applyDiscount(double price) {
        return price - discountAmount;
    }
}

/**
 * Represents a percentage discount strategy.
 */
class PercentageDiscount implements DiscountStrategy {
    private double discountPercentage;

    /**
     * Constructs a percentage discount strategy with the given discount percentage.
     *
     * @param discountPercentage The percentage discount.
     */
    public PercentageDiscount(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double applyDiscount(double price) {
        return price * (1 - discountPercentage / 100);
    }
}

/**
 * Represents a shopping cart that applies a discount strategy.
 */
class ShoppingCart {
    private DiscountStrategy discountStrategy;

    /**
     * Constructs a shopping cart with a discount strategy.
     *
     * @param discountStrategy The discount strategy to apply.
     */
    public ShoppingCart(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    /**
     * Calculates the total price after applying the discount strategy.
     *
     * @param totalPrice The original total price.
     * @return The discounted total price.
     */
    public double calculateTotalPrice(double totalPrice) {
        return discountStrategy.applyDiscount(totalPrice);
    }
}

/**
 * Demonstrates the usage of different discount strategies in a shopping cart.
 */
class OCPExample {
    public static void main(String[] args) {
        double originalPrice = 100.0;

        DiscountStrategy flatDiscount = new FlatDiscount(20.0);
        DiscountStrategy percentageDiscount = new PercentageDiscount(15.0);

        ShoppingCart flatDiscountCart = new ShoppingCart(flatDiscount);
        ShoppingCart percentageDiscountCart = new ShoppingCart(percentageDiscount);

        // Calculate total price after applying different discount strategies
        double totalPriceWithFlatDiscount = flatDiscountCart.calculateTotalPrice(originalPrice);
        double totalPriceWithPercentageDiscount = percentageDiscountCart.calculateTotalPrice(originalPrice);

        System.out.println("Total price with flat discount: $" + totalPriceWithFlatDiscount);
        System.out.println("Total price with percentage discount: $" + totalPriceWithPercentageDiscount);
    }
}

/**
 * In the above program, the ShoppingCart class is closed for modification but
 * open for extension. It can work with any new discount strategies that implement
 * the DiscountStrategy interface without needing any changes to its existing code,
 * adhering to the Open/Closed Principle (OCP).
 */
