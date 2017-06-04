package learn.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import common.Utils;

/**
 * 创建对象
 * 获取方法获取域 依靠类名
 * 调用方法调用域 依靠对象
 * @author better
 * @date: 2017年2月21日 下午4:27:47
 */
public class Reflection {
	public static void main(String[] args) {
		Persion p=new Persion(10);
		p.increase(1);
		Utils.log(""+p.count);
		try {
			 //获取构造方法
			Constructor<Persion> con=Persion.class.getConstructor(int.class);
			//创建对象
			Persion person=con.newInstance(20);
			//获取方法
			Method persionInCrease=Persion.class.getMethod("increase", int.class);
			//调用方法
			persionInCrease.invoke(person, 1);
			//获取域
			Field persionField=Persion.class.getDeclaredField("count");
			//获取域的值
			Utils.log("反射："+persionField.getInt(person));
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
