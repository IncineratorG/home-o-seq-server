package com.touristskaya.homeoseqserver.services.surveillance;

import com.touristskaya.homeoseqlib.reactive.ObservableProperty;
import com.touristskaya.homeoseqlib.redux.State;

public class SurveillanceServiceState implements State {
    public ObservableProperty<String> stateString = new ObservableProperty<>();
}
