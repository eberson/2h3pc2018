/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojavirtual;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 *
 * @author etec
 */
public abstract class BaseViewImpl implements BaseView{
    
    protected abstract Label currentLabelForMessage();

    @Override
    public void showMessage(MessageType type, String message) {
        Label labelMessage = currentLabelForMessage();
        
        labelMessage.setOpacity(0.0);
        
        switch(type){
            case ERROR: labelMessage.setTextFill(Color.RED); break;
            case INFO: labelMessage.setTextFill(Color.BLUE); break;
            case WARNING: labelMessage.setTextFill(Color.ORANGE); break;
            default: labelMessage.setTextFill(Color.BLACK); 
        }
        
        labelMessage.setText(message);
        
        FadeTransition hide = new FadeTransition(
                Duration.millis(500), 
                labelMessage
        );
        
        hide.setFromValue(1.0);
        hide.setToValue(0.0);
        hide.setCycleCount(1);
        hide.setAutoReverse(false);
        hide.setDelay(Duration.seconds(5));
        
        FadeTransition show = new FadeTransition(
                Duration.millis(500), 
                labelMessage
        );
        
        show.setFromValue(0.0);
        show.setToValue(1.0);
        show.setCycleCount(1);
        show.setAutoReverse(false);
        show.setOnFinished((ActionEvent event) -> hide.play());
        show.play();
    }
    
}
