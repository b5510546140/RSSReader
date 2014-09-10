package view;
import controller.RssReaderView;
/**
 * Just run the main
 * @author Wat Wattanagaroon
 *
 */

public class Main {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args){
		try {
			RssReaderView rss = RssReaderView.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
