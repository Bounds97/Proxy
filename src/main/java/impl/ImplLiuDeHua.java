package impl;

import inter.InterLiuDeHua;

/**
 * @author bounds
 *  实现目标对象接口
 */
public class ImplLiuDeHua implements InterLiuDeHua {

	@Override
	public String sing(String name) {
		System.out.println("刘德华唱了一首：" + name);
		return "歌唱完了，谢谢大家！";
	}

	@Override
	public String dance(String name) {
		System.out.println("刘德华跳" + name + "舞！");
		return "舞跳完了，谢谢大家！";
	}

}
