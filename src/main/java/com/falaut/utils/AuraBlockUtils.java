package com.falaut.utils;

import de.ellpeck.naturesaura.api.NaturesAuraAPI;
import de.ellpeck.naturesaura.api.aura.type.IAuraType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;

public class AuraBlockUtils {
    public Number getStoredAura(BlockEntity blockEntity) {
        if (blockEntity == null) return null;
        var cap = blockEntity.getCapability(NaturesAuraAPI.CAP_AURA_CONTAINER);
        if (cap.isPresent()) {
            return cap.resolve().get().getStoredAura();
        }
        return null;
    }

    public Number getMaxAura(BlockEntity blockEntity) {
        if (blockEntity == null) return null;
        var cap = blockEntity.getCapability(NaturesAuraAPI.CAP_AURA_CONTAINER);
        if (cap.isPresent()) {
            return cap.resolve().get().getStoredAura();
        }
        return null;
    }

    public Number getAuraColor(BlockEntity blockEntity) {
        if (blockEntity == null) return null;
        var cap = blockEntity.getCapability(NaturesAuraAPI.CAP_AURA_CONTAINER);
        if (cap.isPresent()) {
            return cap.resolve().get().getAuraColor();
        }
        return null;
    }

    public Boolean isAcceptableType(BlockEntity blockEntity, String auraType) {
        if (blockEntity == null) return null;
        var cap = blockEntity.getCapability(NaturesAuraAPI.CAP_AURA_CONTAINER);
        IAuraType IAuraType =  NaturesAuraAPI.AURA_TYPES.get(new ResourceLocation(auraType));
        if (cap.isPresent() && IAuraType != null) {
            return cap.resolve().get().isAcceptableType(IAuraType);
        }
        return null;
    }

    public void storeAura(BlockEntity blockEntity, Integer aura, Boolean simulate) {
        if (blockEntity == null) return;
        var cap = blockEntity.getCapability(NaturesAuraAPI.CAP_AURA_CONTAINER);
        if (cap.isPresent()) {
            cap.resolve().get().storeAura(aura, simulate);
        }
    }

    public void drainAura(BlockEntity blockEntity, Integer aura, Boolean simulate) {
        if (blockEntity == null) return;
        var cap = blockEntity.getCapability(NaturesAuraAPI.CAP_AURA_CONTAINER);
        if (cap.isPresent()) {
            cap.resolve().get().drainAura(aura, simulate);
        }
    }
}
