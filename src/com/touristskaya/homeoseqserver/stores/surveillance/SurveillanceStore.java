package com.touristskaya.homeoseqserver.stores.surveillance;

import com.touristskaya.homeoseqserver.services.Services;
import com.touristskaya.homeoseqserver.stores.common.Action;
import com.touristskaya.homeoseqserver.stores.common.ActionsFactory;
import com.touristskaya.homeoseqserver.stores.common.State;
import com.touristskaya.homeoseqserver.stores.common.Store;
import com.touristskaya.homeoseqserver.services.surveillance.SurveillanceService;
import com.touristskaya.homeoseqserver.services.surveillance.SurveillanceServiceState;

public class SurveillanceStore extends Store {
    private SurveillanceState mSurveillanceState;
    private SurveillanceActionsFactory mSurveillanceActionsFactory;
    private SurveillanceService mSurveillanceService;


    public SurveillanceStore() {
        mSurveillanceState = new SurveillanceState();
        mSurveillanceActionsFactory = new SurveillanceActionsFactory();
        mSurveillanceService = (SurveillanceService) Services.getInstance().getService(Services.SurveillanceService);
    }

    @Override
    public State getState() {
        return mSurveillanceState;
    }

    @Override
    public ActionsFactory getActionFactory() {
        return mSurveillanceActionsFactory;
    }

    @Override
    protected void reduce(Action action) {
        switch (action.getType()) {
            case SurveillanceActionsFactory.StartSurveillanceService: {
                startSurveillanceServiceReducer(action);
                break;
            }

            case SurveillanceActionsFactory.StopSurveillanceService: {
                stopSurveillanceServiceReduce(action);
                break;
            }

            case SurveillanceActionsFactory.BindSurveillanceServiceState: {
                bindSurveillanceStateReduce(action);
                break;
            }
        }
    }

    @Override
    protected void effect(Action action) {

    }


    private void startSurveillanceServiceReducer(Action action) {
        mSurveillanceService.start();
    }

    private void stopSurveillanceServiceReduce(Action action) {
        mSurveillanceService.stop();
    }

    private void bindSurveillanceStateReduce(Action action) {
        SurveillanceServiceState state = (SurveillanceServiceState) mSurveillanceService.getState();

        state.stateString.subscribe(() -> {
            mSurveillanceState.serviceStateString.set(state.stateString.get());
        });
    }
}
