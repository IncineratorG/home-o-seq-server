package com.touristskaya.homeoseqserver.stores.surveillance;

import com.touristskaya.homeoseqserver.common.types.reactive.ObservableProperty;
import com.touristskaya.homeoseqserver.stores.common.State;

public class SurveillanceState implements State {
    public ObservableProperty<String> serviceStateString = new ObservableProperty<>();
}
