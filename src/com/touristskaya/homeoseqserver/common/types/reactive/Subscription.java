package com.touristskaya.homeoseqserver.common.types.reactive;

import java.util.UUID;

/**
 * TODO: Add a class header comment
 */
public class Subscription {
    private String mUuid = null;
    private Observable mObservable;

    public Subscription(Observable o) {
        mUuid = UUID.randomUUID().toString();
        mObservable = o;
    }

    public void unsubscribe() {
        mObservable.unsubscribe(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subscription that = (Subscription) o;

        return mUuid != null ? mUuid.equals(that.mUuid) : that.mUuid == null;
    }

    @Override
    public int hashCode() {
        return mUuid != null ? mUuid.hashCode() : 0;
    }
}
