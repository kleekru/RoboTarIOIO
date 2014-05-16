package com.robotar.ioio.showcase;

import ioio.lib.api.DigitalOutput;
import ioio.lib.api.exception.ConnectionLostException;

public abstract class ShowcasePattern {
	protected boolean shouldQuit;
	protected int delay;
	
	public ShowcasePattern(int delay) {
		this.delay = delay;
	}
	
	public boolean isShouldQuit() {
		return shouldQuit;
	}

	public void setShouldQuit(boolean shouldQuit) {
		this.shouldQuit = shouldQuit;
	}
	
	public abstract void play(DigitalOutput[][] leds, int loops) throws InterruptedException, ConnectionLostException;
	
}
