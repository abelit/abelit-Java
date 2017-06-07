package org.dataforum.concurrent;

public class ShareData {
	public static int count = 0;

	public static void main(String[] args) {
		ShareData data = new ShareData();
		
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					for (int j = 0; j < 100; j++) {
						data.addCount();
					}
					System.out.println(count + " ");
				}
			}).start();
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("count = " + count);

	}
	
//	// 共享数据模式，返回结果每次不确定，不一定为1000
//	public void addCount() {
//		count++;
//	}

	// 排斥数据模式，最终结果都返回1000
	public synchronized void addCount() {
		count++;
	}
}
