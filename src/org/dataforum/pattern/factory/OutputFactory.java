package org.dataforum.pattern.factory;

public class OutputFactory {
	public Output createOutput(String printerName) throws InstantiationException, IllegalAccessException {
		if (printerName.equalsIgnoreCase("printerA")) {
			return PrinterA.class.newInstance();
		}else if (printerName.equalsIgnoreCase("printerB")) {
			return PrinterB.class.newInstance();
		}else {
			System.out.println("我们无法生成你的设备！");
			return null;
		}
	}
}
