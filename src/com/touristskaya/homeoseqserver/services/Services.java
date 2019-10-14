package com.touristskaya.homeoseqserver.services;

import com.touristskaya.homeoseqserver.services.common.Service;
import com.touristskaya.homeoseqserver.services.communication.CommunicationService;
import com.touristskaya.homeoseqserver.services.surveillance.SurveillanceService;

public class Services {
    private static Services mInstance = null;

    private SurveillanceService mSurveillanceService;
    private CommunicationService mCommunicationService;

    public static final int SurveillanceService = 1;
    public static final int CommunicationService = 2;


    private Services() {
        mSurveillanceService = new SurveillanceService();
        mCommunicationService = new CommunicationService();

    }

    public static synchronized Services getInstance() {
        if (mInstance != null)
            return mInstance;
        else {
            mInstance = new Services();
            return mInstance;
        }
    }

    public Service getService(int type) {
        switch (type) {
            case SurveillanceService: {
                return mSurveillanceService;
            }

            case CommunicationService: {
                return mCommunicationService;
            }
        }

        return null;
    }
}
