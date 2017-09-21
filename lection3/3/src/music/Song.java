package music;

public class Song {
	private Styles style;
	private String name;
	private String group;
	private int continuance;

	public Song(Styles style, String name, String group, int continuance) {
		this.style = style;
		this.name = name;
		this.group = group;
		this.continuance = continuance;
	}

	public Styles getStyle() {
		return style;
	}

	public void setStyle(Styles style) {
		this.style = style;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public int getContinuance() {
		return continuance;
	}

	public void setContinuance(int continuance) {
		this.continuance = continuance;
	}

	

}
