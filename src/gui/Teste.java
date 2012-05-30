package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Teste extends JFrame{
	
	public Teste(String titulo) {

        super( titulo );
        setLayout( new BorderLayout() );

        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;

        menuBar = new JMenuBar();

        menu = new JMenu( "File" );
        menu.setMnemonic( 'F' );
        menuBar.add( menu );
        
        menuItem = new JMenuItem( "Import" );
        menuItem.addActionListener( new ActionListener() {

            public void actionPerformed(ActionEvent e) {
            }
     } );
        menu.add(menuItem);
        
        menuItem = new JMenuItem( "Export" );
        menuItem.addActionListener( new ActionListener() {

            public void actionPerformed(ActionEvent e) {
            }
     } );
        menu.add(menuItem);
        
        setJMenuBar( menuBar );
        
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setSize(400,300);
        pack();
        setResizable( true );
        setLocationRelativeTo( null );
        setVisible( true );
	}
}
