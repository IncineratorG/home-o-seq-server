package com.touristskaya.homeoseqserver.services.common;

import com.touristskaya.homeoseqlib.redux.State;

public interface DaemonService extends Service {
    void start();
    void stop();
    State getState();
}
