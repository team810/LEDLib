package org.usfirst.frc810.tests;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import org.usfirst.frc810.ledlib.virtual.LEDVirtualizer;
import org.usfirst.frc810.ledlib.virtual.VirtualLEDStrip;

public class VirtualizerTest {
	public static void main(String[] args){
		new VirtualizerTest();
	}
	
	LEDVirtualizer LEDv;
	
	public VirtualizerTest(){
		LEDv = new LEDVirtualizer();
		VirtualLEDStrip strip = new VirtualLEDStrip();
		VirtualLEDStrip strip2 = new VirtualLEDStrip();
		LEDv.addLEDStrip(getRandomStrip(10));
		LEDv.addLEDStrip(getRandomStrip(10));
		LEDv.addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_N)
					LEDv.addLEDStrip(getRandomStrip(10));
				else if (e.getKeyCode() == KeyEvent.VK_D)
					LEDv.getLEDStrips().remove(LEDv.getCanvas().getSelectedStrip());
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	public VirtualLEDStrip getRandomStrip(int length){
		Random random = new Random();
		VirtualLEDStrip strip = new VirtualLEDStrip();
		for(int i = 0; i<length; i++){
			strip.setLEDColor(i, new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
		}
		return strip;
	}
}
