package shorts.v4;

import java.util.ArrayList;
import java.util.List;

// Event class
class Event {
    private String message;

    public Event(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

// Subscriber interface
interface Subscriber {
    void update(Event event);
}

// Publisher class
class Publisher {
    private List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void publish(Event event) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(event);
        }
    }
}

// Example Subscriber implementation
class ExampleSubscriber implements Subscriber {
    private String name;

    public ExampleSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(Event event) {
        System.out.println(name + " received event: " + event.getMessage());
    }
}

// Main class to demonstrate the pub-sub pattern
public class PubSubDemo {
    public static void main(String[] args) {
        Publisher publisher = new Publisher();

        Subscriber subscriber1 = new ExampleSubscriber("Subscriber 1");
        Subscriber subscriber2 = new ExampleSubscriber("Subscriber 2");

        publisher.subscribe(subscriber1);
        publisher.subscribe(subscriber2);

        Event event = new Event("Hello, Subscribers!");
        publisher.publish(event);

        publisher.unsubscribe(subscriber1);

        Event anotherEvent = new Event("Another event!");
        publisher.publish(anotherEvent);
    }
}
