/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojavirtual.util;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
    
}
