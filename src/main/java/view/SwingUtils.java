/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author gr
 */
public class SwingUtils {
    private static DisplayMode mode;
    private static GraphicsDevice device;
    private SwingUtils(){
        super();
    }
    private static void loadDisplayInfos(){
        GraphicsEnvironment gEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
        device = gEnv.getDefaultScreenDevice();
        mode = device.getDisplayMode();
    }
    /**
     * return the insets of the screen
     */
    private static Insets getInsets(){
        return Toolkit.getDefaultToolkit().getScreenInsets(device.getDefaultConfiguration());
        
    }
    /**
     * Center a frame on the screen
     */
    public static void centerFrame(JFrame frame){
        if(mode == null){
            loadDisplayInfos();
        }
        frame.setLocation((getWidth()-frame.getWidth())/2, (getHeight()-frame.getHeight())/2);
    }
    public static int getHeight(){
        if(mode == null){
            loadDisplayInfos();
        }
        return mode.getHeight()- getInsets().bottom-getInsets().top;
    }
    public static int getWidth(){
        if(mode == null){
            loadDisplayInfos();
        }
        return mode.getWidth() - getInsets().left - getInsets().right;
    }
    public static int getMainHeight(){
        if(mode == null){
            loadDisplayInfos();
        }
        return mode.getHeight();          
    }
    public static int getMainWidth(){
        if(mode == null) {
            loadDisplayInfos();
        }
        return mode.getWidth();
    }
}
