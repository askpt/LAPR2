package gui;

import java.awt.*;
import javax.swing.*;

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
        menu.add(menuItem);
        
        menuItem = new JMenuItem( "Export" );
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
