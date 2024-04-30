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
//        = HttpUtil.get("https://crafatar.com/avatars/$uuid?overlay")
            = HttpUtil.get("https://nmsr.nickac.dev/face/$uuid")

    /**
     * 获取玩家头模型渲染图
     */
    fun getHeadRenders(uuid: String)
//        = HttpUtil.get("https://crafatar.com/renders/head/$uuid?overlay")
        = HttpUtil.get("https://nmsr.nickac.dev/head/$uuid")

    /**
     * 获取玩家皮肤模型渲染图
     */
    fun getBodyRenders(uuid: String)
//        = HttpUtil.get("https://crafatar.com/renders/body/$uuid?overlay")
        = HttpUtil.get("https://nmsr.nickac.dev/fullbody/$uuid")

    /**
     * 获取玩家皮肤源文件
     */
    fun getSkins(uuid: String)
//        = HttpUtil.get("https://crafatar.com/skins/$uuid")
        = HttpUtil.get("https://nmsr.nickac.dev/skin/$uuid")

//    /**
//     * 获取玩家皮肤源文件
//     */
//    fun getCapes(uuid: String)
//        = HttpUtil.get("https://crafatar.com/capes/$uuid")
}
