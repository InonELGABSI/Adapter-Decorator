package test;

import test.Q2.MyIntArrayToStringReader;
import test.Q2.MyWordFilter;

public class MainTrain {
	
	
	public static void q1(){
		if(PushableAdapter.class.getInterfaces().length==0 || !PushableAdapter.class.getInterfaces()[0].equals(Pushable.class))
			System.out.println("Pushable adapater is not of type Pushable (-15)");
	}
	
	private static void q2c(){
		int[] r ={10,20,30,30,40};
		String result = new MyWordFilter(new MyIntArrayToStringReader(()->r)).readString();
		if(!result.equals("10;20;30;40;"))
			System.out.println("Q2: Decorator + Adapter implementation is worng (-15)");
	}
	
	public static void main(String[] args) {
		q1();
		q2c();
		System.out.println("done");
	}

}
