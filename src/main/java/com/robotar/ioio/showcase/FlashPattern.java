package com.robotar.ioio.showcase;

import ioio.lib.api.DigitalOutput;
import ioio.lib.api.exception.ConnectionLostException;

public class FlashPattern extends ShowcasePattern {
	@Override
	public void play(DigitalOutput[][] leds, int loops) throws InterruptedException, ConnectionLostException {
		// shine all
		boolean b = true;
		int loop = 0;
		while (!shouldQuit && loop < loops) {
			if (b) {
				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < 4; j++) {
						leds[i][j].write(true);
					}
				}
			} else {
				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < 4; j++) {
						leds[i][j].write(false);
					}
				}
				loop++;
			}
			b = !b;
			Thread.sleep(1000);
		}
	}

}
