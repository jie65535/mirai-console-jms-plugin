package top.jie65535

import net.mamoe.mirai.console.data.AutoSavePluginData
import net.mamoe.mirai.console.data.value

object JMSPluginData : AutoSavePluginData("data") {
    /**
     * 玩家昵称与ID缓存
     *
     * key: 昵称    value: uuid
     */
    val idMap: MutableMap<String, String> by value()
}