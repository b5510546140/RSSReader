package controller;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import model.Item;
import view.OnGui;
import view.UrlGUI;
/**
 * RssReader view is use to unmarshall
 * @author wat wattanagaroon
 * @version 2014/9/10
 *
 */

public class RssReaderView {
	
	private static RssReaderView instance;
	/**
	 * @param args
	 * @throws JAXBException 
	 */
	private Rss rss;
	private Item[] itemArray;
	private UrlGUI urlGui;
	private OnGui onGui;
	private RssReaderView() throws Exception{
		urlGui = new UrlGUI();
	}
	public static RssReaderView getInstance(){
		if(instance == null){
			try {
				instance = new RssReaderView();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return instance;
	}
	/**
	 * This method use to read the url and unmarshall it
	 * @param url
	 * @throws JAXBException
	 */
	public void rssReader(String url) throws JAXBException{
		JAXBContext ctx = JAXBContext.newInstance( Rss.class );
		Unmarshaller unmarshaller = ctx.createUnmarshaller( );
		URL urlRead = null;
		try {
			urlRead = new URL(url);
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}
		Object obj = unmarshaller.unmarshal( urlRead );
		rss = (Rss) obj;
		setListToArray();
		try {
			nextFrame(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * put url to GUI
	 * @param url
	 * @throws Exception
	 */
	private void nextFrame(String url) throws Exception{
		onGui = new OnGui(url);
		onGui.gui(itemArray);
	}
	/**
	 * get array of the list and change to array
	 */
	private  void setListToArray(){
		List<Item> itemList = rss.getChannel().getItems();
		itemArray = itemList.toArray(new Item[itemList.size()]);
	}

}
