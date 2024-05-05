package com.falaut.kubejsnaturesaura.schema;

import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.ItemComponents;
import dev.latvian.mods.kubejs.recipe.component.NumberComponent;
import dev.latvian.mods.kubejs.recipe.component.TimeComponent;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;

public interface NaturalAltarSchema {

    RecipeKey<?> OUTPUT = ItemComponents.OUTPUT.key("output");
    RecipeKey<?> INPUT = ItemComponents.INPUT.key("input");
    RecipeKey<?> AURA = NumberComponent.INT.key("aura").optional(5000).alwaysWrite();
    RecipeKey<?> TIME = TimeComponent.TICKS.key("time").optional(60L).alwaysWrite();
    RecipeKey<?> CATALYST = ItemComponents.INPUT.key("catalyst").defaultOptional();

    RecipeSchema SCHEMA = new RecipeSchema(OUTPUT, INPUT, AURA, TIME, CATALYST);
}
