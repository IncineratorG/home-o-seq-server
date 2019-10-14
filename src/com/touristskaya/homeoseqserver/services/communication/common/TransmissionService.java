package com.touristskaya.homeoseqserver.services.communication.common;

import com.touristskaya.homeoseqserver.services.common.DaemonService;

public interface TransmissionService extends DaemonService {
    void sendSerializedString(String s);
}
