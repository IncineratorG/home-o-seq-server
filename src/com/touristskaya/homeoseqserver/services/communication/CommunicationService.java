package com.touristskaya.homeoseqserver.services.communication;

import com.touristskaya.homeoseqserver.services.communication.common.TransmissionService;
import com.touristskaya.homeoseqserver.services.communication.firebase.FirebaseCommunicationService;
import com.touristskaya.homeoseqserver.stores.common.State;

public class CommunicationService implements TransmissionService {
    private FirebaseCommunicationService mFirebaseCommunicationService;
    private CommunicationServiceState mCommunicationServiceState;


    public CommunicationService() {
        mCommunicationServiceState = new CommunicationServiceState();
        mFirebaseCommunicationService = new FirebaseCommunicationService(mCommunicationServiceState);
    }

    @Override
    public void sendSerializedString(String s) {
        mFirebaseCommunicationService.sendSerializedString(s);
    }

    @Override
    public void start() {
        mFirebaseCommunicationService.start();
    }

    @Override
    public void stop() {
        mFirebaseCommunicationService.stop();
    }

    @Override
    public State getState() {
        return mFirebaseCommunicationService.getState();
    }
}
