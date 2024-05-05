package com.falaut.kubejsnaturesaura.event;

import de.ellpeck.naturesaura.api.NaturesAuraAPI;
import de.ellpeck.naturesaura.api.aura.type.BasicAuraType;
import dev.latvian.mods.kubejs.event.EventJS;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

public class NaturesAuraEventJS extends EventJS {
    public static NaturesAuraEventJS INSTANCE = new NaturesAuraEventJS();

    public void custom(ResourceLocation auraType, ResourceLocation dimension, Integer color) {
        custom(auraType, dimension, color, 0);
    }
    public void custom(ResourceLocation auraType, ResourceLocation dimension, Integer color, Integer priority) {
        new BasicAuraType(auraType, ResourceKey.create(Registries.DIMENSION, dimension), color, priority).register();
    }

    public void modify(ResourceLocation dimension, String auraType) {
        ((BasicAuraType) NaturesAuraAPI.AURA_TYPES.get(new ResourceLocation(auraType))).addDimensionType(dimension);
    }

    public void createMultiblock(ResourceLocation name, String[][] pattern, Object... rawMatchers) {
        NaturesAuraAPI.instance().createMultiblock(name, pattern, rawMatchers);
    }
}
