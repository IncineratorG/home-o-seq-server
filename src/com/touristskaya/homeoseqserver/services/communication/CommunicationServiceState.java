package com.touristskaya.homeoseqserver.services.communication;

import com.touristskaya.homeoseqlib.reactive.ObservableProperty;
import com.touristskaya.homeoseqlib.redux.State;

public class CommunicationServiceState implements State {
    ObservableProperty<String> serverStateSerialized = new ObservableProperty<>();
    ObservableProperty<String> clientStateSerialized = new ObservableProperty<>();
}
