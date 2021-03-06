package edu.buffalo.cse.blueseal.blueseal;

import java.util.Map;

import org.apache.log4j.Logger;

import edu.buffalo.cse.blueseal.BSFlow.ComplexFlowFinder;
import edu.buffalo.cse.blueseal.BSG.BlueSealGraph;


public class Debug {
	
	static Logger logger = Logger.getLogger(ComplexFlowFinder.class);
	
	//This class is used to print out debug messages;
	private static boolean debugOn = true; //default, debug mode is off

	public Debug(boolean enableDebug){
		this.debugOn = enableDebug;
	}
	public static void printOb(Object ob){
		if(!debugOn){
			return;
		}
		logger.debug(ob);
	}
	public static void println(String tag, String msg){
		if(!debugOn){
			return;
		}
		logger.debug(tag+":"+msg);
	}
	
	public static void printSet(String tag, Iterable<? extends Object> set){
		if(!debugOn){
			return;
		}
		println(tag, "");
		for(Object ob: set){
			logger.debug(ob);
		}
	}
	
	public static void printMap(String tag, Map map){
		
		if(!debugOn){
			return;
		}
		
		println(tag, "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		for(Object key : map.keySet()){
			//logger.debug(key.toString()+":"+map.get(key).toString());
			logger.debug(key.toString()+":");
			if(key.toString().contains("test")||
					key.toString().contains("onCreate"))
				((BlueSealGraph)map.get(key)).print();
		}
	}
	
}
