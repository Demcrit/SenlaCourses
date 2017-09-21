package main;

import disk.Disk;
import music.Styles;
import music.Song;

public class Main {
	private static  Song s1 = new Song(Styles.POP, "Unbreakable", "Sia", 259);
	private static Song s2 = new Song(Styles.POP, "Paparazzi", "Lady Gaga", 224);
	private static Song s3 = new Song(Styles.RAP, "Not from this world", "Oxxymiron",534);
	private static Song s4 = new Song(Styles.ROCK, "Crazy", "Aerosmith ",252);
	private static Song s5 = new Song(Styles.PUNK, "Red Flag", "Billy Talent",345);
	private static Song s6 = new Song(Styles.PUNK, "Pretty Fly", "Offspring",260);
	
	private static Disk disk;

	public static void main(String[] args) {
		disk = new Disk(new Song[] { s1, s2, s3,s4,s5,s6 });
		System.out.println("Continuance: " + disk.countContinuance() + " seconds");
		System.out.println("Style: " + disk.getStyle());
		disk.printDisk();
	}

}
