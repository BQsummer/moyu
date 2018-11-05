# moyu
idea  摸鱼插件 🐟

正在进行：

    * v2ex
    
        1. config(设置followed topic) 
        2. 选择followed topic    
        3. cache, topic, reply要不要缓存暂定，v站策略是1小时120次，但是cdn有缓存，~~查询node要缓存~~ 所有的node可以都列出来
        4. ~~进度条~~ http request要改造成异步，工作量大，~~而且没必要~~
        5. 刷新
        6. 登录、发送
        7. 颜色 比如作者高亮 颜色不能太亮，需要能自定义
        8. 点击评论后，回复的人高亮
        9. toolbar添加下拉框，提供topic选择或输入
        10. hot topic太少，缓存前几天的hot topic？
        
    * wechat
一些想法：

    * 知乎
    * stock
    * 微博

bug: 

     ~~1. topic panel 和 reply panel的比例有时候会跳~~
     2. 部分detail panel没有信息（followed topic很多都没有）
     3. 同tabbed panel，切换topic后，右侧的scroll没有移到最上面
     4. 内容要可选中复制
     5. 部分正文显示不全，后面是“...”,初步排查是如果首次刷新的第一个topic没有超出list宽度，就不显示水平滚动条，即使下面的topic需要滚动条也不显示了。

优化：

    * itchat4j简化
    * Whats the exact difference between paint, repaint, validate, update & updateUI ?
    * findbugs有好多错误
 
