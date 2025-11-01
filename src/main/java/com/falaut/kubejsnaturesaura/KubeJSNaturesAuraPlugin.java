package com.falaut.kubejsnaturesaura;

import com.falaut.kubejsnaturesaura.utils.*;
import com.falaut.kubejsnaturesaura.custom.*;
import com.falaut.kubejsnaturesaura.schema.*;
import com.falaut.kubejsnaturesaura.event.NaturesAuraEventJS;
import dev.latvian.mods.kubejs.event.EventGroupRegistry;
import dev.latvian.mods.kubejs.plugin.KubeJSPlugin;
import dev.latvian.mods.kubejs.event.EventGroup;
import dev.latvian.mods.kubejs.event.EventHandler;
import dev.latvian.mods.kubejs.registry.BuilderTypeRegistry;
import dev.latvian.mods.kubejs.script.BindingRegistry;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchemaRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;

public class KubeJSNaturesAuraPlugin implements KubeJSPlugin {

    @Override
    public void registerBuilderTypes(BuilderTypeRegistry registry) {
        registry.of(Registries.ITEM, reg -> {
            reg.add(ResourceLocation.fromNamespaceAndPath("naturesaura", "aura_cache"), AuraCacheItemBuilder.class, AuraCacheItemBuilder::new);
            reg.add(ResourceLocation.fromNamespaceAndPath("naturesaura", "structure_finder"), StructureFinderItemBuilder.class, StructureFinderItemBuilder::new);
        });
    }

    public static EventGroup GROUP = EventGroup.of("NaturesAuraEvents");
    public static EventHandler INIT = GROUP.startup("init", () -> NaturesAuraEventJS.class);

    @Override
    public void registerEvents(EventGroupRegistry registry) {
        registry.register(GROUP);
    }

    public void registerBindings(BindingRegistry event) {
        event.add("AuraBlock", new AuraBlockUtils());
        event.add("AuraItem", new AuraItemUtils());
        event.add("AuraChunk", new AuraChunkUtils());
    }

    @Override
    public void registerRecipeSchemas(RecipeSchemaRegistry event) {
        event.namespace("naturesaura")
                .register("altar", NaturalAltarSchema.SCHEMA)
                .register("animal_spawner", AnimalSpawnerSchema.SCHEMA)
                .register("offering", OfferingTableSchema.SCHEMA)
                .register("tree_ritual", TreeRitualSchema.SCHEMA)
        ;
    }
}

