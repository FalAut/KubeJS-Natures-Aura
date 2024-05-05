package com.falaut.kubejsnaturesaura.utils;


import de.ellpeck.naturesaura.api.NaturesAuraAPI;
import de.ellpeck.naturesaura.api.aura.chunk.IAuraChunk;
import de.ellpeck.naturesaura.api.aura.type.IAuraType;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import org.apache.commons.lang3.tuple.Pair;

public class AuraChunkUtils {
    int DEFAULT_AURA = 1000000;

    public void deserializeNBT(Level level, BlockPos pos, CompoundTag compoundTag) {
        if (level == null || pos == null) return;
        var cap = level.getChunkAt(pos).getCapability(NaturesAuraAPI.CAP_AURA_CHUNK);
        if (cap.isPresent()) {
            cap.resolve().get().deserializeNBT(compoundTag);
        }
    }

    public void drainAura(Level level, BlockPos pos, int amount) {
        if (level == null || pos == null) return;
        var cap = level.getChunkAt(pos).getCapability(NaturesAuraAPI.CAP_AURA_CHUNK);
        if (cap.isPresent()) {
            cap.resolve().get().drainAura(pos, amount);
        }
    }

    public void drainAura(Level level, BlockPos pos, int amount, boolean aimForZero, boolean simulate) {
        if (level == null || pos == null) return;
        var cap = level.getChunkAt(pos).getCapability(NaturesAuraAPI.CAP_AURA_CHUNK);
        if (cap.isPresent()) {
            cap.resolve().get().drainAura(pos, amount, aimForZero, simulate);
        }
    }

    public void storeAura(Level level, BlockPos pos, int amount) {
        if (level == null || pos == null) return;
        var cap = level.getChunkAt(pos).getCapability(NaturesAuraAPI.CAP_AURA_CHUNK);
        if (cap.isPresent()) {
            cap.resolve().get().storeAura(pos, amount);
        }
    }

    public void storeAura(Level level, BlockPos pos, int amount, boolean aimForZero, boolean simulate) {
        if (level == null || pos == null) return;
        var cap = level.getChunkAt(pos).getCapability(NaturesAuraAPI.CAP_AURA_CHUNK);
        if (cap.isPresent()) {
            cap.resolve().get().storeAura(pos, amount, aimForZero, simulate);
        }
    }

    public Pair<Integer, Integer> getAuraAndSpotAmountInArea(Level level, BlockPos pos, int radius) {
        if (level == null || pos == null) return null;
        var cap = level.getChunkAt(pos).getCapability(NaturesAuraAPI.CAP_AURA_CHUNK);
        if (cap.isPresent()) {
            return IAuraChunk.getAuraAndSpotAmountInArea(level, pos, radius);
        }
        return null;
    }

    public IAuraChunk getAuraChunk(Level level, BlockPos pos) {
        if (level == null || pos == null) return null;
        var cap = level.getChunkAt(pos).getCapability(NaturesAuraAPI.CAP_AURA_CHUNK);
        if (cap.isPresent()) {
            return IAuraChunk.getAuraChunk(level, pos);
        }
        return null;
    }

    public Number getAuraInArea(Level level, BlockPos pos, int radius) {
        if (level == null || pos == null) return null;
        var cap = level.getChunkAt(pos).getCapability(NaturesAuraAPI.CAP_AURA_CHUNK);
        if (cap.isPresent()) {
            return IAuraChunk.getAuraInArea(level, pos, radius);
        }
        return null;
    }

    public BlockPos getHighestSpot(Level level, BlockPos pos, int radius, BlockPos defaultSpot) {
        if (level == null || pos == null) return null;
        var cap = level.getChunkAt(pos).getCapability(NaturesAuraAPI.CAP_AURA_CHUNK);
        if (cap.isPresent()) {
            return IAuraChunk.getHighestSpot(level, pos, radius, defaultSpot);
        }
        return null;
    }

    public BlockPos getLowestSpot(Level level, BlockPos pos, int radius, BlockPos defaultSpot) {
        if (level == null || pos == null) return null;
        var cap = level.getChunkAt(pos).getCapability(NaturesAuraAPI.CAP_AURA_CHUNK);
        if (cap.isPresent()) {
            return IAuraChunk.getLowestSpot(level, pos, radius, defaultSpot);
        }
        return null;
    }

    public Number getSpotAmountInArea(Level level, BlockPos pos, int radius) {
        if (level == null || pos == null) return null;
        var cap = level.getChunkAt(pos).getCapability(NaturesAuraAPI.CAP_AURA_CHUNK);
        if (cap.isPresent()) {
            return IAuraChunk.getSpotAmountInArea(level, pos, radius);
        }
        return null;
    }

    public IAuraType getType(Level level, BlockPos pos) {
        if (level == null || pos == null) return null;
        var cap = level.getChunkAt(pos).getCapability(NaturesAuraAPI.CAP_AURA_CHUNK);
        if (cap.isPresent()) {
            return cap.resolve().get().getType();
        }
        return null;
    }

    public void markDirty(Level level, BlockPos pos) {
        if (level == null || pos == null) return;
        var cap = level.getChunkAt(pos).getCapability(NaturesAuraAPI.CAP_AURA_CHUNK);
        if (cap.isPresent()) {
            cap.resolve().get().markDirty();
        }
    }

    public void serializeNBT(Level level, BlockPos pos) {
        if (level == null || pos == null) return;
        var cap = level.getChunkAt(pos).getCapability(NaturesAuraAPI.CAP_AURA_CHUNK);
        if (cap.isPresent()) {
            cap.resolve().get().serializeNBT();
        }
    }

    public Number triangulateAuraInArea(Level level, BlockPos pos, int radius) {
        if (level == null || pos == null) return null;
        var cap = level.getChunkAt(pos).getCapability(NaturesAuraAPI.CAP_AURA_CHUNK);
        if (cap.isPresent()) {
            return IAuraChunk.triangulateAuraInArea(level, pos, radius);
        }
        return null;
    }
}
