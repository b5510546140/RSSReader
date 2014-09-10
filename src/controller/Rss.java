package controller;
import javax.xml.bind.annotation.XmlRootElement;

import model.Channel;
/**
 * 
 * @author wat wattanagaroon
 * @version 2014/9/10
 * 
 */
@XmlRootElement
public class Rss {
	/**
	 * This is the channel
	 */
	 private Channel channel;

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	 
}
