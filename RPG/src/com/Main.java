package com;

import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

public class Main implements Runnable {
	Interpreter interpret= new Interpreter();
	public static void main(String[] args) throws InterruptedException,
	InvocationTargetException {

			SwingUtilities.invokeAndWait(new Main());

	}
	@Override
	public void run() {
		interpret.run();
		
	}

}
