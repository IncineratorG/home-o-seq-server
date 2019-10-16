package com.touristskaya.homeoseqserver.stores.surveillance;

import com.touristskaya.homeoseqlib.redux.Action;
import com.touristskaya.homeoseqlib.redux.ActionsFactory;
import com.touristskaya.homeoseqserver.stores.surveillance.actions.BindSurveillanceServiceStateAction;
import com.touristskaya.homeoseqserver.stores.surveillance.actions.StartSurveillanceServiceAction;
import com.touristskaya.homeoseqserver.stores.surveillance.actions.StopSurveillanceServiceAction;

public class SurveillanceActionsFactory implements ActionsFactory {
    public static final int StartSurveillanceService = 1;
    public static final int StopSurveillanceService = 2;
    public static final int BindSurveillanceServiceState = 3;


    @Override
    public Action getAction(int type) {
        switch (type) {
            case StartSurveillanceService: {
                return new StartSurveillanceServiceAction();
            }

            case StopSurveillanceService: {
                return new StopSurveillanceServiceAction();
            }

            case BindSurveillanceServiceState: {
                return new BindSurveillanceServiceStateAction();
            }
        }

        return null;
    }
}
