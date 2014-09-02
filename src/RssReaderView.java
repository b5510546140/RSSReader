import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


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
	
	public void rssReader(String url) throws JAXBException{
		JAXBContext ctx = JAXBContext.newInstance( Rss.class );
		Unmarshaller unmarshaller = ctx.createUnmarshaller( );
//		File file = new File("/Users/Aof/Desktop/bbcrss.xml");
		URL urlRead = null;
		try {
			urlRead = new URL(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
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
	
	private void nextFrame(String url) throws Exception{
		onGui = new OnGui(url);
		onGui.gui(itemArray);
	}
	
	private  void setListToArray(){
		List<Item> itemList = rss.getChannel().getItems();
		itemArray = itemList.toArray(new Item[itemList.size()]);
		System.out.println("EEEEE");
		System.out.println(itemArray[0]);
	}

}
