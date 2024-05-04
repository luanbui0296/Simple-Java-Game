package myGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Circle extends JFrame{

    private boolean isDraw = false;
    private CircleFrame cf;
    private LunchBox lb;
    private JButton draw;

    public Circle (){ // see Java Naming Conventions https://www.geeksforgeeks.org/java-naming-conventions

        super("2D Product Assembly Game");
        setSize(1000,1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout bord = new BorderLayout(); //you never use bord
        setLayout(bord);  //BTW BorderLayout is the default for JFrame content pane

        //you do not want to add a new panel with every button click so it
        //should NOT be triggered by the action listener
        cf = new CircleFrame();
        add(cf, BorderLayout.CENTER);

//        lb=new LunchBox();
//        add(lb, BorderLayout.CENTER);

        //creating a button
        draw = new JButton("Draw");
        draw.addActionListener(event ->  toggleDrawErase() );
        //you also need to add the button
        add(draw, BorderLayout.PAGE_END);

        pack();
        setVisible(true);
    }


    private void toggleDrawErase() {
        isDraw = ! isDraw;
        cf.setDraw(isDraw);
        //lb.setDraw(isDraw);
        draw.setText(isDraw ?  "Erase" : "Draw");
        repaint();
    }

    public static void main(String[] arguments){
        new Circle();
    }
}

class CircleFrame extends JPanel{

    private boolean isDraw = false;

    public CircleFrame(){

        setPreferredSize(new Dimension(600, 600));
    }

    @Override
    public void paintComponent(Graphics comp){
        super.paintComponent(comp);
        if(! isDraw() ) return;  
        Graphics2D comp2D = (Graphics2D) comp;
        comp2D.setColor(Color.black);
        comp2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        Ellipse2D.Float circle = new Ellipse2D.Float(100F, 100F, 100F, 100F);
        Ellipse2D.Float circle1 = new Ellipse2D.Float(100F, 150F, 100F, 100F);
        Ellipse2D.Float circle3 = new Ellipse2D.Float(100F, 200F, 100F, 100F);
        comp2D.fill(circle);
        comp2D.setColor(Color.red);
        comp2D.fill(circle1);
        comp2D.setColor(Color.green);
        comp2D.fill(circle3);
        
    }

    boolean isDraw() {  return isDraw;  }

    void setDraw(boolean isDraw) {  this.isDraw = isDraw;   }
}

class LunchBox extends JPanel{

    private boolean isDraw = false;

    public LunchBox(){

        setPreferredSize(new Dimension(600, 600));
    }

    @Override
    public void paintComponent(Graphics comp){
        super.paintComponent(comp);
        if(! isDraw() ) return;  
        Graphics2D comp2D = (Graphics2D) comp;
        comp2D.setColor(Color.red);
        comp2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        Ellipse2D.Float circle = new Ellipse2D.Float(300F, 300F, 100F, 100F);
        comp2D.fill(circle);
    }

    boolean isDraw() {  return isDraw;  }

    void setDraw(boolean isDraw) {  this.isDraw = isDraw;   }
}

class PizzaFactory extends JPanel{

    private boolean isDraw = false;

    public PizzaFactory(){

        setPreferredSize(new Dimension(600, 600));
    }

    @Override
    public void paintComponent(Graphics comp){
        super.paintComponent(comp);
        if(! isDraw() ) return;  
        Graphics2D comp2D = (Graphics2D) comp;
        comp2D.setColor(Color.blue);
        comp2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        Ellipse2D.Float circle = new Ellipse2D.Float(100F, 100F, 100F, 100F);
        comp2D.fill(circle);
    }

    boolean isDraw() {  return isDraw;  }

    void setDraw(boolean isDraw) {  this.isDraw = isDraw;   }
}

class CupCake extends JPanel{

    private boolean isDraw = false;

    public CupCake(){

        setPreferredSize(new Dimension(600, 600));
    }

    @Override
    public void paintComponent(Graphics comp){
        super.paintComponent(comp);
        if(! isDraw() ) return;  
        Graphics2D comp2D = (Graphics2D) comp;
        comp2D.setColor(Color.blue);
        comp2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        Ellipse2D.Float circle = new Ellipse2D.Float(100F, 100F, 100F, 100F);
        comp2D.fill(circle);
    }

    boolean isDraw() {  return isDraw;  }

    void setDraw(boolean isDraw) {  this.isDraw = isDraw;   }
}