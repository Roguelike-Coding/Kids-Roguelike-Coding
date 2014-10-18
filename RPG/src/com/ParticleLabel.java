package com;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.Timer;

public class ParticleLabel extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ParticleLabel(int x,int y,BufferedImage particle,int duration,JComponent source){
		this.setBounds(x, y, 8, 8);
		this.setIcon(new ImageIcon(particle));
		source.add(this);
		Timer timer = new Timer(duration, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 
             }
        });
        timer.setRepeats(false);
        timer.start();
	}
}
