package beans;


public class Sms {
	private int id;
	private String content;
	private String author;
	public Sms(int id , String content, String author) {
		super();
		this.id = id;
		this.content = content;
		this.author = author;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
}
