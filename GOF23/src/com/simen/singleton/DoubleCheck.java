package com.simen.singleton;

//仅供参考，不建议使用。 由于JVM底层实现的问题经常容易出错
public class DoubleCheck {
	private static DoubleCheck instance = null;

	public static DoubleCheck getInstance() {
		if (instance == null) {
			DoubleCheck sc;
			synchronized (DoubleCheck.class) {
				sc = instance;
				if (sc == null) {
					synchronized (DoubleCheck.class) {
						if (sc == null) {
							sc = new DoubleCheck();
						}
					}
					instance = sc;
				}
			}
		}
		return instance;
	}

	private DoubleCheck() {
	}
}