package util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.intellij.ide.plugins.PluginManager;
import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class HttpUtil {

    public static <T> List<T> httpGet(String url, Map<String, String> param, Class<T> type) {
        String result = "";
        BufferedReader in = null;
        StringBuilder builder = new StringBuilder(url);
        try {
            // append params
            if(param != null && param.size() > 0) {
                builder.append("?");
                for(String key : param.keySet()) {
                    builder.append(key).append("=").append(param.get(key)).append("&");
                }
                builder.substring(0, builder.length()-1);
            }
            // request
            URL realUrl = new URL(builder.toString());
            URLConnection connection = realUrl.openConnection();
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.connect();
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            PluginManager.getLogger().error(e);
        }
        // close stream
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                PluginManager.getLogger().error(e2);
            }
        }
        // convert json to object
        if(StringUtils.isNotBlank(result)) {
            return JSON.parseObject(result, new TypeReference<List<T>>(type) {});
        } else {
            return null;
        }
    }

}
