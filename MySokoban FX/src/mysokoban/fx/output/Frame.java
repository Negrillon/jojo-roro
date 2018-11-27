package mysokoban.fx.output;

import com.apple.eawt.FullScreenAdapter;
import mysokoban.fx.core.Coord_x_y;
import mysokoban.fx.core.Deplacement;
import mysokoban.fx.core.Level;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static mysokoban.fx.output.ConsoleOutput.*;

public class Frame extends JFrame {

    public Level lvl;

    public static Panel panel;
    public static int[][] array = new int[11][19];
    public  Deplacement deplacement;

    public Coord_x_y coordPerso;


    public int width;
    public int height;

    public Frame(String title, Level lvl) {

        deplacement = new Deplacement(lvl);

        array = lvl.mapLevel;

        //Création de la barre des tâches avec ses options
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu, jSubMenu;
        JMenuItem jMenuItem;

        jMenu = new JMenu("Menu");
        jSubMenu = new JMenu("SubMenu");
        jMenu.setMnemonic(KeyEvent.VK_A);
        jMenu.getAccessibleContext().setAccessibleDescription("Menu description");
        jMenu.addSeparator();
        jMenu.add(jSubMenu);
        jMenuBar.add(jMenu);

        jMenuItem = new JMenuItem("Quit", KeyEvent.VK_T);
        //Raccourci (ex: Ctrl Q) pour aller plus vite sans devoir passer par le menu
        jMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,KeyEvent.VK_ALT));
        jMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jMenu.add(jMenuItem);

        //Ajout de la barre des tâches à la frame(Interface Graphique)
        this.setJMenuBar(jMenuBar);


        Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(dimension);
        int width = (int) dimension.getWidth();
        int height = (int) dimension.getHeight();
        this.setSize(width, height);



        this.getContentPane().setBackground(Color.BLACK);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setTitle(title);
        this.setVisible(true);

        this.height=height;
        this.width=width;
        //System.out.println(array[0][4]);

        panel = new Panel(width,height,lvl);

        this.setContentPane(panel);

        for(int i = 0; i< 11;i++){
            for (int j = 0; j < 19; j++) {
                //System.out.print(level.getMapLevel()[i][j] + " ");
                if(lvl.mapLevel[i][j] == 1)
                    System.out.print(ANSI_RED + "1 "+ ANSI_RESET);
                else if(lvl.mapLevel[i][j] == 2)
                    System.out.print(ANSI_BLUE + "2 "+ ANSI_RESET);
                else if(lvl.mapLevel[i][j] == 5)
                    System.out.print(ANSI_PURPLE + "5 "+ ANSI_RESET);
                else if(lvl.mapLevel[i][j] == 4)
                    System.out.print(ANSI_GREEN + "4 "+ ANSI_RESET);
                else System.out.print(lvl.mapLevel[i][j] + " ");
            }System.out.println();}

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                /*switch (e.getKeyCode()){
                    case KeyEvent.VK_UP :
                        System.out.println();
                        deplacement.keypressed();

                        lvl.mapLevel[lvl.playerCoord.getX()][lvl.playerCoord.getY()] = lvl.mapLevel[lvl.playerCoord.getX()][lvl.playerCoord.getY()+1];

                        for(int i = 0; i< 11;i++){
                            for (int j = 0; j < 19; j++) {
                                //System.out.print(level.getMapLevel()[i][j] + " ");
                                if(lvl.mapLevel[i][j] == 1)
                                    System.out.print(ANSI_RED + "1 "+ ANSI_RESET);
                                else if(lvl.mapLevel[i][j] == 2)
                                    System.out.print(ANSI_BLUE + "2 "+ ANSI_RESET);
                                else if(lvl.mapLevel[i][j] == 5)
                                    System.out.print(ANSI_PURPLE + "5 "+ ANSI_RESET);
                                else if(lvl.mapLevel[i][j] == 4)
                                    System.out.print(ANSI_GREEN + "4 "+ ANSI_RESET);
                                else System.out.print(lvl.mapLevel[i][j] + " ");
                            }System.out.println();}
                        break;
                    case KeyEvent.VK_DOWN :
                        System.out.println("bas");
                        deplacement.move();
                        break;
                    case KeyEvent.VK_LEFT :
                        System.out.println("gauche");
                        deplacement.move();
                        break;
                    case KeyEvent.VK_RIGHT :
                        System.out.println("droite");
                        deplacement.move();
                        break;
                }*/
                getContentPane().removeAll();
                getContentPane().revalidate();
                getContentPane().repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    public void refresh(Level lvl){
        this.lvl = lvl;
        ConsoleMapDispay(lvl);
        getContentPane().removeAll();
        getContentPane().revalidate();
        getContentPane().repaint();
    }
}
