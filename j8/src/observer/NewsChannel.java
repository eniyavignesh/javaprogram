package observer;


public class NewsChannel implements Observer {
    private String news;

    @Override
    public void update(String message) {
        this.news = message;
        display();
    }

    private void display() {
        System.out.println("Breaking news: " + news);
    }
}