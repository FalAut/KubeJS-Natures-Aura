package com.falaut.kubejsnaturesaura.custom;

import de.ellpeck.naturesaura.items.ItemAuraCache;
import dev.latvian.mods.kubejs.item.ItemBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class AuraCacheItemBuilder extends ItemBuilder {

    public AuraCacheItemBuilder(ResourceLocation i) {
        super(i);
    }

    @Override
    public Item createObject() {
        return new ItemAuraCache(this.id.getPath());
    }
}