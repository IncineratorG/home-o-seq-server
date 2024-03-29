package com.touristskaya.homeoseqserver.stores.surveillance;

import com.touristskaya.homeoseqlib.redux.Action;
import com.touristskaya.homeoseqlib.redux.ActionsFactory;
import com.touristskaya.homeoseqlib.redux.State;
import com.touristskaya.homeoseqlib.redux.Store;
import com.touristskaya.homeoseqserver.services.Services;
import com.touristskaya.homeoseqserver.services.surveillance.SurveillanceService;
import com.touristskaya.homeoseqserver.services.surveillance.SurveillanceServiceState;

public class SurveillanceStore extends Store {
    private SurveillanceState mState;
    private SurveillanceActionsFactory mActionsFactory;
    private SurveillanceService mSurveillanceService;


    public SurveillanceStore() {
        mState = new SurveillanceState();
        mActionsFactory = new SurveillanceActionsFactory();
        mSurveillanceService = (SurveillanceService) Services.getInstance().getService(Services.SurveillanceService);
    }

    @Override
    public State getState() {
        return mState;
    }

    @Override
    public ActionsFactory getActionFactory() {
        return mActionsFactory;
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
            mState.serviceStateString.set(state.stateString.get());
        });
    }
}
