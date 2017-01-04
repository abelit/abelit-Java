package org.dataforum.pattern.factory;

public class Computer {
	private OutputFactory outputFactory;

	public OutputFactory getOutputFactory() {
		return outputFactory;
	}

	public void setOutputFactory(OutputFactory outputFactory) {
		this.outputFactory = outputFactory;
	}

	public void printMsg(String msg) throws InstantiationException, IllegalAccessException{
		outputFactory.createOutput("printerB").out(msg);
	}
}
