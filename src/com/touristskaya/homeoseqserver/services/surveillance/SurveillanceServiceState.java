package com.touristskaya.homeoseqserver.services.surveillance;

import com.touristskaya.homeoseqserver.common.types.reactive.ObservableProperty;
import com.touristskaya.homeoseqserver.stores.common.State;

public class SurveillanceServiceState implements State {
    public ObservableProperty<String> stateString = new ObservableProperty<>();
}
