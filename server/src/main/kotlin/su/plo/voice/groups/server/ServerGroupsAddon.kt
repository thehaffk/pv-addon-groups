package su.plo.voice.groups.server

import su.plo.slib.api.server.event.command.McServerCommandsRegisterEvent
import su.plo.voice.api.addon.AddonLoaderScope
import su.plo.voice.api.addon.annotation.Addon
import su.plo.voice.groups.BuildConstants
import su.plo.voice.groups.GroupsAddon

@Addon(id = "pv-addon-groups", scope = AddonLoaderScope.SERVER, version = BuildConstants.VERSION, authors = ["KPidS"])
class ServerGroupsAddon : GroupsAddon() {

    init {
        McServerCommandsRegisterEvent.registerListener { commandManager, minecraftServer ->
            commandManager.register(
                "groups",
                createCommandHandler(minecraftServer)
                    .also { addSubcommandsToCommandHandler(it) }
            )
        }
    }
}
