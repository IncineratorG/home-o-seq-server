package com.touristskaya.homeoseqserver.services.common;

import com.touristskaya.homeoseqserver.stores.common.State;

public interface DaemonService extends Service {
    void start();
    void stop();
    State getState();
}
