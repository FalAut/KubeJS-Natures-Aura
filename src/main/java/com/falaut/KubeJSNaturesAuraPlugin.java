package com.falaut;

import com.falaut.utils.*;
import com.falaut.custom.*;
import com.falaut.schema.*;
import com.falaut.event.NaturesAuraEventJS;
import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.event.EventGroup;
import dev.latvian.mods.kubejs.event.EventHandler;
import dev.latvian.mods.kubejs.registry.RegistryInfo;
import dev.latvian.mods.kubejs.script.BindingsEvent;
import dev.latvian.mods.kubejs.recipe.schema.RegisterRecipeSchemasEvent;

public class KubeJSNaturesAuraPlugin extends KubeJSPlugin {

    @Override
    public void init() {
        RegistryInfo.ITEM.addType("naturesaura:aura_cache", AuraCacheItemBuilder.class, AuraCacheItemBuilder::new);
        RegistryInfo.ITEM.addType("naturesaura:structure_finder", StructureFinderItemBuilder.class, StructureFinderItemBuilder::new);
    }
    public static EventGroup GROUP = EventGroup.of("NaturesAuraEvents");
    public static EventHandler INIT = GROUP.startup("init", () -> NaturesAuraEventJS.class);

    @Override
    public void registerEvents() {
        GROUP.register();
    }

    public void registerBindings(BindingsEvent event) {
        event.add("AuraBlock", new AuraBlockUtils());
        event.add("AuraItem", new AuraItemUtils());
        event.add("AuraChunk", new AuraChunkUtils());
    }

    @Override
    public void registerRecipeSchemas(RegisterRecipeSchemasEvent event) {
        event.namespace("naturesaura")
                .register("altar", NaturalAltarSchema.SCHEMA)
                .register("animal_spawner", AnimalSpawnerSchema.SCHEMA)
                .register("offering", OfferingTableSchema.SCHEMA)
                .register("tree_ritual", TreeRitualSchema.SCHEMA)
        ;
    }
}

