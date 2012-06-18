package gui;

import java.awt.*;
import java.awt.event.*;
import java.net.*;

import javax.swing.*;
import javax.swing.border.*;

/**
 * 
 * Main GUI window, it is loaded after the splash screen and loads the main
 * menu.
 * 
 */
@SuppressWarnings("serial")
public class JanelaPrincipal extends JFrame {

	/**
	 * Instance of the class <code>Imagens</code>, used to load images in order
	 * to fill buttons and panels.
	 * 
	 * @see Imagens Imagens Class
	 */
	private Imagens img = new Imagens();

	/**
	 * Object AppConfig important to control how the window behaves, if the
	 * object has been initialized, that object will be used instead of creating
	 * another one
	 */
	private AppConfig appconfig;

	public JanelaPrincipal() throws URISyntaxException {

		super("Olympic Games Application");
		addButtons();
		setProperties(640, 480, 0, true);

	}

	/**
	 * Asks the user whether he wants to close the application or not, if the
	 * answer is yes, the complete application will be closed
	 */
	private void close() {
		String[] opt = { "Yes", "No" };
		if (JOptionPane.showOptionDialog(this, "Do you really want to exit?", "Olympic Games", 0, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(img.exit), opt, opt[0]) == 0) {
			Main.gravarEstado();
			dispose();
			System.exit(0);
		}
	}

	/**
	 * Sets the properties to this frame such as <code>/size<code>,
	 * <code>visibility</code> and the <code>operation</code> that will happen
	 * by default when the user initiates a "close" on this frame.
	 * 
	 * @see java.awt.Window#setSize(int,int)
	 * 
	 * @see javax.swing.JFrame#setDefaultCloseOperation(int)
	 * 
	 * @see java.awt.Window#setVisible(boolean)
	 * 
	 * @param w
	 *            the desired width to the window
	 * 
	 * @param h
	 *            the desired height to the window
	 * 
	 * @param opcao
	 *            parameter to use when calling
	 *            javax.swing.JFrame#setDefaultCloseOperation(int)
	 * 
	 * @param v
	 *            sets the windows to visible if the parameter is true
	 */
	private void setProperties(int w, int h, int opcao, boolean v) {
		setSize(w, h);
		setDefaultCloseOperation(opcao);
		setVisible(v);
		setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				close();
			}
		});
	}

	/**
	 * Creates a menu with three customized buttons and panels
	 */
	private void addButtons() {
		// Buttons
		Botao btn1 = new Botao(img.appconfig, img.appconfig_o);
		Botao btn2 = new Botao(img.about, img.about_o);
		Botao btn3 = new Botao(img.exitapp, img.exitapp_o);

		// Panels
		Painel panel = new Painel(new FlowLayout(FlowLayout.RIGHT, 55, 120));
		Painel panelbtn = new Painel(img.bg4);

		// Panels customization
		panelbtn.setLayout(new GridLayout(4, 1, 10, 10));
		panelbtn.setBorder(new EmptyBorder(20, 20, 30, 20));
		panelbtn.setOpaque(false);

		// Empty border
		Border emptyBorder = BorderFactory.createEmptyBorder();

		// Menu title
		JLabel lb = new JLabel("Menu");

		// Title customization
		lb.setFont(new Font("Arial", Font.BOLD, 14));
		lb.setForeground(Color.white);

		// appconfig customization/ actionlistener
		btn1.setContentAreaFilled(false);
		btn1.setBorder(emptyBorder);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (appconfig == null) {
					appconfig = new AppConfig();
				} else {
					appconfig.setVisible(true);
				}
			}
		});

		// about customization/ actionlistener
		btn2.setContentAreaFilled(false);
		btn2.setBorder(emptyBorder);
		btn2.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				try {
					About about = new About(JanelaPrincipal.this);
				} catch (URISyntaxException e1) {
				}
			}
		});

		// exitapp customization/ actionlistener
		btn3.setContentAreaFilled(false);
		btn3.setBorder(emptyBorder);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});

		// adding components to the panels
		panel.add(panelbtn);
		panelbtn.add(lb);
		panelbtn.add(btn1);
		panelbtn.add(btn2);
		panelbtn.add(btn3);
		add(panel, BorderLayout.CENTER);
	}

}
