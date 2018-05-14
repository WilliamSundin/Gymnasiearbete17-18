import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class PastureGUI extends JFrame implements ActionListener {

    

    public static void main(String[] args) {
        PastureGUI gui = new PastureGUI();
    }
    
    /** Icon for an empty position in the pasture */
    private final ImageIcon    II_EMPTY       = new ImageIcon("empty.gif");
      /** The pasture this class should display */
    private Pasture            pasture;
    /** The grid, i.e., the field containing the images to display. */
    private JLabel[][]         grid;
    /** The button for starting the simulation. */
    private JButton            startButton    = new JButton("Start");
    // Button for stoping the simulation
    private JButton stopButton = new JButton("Stop");
    // Button to exit the program
    private JButton exitButton = new JButton("Exit");
    
    
    public PastureGUI() {
	pasture = new Pasture(this);
	initPastureGUI();
    }
    // the World it self
    private void initPastureGUI() {
        setSize(pasture.getWidth()*30, pasture.getHeight()*30);
	
	startButton.addActionListener(this);
             	
        JPanel button = new JPanel();
        button.setLayout(new GridLayout(1,1));
        button.add(startButton);

    stopButton.addActionListener(this);
        JPanel button1 = new JPanel();
        button1.setLayout(new GridLayout(1,1));
        button1.add(stopButton);

    exitButton.addActionListener(this);
        JPanel button2 = new JPanel();
        button2.setLayout(new GridLayout(1,1));
        button2.add(exitButton);

        JPanel field = new JPanel();
        field.setBackground(new Color(10,135,204));
        field.setLayout(new GridLayout(pasture.getHeight(),
				       pasture.getWidth()));
        grid = new JLabel[pasture.getWidth()][pasture.getHeight()];
	
        for (int y = 0; y < pasture.getHeight(); y++) {
            for (int x = 0; x < pasture.getWidth(); x++) {
                grid[x][y] = new JLabel(II_EMPTY);
                grid[x][y].setVisible(true);
                field.add(grid[x][y]);
            }
        }

        JPanel bottomButtons = new JPanel();
        bottomButtons.setLayout(new BoxLayout(bottomButtons, BoxLayout.Y_AXIS));
        bottomButtons.add(button);
        bottomButtons.add(button1);

	Container display = getContentPane();
        display.setBackground(new Color(10,135,204));
        display.setLayout(new BorderLayout());
        display.add(field,BorderLayout.CENTER);
        display.add(bottomButtons,BorderLayout.SOUTH);
        //display.add(button1,BorderLayout.WEST);
        display.add(button2,BorderLayout.NORTH);

	startButton.setEnabled(true);
	stopButton.setEnabled(true);
	exitButton.setEnabled(true);
	updateAll();
	setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
	if (e.getSource() == startButton) {
	    startButton.setEnabled(true);
	    pasture.start();   
	} else if (e.getSource() == stopButton){
        stopButton.setEnabled(true);
        pasture.stop();
    } else if (e.getSource()== exitButton){
	    exitButton.setEnabled(false);
	    System.exit(0);
    }

    }


    public void updateAll() {
	int width  = pasture.getWidth();
	int height = pasture.getHeight();
	
        Entity[][] tempGrid = 
	    new Entity[width][height];


        for (int y = 0; y < height; y++)
            for (int x = 0; x < width; x++)
                tempGrid[x][y] = null;
	
        Collection world  = pasture.getEntities();
	Iterator   it     = world.iterator();
	
	while (it.hasNext()) {
	    Entity e = (Entity)it.next(); 
	    int    x = (int)e.getPosition().getX();
	    int    y = (int)e.getPosition().getY();
	    
	    if (tempGrid[x][y] == null)	tempGrid[x][y] = e;
	   // if ((int)e.getPosition().getX() > 20){(int)e.setPosition(getX(10)); };
	}
	
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
		ImageIcon icon ;
                Entity    e    = tempGrid[x][y];
		
                if (e == null) icon = II_EMPTY;
		else icon = e.getImage();
		grid[x][height - y - 1].setIcon(icon);
            }
        }
    }
}

