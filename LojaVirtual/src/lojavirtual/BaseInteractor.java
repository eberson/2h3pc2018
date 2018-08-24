/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojavirtual;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.ValidationException;

/**
 *
 * @author etec
 */
public abstract class BaseInteractor {
    
    private final BaseView view;

    public BaseInteractor(BaseView view) {
        this.view = view;
    }
    
    public void onError(Exception exception){
        Logger.getLogger(BaseInteractor.class.getName()).log(Level.SEVERE, "Erro ao processar interacao", exception);
        if (exception instanceof ValidationException){
            ValidationException ve = (ValidationException) exception;
            view.showMessage(MessageType.ERROR, ve.getMessage());
            return;
        }
        
        view.showMessage(MessageType.ERROR, exception.getMessage());
    }
    
    protected abstract void runImpl();
    
    public void run(){
        try {
            runImpl();
        } catch (Exception e) {
            onError(e);
        }
    }
    
    
    
}
