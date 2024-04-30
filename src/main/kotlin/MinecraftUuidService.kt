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
        if (!checkUsername(username)) {
            throw IllegalArgumentException("用户名格式不正确")
        }

        var uuid = JMSPluginData.idMap[username]
        if (uuid != null) {
            return uuid
        }

        val retJson = HttpUtil.get("https://api.mojang.com/users/profiles/minecraft/$username").decodeToString()
//        val retJson = HttpUtil.get("https://tenapi.cn/v2/mc/?uid=$username").decodeToString()
        val response = Json.decodeFromString<JsonObject>(retJson)
//        if (response["code"]!!.jsonPrimitive.content == "200") {
//            val elem = response["data"]!!.jsonObject["id"]!!.jsonPrimitive
//            if (elem == JsonNull) throw Exception("Player UUID Not Found!")
//            uuid = elem.content
//        } else {
//            throw Exception(response["msg"]!!.jsonPrimitive.content)
//        }

        if (response.containsKey("id")) {
            uuid = response["id"]!!.jsonPrimitive.content
        } else if (response.containsKey("errorMessage")) {
            throw Exception(response["errorMessage"]!!.jsonPrimitive.content)
        } else {
            throw Exception("未知错误")
        }
        JMSPluginData.idMap[username] = uuid
        return uuid
    }

    /**
     * 检查用户名格式
     * 相当于正则 [0-9a-zA-Z_]{2, 16}
     * 直接代码检查懒得正则了
     */
    fun checkUsername(username: String): Boolean {
        // 长度校验
        if (username.length < 2 || username.length > 16) {
            return false
        } else {
            // 字符校验
            for (ch in username) {
                if (!ch.isLetterOrDigit() && ch != '_')
                    return false
            }
            return true
        }
    }
}