package proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @author bounds 
 * Cglib子类代理工厂 对LiuDeHua在内存中动态构建一个子类对象
 */
public class CglibProxy implements MethodInterceptor {
	// 维护目标对象
	private Object target;

	public CglibProxy(Object target) {
		this.target = target;
	}

	// 给目标对象创建一个代理对象
	public Object getProxyInstance() {
		// 1.工具类
		Enhancer en = new Enhancer();
		// 2.设置父类
		en.setSuperclass(target.getClass());
		// 3.设置回调函数
		en.setCallback(this);
		// 4.创建子类(代理对象)
		return en.create();

	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		// 如果调用的是代理对象的sing方法
		if (method.getName().equals("sing")) {
			System.out.println("我是他的经纪人，要找他唱歌得先给十万块钱！！");
			// 已经给钱了，经纪人自己不会唱歌，就只能找刘德华去唱歌！
			return method.invoke(target, args);// 代理对象调用真实目标对象的sing方法去处理用户请求
		}
		// 如果调用的是代理对象的dance方法
		if (method.getName().equals("dance")) {
			System.out.println("我是他的经纪人，要找他跳舞得先给二十万块钱！！");
			// 已经给钱了，经纪人自己不会唱歌，就只能找刘德华去跳舞！
			return method.invoke(target, args);// 代理对象调用真实目标对象的dance方法去处理用户请求
		}
		return null;
	}

}
