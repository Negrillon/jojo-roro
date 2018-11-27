package mysokoban.fx.output;

import javax.swing.*;
import java.awt.*;

public class FrameMenu extends JFrame {

    private JPanel jPanel = new JPanel();
    private JButton jButtonConsole = new JButton("Console");
    private JButton jButtonGraphic = new JButton("Graphic");


    public FrameMenu(){

        this.setTitle("Menu");
        this.setSize(1280 , 720 );
        this.setLocationRelativeTo(null);

        this.getContentPane().setBackground(Color.BLACK);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jPanel.add(jButtonConsole);
        //this.setContentPane(jPanel);
        this.getContentPane().add(jButtonConsole);
        this.setVisible(true);

    }

    private void Choix(){
        //this.getContentPane().
    }
}
