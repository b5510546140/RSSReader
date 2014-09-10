package model;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
/**
 * This is channel in the rss
 * @author wat wattanagaroon
 * @version 2014/9/10
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Channel {
	private String title;
	private String link;
	private String description;
	@XmlElement(name="item")
	private List<Item> items;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Item> getItems() {
		return items;
	}
	
}
