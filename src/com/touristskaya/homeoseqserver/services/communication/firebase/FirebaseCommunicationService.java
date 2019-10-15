package com.touristskaya.homeoseqserver.services.communication.firebase;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.touristskaya.homeoseqserver.services.communication.CommunicationServiceState;
import com.touristskaya.homeoseqserver.services.communication.common.TransmissionService;
import com.touristskaya.homeoseqserver.stores.common.State;

public class FirebaseCommunicationService implements TransmissionService {
    private static String mFirebaseUrl = "https://surveillance-136a9.firebaseio.com/";
    private static String mClientStateField = "TEST_FIELD";
    private static String mServerStateField = "TEST_FIELD";
    private Firebase mFirebaseDatabase;
    private ValueEventListener mClientStateListener;
    private ValueEventListener mServerStateListener;
    private CommunicationServiceState mCommunicationServiceState;


    public FirebaseCommunicationService(CommunicationServiceState state) {
        mFirebaseDatabase = new Firebase(mFirebaseUrl);
        mCommunicationServiceState = state;
        mClientStateListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot == null || dataSnapshot.getValue() == null) {
                    System.out.println("DATA_IS_EMPTY");
                    return;
                }

                System.out.println("MESSAGE_NOT_NULL: " + dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        };
    }

    @Override
    public void sendSerializedString(String s) {
        mFirebaseDatabase.child(mServerStateField).setValue(s);
    }

    @Override
    public void start() {
        Firebase.goOnline();
        mFirebaseDatabase.child(mClientStateField).addValueEventListener(mClientStateListener);
    }

    @Override
    public void stop() {
        mFirebaseDatabase.child(mClientStateField).removeEventListener(mClientStateListener);
        Firebase.goOffline();
    }

    @Override
    public State getState() {
        return mCommunicationServiceState;
    }
}
