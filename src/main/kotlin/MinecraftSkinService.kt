package top.jie65535

/**
 * Minecraft Skin Service
 *
 * https://crafatar.com/
 */
object MinecraftSkinService {

    /**
     * 获取头像
     */
    fun getAvatars(uuid: String)
        = HttpUtil.get("https://crafatar.com/avatars/$uuid")

    /**
     * 获取玩家头模型渲染图
     */
    fun getHeadRenders(uuid: String)
        = HttpUtil.get("https://crafatar.com/renders/head/$uuid")

    /**
     * 获取玩家皮肤模型渲染图
     */
    fun getBodyRenders(uuid: String)
        = HttpUtil.get("https://crafatar.com/renders/body/$uuid")

    /**
     * 获取玩家皮肤源文件
     */
    fun getSkins(uuid: String)
        = HttpUtil.get("https://crafatar.com/skin/$uuid")

    /**
     * 获取玩家皮肤源文件
     */
    fun getCapes(uuid: String)
        = HttpUtil.get("https://crafatar.com/capes/$uuid")
}