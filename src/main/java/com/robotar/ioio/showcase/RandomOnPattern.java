package com.robotar.ioio.showcase;

import java.util.Random;

import ioio.lib.api.DigitalOutput;
import ioio.lib.api.exception.ConnectionLostException;

public class RandomOnPattern extends ShowcasePattern {

	public RandomOnPattern(int delay) {
		super(delay);
	}

	@Override
	public void play(DigitalOutput[][] leds, int loops)
			throws InterruptedException, ConnectionLostException {
		// shine all
		boolean turnon = true;
		int loop = 0;
		int counter = 0;
		Random rig = new Random();
		Random rjg = new Random();
		boolean[][] shines = new boolean[6][4];
		while (!shouldQuit && loop < loops) {
			if (turnon) {
				// find not yet turn on led
				int ri = rig.nextInt(6);
				int rj = rjg.nextInt(4);
				while (!shines[ri][rj]) {
					ri = rig.nextInt(6);
					rj = rjg.nextInt(4);
				}
				// turn it on
				leds[ri][rj].write(true);
				shines[ri][rj] = true;
				counter++;
				if (counter > 23) {
					turnon = false;
				}
			} else {
				// turn it off
				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < 4; j++) {
						leds[i][j].write(false);
						shines[i][j] = false;
					}
				}
				loop++;
				turnon = true;
				counter = 0;
			}
			Thread.sleep(delay);
		}
	}

}
