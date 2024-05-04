package myGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;

public class DrawingTest extends JFrame
{
    private Canvas drwArea;
    private JButton btnClear;

    public static void main(String[] args)
    {
        DrawingTest StartForm = new DrawingTest();
        StartForm.setVisible(true);
    }


    public DrawingTest()
    {
        //Window...
        this.setTitle("Drawing objects test00");
        this.setBounds(0,0,510,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        //Drawing area...
        drwArea = new Canvas();
        drwArea.setBounds(0, 0, 400, 450);      
        drwArea.setBackground(Color.WHITE);
        drwArea.setOpaque(true);
        drwArea.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        drwArea.addMouseMotionListener(new MouseMotionAdapter()
        {
            @Override
            public void mouseDragged(MouseEvent e)
            {
                //Write code to paint on the image...
            }
        });

        this.getContentPane().add(drwArea);
        //Clear button...
        btnClear = new JButton("Clear");
        btnClear.setBounds(400,50,70,30);
        btnClear.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //Write code to clear the image...
            }
        });

        this.getContentPane().add(btnClear);

    }

    private class Canvas extends JLabel
    {
        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            //The idea of overriding this method is
            //achieving persistence...
        }
    }

}