package club.issizler.orkide.bukkit;

import club.issizler.okyanus.api.math.Vec3d;
import club.issizler.orkide.bukkit.block.BlockImpl;
import org.bukkit.*;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.*;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Consumer;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;

import java.io.File;
import java.util.*;
import java.util.function.Predicate;

public class WorldImpl implements World {

    private final club.issizler.okyanus.api.world.World world;

    public WorldImpl(club.issizler.okyanus.api.world.World world) {
        this.world = world;
    }

    @Override
    public Block getBlockAt(int x, int y, int z) {
        return new BlockImpl(world.getBlockAt(new Vec3d(x, y, z)));
    }

    @Override
    public Block getBlockAt(Location location) {
        return new BlockImpl(world.getBlockAt(new Vec3d(location.getX(), location.getY(), location.getZ())));
    }

    @Override
    public int getHighestBlockYAt(int x, int z) {
        return 0;
    }

    @Override
    public int getHighestBlockYAt(Location location) {
        return 0;
    }

    @Override
    public Block getHighestBlockAt(int x, int z) {
        return null;
    }

    @Override
    public Block getHighestBlockAt(Location location) {
        return null;
    }

    @Override
    public Chunk getChunkAt(int x, int z) {
        return null;
    }

    @Override
    public Chunk getChunkAt(Location location) {
        return null;
    }

    @Override
    public Chunk getChunkAt(Block block) {
        return null;
    }

    @Override
    public boolean isChunkLoaded(Chunk chunk) {
        return false;
    }

    @Override
    public Chunk[] getLoadedChunks() {
        return new Chunk[0];
    }

    @Override
    public void loadChunk(Chunk chunk) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public boolean isChunkLoaded(int x, int z) {
        return false;
    }

    @Override
    public boolean isChunkGenerated(int x, int z) {
        return false;
    }

    @Override
    public boolean isChunkInUse(int x, int z) {
        return false;
    }

    @Override
    public void loadChunk(int x, int z) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public boolean loadChunk(int x, int z, boolean generate) {
        return false;
    }

    @Override
    public boolean unloadChunk(Chunk chunk) {
        return false;
    }

    @Override
    public boolean unloadChunk(int x, int z) {
        return false;
    }

    @Override
    public boolean unloadChunk(int x, int z, boolean save) {
        return false;
    }

    @Override
    public boolean unloadChunkRequest(int x, int z) {
        return false;
    }

    @Override
    public boolean regenerateChunk(int x, int z) {
        return false;
    }

    @Override
    public boolean refreshChunk(int x, int z) {
        return false;
    }

    @Override
    public boolean isChunkForceLoaded(int x, int z) {
        return false;
    }

    @Override
    public void setChunkForceLoaded(int x, int z, boolean forced) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public Collection<Chunk> getForceLoadedChunks() {
        return null;
    }

    @Override
    public boolean addPluginChunkTicket(int i, int i1, Plugin plugin) {
        return false;
    }

    @Override
    public boolean removePluginChunkTicket(int i, int i1, Plugin plugin) {
        return false;
    }

    @Override
    public void removePluginChunkTickets(Plugin plugin) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public Collection<Plugin> getPluginChunkTickets(int i, int i1) {
        return null;
    }

    @Override
    public Map<Plugin, Collection<Chunk>> getPluginChunkTickets() {
        return null;
    }

    @Override
    public Item dropItem(Location location, ItemStack item) {
        return null;
    }

    @Override
    public Item dropItemNaturally(Location location, ItemStack item) {
        return null;
    }

    @Override
    public Arrow spawnArrow(Location location, Vector direction, float speed, float spread) {
        return null;
    }

    @Override
    public <T extends AbstractArrow> T spawnArrow(Location location, Vector direction, float speed, float spread, Class<T> clazz) {
        return null;
    }

    @Override
    public boolean generateTree(Location location, TreeType type) {
        return false;
    }

    @Override
    public boolean generateTree(Location loc, TreeType type, BlockChangeDelegate delegate) {
        return false;
    }

    @Override
    public Entity spawnEntity(Location loc, EntityType type) {
        return null;
    }

    @Override
    public LightningStrike strikeLightning(Location loc) {
        return null;
    }

    @Override
    public LightningStrike strikeLightningEffect(Location loc) {
        return null;
    }

    @Override
    public List<Entity> getEntities() {
        return null;
    }

    @Override
    public List<LivingEntity> getLivingEntities() {
        return null;
    }

    @Override
    public <T extends Entity> Collection<T> getEntitiesByClass(Class<T>... classes) {
        return null;
    }

    @Override
    public <T extends Entity> Collection<T> getEntitiesByClass(Class<T> cls) {
        return null;
    }

    @Override
    public Collection<Entity> getEntitiesByClasses(Class<?>... classes) {
        return null;
    }

    @Override
    public List<Player> getPlayers() {
        return null;
    }

    @Override
    public Collection<Entity> getNearbyEntities(Location location, double x, double y, double z) {
        return null;
    }

    @Override
    public Collection<Entity> getNearbyEntities(Location location, double x, double y, double z, Predicate<Entity> filter) {
        return null;
    }

    @Override
    public Collection<Entity> getNearbyEntities(BoundingBox boundingBox) {
        return null;
    }

    @Override
    public Collection<Entity> getNearbyEntities(BoundingBox boundingBox, Predicate<Entity> filter) {
        return null;
    }

    @Override
    public RayTraceResult rayTraceEntities(Location start, Vector direction, double maxDistance) {
        return null;
    }

    @Override
    public RayTraceResult rayTraceEntities(Location start, Vector direction, double maxDistance, double raySize) {
        return null;
    }

    @Override
    public RayTraceResult rayTraceEntities(Location start, Vector direction, double maxDistance, Predicate<Entity> filter) {
        return null;
    }

    @Override
    public RayTraceResult rayTraceEntities(Location start, Vector direction, double maxDistance, double raySize, Predicate<Entity> filter) {
        return null;
    }

    @Override
    public RayTraceResult rayTraceBlocks(Location start, Vector direction, double maxDistance) {
        return null;
    }

    @Override
    public RayTraceResult rayTraceBlocks(Location start, Vector direction, double maxDistance, FluidCollisionMode fluidCollisionMode) {
        return null;
    }

    @Override
    public RayTraceResult rayTraceBlocks(Location start, Vector direction, double maxDistance, FluidCollisionMode fluidCollisionMode, boolean ignorePassableBlocks) {
        return null;
    }

    @Override
    public RayTraceResult rayTrace(Location start, Vector direction, double maxDistance, FluidCollisionMode fluidCollisionMode, boolean ignorePassableBlocks, double raySize, Predicate<Entity> filter) {
        return null;
    }

    @Override
    public String getName() {
        return world.getName();
    }

    @Override
    public UUID getUID() {
        return null;
    }

    @Override
    public Location getSpawnLocation() {
        return null;
    }

    @Override
    public boolean setSpawnLocation(Location location) {
        return false;
    }

    @Override
    public boolean setSpawnLocation(int x, int y, int z) {
        return false;
    }

    @Override
    public long getTime() {
        return 0;
    }

    @Override
    public void setTime(long time) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public long getFullTime() {
        return 0;
    }

    @Override
    public void setFullTime(long time) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public boolean hasStorm() {
        return false;
    }

    @Override
    public void setStorm(boolean hasStorm) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public int getWeatherDuration() {
        return 0;
    }

    @Override
    public void setWeatherDuration(int duration) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public boolean isThundering() {
        return false;
    }

    @Override
    public void setThundering(boolean thundering) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public int getThunderDuration() {
        return 0;
    }

    @Override
    public void setThunderDuration(int duration) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public boolean createExplosion(double x, double y, double z, float power) {
        return false;
    }

    @Override
    public boolean createExplosion(double x, double y, double z, float power, boolean setFire) {
        return false;
    }

    @Override
    public boolean createExplosion(double x, double y, double z, float power, boolean setFire, boolean breakBlocks) {
        return false;
    }

    @Override
    public boolean createExplosion(Location loc, float power) {
        return false;
    }

    @Override
    public boolean createExplosion(Location loc, float power, boolean setFire) {
        return false;
    }

    @Override
    public Environment getEnvironment() {
        return null;
    }

    @Override
    public long getSeed() {
        return 0;
    }

    @Override
    public boolean getPVP() {
        return false;
    }

    @Override
    public void setPVP(boolean pvp) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public ChunkGenerator getGenerator() {
        return null;
    }

    @Override
    public void save() {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public List<BlockPopulator> getPopulators() {
        return null;
    }

    @Override
    public <T extends Entity> T spawn(Location location, Class<T> clazz) throws IllegalArgumentException {
        return null;
    }

    @Override
    public <T extends Entity> T spawn(Location location, Class<T> clazz, Consumer<T> function) throws IllegalArgumentException {
        return null;
    }

    @Override
    public FallingBlock spawnFallingBlock(Location location, MaterialData data) throws IllegalArgumentException {
        return null;
    }

    @Override
    public FallingBlock spawnFallingBlock(Location location, BlockData data) throws IllegalArgumentException {
        return null;
    }

    @Override
    public FallingBlock spawnFallingBlock(Location location, Material material, byte data) throws IllegalArgumentException {
        return null;
    }

    @Override
    public void playEffect(Location location, Effect effect, int data) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void playEffect(Location location, Effect effect, int data, int radius) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public <T> void playEffect(Location location, Effect effect, T data) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public <T> void playEffect(Location location, Effect effect, T data, int radius) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public ChunkSnapshot getEmptyChunkSnapshot(int x, int z, boolean includeBiome, boolean includeBiomeTemp) {
        return null;
    }

    @Override
    public void setSpawnFlags(boolean allowMonsters, boolean allowAnimals) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public boolean getAllowAnimals() {
        return false;
    }

    @Override
    public boolean getAllowMonsters() {
        return false;
    }

    @Override
    public Biome getBiome(int x, int z) {
        return null;
    }

    @Override
    public void setBiome(int x, int z, Biome bio) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public double getTemperature(int x, int z) {
        return 0;
    }

    @Override
    public double getHumidity(int x, int z) {
        return 0;
    }

    @Override
    public int getMaxHeight() {
        return 0;
    }

    @Override
    public int getSeaLevel() {
        return 0;
    }

    @Override
    public boolean getKeepSpawnInMemory() {
        return false;
    }

    @Override
    public void setKeepSpawnInMemory(boolean keepLoaded) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public boolean isAutoSave() {
        return false;
    }

    @Override
    public void setAutoSave(boolean value) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public Difficulty getDifficulty() {
        return null;
    }

    @Override
    public void setDifficulty(Difficulty difficulty) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public File getWorldFolder() {
        return null;
    }

    @Override
    public WorldType getWorldType() {
        return null;
    }

    @Override
    public boolean canGenerateStructures() {
        return false;
    }

    @Override
    public long getTicksPerAnimalSpawns() {
        return 0;
    }

    @Override
    public void setTicksPerAnimalSpawns(int ticksPerAnimalSpawns) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public long getTicksPerMonsterSpawns() {
        return 0;
    }

    @Override
    public void setTicksPerMonsterSpawns(int ticksPerMonsterSpawns) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public int getMonsterSpawnLimit() {
        return 0;
    }

    @Override
    public void setMonsterSpawnLimit(int limit) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public int getAnimalSpawnLimit() {
        return 0;
    }

    @Override
    public void setAnimalSpawnLimit(int limit) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public int getWaterAnimalSpawnLimit() {
        return 0;
    }

    @Override
    public void setWaterAnimalSpawnLimit(int limit) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public int getAmbientSpawnLimit() {
        return 0;
    }

    @Override
    public void setAmbientSpawnLimit(int limit) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void playSound(Location location, Sound sound, float volume, float pitch) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void playSound(Location location, String sound, float volume, float pitch) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void playSound(Location location, Sound sound, SoundCategory category, float volume, float pitch) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void playSound(Location location, String sound, SoundCategory category, float volume, float pitch) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public String[] getGameRules() {
        return new String[0];
    }

    @Override
    public String getGameRuleValue(String rule) {
        return null;
    }

    @Override
    public boolean setGameRuleValue(String rule, String value) {
        return false;
    }

    @Override
    public boolean isGameRule(String rule) {
        return false;
    }

    @Override
    public <T> T getGameRuleValue(GameRule<T> rule) {
        return null;
    }

    @Override
    public <T> T getGameRuleDefault(GameRule<T> rule) {
        return null;
    }

    @Override
    public <T> boolean setGameRule(GameRule<T> rule, T newValue) {
        return false;
    }

    @Override
    public WorldBorder getWorldBorder() {
        return null;
    }

    @Override
    public void spawnParticle(Particle particle, Location location, int count) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void spawnParticle(Particle particle, double x, double y, double z, int count) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public <T> void spawnParticle(Particle particle, Location location, int count, T data) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public <T> void spawnParticle(Particle particle, double x, double y, double z, int count, T data) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void spawnParticle(Particle particle, Location location, int count, double offsetX, double offsetY, double offsetZ) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void spawnParticle(Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public <T> void spawnParticle(Particle particle, Location location, int count, double offsetX, double offsetY, double offsetZ, T data) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public <T> void spawnParticle(Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, T data) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void spawnParticle(Particle particle, Location location, int count, double offsetX, double offsetY, double offsetZ, double extra) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void spawnParticle(Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, double extra) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public <T> void spawnParticle(Particle particle, Location location, int count, double offsetX, double offsetY, double offsetZ, double extra, T data) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public <T> void spawnParticle(Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, double extra, T data) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public <T> void spawnParticle(Particle particle, Location location, int count, double offsetX, double offsetY, double offsetZ, double extra, T data, boolean force) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public <T> void spawnParticle(Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, double extra, T data, boolean force) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public Location locateNearestStructure(Location origin, StructureType structureType, int radius, boolean findUnexplored) {
        return null;
    }

    @Override
    public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
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
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void sendPluginMessage(Plugin source, String channel, byte[] message) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public Set<String> getListeningPluginChannels() {
        return null;
    }

}
