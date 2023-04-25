package observer;

public class Client {
    public static void main(String[] args) {
        NewsAgency newsAgency = new NewsAgency();
        NewsChannel newsChannel1 = new NewsChannel();
        NewsChannel newsChannel2 = new NewsChannel();

        newsAgency.attach(newsChannel1);
        newsAgency.attach(newsChannel2);

        newsAgency.notifyObservers("COVID-19 vaccine approved by FDA");

        newsAgency.detach(newsChannel2);

        newsAgency.notifyObservers("Bitcoin hits all-time high");
    }
}

/*
In this example, the Subject interface defines methods for attaching, detaching, and notifying observers.
 The NewsAgency class implements the Subject interface and maintains a list of observers that are interested 
 in receiving updates. 
The Observer interface defines the update() method that is called by the subject when a new message is available.
 The NewsChannel class implements the Observer interface and displays the breaking news message.

The Client class demonstrates how the Observer pattern can be used to notify multiple observers when a
 new message is available. The NewsAgency object maintains a list of observers and notifies them
whenever a new message is available. The observers then display the message in their own way.

*/