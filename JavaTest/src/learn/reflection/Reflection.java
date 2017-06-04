package learn.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import common.Utils;

/**
 * ��������
 * ��ȡ������ȡ�� ��������
 * ���÷��������� ��������
 * @author better
 * @date: 2017��2��21�� ����4:27:47
 */
public class Reflection {
	public static void main(String[] args) {
		Persion p=new Persion(10);
		p.increase(1);
		Utils.log(""+p.count);
		try {
			 //��ȡ���췽��
			Constructor<Persion> con=Persion.class.getConstructor(int.class);
			//��������
			Persion person=con.newInstance(20);
			//��ȡ����
			Method persionInCrease=Persion.class.getMethod("increase", int.class);
			//���÷���
			persionInCrease.invoke(person, 1);
			//��ȡ��
			Field persionField=Persion.class.getDeclaredField("count");
			//��ȡ���ֵ
			Utils.log("���䣺"+persionField.getInt(person));
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
