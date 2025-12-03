public class NewsService {
    public static void main(String[] args) {
        NewsAgency cnnNews = new NewsAgency("CNN Breaking News");

        Subscriber subscriber1 = new Subscriber("John Doe");
        Subscriber subscriber2 = new Subscriber("Jane Smith", "Sports");
        Subscriber subscriber3 = new Subscriber("Tech Enthusiast", "Technology");
        Subscriber subscriber4 = new Subscriber("Political Analyst", "Politics");

        System.out.println("\n" + "=".repeat(70));
        System.out.println("SUBSCRIPTION PHASE");
        System.out.println("=".repeat(70));

        cnnNews.attach(subscriber1);
        cnnNews.attach(subscriber2);
        cnnNews.attach(subscriber3);
        cnnNews.attach(subscriber4);

        cnnNews.publishNews(
                "Major Earthquake Hits California",
                "Breaking News",
                "A 7.2 magnitude earthquake has struck Southern California...",
                "2024-12-03 14:30:00"
        );

        cnnNews.publishNews(
                "Lakers Win NBA Championship",
                "Sports",
                "The Los Angeles Lakers defeated the Boston Celtics in Game 7...",
                "2024-12-03 15:45:00"
        );

        System.out.println("\n" + "=".repeat(70));
        System.out.println("DYNAMIC PREFERENCE UPDATE");
        System.out.println("=".repeat(70) + "\n");

        subscriber1.setPreference("Technology");

        cnnNews.publishNews(
                "Revolutionary AI Model Released",
                "Technology",
                "A new AI model has been released that achieves human-level performance...",
                "2024-12-03 16:20:00"
        );

        System.out.println("\n" + "=".repeat(70));
        System.out.println("UNSUBSCRIPTION PHASE");
        System.out.println("=".repeat(70) + "\n");

        cnnNews.detach(subscriber2);

        cnnNews.publishNews(
                "New Climate Policy Announced",
                "Politics",
                "The government has announced a comprehensive climate action plan...",
                "2024-12-03 17:00:00"
        );

        System.out.println("\n" + "=".repeat(70));
        System.out.println("SYSTEM STATISTICS");
        System.out.println("=".repeat(70));
        System.out.println("Final registered subscribers: " + cnnNews.getSubscriberCount());
        System.out.println("Agency: " + cnnNews.getAgencyName());
        System.out.println("=".repeat(70) + "\n");
    }
}