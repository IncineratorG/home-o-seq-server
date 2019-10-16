package com.touristskaya.homeoseqserver.services.surveillance;

import com.touristskaya.homeoseqlib.redux.State;
import com.touristskaya.homeoseqserver.services.common.DaemonService;

public class SurveillanceService implements DaemonService {
    private String CLASS_NAME = "SurveillanceService";

    private SurveillanceServiceState mState;

    public static final String ServiceStartedStatus = "started";
    public static final String ServiceStoppedStatus = "stopped";


    public SurveillanceService() {
        mState = new SurveillanceServiceState();
    }

    public State getState() {
        return mState;
    }

    public void start() {
        String METHOD_NAME = ".start()";

        System.out.println(CLASS_NAME + METHOD_NAME);

        mState.stateString.set(ServiceStartedStatus);
    }

    public void stop() {
        String METHOD_NAME = ".stop()";

        System.out.println(CLASS_NAME + METHOD_NAME);

        mState.stateString.set(ServiceStoppedStatus);
    }
}
