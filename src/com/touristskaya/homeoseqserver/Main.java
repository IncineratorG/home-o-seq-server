package com.touristskaya.homeoseqserver;

import com.touristskaya.homeoseqserver.services.Services;
import com.touristskaya.homeoseqserver.services.common.DaemonService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("resources/ui/main/main_view.fxml"));
        primaryStage.setTitle("ДомОSeq");
        primaryStage.setScene(new Scene(root, 640, 480));
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();

        DaemonService communicationService = (DaemonService) Services.getInstance().getService(Services.CommunicationService);
        communicationService.stop();
    }
}
