package club.issizler.orkide.bukkit.block;

import club.issizler.okyanus.api.math.Vec3d;
import club.issizler.orkide.bukkit.WorldImpl;
import org.bukkit.*;
import org.bukkit.block.*;
import org.bukkit.block.data.BlockData;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;

import java.util.Collection;
import java.util.List;

public class BlockImpl implements Block {

    private final club.issizler.okyanus.api.world.Block block;

    public BlockImpl(club.issizler.okyanus.api.world.Block block) {
        this.block = block;
    }

    @Override
    public byte getData() {
        return 0;
    }

    @Override
    public BlockData getBlockData() {
        return null;
    }

    @Override
    public Block getRelative(int modX, int modY, int modZ) {
        return null;
    }

    @Override
    public Block getRelative(BlockFace face) {
        return null;
    }

    @Override
    public Block getRelative(BlockFace face, int distance) {
        return null;
    }

    @Override
    public Material getType() {
        return null;
    }

    @Override
    public byte getLightLevel() {
        return 0;
    }

    @Override
    public byte getLightFromSky() {
        return 0;
    }

    @Override
    public byte getLightFromBlocks() {
        return 0;
    }

    @Override
    public World getWorld() {
        return null;
    }

    @Override
    public int getX() {
        return (int) block.getLocation().x;
    }

    @Override
    public int getY() {
        return (int) block.getLocation().y;
    }

    @Override
    public int getZ() {
        return (int) block.getLocation().z;
    }

    @Override
    public Location getLocation() {
        Vec3d location = block.getLocation();
        return new Location(new WorldImpl(block.getWorld()), location.x, location.y, location.z);
    }

    @Override
    public Location getLocation(Location loc) {
        return null;
    }

    @Override
    public Chunk getChunk() {
        return null;
    }

    @Override
    public void setBlockData(BlockData data) {

    }

    @Override
    public void setBlockData(BlockData data, boolean applyPhysics) {

    }

    @Override
    public void setType(Material type) {

    }

    @Override
    public void setType(Material type, boolean applyPhysics) {

    }

    @Override
    public BlockFace getFace(Block block) {
        return null;
    }

    @Override
    public BlockState getState() {
        return null;
    }

    @Override
    public Biome getBiome() {
        return null;
    }

    @Override
    public void setBiome(Biome bio) {

    }

    @Override
    public boolean isBlockPowered() {
        return false;
    }

    @Override
    public boolean isBlockIndirectlyPowered() {
        return false;
    }

    @Override
    public boolean isBlockFacePowered(BlockFace face) {
        return false;
    }

    @Override
    public boolean isBlockFaceIndirectlyPowered(BlockFace face) {
        return false;
    }

    @Override
    public int getBlockPower(BlockFace face) {
        return 0;
    }

    @Override
    public int getBlockPower() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isLiquid() {
        return false;
    }

    @Override
    public double getTemperature() {
        return 0;
    }

    @Override
    public double getHumidity() {
        return 0;
    }

    @Override
    public PistonMoveReaction getPistonMoveReaction() {
        return null;
    }

    @Override
    public boolean breakNaturally() {
        return false;
    }

    @Override
    public boolean breakNaturally(ItemStack tool) {
        return false;
    }

    @Override
    public Collection<ItemStack> getDrops() {
        return null;
    }

    @Override
    public Collection<ItemStack> getDrops(ItemStack tool) {
        return null;
    }

    @Override
    public boolean isPassable() {
        return false;
    }

    @Override
    public RayTraceResult rayTrace(Location start, Vector direction, double maxDistance, FluidCollisionMode fluidCollisionMode) {
        return null;
    }

    @Override
    public BoundingBox getBoundingBox() {
        return null;
    }

    @Override
    public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {

    }

    @Override
    public List<MetadataValue> getMetadata(String metadataKey) {
        return null;
    }

    @Override
    public boolean hasMetadata(String metadataKey) {
        return false;
    }

    @Override
    public void removeMetadata(String metadataKey, Plugin owningPlugin) {

    }

}
