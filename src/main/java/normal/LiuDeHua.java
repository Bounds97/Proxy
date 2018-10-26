package normal;

/**
 * @author bounds
 * 目标对象,没有实现任何接口
 */
public class LiuDeHua {

	public String sing(String name) {
		System.out.println("刘德华唱了一首：" + name);
		return "歌唱完了，谢谢大家！";
	}

	public String dance(String name) {
		System.out.println("刘德华跳" + name + "舞！");
		return "舞跳完了，谢谢大家！";
	}
}
