package com;

import java.awt.image.BufferedImage;

public class Particle {
	private BufferedImage[] variants;
	private int[] probability;
	
	public Particle(BufferedImage[] variants){
		this.setVariants(variants);
		this.setProbability(new int[variants.length]);
		for(int i=0;i<variants.length;i++){
			probability[i]=1;
		}
	}

	public Particle(BufferedImage[] variants,int[] probability){
		this.setVariants(variants);
		this.setVariants(variants);
	}
	public BufferedImage[] getVariants() {
		return variants;
	}

	public void setVariants(BufferedImage[] variants) {
		this.variants = variants;
	}

	public int[] getProbability() {
		return probability;
	}

	public void setProbability(int[] probability) {
		this.probability = probability;
	}
}
