package com.falaut.kubejsnaturesaura.schema;

import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.*;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.crafting.SizedIngredient;

import java.util.List;

public interface TreeRitualSchema {

    RecipeKey<ItemStack> OUTPUT =  ItemStackComponent.ITEM_STACK.outputKey("output");
    RecipeKey<List<Ingredient>> INGREDIENTS = IngredientComponent.INGREDIENT.asList().inputKey("ingredients");
    RecipeKey<Ingredient> SAPLING = IngredientComponent.INGREDIENT.inputKey("sapling").optional(Ingredient.of(Items.OAK_SAPLING)).alwaysWrite();
    RecipeKey<Integer> TIME = NumberComponent.INT.key("time",ComponentRole.OTHER).optional(200).alwaysWrite();

    RecipeSchema SCHEMA = new RecipeSchema(OUTPUT, INGREDIENTS, SAPLING, TIME);
}
