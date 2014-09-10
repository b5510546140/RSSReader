package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.xml.bind.JAXBException;

import controller.RssReaderView;
import model.Item;

/**
 * This class is GUI that use for put the url of rss.
 * @author wat wattanagaroon
 * @version 2014/09/01
 */
public class UrlGUI extends JFrame{
	private Item[] itemArray;
	private String url;
	private JTextArea textArea;
	private RssReaderView rssReader;
	public UrlGUI() {
		onGuiGetLink();
	}
	/**
	 * This is the method that create GUI 
	 */
	private void onGuiGetLink(){
		setLocation(100, 60);
		JPanel jPanel= new JPanel();
		JButton button = new JButton("Go");
		button.setBounds(650, 100, 30, 30);
		jPanel.setLayout(null);
		setSize(800, 1000);
		textArea = new JTextArea();
		textArea.setBounds(100, 100, 500, 25);
		jPanel.add(textArea);
		jPanel.add(button);
		add(jPanel);

		textArea.addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				getSomeClickOrEnter();
			}
		});
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getSomeClickOrEnter();
			}
		});
		setVisible(true);
	}
	/**
	 * Click enter for send the url from text area
	 */
	private void getSomeClickOrEnter(){
		rssReader = RssReaderView.getInstance();
		url = textArea.getText();
		try {
			rssReader.rssReader(url);
			setVisible(false);
		} catch (JAXBException e1) {
			e1.printStackTrace();
		}
	
	}
}
