package com.touristskaya.homeoseqserver.stores;

import com.touristskaya.homeoseqlib.redux.Store;
import com.touristskaya.homeoseqserver.stores.surveillance.SurveillanceStore;

public class Stores {
    private static Stores mInstance = null;

    private SurveillanceStore mSurveillanceStore;

    public static final int SurveillanceStore = 1;


    private Stores() {
        mSurveillanceStore = new SurveillanceStore();
    }

    public static synchronized Stores getInstance() {
        if (mInstance != null)
            return mInstance;
        else {
            mInstance = new Stores();
            return mInstance;
        }
    }

    public Store getStore(int type) {
        switch (type) {
            case SurveillanceStore: {
                return mSurveillanceStore;
            }
        }

        return null;
    }
}
