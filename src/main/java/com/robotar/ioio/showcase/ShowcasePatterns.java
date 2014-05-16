package com.robotar.ioio.showcase;

import ioio.lib.api.DigitalOutput;
import ioio.lib.api.exception.ConnectionLostException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShowcasePatterns {
	List<ShowcasePattern> patterns = new ArrayList<ShowcasePattern>();
	Random r = new Random(System.currentTimeMillis());
	private ShowcasePattern currentPattern;
	private DigitalOutput[][] leds;
	
	public ShowcasePatterns(DigitalOutput[][] fretLEDs) {
		this.leds = fretLEDs;
	}

	public void quit() {
		if (currentPattern != null) {
			currentPattern.setShouldQuit(true);
		}
	}
	
	public void add(ShowcasePattern p) {
		patterns.add(p);
	}
	
	public void initAll() {
		patterns.add(new FlashPattern(500));
		patterns.add(new StringsPattern(100));
		patterns.add(new SnakePattern(100));
		patterns.add(new RandomOnPattern(500));
	}
	
	public int getRandomPatternIdx() {
		if (patterns.isEmpty()) return -1;
		return r.nextInt(patterns.size());
	}
	
	public void play(int i) throws InterruptedException, ConnectionLostException {
		if (i < 0 || i > patterns.size()) {
			throw new IllegalArgumentException("wrong idx, out of bounds");
		}
		currentPattern = patterns.get(i);
		currentPattern.play(leds, 1);
	}
}
