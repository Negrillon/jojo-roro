/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysokoban.fx;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.*;
import java.util.Scanner;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import mysokoban.fx.core.Deplacement;
import mysokoban.fx.core.Level;
import mysokoban.fx.output.ConsoleOutput;
import mysokoban.fx.output.Frame;
import mysokoban.fx.output.FrameMenu;
import mysokoban.fx.testgoal.TestGoal;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author joris
 */
public class MySokobanFX extends JApplet {
    
    private static final int JFXPANEL_WIDTH_INT = 300;
    private static final int JFXPANEL_HEIGHT_INT = 250;
    private static JFXPanel fxContainer;

    private static Level lvl;
    private static Frame frame1;


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (Exception e) {
                }
                
                JFrame frame = new JFrame("JavaFX 2 in Swing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                JApplet applet = new MySokobanFX();
                applet.init();
                
                frame.setContentPane(applet.getContentPane());
                
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                
                applet.start();


                //Test affichage level

                lvl = new Level();

                lvl.loadLevel("/Users/joris/Document/Projet ING3/jojo-roro/MySokoban FX/src/ressource/map/map_01");

                System.out.println("Pressez la touche 1 pour jouer en mode console \r");
                System.out.println("Pressez la touche 2 pour jouer en mode graphique \r");

                Scanner choiceMode = new Scanner(System.in);
                String resultChoiceMode = choiceMode.nextLine();


                //FrameMenu frameMenu = new FrameMenu();

                if (resultChoiceMode.equals("1")){
                    System.out.println("1");
                    ConsoleOutput.ConsoleMapDispay(lvl);
                }else if (resultChoiceMode.equals("2")){
                    System.out.println("2");
                    frame1 = new Frame("Graphique",lvl);
                }


            }
        });
    }
    
    @Override
    public void init() {
        fxContainer = new JFXPanel();
        fxContainer.setPreferredSize(new Dimension(JFXPANEL_WIDTH_INT, JFXPANEL_HEIGHT_INT));
        add(fxContainer, BorderLayout.CENTER);
        // create JavaFX scene
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                createScene();
            }
        });
    }
    
    /*private void createScene() {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        fxContainer.setScene(new Scene(root));

        btn.setOnKeyPressed(e -> {
            lvl = new Deplacement(lvl).keypressed(e.getCode());

            ConsoleOutput.ConsoleMapDispay(lvl);
            frame1.refresh();

            if(!TestGoal.test(lvl)){
                System.out.println("la partie n'est pas finit");
            }else{
                System.out.println("gagné");
            }
        });
    }*/

    private void createScene() {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        fxContainer.setScene(new Scene(root));

        //frame1.addKeyListener();

        btn.setOnKeyPressed(e -> {
            lvl = new Deplacement(lvl).keypressed(e.getCode());

            ConsoleOutput.ConsoleMapDispay(lvl);
            frame1.refresh(lvl);

            if(!TestGoal.test(lvl)){
                System.out.println("la partie n'est pas finit");
            }else{
                System.out.println("gagné");
            }
        });
    }


    
}
