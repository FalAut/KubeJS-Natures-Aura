package com.falaut.custom;

import de.ellpeck.naturesaura.items.ItemStructureFinder;
import dev.latvian.mods.kubejs.item.ItemBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class StructureFinderItemBuilder extends ItemBuilder {
    //    private String baseName;
    private ResourceLocation structure;
    private int color;
    private int radius;

    public StructureFinderItemBuilder(ResourceLocation i) {
        super(i);
    }

//    public StructureFinderItemBuilder setBaseName(String name) {
//        this.baseName = name;
//        return this;
//    }

    public StructureFinderItemBuilder setStructure(ResourceLocation structure) {
        this.structure = structure;
        return this;
    }

    public StructureFinderItemBuilder setColor(int c) {
        this.color = c;
        return this;
    }

    public StructureFinderItemBuilder setRadius(int r) {
        this.radius = r;
        return this;
    }

    @Override
    public Item createObject() {
        return new ItemStructureFinder(this.id.getPath(), ResourceKey.create(Registries.STRUCTURE, structure), color, radius);
    }
}