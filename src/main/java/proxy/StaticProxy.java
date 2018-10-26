package proxy;

import inter.InterLiuDeHua;

/**
 * @author bounds
 * 代理对象，静态代理
 */
public class StaticProxy {
	
	//维护目标对象
	private InterLiuDeHua target;
	//接收保存目标对象
	public StaticProxy(InterLiuDeHua target) {
		this.target = target;
	}
	//执行目标对象的方法
	public void agent() {
		System.out.println("我是他的经纪人，要找他唱歌得先给十万块钱！！");
		// 代理对象调用真实目标对象的sing方法去处理用户请求
		target.sing("冰雨");
		System.out.println("我是他的经纪人，要找他跳舞得先给二十万块钱！！");
		// 代理对象调用真实目标对象的dance方法去处理用户请求
		target.dance("小苹果");
	}

}
