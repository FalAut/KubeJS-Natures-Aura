package com.falaut.kubejsnaturesaura;

import com.falaut.kubejsnaturesaura.event.NaturesAuraEventJS;
import dev.latvian.mods.kubejs.script.ScriptType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(KubeJSNaturesAura.MOD_ID)
public class KubeJSNaturesAura {
    public static final String MOD_ID = "kubejs_naturesaura";

    public KubeJSNaturesAura() {
        MinecraftForge.EVENT_BUS.addListener(KubeJSNaturesAura::gameStart);
    }
    public static void gameStart(ServerStartedEvent event) {
        KubeJSNaturesAuraPlugin.INIT.post(ScriptType.STARTUP, NaturesAuraEventJS.INSTANCE);
    }
}
