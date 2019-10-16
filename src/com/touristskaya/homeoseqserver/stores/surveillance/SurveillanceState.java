package com.touristskaya.homeoseqserver.stores.surveillance;


import com.touristskaya.homeoseqlib.reactive.ObservableProperty;
import com.touristskaya.homeoseqlib.redux.State;

public class SurveillanceState implements State {
    public ObservableProperty<String> serviceStateString = new ObservableProperty<>();
}
