package org.dataforum.pattern.factory;

public class PrinterB implements Output{

	@Override
	public void out(String msg) {
		// TODO Auto-generated method stub
		System.out.println(msg);
		System.out.println("PrinterB");
	}
	
}
