import javax.xml.bind.annotation.XmlRootElement;
/**
 * 
 * @author Aof
 * @version
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
