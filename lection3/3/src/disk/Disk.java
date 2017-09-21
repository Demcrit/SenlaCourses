package disk;

import music.Styles;
import music.Song;

public class Disk implements IDisk {
	private Song[] songs;
	private Styles[] styles;
	StringBuilder str = new StringBuilder();

	public Disk(Song[] songs) {
		this.songs = songs;
	}

	// count album length in seconds
	public int countContinuance() {

		int continuance = 0;
		for (Song s : songs) {
			continuance += s.getContinuance();
		}
		return continuance;
	}

	// show us common genre of our album
	@Override
	public String getStyle() {
		str.delete(0, str.length());
		for (Song m : songs) {
			addStyle(m);
		}
		for (Styles g : styles) {
			str.append(g.toString().toLowerCase()).append(",");
		}
		return str.toString();
	}

	// print our album on the screen
	public void printDisk() {
		System.out.println("Tracklist:");
		int i = 1;
		for (Song m : songs) {
			str.delete(0, str.length());
			System.out.println(str.append(i + ". ").append("Style: ").append(m.getStyle().toString()).append(", Name: ")
					.append(m.getName()).append(", Autor: ").append(m.getGroup()).append(", Continuance: ")
					.append(m.getContinuance()));
			i++;
		}

	}

	public void addStyle(Song song) {
		if (styles != null) {
			if (!inStyles(song.getStyle())) {
				Styles[] styles2 = new Styles[styles.length + 1];
				for (int i = 0; i < styles.length; i++) {
					styles2[i] = styles[i];
				}
				styles2[styles.length] = song.getStyle();
				styles = styles2;
			}
		} else {
			styles = new Styles[1];
			styles[0] = song.getStyle();
		}
	}

	// check is this genre exist at all
	private boolean inStyles(Styles style) {
		boolean check = false;
		for (Styles g : styles) {
			if (g.equals(style)) {
				check = true;
				break;
			}
		}
		return check;
	}

}
