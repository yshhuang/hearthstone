import com.huangyongsheng.hearthstone.pojo.po.User;

import net.sf.json.JSONObject;

public class JsonTest {

	public static void main(String[] args) {
		User user=new User();
		user.setPassword("eee");
		user.setUsername("tt");
		JSONObject jsonObject=JSONObject.fromObject(user);
		System.out.println(jsonObject);
	}
}
