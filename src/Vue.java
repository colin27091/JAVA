import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Vue extends JFrame implements Observer{

	File[] images;
	File repertoire;
	ArrayList<Pic> pics;
	Pane pane;
	Control ctr;


	public Vue(Control ctr) {
		this.setTitle("Banque de données");
		this.setVisible(true);
		this.setPreferredSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		

		this.ctr = ctr;
		
		this.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	SaveDonnees sd = new SaveDonnees(ctr.model);
		        sd.enregistrement();
		    }
		});
		
		this.pane = new Pane(ctr);
		
		this.pics = new ArrayList<Pic>();
		//= Pic.fromFiles(new File("images/"));
		
		this.add(pane);

		this.pack();

	}

	@Override
	public void update(Observable obs, Object obj) {
		System.out.println(obj);
		this.pane.setPics((ArrayList<Pic>) obj);
	}

}
