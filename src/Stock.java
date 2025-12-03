import java.util.ArrayList;
import java.util.List;

public class Stock implements StockSubject {
    final List<ClientObserver> clientList = new ArrayList<>();

    private String stockName;
    private double stockPrice;

    public Stock(String stockName, double stockPrice) {
        this.stockName = stockName;
        this.stockPrice = stockPrice;
    }

    @Override
    public void attach(ClientObserver observer) {
        if (!clientList.contains(observer)) {
            clientList.add(observer);
            System.out.println("[+] " + observer + " subscribed to " + stockName);
        }
    }

    @Override
    public void detach(ClientObserver observer) {
        if (clientList.remove(observer)) {
            System.out.println("[-] " + observer + " unsubscribed from " + stockName);
        }
    }

    @Override
    public void notifyClient() {
        System.out.println("\n>>> Notifying " + clientList.size() + " client(s) about " + stockName + "...\n");
        for (ClientObserver observer : new ArrayList<>(clientList)) { // snapshot
            observer.update(this);
        }
    }

    // Business method: price changed
    public void setStockPrice(double newPrice) {
        System.out.println("STOCK UPDATE: " + stockName + " price changed from $" + this.stockPrice + " → $" + newPrice);
        this.stockPrice = newPrice;
        notifyClient();
    }

    // Getters
    public String getStockName() { return stockName; }
    public double getStockPrice() { return stockPrice; }
}