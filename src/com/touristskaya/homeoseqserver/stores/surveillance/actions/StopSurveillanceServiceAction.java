package com.touristskaya.homeoseqserver.stores.surveillance.actions;

import com.touristskaya.homeoseqserver.stores.common.Action;
import com.touristskaya.homeoseqserver.stores.surveillance.SurveillanceActionsFactory;

public class StopSurveillanceServiceAction implements Action {
    private Object mPayload;


    @Override
    public int getType() {
        return SurveillanceActionsFactory.StopSurveillanceService;
    }

    @Override
    public Object getPayload() {
        return mPayload;
    }

    @Override
    public void setPayload(Object payload) {
        mPayload = payload;
    }
}
