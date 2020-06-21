package validaciones;

import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

/**
 *
 * @author Joan
 */
public class Validaciones {
    
    JFrame frame = new JFrame();   
    
    private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
    
    public void validarTamano(JTextField campoTexto, KeyEvent evt, int limite){
                        
        if(campoTexto.getText().length() >= limite){
            frame.getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese sólo " + limite + " caracteres");
        }
        
    }
    
    public boolean esCaracterEspecial(int numChar){
        
        boolean result = false;                                   
        
        if((numChar > 32) && (numChar <= 47)
                ||((numChar >=58) && (numChar <=64))
                ||((numChar >=91) && (numChar <=96))
                ||((numChar >=123) && (numChar <=255))){
            result = true;
        }     
        
        //Se define un arreglo con los números de los char con tilde y ñ Ñ
        
        int[] validos = {241, 209, 225, 193, 233, 201, 237, 205, 211, 243, 250, 218}; 
        
        for (int i = 0; i < validos.length; i++) {
            if(numChar == validos[i]){
                result = false;
                break;
            }            
        } 
        
        return result;
        
    }
    
    
    public void validarNumeros(KeyEvent evt){
        
        char c = evt.getKeyChar();
        int numChar = (int) c;
        
        if(Character.isLetter(c)){
            evt.consume();
        }
       
        else if (esCaracterEspecial(numChar)){
        
            evt.consume();
        } 
        
    }
    
    public void validarLetras(KeyEvent evt){
        
        char c = evt.getKeyChar();
        int numChar = (int) c;
        
        if(Character.isDigit(c)){
            
            evt.consume();
        }       
                
        else if (esCaracterEspecial(numChar)){
            
            evt.consume();            
        }  
        
    }
    
    
    public boolean validarEmail(String email){
        
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
 
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
        
    }

    public void validarTamanoArea(JTextArea campoTexto, KeyEvent evt, int limite) {
        if(campoTexto.getText().length() >= limite){
            frame.getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese sólo " + limite + " caracteres");
        }
    }
    
    
    
    
}
