package com.falaut.kubejsnaturesaura;

import com.falaut.kubejsnaturesaura.event.NaturesAuraEventJS;
import dev.latvian.mods.kubejs.script.ScriptType;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartedEvent;

@Mod(KubeJSNaturesAura.MOD_ID)
public class KubeJSNaturesAura {
    public static final String MOD_ID = "kubejs_naturesaura";

    public KubeJSNaturesAura() {
        NeoForge.EVENT_BUS.addListener(KubeJSNaturesAura::gameStart);
    }
    public static void gameStart(ServerStartedEvent event) {
        KubeJSNaturesAuraPlugin.INIT.post(ScriptType.STARTUP, NaturesAuraEventJS.INSTANCE);
    }
}
