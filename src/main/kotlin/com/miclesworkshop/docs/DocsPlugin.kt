package com.miclesworkshop.docs

import co.aikar.commands.BaseCommand
import org.bukkit.plugin.java.JavaPlugin
import co.aikar.commands.PaperCommandManager
import co.aikar.commands.CommandHelp
import co.aikar.commands.annotation.*
import org.bukkit.command.CommandSender
import org.eclipse.jgit.api.Git
import java.io.File

class DocsPlugin : JavaPlugin() {
    private val commandManager = PaperCommandManager(this)
    val gitRoot = File(dataFolder, "repository")

    override fun onEnable() {
        gitRoot.mkdirs()
        commandManager.registerCommand(DocsCommand(this))
        commandManager.enableUnstableAPI("help")
    }

    override fun onDisable() {
        commandManager.unregisterCommands()
    }

    fun async(function: () -> Unit) = server.scheduler.runTaskAsynchronously(this, function)
}

@Suppress("unused")
@CommandAlias("docs")
class DocsCommand(val plugin: DocsPlugin) : BaseCommand() {
    @HelpCommand
    fun onHelp(sender: CommandSender, help: CommandHelp) = help.showHelp()

    @Subcommand("origin")
    @Description("Changes git origin URL and clones")
    @CommandPermission("docs.origin")
    fun onOrigin() {
//        val git = Git()
    }

    @Subcommand("update")
    @Description("updates the repo")
    fun onUpdate() {

    }
}