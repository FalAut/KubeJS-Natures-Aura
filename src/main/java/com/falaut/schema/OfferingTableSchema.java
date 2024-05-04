package com.falaut.schema;

import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.ItemComponents;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;

public interface OfferingTableSchema {

    RecipeKey<?> OUTPUT = ItemComponents.OUTPUT.key("output");
    RecipeKey<?> INPUT = ItemComponents.INPUT.key("input");
    RecipeKey<?> START_ITEM = ItemComponents.INPUT.key("start_item");

    RecipeSchema SCHEMA = new RecipeSchema(OUTPUT, INPUT, START_ITEM);
}
