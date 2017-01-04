package org.dataforum.pattern.factory;

public class Test {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		Computer computer=new Computer();
		
		OutputFactory outputFactory=new OutputFactory();
		
		computer.setOutputFactory(outputFactory);
		
		computer.printMsg("打印机信息");
	}
}
