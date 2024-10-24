package com.falaut.kubejsnaturesaura.utils;

import de.ellpeck.naturesaura.api.NaturesAuraAPI;
import de.ellpeck.naturesaura.api.aura.chunk.IAuraChunk;
import de.ellpeck.naturesaura.api.aura.type.IAuraType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import org.apache.commons.lang3.tuple.Pair;

public class AuraChunkUtils {

    private IAuraChunk getAuraChunkCapability(Level level, BlockPos pos) {
        if (level == null || pos == null) return null;
        var chunk = level.getChunkAt(pos);
        return chunk.getData(NaturesAuraAPI.AURA_CHUNK_ATTACHMENT);
    }

    public void deserializeNBT(Level level, BlockPos pos, HolderLookup.Provider registries, CompoundTag compoundTag) {
        IAuraChunk cap = getAuraChunkCapability(level, pos);
        if (cap != null) {
            cap.deserializeNBT(registries, compoundTag);
        }
    }

    public void drainAura(Level level, BlockPos pos, int amount) {
        IAuraChunk cap = getAuraChunkCapability(level, pos);
        if (cap != null) {
            cap.drainAura(pos, amount);
        }
    }

    public void drainAura(Level level, BlockPos pos, int amount, boolean aimForZero, boolean simulate) {
        IAuraChunk cap = getAuraChunkCapability(level, pos);
        if (cap != null) {
            cap.drainAura(pos, amount, aimForZero, simulate);
        }
    }

    public void storeAura(Level level, BlockPos pos, int amount) {
        IAuraChunk cap = getAuraChunkCapability(level, pos);
        if (cap != null) {
            cap.storeAura(pos, amount);
        }
    }

    public void storeAura(Level level, BlockPos pos, int amount, boolean aimForZero, boolean simulate) {
        IAuraChunk cap = getAuraChunkCapability(level, pos);
        if (cap != null) {
            cap.storeAura(pos, amount, aimForZero, simulate);
        }
    }

    public Pair<Integer, Integer> getAuraAndSpotAmountInArea(Level level, BlockPos pos, int radius) {
        if (level == null || pos == null) return null;
        return IAuraChunk.getAuraAndSpotAmountInArea(level, pos, radius);
    }

    public IAuraChunk getAuraChunk(Level level, BlockPos pos) {
        return IAuraChunk.getAuraChunk(level, pos);
    }

    public Number getAuraInArea(Level level, BlockPos pos, int radius) {
        if (level == null || pos == null) return null;
        return IAuraChunk.getAuraInArea(level, pos, radius);
    }

    public BlockPos getHighestSpot(Level level, BlockPos pos, int radius, BlockPos defaultSpot) {
        if (level == null || pos == null) return null;
        return IAuraChunk.getHighestSpot(level, pos, radius, defaultSpot);
    }

    public BlockPos getLowestSpot(Level level, BlockPos pos, int radius, BlockPos defaultSpot) {
        if (level == null || pos == null) return null;
        return IAuraChunk.getLowestSpot(level, pos, radius, defaultSpot);
    }

    public Number getSpotAmountInArea(Level level, BlockPos pos, int radius) {
        if (level == null || pos == null) return null;
        return IAuraChunk.getSpotAmountInArea(level, pos, radius);
    }

    public IAuraType getType(Level level, BlockPos pos) {
        IAuraChunk cap = getAuraChunkCapability(level, pos);
        if (cap != null) {
            return cap.getType();
        }
        return null;
    }

    public void markDirty(Level level, BlockPos pos) {
        IAuraChunk cap = getAuraChunkCapability(level, pos);
        if (cap != null) {
            cap.markDirty();
        }
    }

    public CompoundTag serializeNBT(Level level, BlockPos pos, HolderLookup.Provider registries) {
        IAuraChunk cap = getAuraChunkCapability(level, pos);
        if (cap != null) {
            return cap.serializeNBT(registries);
        }
        return null;
    }

    public Number triangulateAuraInArea(Level level, BlockPos pos, int radius) {
        if (level == null || pos == null) return null;
        return IAuraChunk.triangulateAuraInArea(level, pos, radius);
    }
}
