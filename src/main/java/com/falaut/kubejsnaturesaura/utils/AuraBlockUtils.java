package com.falaut.kubejsnaturesaura.utils;

import de.ellpeck.naturesaura.api.NaturesAuraAPI;
import de.ellpeck.naturesaura.api.aura.container.IAuraContainer;
import de.ellpeck.naturesaura.api.aura.type.IAuraType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;

public class AuraBlockUtils {

    private IAuraContainer getAuraContainer(BlockEntity blockEntity) {
        if (blockEntity == null) return null;
        var level = blockEntity.getLevel();
        var pos = blockEntity.getBlockPos();
        var tile = level.getBlockEntity(pos);
        return level.getCapability(NaturesAuraAPI.AURA_CONTAINER_BLOCK_CAPABILITY, tile.getBlockPos(), tile.getBlockState(), tile, null);
    }

    public Number getStoredAura(BlockEntity blockEntity) {
        var cap = getAuraContainer(blockEntity);
        return cap != null ? cap.getStoredAura() : null;
    }

    public Number getMaxAura(BlockEntity blockEntity) {
        var cap = getAuraContainer(blockEntity);
        return cap != null ? cap.getMaxAura() : null;
    }

    public Number getAuraColor(BlockEntity blockEntity) {
        var cap = getAuraContainer(blockEntity);
        return cap != null ? cap.getAuraColor() : null;
    }

    public Boolean isAcceptableType(BlockEntity blockEntity, String auraType) {
        var cap = getAuraContainer(blockEntity);
        if (cap != null) {
            IAuraType auraTypeObj = NaturesAuraAPI.AURA_TYPES.get(ResourceLocation.parse(auraType));
            if (auraTypeObj != null) {
                return cap.isAcceptableType(auraTypeObj);
            }
        }
        return null;
    }

    public void storeAura(BlockEntity blockEntity, Integer aura, Boolean simulate) {
        var cap = getAuraContainer(blockEntity);
        if (cap != null) {
            cap.storeAura(aura, simulate);
        }
    }

    public void drainAura(BlockEntity blockEntity, Integer aura, Boolean simulate) {
        var cap = getAuraContainer(blockEntity);
        if (cap != null) {
            cap.drainAura(aura, simulate);
        }
    }
}
