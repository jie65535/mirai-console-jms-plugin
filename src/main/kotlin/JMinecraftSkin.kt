package top.jie65535

import net.mamoe.mirai.console.command.CommandManager.INSTANCE.register
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.utils.info

object JMinecraftSkin : KotlinPlugin(
    JvmPluginDescription(
        id = "top.jie65535.mirai-console-jms-plugin",
        name = "J Minecraft Skin",
        version = "1.1.1",
    ) {
        author("jie65535")
        info("MC皮肤查询插件")
    }
) {

    override fun onEnable() {
        JMSPluginData.reload()
        JMSCommand.register()
        logger.info { "Plugin loaded. https://github.com/jie65535/mirai-console-jcf-plugin" }
    }

    override fun onDisable() {
        JMSPluginData.save()
    }
}