package myGame;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import java.math.*;
//import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.TransferHandler;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;
import javax.swing.*;
//
public class ProductAssembly2Dgame extends JPanel  implements MouseMotionListener, MouseListener{

    private static final int D_W = 1000, D_H = 900;
    private int intLevel=1;
    private int intLives=3;
    private int intScores=0;
    JButton btnStart;
    JButton btnEnd;
    JLabel level;
    JLabel lives;
    JLabel scoring;
    JTextArea area;
    JTextArea txtLevel;
    JTextArea txtLives;
    JTextArea txtScore;

    //private final List<Fireball> fireBalls;
    private BufferedImage background;
    LunchBox ll;
    PizzaFactory pp;
    CupCakeFactory cc;
    BiCycleFactory bb;
    Lunch lunch;
    Pizza pizza;
    CupCake cupcake;
    Bike bike;
    private final Random rand = new Random();
    public void setLevel(int i) {
    	this.intLevel=i;
    }
    public void setLives(int i) {
    	intLives=i;
    }
    public void setScores(int i) {
    	intScores=i;
    }
    public ProductAssembly2Dgame() {

        try {
            //fighter image
            //ryu = ImageIO.read(new File("C:/Users/beautyoflife/myGame/src/myGame/boat.png"));
            background = ImageIO.read(new File("C:/Users/beautyoflife/myGame/src/myGame/grass.jpg"));
            ll=new LunchBox();
            lunch=new Lunch();
            pp=new PizzaFactory();
            pizza= new Pizza();
            cc=new CupCakeFactory();
            cupcake=new CupCake();
            bb=new BiCycleFactory();
            bike=new Bike();
            
            // controls for game development
            btnStart=new JButton("Start");
            btnEnd=new JButton("End");
            level=new JLabel("Level");
            lives=new JLabel("Lives");
            scoring=new JLabel("Score");
            area = new JTextArea("Game Cycle");
            txtLevel=new JTextArea("1");
            txtLives=new JTextArea("3");
            txtScore=new JTextArea("00");
            area.setBounds(50,50,150,30);
            this.add(area);
            
            btnStart.setBounds(250,50,100,30);
            btnEnd.setBounds(400,50,100,30);
            level.setBounds(550,50,50,30);
            txtLevel.setBounds(600,50,30,30);
            
            //level.setBackground(Color.white);
            lives.setBounds(650,50,50,30);
            lives.setBackground(Color.white);
            txtLives.setBounds(700,50,30,30);
            
            scoring.setBounds(750,50,50,30);
            scoring.setBackground(Color.white);
            txtScore.setBounds(800,50,80,30);
            btnStart.addActionListener(event -> gameBeagin() );
            btnEnd.addActionListener(event-> gameEnd());
            this.add(btnStart);
            this.add(btnEnd);
            this.add(level);
            this.add(lives);
            this.add(scoring);
            this.add(txtLevel);
            this.add(txtLives);
            this.add(txtScore);
        } catch (IOException ex) {  ex.printStackTrace();   }

        //fireBalls = new LinkedList<>();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);


/*        Timer timer = new Timer(40, e -> {
        	
        	ll.x=ll.x+intLevel;
        	pp.x=pp.x+intLevel;
        	cc.x=cc.x+intLevel;
        	bb.x=bb.x+intLevel;
        	if (lunch.getIncluded()) {
        		lunch.setxy(ll.x+33, ll.y+33);
        	}
        	if (bike.getIncluded()) {
        		bike.setxy(bb.x+33, bb.y+33);
        	}
        	if (pizza.getIncluded()) {
        		pizza.setxy(pp.x+33, pp.y+33);
        	}
        	if (cupcake.getIncluded()) {
        		cupcake.setxy(cc.x+33, cc.y+33);
        	}
        	//System.out.println("TT");
            /*Iterator<Fireball> it = fireBalls.iterator();

            while (it.hasNext()) {
                Fireball ball = it.next();
                if (ball.x > D_W) {
                    it.remove();
                } else {
                    ball.x += X_INC;
                    repaint();
                }
            }
        	

           
        	repaint();
        };
        
*/
        //timer.start();
    }
    public void gameBeagin() {
    	if(intLevel==0) {intLevel=1;}
    	if(txtLevel.getText()=="1") {intLevel=1;}
    	if(txtLevel.getText()=="2") {intLevel=2;}
    	if(txtLevel.getText()=="3") {intLevel=3;}
    	if(ll.x>0 && ll.x <1000) {gameEnd();return;}
    	Timer timer = new Timer(40, e -> {
        	
        	ll.x=ll.x+intLevel;
        	pp.x=pp.x+intLevel;
        	cc.x=cc.x+intLevel;
        	bb.x=bb.x+intLevel;
        	if (lunch.getIncluded()) {
        		lunch.setxy(ll.x+33, ll.y+33);
        		//intScores=intScores+50;
        	}
        	if (bike.getIncluded()) {
        		bike.setxy(bb.x+33, bb.y+33);
        		//intScores=intScores+50;
        		//txtScore.setText(Integer.toString(intScores));
        	}
        	if (pizza.getIncluded()) {
        		pizza.setxy(pp.x+33, pp.y+33);
        		//intScores=intScores+50;
        		//txtScore.setText(Integer.toString(intScores));
        	}
        	if (cupcake.getIncluded()) {
        		cupcake.setxy(cc.x+33, cc.y+33);
        		//intScores=intScores+50;
        		//txtScore.setText(Integer.toString(intScores));
        	}
        	repaint();
        	if(lunch.getIncluded() && bike.getIncluded()&&pizza.getIncluded()&&cupcake.getIncluded()) {
        		JOptionPane.showMessageDialog(this, "You won the game!","Congratulation!", JOptionPane.OK_OPTION);
        		intScores=intScores+100;
        		txtScore.setText(Integer.toString(intScores));
        		gameEnd();
        		return;
        		
        	}
        	if(ll.x>1000) {
        		
        		intLives=intLives-1;
        		if (lunch.getIncluded()) {
            		intScores=intScores+50;
            	}
            	if (bike.getIncluded()) {
            		intScores=intScores+50;
            		//txtScore.setText(Integer.toString(intScores));
            	}
            	if (pizza.getIncluded()) {
            		intScores=intScores+50;
            		//txtScore.setText(Integer.toString(intScores));
            	}
            	if (cupcake.getIncluded()) {
            		intScores=intScores+50;
            		//;
            	}
            	txtScore.setText(Integer.toString(intScores));
            	JOptionPane.showMessageDialog(this, "You failed.Try again!","Sorry", JOptionPane.OK_OPTION);
        		gameEnd();
        		return;
        	}
        });
    	
        timer.start();
        
    }
	public void gameEnd() {
		ll.x=0;
    	pp.x=0;
    	cc.x=0;
    	bb.x=0;
		intLevel=0;
		lunch.setIncluded(false);
		bike.setIncluded(false);
		pizza.setIncluded(false);
		cupcake.setIncluded(false);
		
		lunch.setSelected(false);
		bike.setSelected(false);
		pizza.setSelected(false);
		cupcake.setSelected(false);
		area.setText("Game Ended");
		//JOptionPane.showMessageDialog(this, "You won the game!","Victory", JOptionPane.OK_OPTION);
        lunch.setxy(400, 100);
		pizza.setxy(400, 300);
		cupcake.setxy(400, 500);
		bike.setxy(400, 700);
		repaint();
	}
    /*private void addBalls() {

        if(rand.nextInt(100) > 5)  return; //reduce the frequency of adding balls
        fireBalls.add(new Fireball());
    }*/

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, D_W, D_H, this);
        //g.drawImage(ryu, 50, 125, 150, 115, this);
        ll.drawLunchBox(g);
        pp.drawPizzaFactory(g);
        cc.drawCupCakeFactory(g);
        bb.drawBiCycleFactory(g);
        bike.drawImage(g);
        lunch.drawImage(g);
        pizza.drawImage(g);
        cupcake.drawImage(g);
        /*for (Fireball ball : fireBalls) {
            ball.drawFireball(g);
        }*/
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(D_W, D_H);
    }

/*    private class Fireball {

        private final Image fireball;
        private int x = 180;       
        private final int y = 140;
        private static final int SIZE =25;

        public Fireball() {
            fireball = getBall();
        }

        public void drawFireball(Graphics g) {
            g.drawImage(fireball, x, y, 25, 25, null);
        }

        private BufferedImage getBall() {
            BufferedImage img = new BufferedImage(SIZE , SIZE,
                                                BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = img.createGraphics();
            g2.setColor(Color.RED);
            g2.fillOval(1, 1, SIZE - 2, SIZE - 2);
            g2.dispose();
            return img;
        }
    }
*/    
    public class LunchBox {

        private BufferedImage lunchbox;
        private int x = 0;       
        private int y = 200;
        private static final int SIZE =100;

        public LunchBox() {
        	try {
                //fighter image
                lunchbox = ImageIO.read(new File("C:/Users/beautyoflife/myGame/src/myGame/lunchbox.jpg"));
                //background = ImageIO.read(new File("C:/Users/beautyoflife/myGame/src/myGame/ITExpert.jpg"));
            } catch (IOException ex) {  ex.printStackTrace();   }
        }

        public void drawLunchBox(Graphics g) {
            g.drawImage(lunchbox, x, y, 100, 100, null);
        }
    }

    public class PizzaFactory {

        private BufferedImage image;
        private int x = 0;       
        private int y = 400;
        private static final int SIZE =100;

        public PizzaFactory() {
        	try {
                //fighter image
                image = ImageIO.read(new File("C:/Users/beautyoflife/myGame/src/myGame/pizzafactory.jpg"));
                //background = ImageIO.read(new File("C:/Users/beautyoflife/myGame/src/myGame/ITExpert.jpg"));
            } catch (IOException ex) {  ex.printStackTrace();   }
        }

        public void drawPizzaFactory(Graphics g) {
            g.drawImage(image, x, y, 100, 100, null);
        }
    }
    public class CupCakeFactory {

        private BufferedImage image;
        private int x = 0;       
        private int y = 600;
        private static final int SIZE =100;

        public CupCakeFactory() {
        	try {
                //fighter image
                image = ImageIO.read(new File("C:/Users/beautyoflife/myGame/src/myGame/cupcakefactory.jpg"));
                //background = ImageIO.read(new File("C:/Users/beautyoflife/myGame/src/myGame/ITExpert.jpg"));
            } catch (IOException ex) {  ex.printStackTrace();   }
        }

        public void drawCupCakeFactory(Graphics g) {
            g.drawImage(image, x, y, 100, 100, null);
        }
    }
    public class BiCycleFactory {

        private BufferedImage image;
        private int x = 0;       
        private int y = 800;
        private static final int SIZE =100;

        public BiCycleFactory() {
        	try {
                //fighter image
                image = ImageIO.read(new File("C:/Users/beautyoflife/myGame/src/myGame/bicyclefactory.jpg"));
                //background = ImageIO.read(new File("C:/Users/beautyoflife/myGame/src/myGame/ITExpert.jpg"));
            } catch (IOException ex) {  ex.printStackTrace();   }
        }

        public void drawBiCycleFactory(Graphics g) {
            g.drawImage(image, x, y, 100, 100, null);
        }
    }
    private class Lunch {

        private BufferedImage image;
        private int x = 400;       
        private int y = 100;
        private static final int SIZE =25;
        private boolean selected=false;
        private boolean included=false;

        public Lunch() {
        	try {
                //fighter image
                image = ImageIO.read(new File("C:/Users/beautyoflife/myGame/src/myGame/lunch.jpg"));
                //background = ImageIO.read(new File("C:/Users/beautyoflife/myGame/src/myGame/ITExpert.jpg"));
            } catch (IOException ex) {  ex.printStackTrace();   }
        }

        public void drawImage(Graphics g) {
            g.drawImage(image, x, y, 35, 35, null);
        }
        
        public void setxy(int xx, int yy) {
        	x=xx;
        	y=yy;
        }
        public boolean getSelected() {
        	return selected;
        }
        public void setSelected(boolean value) {
        	selected=value;
        }
        public boolean getIncluded() {
        	return included;
        }
        public void setIncluded(boolean value) {
        	included=value;
        }
    }
    private class Pizza {

        private BufferedImage image;
        private int x = 400;       
        private int y = 300;
        private static final int SIZE =25;
        private boolean selected=false;
        private boolean included=false;

        public Pizza() {
        	try {
                //fighter image
                image = ImageIO.read(new File("C:/Users/beautyoflife/myGame/src/myGame/pizza.png"));
                //background = ImageIO.read(new File("C:/Users/beautyoflife/myGame/src/myGame/ITExpert.jpg"));
            } catch (IOException ex) {  ex.printStackTrace();   }
        }

        public void drawImage(Graphics g) {
            g.drawImage(image, x, y, 35, 35, null);
        }
        public void setxy(int xx, int yy) {
        	x=xx;
        	y=yy;
        }
        public boolean getSelected() {
        	return selected;
        }
        public void setSelected(boolean value) {
        	selected=value;
        }
        public boolean getIncluded() {
        	return included;
        }
        public void setIncluded(boolean value) {
        	included=value;
        }
    }
    private class CupCake {

        private BufferedImage image;
        private int x = 400;       
        private int y = 500;
        private static final int SIZE =25;
        private boolean selected=false;
        private boolean included=false;

        public CupCake() {
        	try {
                //fighter image
                image = ImageIO.read(new File("C:/Users/beautyoflife/myGame/src/myGame/cupcake.jpg"));
                //background = ImageIO.read(new File("C:/Users/beautyoflife/myGame/src/myGame/ITExpert.jpg"));
            } catch (IOException ex) {  ex.printStackTrace();   }
        }

        public void drawImage(Graphics g) {
            g.drawImage(image, x, y, 35, 35, null);
        }
        public void setxy(int xx, int yy) {
        	x=xx;
        	y=yy;
        }
        public boolean getSelected() {
        	return selected;
        }
        public void setSelected(boolean value) {
        	selected=value;
        }
        public boolean getIncluded() {
        	return included;
        }
        public void setIncluded(boolean value) {
        	included=value;
        }
    }
    private class Bike {

        private BufferedImage image;
        private int x = 400;       
        private int y = 700;
        private static final int SIZE =25;
        private boolean selected=false;
        private boolean included=false;

        public Bike() {
        	try {
                //fighter image
                image = ImageIO.read(new File("C:/Users/beautyoflife/myGame/src/myGame/bike.jpg"));
                //background = ImageIO.read(new File("C:/Users/beautyoflife/myGame/src/myGame/ITExpert.jpg"));
            } catch (IOException ex) {  ex.printStackTrace();   }
        }

        public void drawImage(Graphics g) {
            g.drawImage(image, x, y, 35, 35, null);
        }
        public void setxy(int xx, int yy) {
        	x=xx;
        	y=yy;
        }
        public boolean getSelected() {
        	return selected;
        }
        public void setSelected(boolean value) {
        	selected=value;
        }
        public boolean getIncluded() {
        	return included;
        }
        public void setIncluded(boolean value) {
        	included=value;
        }
    }

 // Mouse Event Description part
    
    @Override
    public void mousePressed(MouseEvent e) {
    	//clicked=true;
    	int x = e.getX();
        int y = e.getY();
        
        //System.out.println(Math.abs(lunch.x-x));
        //System.out.println(Math.abs(lunch.y-y));
        
        if (Math.abs(lunch.x-x)<18 && Math.abs(lunch.y-y)<18) {
            lunch.setSelected(true);
        }
        if (Math.abs(bike.x-x)<18 && Math.abs(bike.y-y)<18) {
        	bike.setSelected(true);
        }
        if (Math.abs(cupcake.x-x)<18 && Math.abs(cupcake.y-y)<18) {
        	
            cupcake.setSelected(true);
    
        }
        if (Math.abs(pizza.x-x)<18 && Math.abs(pizza.y-y)<18) {
        	pizza.setSelected(true);
    
        }
        //lunch.setxy(x, y);

        //repaint();

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
        if(lunch.getSelected()) {
        	int x = e.getX();
            int y = e.getY();
            
            if (Math.abs(ll.x-x)<50 && Math.abs(ll.y-y)<50) {
            	lunch.setxy(ll.x, ll.y);
            	lunch.setIncluded(true);
            	lunch.setSelected(false);
            	repaint();
            	return;
            }
            
            lunch.setxy(x, y);
            repaint();
        }
        
        if(pizza.getSelected()) {
        	int x = e.getX();
            int y = e.getY();
            
            if (Math.abs(pp.x-x)<50 && Math.abs(pp.y-y)<50) {
            	pizza.setxy(pp.x, pp.y);
            	pizza.setIncluded(true);
            	pizza.setSelected(false);
            	repaint();
            	return;
            }
            
            pizza.setxy(x, y);
            repaint();
        }
        if(cupcake.getSelected()) {
        	int x = e.getX();
            int y = e.getY();
            
            if (Math.abs(cc.x-x)<50 && Math.abs(cc.y-y)<50) {
            	cupcake.setxy(cc.x, cc.y);
            	cupcake.setIncluded(true);
            	cupcake.setSelected(false);
            	repaint();
            	return;
            }
            
            cupcake.setxy(x, y);
            repaint();
        }
        if(bike.getSelected()) {
        	int x = e.getX();
            int y = e.getY();
            
            if (Math.abs(bb.x-x)<50 && Math.abs(bb.y-y)<50) {
            	bike.setxy(bb.x, bb.y);
            	bike.setIncluded(true);
            	bike.setSelected(false);
            	repaint();
            	return;
            }
            
            bike.setxy(x, y);
            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println("mouseClicked");
        //clicked=true;
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //System.out.println("mouseReleased");
        //lunch.setSelected(false);
        if(lunch.getSelected()) {lunch.setSelected(false);}
        if(pizza.getSelected()) {pizza.setSelected(false);}
        if(bike.getSelected()) {bike.setSelected(false);}
        if(cupcake.getSelected()) {cupcake.setSelected(false);}



    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    
    
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Simple Game Simulation");
            
            frame.setBounds(0,0,1000,800);
            ProductAssembly2Dgame leftPanel;    
            leftPanel=new ProductAssembly2Dgame();
            leftPanel.setBounds(0,0,1000,1000);
            leftPanel.setBorder(BorderFactory.createLineBorder(Color.red));
            leftPanel.setLayout(null);
            frame.add(leftPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
    
}