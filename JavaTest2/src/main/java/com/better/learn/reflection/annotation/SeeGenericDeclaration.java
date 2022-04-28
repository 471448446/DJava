package com.better.learn.reflection.annotation;

import java.io.Serializable;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * Class和Method类都继承了{@link java.lang.reflect.GenericDeclaration}。
 * 所有可以通过{@link GenericDeclaration#getTypeParameters()}方法获取申明的泛型变量
 */
public class SeeGenericDeclaration<T1, T2 extends Number, T3 extends Serializable & Comparable> {
    // 类SeeGenericDeclaration申明了三个泛型变量，T2、T3分别限制的上限，而T1没有限制，默认上限是Object

    public <H, H2 extends Number> H someMethod(H p1, H2 p2, String p3) {
        // 改方法申明了2个泛型变量
        return p1;
    }

    public static void test() {
        System.out.println("--------------See GenericDeclaration in Class");
        // 获取类定义的泛型变量列表
        TypeVariable<Class<SeeGenericDeclaration>>[] typeParameters = SeeGenericDeclaration.class.getTypeParameters();
        for (TypeVariable<Class<SeeGenericDeclaration>> typeParameter : typeParameters) {
            SeeTypeVariable.printTypeVariable(typeParameter);
        }
        System.out.println("--------------See GenericDeclaration in Method");
        Method someMethod = null;
        for (Method method : SeeGenericDeclaration.class.getMethods()) {
            if (method.getName().equals("someMethod")) {
                someMethod = method;
                break;
            }
        }

        // 获取方法定义的泛型变量列表
        System.out.println("---see someMethod() declaration generic");
        TypeVariable<Method>[] typeParametersOfMethod = someMethod.getTypeParameters();
        for (TypeVariable<Method> methodTypeVariable : typeParametersOfMethod) {
            SeeTypeVariable.printTypeVariable(methodTypeVariable);
        }

        // 获取方法的返回类型
        System.out.println("---see someMethod() return Parameter Types");
        Type genericReturnType = someMethod.getGenericReturnType();
        if (genericReturnType instanceof TypeVariable) {
            SeeTypeVariable.printTypeVariable((TypeVariable) genericReturnType);
        } else {
            System.out.println("method() return is not generic: return class is" + genericReturnType.getTypeName());
        }

        // 获取方法的参数类型信息
        System.out.println("---see someMethod() Parameter Types");
        Type[] genericParameterTypes = someMethod.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            if (genericParameterType instanceof TypeVariable) {
                SeeTypeVariable.printTypeVariable((TypeVariable) genericParameterType);
            } else if (genericParameterType instanceof Class) {
                System.out.println("--Parameter is not generic: " + genericParameterType.getTypeName() + "," + ((Class) genericParameterType).getName());
            }
        }

        // 获取参数的限定类型，如果是泛型就是泛型的限定类的名称，如果是非泛型，就是参数的类名称
        Class<?>[] parameterTypes = someMethod.getParameterTypes();
    }
}
