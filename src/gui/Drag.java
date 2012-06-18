package gui;

import java.io.*;

import javax.swing.*;

import dados.*;
import dragndrop.*;

/**
 * 
 * Creates a drag and drop window
 * 
 */
@SuppressWarnings("serial")
public class Drag extends JDialog {

	/**
	 * Constructor of this class
	 * 
	 * @param parent
	 *            parent where to open
	 */
	public Drag(JFrame parent) {
		super(parent, "Drag & Drop Files here", true);

		addDragDrop();
		setProperties(200, 185, true, true);

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
	 * @param visible
	 *            sets the windows to visible if the parameter is true
	 * @param onTop
	 *            sets the windows to always on top if true
	 */
	private void setProperties(int w, int h, boolean visible, boolean onTop) {
		setSize(w, h);
		setLocationRelativeTo(null);
		setAlwaysOnTop(onTop);
		setVisible(visible);
	}

	/**
	 * Creates a custom and programmed panel
	 */
	private void addDragDrop() {

		Imagens img = new Imagens();
		Painel principal = new Painel(img.dragndrop);

		new FileDrop(principal, new FileDrop.Listener() {
			@Override
			public void filesDropped(File[] files) {
				Csv csv = new Csv();
				csv.intelImport(files, Drag.this, Main.getPaises(), Main.getDisciplinas(), Main.getModalidades(), Main.getJogos(), Main.getProvas(), Main.getEquipas(), Main.getAtleta());
			}
		});

		principal.setOpaque(false);
		getContentPane().add(principal);
	}
}
