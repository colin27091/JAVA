import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Scrollable;
import javax.swing.SwingConstants;

public class Case extends JPanel implements Serializable{

	Pic pic;
	JComboBox liste_tags;
	JCheckBox selection;
	JScrollPane picture;
	JLabel image;
	JLabel nom;
	JLabel global;

	private static final long serialVersionUID = 1L;

	Case(Pic pic) {
		super();
		this.pic = pic;
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createLineBorder(new Color(255, 166, 77)));
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(225,225));
		
		//this.global 
		picture = new JScrollPane(new JLabel(pic.image));
		image = new JLabel(pic.image, SwingConstants.CENTER);
		
		liste_tags= new JComboBox<>();
		liste_tags.setSize(100,20);
		liste_tags.setBounds(5, 25, 50, 20);
		nom = new JLabel(pic.name);

		
		selection = new JCheckBox();
		selection.setBackground(null);
		this.add(liste_tags, BorderLayout.NORTH);
		this.add(selection, BorderLayout.NORTH);
		this.add(picture);
		this.add(nom, BorderLayout.SOUTH);

	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

	}

	static ArrayList<Case> fromPics(ArrayList<Pic> pics) {
		ArrayList<Case> cases = new ArrayList<Case>();
		for (Pic pic : pics) {
			cases.add(new Case(pic));
		}
		return cases;
	}

}
