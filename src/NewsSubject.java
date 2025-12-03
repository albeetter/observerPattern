public interface NewsSubject {
    void attach(SubscriberObserver observer);
    void detach(SubscriberObserver observer);
    void notifySubscribers();
}