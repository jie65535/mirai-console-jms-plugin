package top.jie65535

/**
 * Minecraft 玩家封装
 *
 * @param username 玩家昵称
 */
class MinecraftPlayer(username: String) {

    /**
     * 玩家UUID
     */
    val uuid: String = MinecraftUuidService.getUuid(username)

    /**
     * 头像
     */
    val avatar get() = MinecraftSkinService.getAvatars(uuid)

    /**
     * 头模型渲染
     */
    val head get() = MinecraftSkinService.getHeadRenders(uuid)

    /**
     * 皮肤模型渲染
     */
    val body get() = MinecraftSkinService.getBodyRenders(uuid)

    /**
     * 皮肤文件
     */
    val skin get() = MinecraftSkinService.getSkins(uuid)

    /**
     * 披风文件
     */
    val cape get() = MinecraftSkinService.getCapes(uuid)
}