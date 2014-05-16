package com.robotar.ioio.showcase;

import ioio.lib.api.DigitalOutput;
import ioio.lib.api.exception.ConnectionLostException;

public class SnakePattern extends ShowcasePattern {

	@Override
	public void play(DigitalOutput[][] leds, int loops)
			throws InterruptedException, ConnectionLostException {
		// one after another
		int i = 5;
		int j = 0;
		int loop = 0;
		int di = -1;
		int dj = 1;
		while (!shouldQuit && loop < loops) {
			leds[i][j].write(true);
			Thread.sleep(100);
			leds[i][j].write(false);
			i += di;
			if (i < 0) {
				i = 0;
				di = 1;
				j += dj;
				if (j > 3) {
					j = 3;
					dj = -1;
				} else if (j < 0) {
					j = 0;
					dj = 1;
					loop++;
				}
			} else if (i > 5) {
				i = 5;
				di = -1;
				j += dj;
				if (j > 3) {
					j = 3;
					dj = -1;
				} else if (j < 0) {
					j = 0;
					dj = 1;
					loop++;
				}
			}
		}
	}

}
