package com.touristskaya.homeoseqserver.services.communication.firebase;

import com.firebase.client.Firebase;
import com.touristskaya.homeoseqserver.services.communication.common.TransmissionService;
import com.touristskaya.homeoseqserver.stores.common.State;

public class FirebaseCommunicationService implements TransmissionService {
    private static String mFirebaseUrl = "https://surveillance-136a9.firebaseio.com/";
    private static String mClientStateField = "TEST_FIELD";
    private static String mServerStateField = "TEST_FIELD";
    private Firebase mFirebaseDatabase;


    public FirebaseCommunicationService() {
        mFirebaseDatabase = new Firebase(mFirebaseUrl);
    }

    @Override
    public void sendSerializedString(String s) {
        mFirebaseDatabase.child(mServerStateField).setValue(s);
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {
        Firebase.goOffline();
    }

    @Override
    public State getState() {
        return null;
    }
}
