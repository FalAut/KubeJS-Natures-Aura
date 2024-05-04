package com.falaut.custom;

import de.ellpeck.naturesaura.items.ItemAuraCache;
import dev.latvian.mods.kubejs.item.ItemBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class AuraCacheItemBuilder extends ItemBuilder {

//    private String name;
    private int maxAura;

    public AuraCacheItemBuilder(ResourceLocation i) {
        super(i);
    }

//    public AuraCacheItemBuilder setName(String name) {
//        this.name = name;
//        return this;
//    }

    public AuraCacheItemBuilder setMaxAura(int m) {
        this.maxAura = m;
        return this;
    }

    @Override
    public Item createObject() {
        return new ItemAuraCache(this.id.getPath(),maxAura);
    }
}