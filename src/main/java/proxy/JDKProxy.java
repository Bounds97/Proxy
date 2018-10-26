package proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import impl.ImplLiuDeHua;
import inter.InterLiuDeHua;

/**
 * @author bounds
 * 创建动态代理对象
 * 动态代理不需要实现接口,但是需要指定接口类型
 */
public class JDKProxy {
	private InterLiuDeHua interLiuDeHua = new ImplLiuDeHua();

	public InterLiuDeHua getProxy() {
		// 使用Proxy.newProxyInstance(ClassLoader loader, Class<?>[]
		// interfaces,InvocationHandler h)返回某个对象的代理对象
		return (InterLiuDeHua) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(),
				interLiuDeHua.getClass().getInterfaces(), new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						// 如果调用的是代理对象的sing方法
						if (method.getName().equals("sing")) {
							System.out.println("我是他的经纪人，要找他唱歌得先给十万块钱！！");
							// 已经给钱了，经纪人自己不会唱歌，就只能找刘德华去唱歌！
							return method.invoke(interLiuDeHua, args);// 代理对象调用真实目标对象的sing方法去处理用户请求
						}
						// 如果调用的是代理对象的dance方法
						if (method.getName().equals("dance")) {
							System.out.println("我是他的经纪人，要找他跳舞得先给二十万块钱！！");
							// 已经给钱了，经纪人自己不会唱歌，就只能找刘德华去跳舞！
							return method.invoke(interLiuDeHua, args);// 代理对象调用真实目标对象的dance方法去处理用户请求
						}
						return null;
					}
				});

	}
}
