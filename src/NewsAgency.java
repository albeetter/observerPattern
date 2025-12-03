import java.util.ArrayList;
import java.util.List;

public class NewsAgency implements NewsSubject {
    private final List<SubscriberObserver> subscriberList = new ArrayList<>();
    private String agencyName;
    private News currentNews;

    public NewsAgency(String agencyName) {
        this.agencyName = agencyName;
    }

    @Override
    public void attach(SubscriberObserver observer) {
        if (!subscriberList.contains(observer)) {
            subscriberList.add(observer);
            System.out.println("[+] " + observer + " subscribed to " + agencyName);
        }
    }

    @Override
    public void detach(SubscriberObserver observer) {
        if (subscriberList.remove(observer)) {
            System.out.println("[-] " + observer + " unsubscribed from " + agencyName);
        }
    }

    @Override
    public void notifySubscribers() {
        System.out.println("\n>>> Notifying " + subscriberList.size() +
                " subscriber(s) from " + agencyName + "...\n");
        for (SubscriberObserver observer : new ArrayList<>(subscriberList)) {
            observer.update(currentNews);
        }
    }

    public void publishNews(String headline, String category, String content, String timestamp) {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("BREAKING NEWS PUBLISHED by " + agencyName);
        System.out.println("Headline: " + headline);
        System.out.println("Category: " + category);
        System.out.println("Time: " + timestamp);
        System.out.println("=".repeat(70));

        this.currentNews = new News(headline, category, content, timestamp);
        notifySubscribers();
    }

    public String getAgencyName() {
        return agencyName;
    }

    public int getSubscriberCount() {
        return subscriberList.size();
    }
}