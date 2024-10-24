package com.falaut.kubejsnaturesaura.schema;

import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.*;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public interface NaturalAltarSchema {
    RecipeKey<ItemStack> OUTPUT = ItemStackComponent.ITEM_STACK.outputKey("output");
    RecipeKey<Ingredient> INPUT = IngredientComponent.INGREDIENT.inputKey("input");
    RecipeKey<Integer> AURA = NumberComponent.INT.otherKey("aura").optional(5000).alwaysWrite();
    RecipeKey<Integer> TIME = NumberComponent.INT.otherKey("time").optional(60).alwaysWrite();
    RecipeKey<Ingredient> CATALYST =  IngredientComponent.INGREDIENT.inputKey("catalyst").defaultOptional();

    RecipeSchema SCHEMA = new RecipeSchema(OUTPUT, INPUT, AURA, TIME, CATALYST);
}
