import model.v2ex.Topic;
import org.junit.Test;
import util.HttpUtil;
import util.PageHelper;

import java.util.List;

public class HttpUtilTest {

    @Test
    public void testHttpGet() {
        List<Topic> topicList = HttpUtil.httpGetList("https://v2ex.com/api/topics/latest.json", null, Topic.class);
        System.out.println((topicList.get(0)).getContent());
    }

    @Test
    public void testPageHelper() {
        List<Topic> topicList = HttpUtil.page("https://v2ex.com/api/topics/latest.json", null, Topic.class, new PageHelper(1, 10));
        System.out.println((topicList.get(0)).getContent());
    }
}
