package com.falaut.kubejsnaturesaura.schema;

import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.*;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;

public interface AnimalSpawnerSchema {

    RecipeKey<String> ENTITY = StringComponent.STRING.outputKey("entity");
    RecipeKey<List<Ingredient>> INGREDIENTS = IngredientComponent.INGREDIENT.instance().asList().inputKey("ingredients");
    RecipeKey<Integer> AURA = NumberComponent.INT.otherKey("aura").optional(10000).alwaysWrite();
    RecipeKey<Integer> TIME = NumberComponent.INT.otherKey("time").optional(120).alwaysWrite();

    RecipeSchema SCHEMA = new RecipeSchema(ENTITY, INGREDIENTS, AURA, TIME);
}
