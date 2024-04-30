package top.jie65535

import net.mamoe.mirai.console.command.CommandSender
import net.mamoe.mirai.console.command.CompositeCommand
import net.mamoe.mirai.contact.Contact.Companion.sendImage
import net.mamoe.mirai.utils.ExternalResource.Companion.toExternalResource

object JMSCommand : CompositeCommand(
    JMinecraftSkin, "jms",
    description = "Minecraft Skin Commands"
) {
    @SubCommand("uuid")
    @Description("查询玩家UUID")
    suspend fun CommandSender.getUuid(username: String) {
        try {
            sendMessage(MinecraftPlayer(username).uuid)
        } catch (e: Throwable) {
            JMinecraftSkin.logger.error("获取玩家UUID失败", e)
            e.message?.let { sendMessage(it) }
        }
    }

    @SubCommand("avatar")
    @Description("查询玩家头像")
    suspend fun CommandSender.getAvatar(username: String) {
        try {
            sendImage(MinecraftPlayer(username).avatar)
        } catch (e: Throwable) {
            JMinecraftSkin.logger.error("获取玩家头像失败", e)
            e.message?.let { sendMessage(it) }
        }
    }

    @SubCommand("head")
    @Description("查询玩家头模型")
    suspend fun CommandSender.getHead(username: String) {
        try {
            sendImage(MinecraftPlayer(username).head)
        } catch (e: Throwable) {
            JMinecraftSkin.logger.error("查询玩家头模型失败", e)
            e.message?.let { sendMessage(it) }
        }
    }

    @SubCommand("body")
    @Description("查询玩家皮肤模型")
    suspend fun CommandSender.getBody(username: String) {
        try {
            sendImage(MinecraftPlayer(username).body)
        } catch (e: Throwable) {
            JMinecraftSkin.logger.error("查询玩家皮肤模型失败", e)
            e.message?.let { sendMessage(it) }
        }
    }

    @SubCommand("skin")
    @Description("获取玩家皮肤文件")
    suspend fun CommandSender.getSkin(username: String) {
        try {
            sendImage(MinecraftPlayer(username).skin)
        } catch (e: Throwable) {
            JMinecraftSkin.logger.error("获取玩家皮肤文件失败", e)
            e.message?.let { sendMessage(it) }
        }
    }

//    @SubCommand("cape")
//    @Description("获取玩家披风文件")
//    suspend fun CommandSender.getCape(username: String) {
//        try {
//            sendImage(MinecraftPlayer(username).cape)
//        } catch (e: Throwable) {
//            JMinecraftSkin.logger.error("获取玩家披风文件失败", e)
//            e.message?.let { sendMessage(it) }
//        }
//    }

    private suspend fun CommandSender.sendImage(data: ByteArray) {
        try {
            if (data.isEmpty()) {
                subject?.sendMessage("未查询到数据")
                return
            }

            data.toExternalResource().use {
                subject?.sendImage(it)
            }
        } catch (e: Throwable) {
            subject?.sendMessage(String(data))
        }
    }
}