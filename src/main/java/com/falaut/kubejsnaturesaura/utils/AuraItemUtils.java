package com.falaut.kubejsnaturesaura.utils;

import de.ellpeck.naturesaura.api.NaturesAuraAPI;
import de.ellpeck.naturesaura.api.aura.type.IAuraType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class AuraItemUtils {
    public Number getStoredAura(ItemStack itemStack) {
        if (itemStack == null) return null;
        var cap = itemStack.getCapability(NaturesAuraAPI.CAP_AURA_CONTAINER);
        if (cap.isPresent()) {
            return cap.resolve().get().getStoredAura();
        }
        return null;
    }

    public Number getMaxAura(ItemStack itemStack) {
        if (itemStack == null) return null;
        var cap = itemStack.getCapability(NaturesAuraAPI.CAP_AURA_CONTAINER);
        if (cap.isPresent()) {
            return cap.resolve().get().getStoredAura();
        }
        return null;
    }

    public Number getAuraColor(ItemStack itemStack) {
        if (itemStack == null) return null;
        var cap = itemStack.getCapability(NaturesAuraAPI.CAP_AURA_CONTAINER);
        if (cap.isPresent()) {
            return cap.resolve().get().getAuraColor();
        }
        return null;
    }

    public Boolean isAcceptableType(ItemStack itemStack, String auraType) {
        if (itemStack == null) return null;
        var cap = itemStack.getCapability(NaturesAuraAPI.CAP_AURA_CONTAINER);
        IAuraType IAuraType =  NaturesAuraAPI.AURA_TYPES.get(new ResourceLocation(auraType));
        if (cap.isPresent() && IAuraType != null) {
            return cap.resolve().get().isAcceptableType(IAuraType);
        }
        return null;
    }

    public void storeAura(ItemStack itemStack, Integer aura, Boolean simulate) {
        if (itemStack == null) return;
        var cap = itemStack.getCapability(NaturesAuraAPI.CAP_AURA_CONTAINER);
        if (cap.isPresent()) {
            cap.resolve().get().storeAura(aura, simulate);
        }
    }

    public void drainAura(ItemStack itemStack, Integer aura, Boolean simulate) {
        if (itemStack == null) return;
        var cap = itemStack.getCapability(NaturesAuraAPI.CAP_AURA_CONTAINER);
        if (cap.isPresent()) {
            cap.resolve().get().drainAura(aura, simulate);
        }
    }
}
