package com.falaut;

import com.falaut.event.NaturesAuraEventJS;
import dev.latvian.mods.kubejs.script.ScriptType;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartedEvent;
import net.neoforged.fml.common.Mod;

@Mod(KubeJSNaturesAura.MOD_ID)
public class KubeJSNaturesAura {
    public static final String MOD_ID = "kubejs_naturesaura";

    public KubeJSNaturesAura() {
        NeoForge.EVENT_BUS.addListener(KubeJSNaturesAura::gameStart);
    }
    public static void gameStart(ServerStartedEvent event) {
        KubeJSNaturesAuraPlugin.AURA_TYPE.post(ScriptType.SERVER, NaturesAuraEventJS.INSTANCE);
    }
}
