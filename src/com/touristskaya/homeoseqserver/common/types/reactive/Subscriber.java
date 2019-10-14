package com.touristskaya.homeoseqserver.common.types.reactive;

/**
 * TODO: Add a class header comment
 */
public class Subscriber {
    private Subscription mSubscription;
    private Executable mExecutable;


    public Subscriber(Subscription s, Executable e) {
        this.mSubscription = s;
        this.mExecutable = e;
    }

    public Subscription getSubscription() {
        return mSubscription;
    }

    public  Executable getExecutable() {
        return mExecutable;
    }
}
