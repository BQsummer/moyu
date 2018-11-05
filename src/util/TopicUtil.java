package util;

import common.PluginConf;
import model.v2ex.Reply;
import model.v2ex.Topic;
import service.PersistentState;

import java.util.Arrays;

public class TopicUtil {

    public static String generateTitleInfo(Topic topic) {
        return topic.getTitle() + "  replies: " + topic.getReplies();
    }

    public static String generateTopicInfo(Topic topic) {
        return topic.getMember().getUsername() + " created at: " + TimeUtil.convertTimeStampToStr(topic.getCreated(), TimeUtil.format1);
    }

    public static String generateReplyInfo(Reply reply) {
        return reply.getContent() + " replied by: " + reply.getMember().getUsername() + "  at: " + TimeUtil.convertTimeStampToStr(reply.getCreated(), TimeUtil.format1);
    }

    public static String[] getFollowedTopic() {
        Object obj = PersistentState.getInstance().get(PluginConf.V2EX_FOLLOW_LIST);
        String[] followedTopicArr = null;
        if (obj != null) {
            Object[] objArr = (Object[]) obj;
            followedTopicArr = Arrays.copyOf(objArr, objArr.length, String[].class);
        }
        return followedTopicArr;
    }
}
