public class PSE {
    public static void main(String[] args) {
        // Create ConcreteSubject
        Stock googleStock = new Stock("GOOGLE", 2800.00);

        // Create ConcreteObservers
        Client investor1 = new Client("Warren Buffett");
        Client investor2 = new Client("Cathie Wood");
        Client investor3 = new Client("Retail Trader");

        // Register observers
        googleStock.attach(investor1);
        googleStock.attach(investor2);
        googleStock.attach(investor3);

        System.out.println("\n" + "=".repeat(60));

        // Change stock price → triggers notification
        googleStock.setStockPrice(2950.50);

        System.out.println("=".repeat(60));

        // One investor unsubscribes
        googleStock.detach(investor2);

        // Another price update
        googleStock.setStockPrice(3020.75);

        System.out.println("Final registered clients: " +
                ((Stock)googleStock).clientList.size()); // Note: clientList is private → use getter in real code
    }
}