/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojavirtual.util;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lojavirtual.OpenListener;
import lojavirtual.ViewListener;

/**
 *
 * @author etec
 */
public class StageUtil {
    
    public static void openNewStage(Parent parent){
        Scene scene = new Scene(parent);
        
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    
    public static <T> void openNewStage(URL fxmlUrl){
        try {
            FXMLLoader loader = new FXMLLoader(fxmlUrl);
            
            Parent root = loader.load();
            
            Scene scene = new Scene(root);
            
            Stage stage = new Stage();
            stage.setScene(scene);
            
            Initializable controller = loader.getController();
            
            if (controller instanceof ViewListener){
                ((ViewListener) controller).registerEvents(stage);
            }
            
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(StageUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static <T> void openNewStage(URL fxmlUrl, Class<T> type, OpenListener<T>... listeners){
        try {
            FXMLLoader loader = new FXMLLoader(fxmlUrl);
            
            Parent root = loader.load();
            
            Scene scene = new Scene(root);
            
            Stage stage = new Stage();
            stage.setScene(scene);
            
            Initializable controller = loader.getController();
            
            if (controller instanceof ViewListener){
                ((ViewListener) controller).registerEvents(stage);
            }
            for (OpenListener<T> listener : listeners){
                if (type.isAssignableFrom(controller.getClass())){
                    listener.onOpen((T) controller);
                }                
            }
            
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(StageUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
