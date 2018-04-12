package effectjava;

public class AutoBox {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer integer1 = 100;
		Integer integer2 = 100;
		System.out.println("integer1==integer2: " + (integer1 == integer2));// true  自动装箱的两个缓存中的 Integer对象的引用比较  
		System.out.println("integer1.equals(integer2): " + (integer1.equals(integer2)));// true  
		System.out.println("integer1.compare(integer2): " + integer1.compareTo(integer2));// 0      
		Integer integer3 = 200;  
		Integer integer4 = 200;  
		System.out.println("integer3==integer4: " + (integer3 == integer4));// false 自动装箱的两个new Integer的引用比较  
		System.out.println("integer3>integer4: " + (integer3 > integer4)); // false 将两个对象拆箱，再比较大小  
		System.out.println("integer3.equals(integer4): " + (integer3.equals(integer4)));// true  
		System.out.println("integer3.compare(integer4): " + integer3.compareTo(integer4));// 0     
		Integer integer5 = new Integer(100);  
		Integer integer6 = new Integer(100);  
		System.out.println("integer5==integer6: " + (integer5 == integer6)); // false 两个不同的Integer对象引用的比较  
		System.out.println("integer5.equals(integer6): " + (integer5.equals(integer6)));// true  
		System.out.println("integer5.compare(integer6): " + integer5.compareTo(integer6));// 0      
		int int1 = 100;  
		System.out.println("integer1==int1: " + (integer1 == int1));// true  Integer缓存对象拆箱后与int比较  
		System.out.println("integer1.equals(int1): " + (integer1.equals(int1)));// true  
		System.out.println("integer1.compare(int1): " + integer1.compareTo(int1));// 0        
		int int2 = 200;  
		System.out.println("integer3==int2: " + (integer3 == int2));// true  Integer对象拆箱后与int比较  
		System.out.println("integer3.equals(int2): " + (integer3.equals(int2)));// true  
		System.out.println("integer3.compare(int2): " + integer3.compareTo(int2));// 0   
	}

}
