package top.jie65535

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.*

/**
 * Minecraft UUID Service
 *
 * https://tenapi.cn/
 */
object MinecraftUuidService {

    /**
     * 根据游戏角色名获取UUID
     */
    fun getUuid(username: String) : String {
        var uuid = JMSPluginData.idMap[username]
        if (uuid != null) {
            return uuid
        }

        val retJson = HttpUtil.get("https://tenapi.cn/v2/mc/?uid=$username").decodeToString()
        val response = Json.decodeFromString<JsonObject>(retJson)
        if (response["code"]!!.jsonPrimitive.content == "200") {
            val elem = response["data"]!!.jsonObject["id"]!!.jsonPrimitive
            if (elem == JsonNull) throw Exception("Player UUID Not Found!")
            uuid = elem.content
        } else {
            throw Exception(response["msg"]!!.jsonPrimitive.content)
        }

        JMSPluginData.idMap[username] = uuid
        return uuid
    }
}