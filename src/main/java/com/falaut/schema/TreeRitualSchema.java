package com.falaut.schema;

import dev.latvian.mods.kubejs.item.InputItem;
import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.ItemComponents;
import dev.latvian.mods.kubejs.recipe.component.TimeComponent;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;

public interface TreeRitualSchema {

    RecipeKey<?> OUTPUT = ItemComponents.OUTPUT.key("output");
    RecipeKey<?> INGREDIENTS = ItemComponents.INPUT_ARRAY.key("ingredients");
    RecipeKey<?> SAPLING = ItemComponents.INPUT.key("sapling").optional(InputItem.of("oak_sapling")).alwaysWrite();
    RecipeKey<?> TIME = TimeComponent.TICKS.key("time").optional(200L).alwaysWrite();

    RecipeSchema SCHEMA = new RecipeSchema(OUTPUT, INGREDIENTS, SAPLING, TIME);
}
