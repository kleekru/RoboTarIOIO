package com.robotar.ioio.showcase;

import ioio.lib.api.DigitalOutput;
import ioio.lib.api.exception.ConnectionLostException;

public class StringsPattern extends ShowcasePattern {

	@Override
	public void play(DigitalOutput[][] leds, int loops) throws InterruptedException,
			ConnectionLostException {
		// one after another
		int i = 0;
		int j = 0;
		int loop = 0;
		while (!shouldQuit && loop < loops) {
			leds[i][j].write(true);
			Thread.sleep(100);
			leds[i][j].write(false);
			j++;
			if (j > 3) {
				i++;
				j = 0;
				if (i > 5) {
					i = 0;
					loop++;
				}
			}
		}
	}
}
