import model.v2ex.Topic;
import org.junit.Test;
import util.HttpUtil;

import java.util.List;

public class HttpUtilTest {

    @Test
    public void testHttpGet() {
        List<Topic> topicList = HttpUtil.httpGet("https://v2ex.com/api/topics/latest.json", null, Topic.class);
        System.out.println((topicList.get(0)).getContent());
    }
}
