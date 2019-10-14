package com.touristskaya.homeoseqserver.stores.common;

/**
 * TODO: Add a class header comment
 */
public interface Action {
    int getType();
    Object getPayload();
    void setPayload(Object payload);
}
