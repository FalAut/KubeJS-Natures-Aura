package com.falaut.kubejsnaturesaura.utils;

import de.ellpeck.naturesaura.api.NaturesAuraAPI;
import de.ellpeck.naturesaura.api.aura.container.IAuraContainer;
import de.ellpeck.naturesaura.api.aura.type.IAuraType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class AuraItemUtils {

    private @Nullable IAuraContainer getAuraContainer(ItemStack itemStack) {
        if (itemStack == null) return null;

        return itemStack.getCapability(NaturesAuraAPI.AURA_CONTAINER_ITEM_CAPABILITY, null);
    }

    public Number getStoredAura(ItemStack itemStack) {
        var cap = getAuraContainer(itemStack);
        return cap != null ? cap.getStoredAura() : null;
    }

    public Number getMaxAura(ItemStack itemStack) {
        var cap = getAuraContainer(itemStack);
        return cap != null ? cap.getMaxAura() : null;
    }

    public Number getAuraColor(ItemStack itemStack) {
        var cap = getAuraContainer(itemStack);
        return cap != null ? cap.getAuraColor() : null;
    }

    public Boolean isAcceptableType(ItemStack itemStack, String auraType) {
        var cap = getAuraContainer(itemStack);
        if (cap != null) {
            IAuraType auraTypeObj = NaturesAuraAPI.AURA_TYPES.get(ResourceLocation.parse(auraType));
            if (auraTypeObj != null) {
                return cap.isAcceptableType(auraTypeObj);
            }
        }
        return null;
    }

    public void storeAura(ItemStack itemStack, Integer aura, Boolean simulate) {
        var cap = getAuraContainer(itemStack);
        if (cap != null) {
            cap.storeAura(aura, simulate);
        }
    }

    public void drainAura(ItemStack itemStack, Integer aura, Boolean simulate) {
        var cap = getAuraContainer(itemStack);
        if (cap != null) {
            cap.drainAura(aura, simulate);
        }
    }
}
