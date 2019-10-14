package com.touristskaya.homeoseqserver.common.types.reactive;

/**
 * TODO: Add a class header comment
 */
public class Observable {
    private Subscribers mSubscribers;


    public Observable() {
        mSubscribers = new Subscribers();
    }

    public Subscription subscribe(Executable e) {
        Subscription subscription = new Subscription(this);

        Subscriber subscriber = new Subscriber(subscription, e);
        mSubscribers.add(subscriber);

        return subscription;
    }

    public boolean unsubscribe(Subscription s) {
        return mSubscribers.remove(s);
    }

    protected void notifySubscribers() {
        mSubscribers.runAll();
    }
}
