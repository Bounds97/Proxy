package test;

import org.junit.Test;

import impl.ImplLiuDeHua;
import inter.InterLiuDeHua;
import normal.LiuDeHua;
import proxy.CglibProxy;
import proxy.JDKProxy;
import proxy.StaticProxy;

public class TestLiuDeHua {

	@Test
	public void testOne() {
		System.out.println("常规静态代理：");
		//目标对象
		InterLiuDeHua target=new ImplLiuDeHua();
		//代理对象,把目标对象传给代理对象,建立代理关系
		StaticProxy staticProxy = new StaticProxy(target);
		//执行的是代理的方法
		staticProxy.agent();
	}
	@Test
	public void testTwo(){
		System.out.println("JDK动态代理：");
		//代理对象
		JDKProxy jdkProxy=new JDKProxy();
		//获得代理对象
		InterLiuDeHua interLiuDeHua=jdkProxy.getProxy();
		//调用代理对象的sing方法
		interLiuDeHua.sing("冰雨");
		//调用代理对象的dance方法
		interLiuDeHua.dance("小苹果");
	}
	@Test
	public void testThree(){
		System.out.println("Cglib子类代理：");
		//目标对象
		LiuDeHua target=new LiuDeHua();
		//代理对象
		LiuDeHua proxy=(LiuDeHua) new CglibProxy(target).getProxyInstance();
		//调用代理对象的sing方法
		proxy.sing("冰雨");
		//调用代理对象的dance方法
		proxy.dance("小苹果");
	}
}
