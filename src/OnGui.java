import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;


public class OnGui extends JFrame {
	private Item item;
	private JList<Item> list;
	private JTextPane textPane;
	private JPanel content = new JPanel();
	private JButton button;
	private URI uri;
	OnGui(String url){
		super(url);	
	}
	public void gui(Item[] array){
		//1. Create the frame.
				GridLayout experimentLayout = new GridLayout(1,2);
		        content.setLayout(new BorderLayout());
				setSize(900, 1000);
				textPane = new JTextPane();
				content.add(textPane,BorderLayout.CENTER);
				setLayout(experimentLayout);
				//2. Optional: What happens when the frame closes?
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				//3. Create components and put them in the frame.

				list = new JList(array); //data has type Object[]
				list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
				list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
				list.setVisibleRowCount(-1);
				JScrollPane listScroller = new JScrollPane(list);
				button = new JButton();
				buttonLink();
				content.add(button,BorderLayout.SOUTH);
				add(listScroller);
				add(content);
				
				listScroller.setPreferredSize(new Dimension(250, 600));
				list.addListSelectionListener(new ListSelectionListener() {
					
					@Override
					public void valueChanged(ListSelectionEvent e) {
						item = (Item) list.getSelectedValue();
						textPane.setText(item.getTitle()+"\n"+item.getDescription());
						StyledDocument doc = textPane.getStyledDocument();
						
						SimpleAttributeSet keyWord = new SimpleAttributeSet();
						StyleConstants.setForeground(keyWord, Color.BLUE);
//						StyleConstants.setBackground(keyWord, Color.YELLOW);
						StyleConstants.setBold(keyWord, true);
//						textArea.setLineWrap(true);
//						textPane.("\n");
						try {
							uri = new URI(item.getLink());
						} catch (URISyntaxException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						try {
//							doc.insertString(0, "eiei", null );
							doc.insertString(doc.getLength(), "\n", null );
							doc.insertString(doc.getLength(), uri.toString(), keyWord );
							
						} catch (BadLocationException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				

//				frame.pack();
				setVisible(true);
	}
	
	private void buttonLink(){
	    button.setText("<HTML>Click here to <FONT color=\"#000099\"><U>link</U></FONT>"
	        + "go to the website.</HTML>");
	    button.setHorizontalAlignment(SwingConstants.LEFT);
	    button.setBorderPainted(false);
	    button.setOpaque(false);
	    button.setBackground(Color.WHITE);
	    button.setSize(200, 200);
	    button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				open(uri);
			}
		});
	}
	
	 private static void open(URI uri) {
		    if (Desktop.isDesktopSupported()) {
		      try {
		        Desktop.getDesktop().browse(uri);
		      } catch (IOException e) { /* TODO: error handling */ }
		    } else { /* TODO: error handling */ }
		  }

}
