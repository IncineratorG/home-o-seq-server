package com.touristskaya.homeoseqserver.services.communication;

import com.touristskaya.homeoseqserver.common.types.reactive.ObservableProperty;
import com.touristskaya.homeoseqserver.stores.common.State;

public class CommunicationServiceState implements State {
    ObservableProperty<String> serverStateSerialized = new ObservableProperty<>();
    ObservableProperty<String> clientStateSerialized = new ObservableProperty<>();
}
