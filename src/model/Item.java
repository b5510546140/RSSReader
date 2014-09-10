package model;
/**
 * Item is in the rss
 * @author wat wattanagaroon
 * @version 2014/09/10
 */
public class Item {
	private String title;
	private String link;
	private String description;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString(){
		
		return title;
		
	}
}
	