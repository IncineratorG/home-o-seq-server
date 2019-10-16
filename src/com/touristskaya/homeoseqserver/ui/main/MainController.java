package com.touristskaya.homeoseqserver.ui.main;

import com.sun.xml.internal.ws.developer.Serialization;
import com.touristskaya.homeoseqlib.redux.Action;
import com.touristskaya.homeoseqlib.states.server.ServerCommunicationState;
import com.touristskaya.homeoseqserver.common.SerializationHelper;
import com.touristskaya.homeoseqserver.services.Services;
import com.touristskaya.homeoseqserver.services.communication.CommunicationService;
import com.touristskaya.homeoseqserver.services.surveillance.SurveillanceService;
import com.touristskaya.homeoseqserver.stores.Stores;
import com.touristskaya.homeoseqserver.stores.surveillance.SurveillanceActionsFactory;
import com.touristskaya.homeoseqserver.stores.surveillance.SurveillanceState;
import com.touristskaya.homeoseqserver.stores.surveillance.SurveillanceStore;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private String CLASS_NAME = "MainController";

    public Label label;
    public Button setButton;

    private SurveillanceStore mSurveillanceStore;
    private SurveillanceState mSurveillanceState;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String METHOD_NAME = ".initialize()";
        System.out.println(CLASS_NAME + METHOD_NAME);

        label.setText(CLASS_NAME + METHOD_NAME);

        setButton.setOnAction((event) -> {
            System.out.println("CLICKED");

            String surveillanceServiceState = mSurveillanceState.serviceStateString.get();
            if (surveillanceServiceState == null || surveillanceServiceState.equals(SurveillanceService.ServiceStoppedStatus)) {
                Action startServiceAction = mSurveillanceStore.getActionFactory().getAction(SurveillanceActionsFactory.StartSurveillanceService);
                mSurveillanceStore.dispatch(startServiceAction);
            } else {
                Action stopServiceAction = mSurveillanceStore.getActionFactory().getAction(SurveillanceActionsFactory.StopSurveillanceService);
                mSurveillanceStore.dispatch(stopServiceAction);
            }
        });


        mSurveillanceStore = (SurveillanceStore) Stores.getInstance().getStore(Stores.SurveillanceStore);
        mSurveillanceState = (SurveillanceState) mSurveillanceStore.getState();

        Action bindSurveillanceServiceStateAction = mSurveillanceStore.getActionFactory().getAction(SurveillanceActionsFactory.BindSurveillanceServiceState);
        mSurveillanceStore.dispatch(bindSurveillanceServiceStateAction);

        mSurveillanceState.serviceStateString.subscribe(() -> {
            ServerCommunicationState serverCommunicationState = new ServerCommunicationState();
            serverCommunicationState.serverState.set("NEW_STATE");
            serverCommunicationState.timestamp.set(System.currentTimeMillis());

            String serializedState = SerializationHelper.objectToString(serverCommunicationState);


            CommunicationService communicationService = (CommunicationService) Services.getInstance().getService(Services.CommunicationService);
            communicationService.sendSerializedString(serializedState);
        });
    }
}
