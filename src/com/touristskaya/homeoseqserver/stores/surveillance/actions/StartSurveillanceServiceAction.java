package com.touristskaya.homeoseqserver.stores.surveillance.actions;

import com.touristskaya.homeoseqlib.redux.Action;
import com.touristskaya.homeoseqserver.stores.surveillance.SurveillanceActionsFactory;

public class StartSurveillanceServiceAction implements Action {
    private Object mPayload;


    @Override
    public int getType() {
        return SurveillanceActionsFactory.StartSurveillanceService;
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
