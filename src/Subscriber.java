public class Subscriber implements SubscriberObserver {
    private final String subscriberName;
    private String preference;

    public Subscriber(String subscriberName) {
        this.subscriberName = subscriberName;
        this.preference = "All";
    }

    public Subscriber(String subscriberName, String preference) {
        this.subscriberName = subscriberName;
        this.preference = preference;
    }

    @Override
    public void update(News news) {
        if (preference.equals("All") || preference.equalsIgnoreCase(news.getCategory())) {
            System.out.println("NOTIFICATION → " + subscriberName);
            System.out.println("   Headline: " + news.getHeadline());
            System.out.println("   Category: " + news.getCategory());
            System.out.println("   Time: " + news.getTimestamp());
            System.out.println("   Content: " + news.getContent() + "\n");
        } else {
            System.out.println("SKIPPED → " + subscriberName +
                    " (only interested in " + preference + " news)\n");
        }
    }

    public void setPreference(String preference) {
        System.out.println("[~] " + subscriberName +
                " changed preference from '" + this.preference +
                "' to '" + preference + "'");
        this.preference = preference;
    }

    public String getPreference() {
        return preference;
    }

    @Override
    public String toString() {
        return "Subscriber{" + subscriberName + ", prefers=" + preference + "}";
    }
}