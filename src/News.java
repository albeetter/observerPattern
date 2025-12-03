public class News {
    private String headline;
    private String category;
    private String content;
    private String timestamp;

    public News(String headline, String category, String content, String timestamp) {
        this.headline = headline;
        this.category = category;
        this.content = content;
        this.timestamp = timestamp;
    }

    public String getHeadline() {
        return headline;
    }

    public String getCategory() {
        return category;
    }

    public String getContent() {
        return content;
    }

    public String getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "News{" +
                "headline='" + headline + '\'' +
                ", category='" + category + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}