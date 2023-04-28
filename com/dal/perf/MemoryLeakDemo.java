package com.dal.perf;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ThreadMXBean;
import java.util.Map;

public class MemoryLeakDemo {

	public final String key;

	public MemoryLeakDemo(String key) {
		this.key=key;
	}
	public static void main(String[] args) {
		RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();
		String jvmName = runtimeBean.getName();
		
		System.out.println("JVM name = " + jvmName);
		
		long pid = Long.valueOf(jvmName.split("@")[0]);
		System.out.println("JVM PID = " + pid);
		
		ThreadMXBean bean = ManagementFactory.getThreadMXBean();
		int peakThreadCount = bean.getPeakThreadCount();
		
		System.out.println("Peak Thread Count = " + peakThreadCount);
		System.out.println("Total memory = " + Runtime.getRuntime().totalMemory() + " bytes");
		System.out.println("Free memory = " + Runtime.getRuntime().freeMemory() + " bytes");		
		System.out.println("Used Memory = " + (Runtime.getRuntime().totalMemory() -Runtime.getRuntime().freeMemory()) + " bytes");
		System.out.println("Max memory = " + Runtime.getRuntime().maxMemory() + " bytes");
		
		try {
			Map map = System.getProperties();
			for(;;) {
				map.put(new MemoryLeakDemo("key"), 1);
				System.out.println(map);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
