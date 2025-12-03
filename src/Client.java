public class Client implements ClientObserver {
        private final String clientName;

        public Client(String clientName) {
            this.clientName = clientName;
        }

        @Override
        public void update(Stock stock) {
            System.out.println("NOTIFICATION → " + clientName);
            System.out.println("   Stock: " + stock.getStockName());
            System.out.println("   New Price: $" + stock.getStockPrice() + "\n");
        }

        @Override
        public String toString() {
            return "Client{" + clientName + "}";
        }
}

