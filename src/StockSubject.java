public interface StockSubject {
    void attach(ClientObserver observer);
    void detach(ClientObserver observer);
    void notifyClient();
}
