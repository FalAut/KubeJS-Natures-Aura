package com.falaut.kubejsnaturesaura.schema;

import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.ItemComponents;
import dev.latvian.mods.kubejs.recipe.component.NumberComponent;
import dev.latvian.mods.kubejs.recipe.component.StringComponent;
import dev.latvian.mods.kubejs.recipe.component.TimeComponent;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;

public interface AnimalSpawnerSchema {

    RecipeKey<?> ENTITY = StringComponent.NON_BLANK.key("entity");
    RecipeKey<?> INGREDIENTS = ItemComponents.INPUT_ARRAY.key("ingredients");
    RecipeKey<?> AURA = NumberComponent.INT.key("aura").optional(10000).alwaysWrite();
    RecipeKey<?> TIME = TimeComponent.TICKS.key("time").optional(120L).alwaysWrite();

    RecipeSchema SCHEMA = new RecipeSchema(ENTITY, INGREDIENTS, AURA, TIME);
}
