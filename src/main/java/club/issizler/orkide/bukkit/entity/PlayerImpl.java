package club.issizler.orkide.bukkit.entity;

import club.issizler.okyanus.api.math.Vec3d;
import club.issizler.orkide.Globals;
import club.issizler.orkide.bukkit.WorldImpl;
import org.bukkit.*;
import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.block.data.BlockData;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.entity.*;
import org.bukkit.entity.memory.MemoryKey;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.*;
import org.bukkit.map.MapView;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;

import java.net.InetSocketAddress;
import java.util.*;

public class PlayerImpl implements Player {

    private club.issizler.okyanus.api.entity.Player player;

    public PlayerImpl(club.issizler.okyanus.api.entity.Player player) {
        this.player = player;
    }

    @Override
    public String getDisplayName() {
        return player.getCustomName();
    }

    @Override
    public void setDisplayName(String name) {
        player.setCustomName(name);
    }

    @Override
    public String getPlayerListName() {
        return player.getCustomName();
    }

    @Override
    public void setPlayerListName(String name) {
        player.setCustomName(name);
    }

    @Override
    public String getPlayerListHeader() {
        return ""; // Not implemented in Okyanus yet
    }

    @Override
    public void setPlayerListHeader(String header) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public String getPlayerListFooter() {
        return ""; // Not implemented in Okyanus yet
    }

    @Override
    public void setPlayerListFooter(String footer) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void setPlayerListHeaderFooter(String header, String footer) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public Location getCompassTarget() {
        return null;
    }

    @Override
    public void setCompassTarget(Location loc) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public InetSocketAddress getAddress() {
        return null;
    }

    @Override
    public boolean isConversing() {
        return false;
    }

    @Override
    public void acceptConversationInput(String input) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public boolean beginConversation(Conversation conversation) {
        return false;
    }

    @Override
    public void abandonConversation(Conversation conversation) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void abandonConversation(Conversation conversation, ConversationAbandonedEvent details) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void sendRawMessage(String message) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void kickPlayer(String message) {
        player.kick(message);
    }

    @Override
    public void chat(String msg) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public boolean performCommand(String command) {
        return false;
    }

    @Override
    public boolean isSneaking() {
        return false;
    }

    @Override
    public void setSneaking(boolean sneak) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public boolean isSprinting() {
        return false;
    }

    @Override
    public void setSprinting(boolean sprinting) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void saveData() {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void loadData() {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public boolean isSleepingIgnored() {
        return false;
    }

    @Override
    public void setSleepingIgnored(boolean isSleeping) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void playNote(Location loc, byte instrument, byte note) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void playNote(Location loc, Instrument instrument, Note note) {
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
    public void stopSound(Sound sound) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void stopSound(String sound) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void stopSound(Sound sound, SoundCategory category) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void stopSound(String sound, SoundCategory category) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void playEffect(Location loc, Effect effect, int data) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public <T> void playEffect(Location loc, Effect effect, T data) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void sendBlockChange(Location loc, Material material, byte data) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void sendBlockChange(Location loc, BlockData block) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public boolean sendChunkChange(Location loc, int sx, int sy, int sz, byte[] data) {
        return false;
    }

    @Override
    public void sendSignChange(Location loc, String[] lines) throws IllegalArgumentException {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void sendSignChange(Location loc, String[] lines, DyeColor dyeColor) throws IllegalArgumentException {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void sendMap(MapView map) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void updateInventory() {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void awardAchievement(Achievement achievement) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void removeAchievement(Achievement achievement) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public boolean hasAchievement(Achievement achievement) {
        return false;
    }

    @Override
    public void incrementStatistic(Statistic statistic) throws IllegalArgumentException {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void decrementStatistic(Statistic statistic) throws IllegalArgumentException {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void incrementStatistic(Statistic statistic, int amount) throws IllegalArgumentException {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void decrementStatistic(Statistic statistic, int amount) throws IllegalArgumentException {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void setStatistic(Statistic statistic, int newValue) throws IllegalArgumentException {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public int getStatistic(Statistic statistic) throws IllegalArgumentException {
        return 0;
    }

    @Override
    public void incrementStatistic(Statistic statistic, Material material) throws IllegalArgumentException {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void decrementStatistic(Statistic statistic, Material material) throws IllegalArgumentException {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public int getStatistic(Statistic statistic, Material material) throws IllegalArgumentException {
        return 0;
    }

    @Override
    public void incrementStatistic(Statistic statistic, Material material, int amount) throws IllegalArgumentException {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void decrementStatistic(Statistic statistic, Material material, int amount) throws IllegalArgumentException {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void setStatistic(Statistic statistic, Material material, int newValue) throws IllegalArgumentException {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void incrementStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void decrementStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public int getStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {
        return 0;
    }

    @Override
    public void incrementStatistic(Statistic statistic, EntityType entityType, int amount) throws IllegalArgumentException {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void decrementStatistic(Statistic statistic, EntityType entityType, int amount) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void setStatistic(Statistic statistic, EntityType entityType, int newValue) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void setPlayerTime(long time, boolean relative) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public long getPlayerTime() {
        return 0;
    }

    @Override
    public long getPlayerTimeOffset() {
        return 0;
    }

    @Override
    public boolean isPlayerTimeRelative() {
        return false;
    }

    @Override
    public void resetPlayerTime() {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public WeatherType getPlayerWeather() {
        return null;
    }

    @Override
    public void setPlayerWeather(WeatherType type) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void resetPlayerWeather() {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void giveExp(int amount) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void giveExpLevels(int amount) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public float getExp() {
        return 0;
    }

    @Override
    public void setExp(float exp) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public void setLevel(int level) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public int getTotalExperience() {
        return 0;
    }

    @Override
    public void setTotalExperience(int exp) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public float getExhaustion() {
        return 0;
    }

    @Override
    public void setExhaustion(float value) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public float getSaturation() {
        return 0;
    }

    @Override
    public void setSaturation(float value) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public int getFoodLevel() {
        return 0;
    }

    @Override
    public void setFoodLevel(int value) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public boolean getAllowFlight() {
        return false;
    }

    @Override
    public void setAllowFlight(boolean flight) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void hidePlayer(Player player) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void hidePlayer(Plugin plugin, Player player) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void showPlayer(Player player) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void showPlayer(Plugin plugin, Player player) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public boolean canSee(Player player) {
        return false;
    }

    @Override
    public boolean isFlying() {
        return false;
    }

    @Override
    public void setFlying(boolean value) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public float getFlySpeed() {
        return 0;
    }

    @Override
    public void setFlySpeed(float value) throws IllegalArgumentException {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public float getWalkSpeed() {
        return 0;
    }

    @Override
    public void setWalkSpeed(float value) throws IllegalArgumentException {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void setTexturePack(String url) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void setResourcePack(String url) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void setResourcePack(String url, byte[] hash) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public Scoreboard getScoreboard() {
        return null;
    }

    @Override
    public void setScoreboard(Scoreboard scoreboard) throws IllegalArgumentException, IllegalStateException {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public boolean isHealthScaled() {
        return false;
    }

    @Override
    public void setHealthScaled(boolean scale) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public double getHealthScale() {
        return 0;
    }

    @Override
    public void setHealthScale(double scale) throws IllegalArgumentException {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public Entity getSpectatorTarget() {
        return null;
    }

    @Override
    public void setSpectatorTarget(Entity entity) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void sendTitle(String title, String subtitle) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void sendTitle(String title, String subtitle, int fadeIn, int stay, int fadeOut) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void resetTitle() {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
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
    public AdvancementProgress getAdvancementProgress(Advancement advancement) {
        return null;
    }

    @Override
    public int getClientViewDistance() {
        return 0;
    }

    @Override
    public String getLocale() {
        return null;
    }

    @Override
    public void updateCommands() {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void openBook(ItemStack book) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public Location getLocation() {
        return new Location(new WorldImpl(player.getWorld()), player.getPos().x, player.getPos().y, player.getPos().z);
    }

    @Override
    public Location getLocation(Location loc) {
        loc = new Location(new WorldImpl(player.getWorld()), player.getPos().x, player.getPos().y, player.getPos().z);
        return loc; // We mighgt need to copy
    }

    @Override
    public Vector getVelocity() {
        return null;
    }

    @Override
    public void setVelocity(Vector velocity) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public double getHeight() {
        return 0;
    }

    @Override
    public double getWidth() {
        return 0;
    }

    @Override
    public BoundingBox getBoundingBox() {
        return null;
    }

    @Override
    public boolean isOnGround() {
        return false;
    }

    @Override
    public World getWorld() {
        return new WorldImpl(player.getWorld());
    }

    @Override
    public void setRotation(float yaw, float pitch) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public boolean teleport(Location location) {
        player.teleport(new Vec3d(location.getX(), location.getY(), location.getZ()));
        return true;
    }

    @Override
    public boolean teleport(Location location, PlayerTeleportEvent.TeleportCause cause) {
        player.teleport(new Vec3d(location.getX(), location.getY(), location.getZ()));
        return true;
    }

    @Override
    public boolean teleport(Entity destination) {
        player.teleport(new Vec3d(destination.getLocation().getX(), destination.getLocation().getY(), destination.getLocation().getZ()));
        return true;
    }

    @Override
    public boolean teleport(Entity destination, PlayerTeleportEvent.TeleportCause cause) {
        return false;
    }

    @Override
    public List<Entity> getNearbyEntities(double x, double y, double z) {
        return null;
    }

    @Override
    public int getEntityId() {
        return 0;
    }

    @Override
    public int getFireTicks() {
        return 0;
    }

    @Override
    public void setFireTicks(int ticks) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public int getMaxFireTicks() {
        return 0;
    }

    @Override
    public void remove() {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public boolean isDead() {
        return false;
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public void sendMessage(String message) {
        player.send(message);
    }

    @Override
    public void sendMessage(String[] messages) {
        for (String message : messages) {
            sendMessage(message);
        }
    }

    @Override
    public Server getServer() {
        return Globals.server;
    }

    @Override
    public boolean isPersistent() {
        return false;
    }

    @Override
    public void setPersistent(boolean persistent) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public Entity getPassenger() {
        return null;
    }

    @Override
    public boolean setPassenger(Entity passenger) {
        return false;
    }

    @Override
    public List<Entity> getPassengers() {
        return null;
    }

    @Override
    public boolean addPassenger(Entity passenger) {
        return false;
    }

    @Override
    public boolean removePassenger(Entity passenger) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean eject() {
        return false;
    }

    @Override
    public float getFallDistance() {
        return 0;
    }

    @Override
    public void setFallDistance(float distance) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public EntityDamageEvent getLastDamageCause() {
        return null;
    }

    @Override
    public void setLastDamageCause(EntityDamageEvent event) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public UUID getUniqueId() {
        return player.getUUID();
    }

    @Override
    public int getTicksLived() {
        return 0;
    }

    @Override
    public void setTicksLived(int value) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void playEffect(EntityEffect type) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public EntityType getType() {
        return null;
    }

    @Override
    public boolean isInsideVehicle() {
        return false;
    }

    @Override
    public boolean leaveVehicle() {
        return false;
    }

    @Override
    public Entity getVehicle() {
        return null;
    }

    @Override
    public boolean isCustomNameVisible() {
        return false;
    }

    @Override
    public void setCustomNameVisible(boolean flag) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public boolean isGlowing() {
        return false;
    }

    @Override
    public void setGlowing(boolean flag) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public boolean isInvulnerable() {
        return false;
    }

    @Override
    public void setInvulnerable(boolean flag) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public boolean isSilent() {
        return false;
    }

    @Override
    public void setSilent(boolean flag) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public boolean hasGravity() {
        return false;
    }

    @Override
    public void setGravity(boolean gravity) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public int getPortalCooldown() {
        return 0;
    }

    @Override
    public void setPortalCooldown(int cooldown) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public Set<String> getScoreboardTags() {
        return null;
    }

    @Override
    public boolean addScoreboardTag(String tag) {
        return false;
    }

    @Override
    public boolean removeScoreboardTag(String tag) {
        return false;
    }

    @Override
    public PistonMoveReaction getPistonMoveReaction() {
        return null;
    }

    @Override
    public BlockFace getFacing() {
        return null;
    }

    @Override
    public Pose getPose() {
        return null;
    }

    @Override
    public Spigot spigot() {
        return null;
    }

    @Override
    public boolean isOnline() {
        return false;
    }

    @Override
    public boolean isBanned() {
        return false;
    }

    @Override
    public boolean isWhitelisted() {
        return false;
    }

    @Override
    public void setWhitelisted(boolean value) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public Player getPlayer() {
        return null;
    }

    @Override
    public long getFirstPlayed() {
        return 0;
    }

    @Override
    public long getLastPlayed() {
        return 0;
    }

    @Override
    public boolean hasPlayedBefore() {
        return false;
    }

    @Override
    public Map<String, Object> serialize() {
        return null;
    }

    @Override
    public String getName() {
        return player.getName();
    }

    @Override
    public PlayerInventory getInventory() {
        return null;
    }

    @Override
    public Inventory getEnderChest() {
        return null;
    }

    @Override
    public MainHand getMainHand() {
        return null;
    }

    @Override
    public boolean setWindowProperty(InventoryView.Property prop, int value) {
        return false;
    }

    @Override
    public InventoryView getOpenInventory() {
        return null;
    }

    @Override
    public InventoryView openInventory(Inventory inventory) {
        return null;
    }

    @Override
    public InventoryView openWorkbench(Location location, boolean force) {
        return null;
    }

    @Override
    public InventoryView openEnchanting(Location location, boolean force) {
        return null;
    }

    @Override
    public void openInventory(InventoryView inventory) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public InventoryView openMerchant(Villager trader, boolean force) {
        return null;
    }

    @Override
    public InventoryView openMerchant(Merchant merchant, boolean force) {
        return null;
    }

    @Override
    public void closeInventory() {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public ItemStack getItemInHand() {
        return null;
    }

    @Override
    public void setItemInHand(ItemStack item) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public ItemStack getItemOnCursor() {
        return null;
    }

    @Override
    public void setItemOnCursor(ItemStack item) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public boolean hasCooldown(Material material) {
        return false;
    }

    @Override
    public int getCooldown(Material material) {
        return 0;
    }

    @Override
    public void setCooldown(Material material, int ticks) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public int getSleepTicks() {
        return 0;
    }

    @Override
    public Location getBedSpawnLocation() {
        return null;
    }

    @Override
    public void setBedSpawnLocation(Location location) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void setBedSpawnLocation(Location location, boolean force) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public boolean sleep(Location location, boolean force) {
        return false;
    }

    @Override
    public void wakeup(boolean setSpawnLocation) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public Location getBedLocation() {
        return null;
    }

    @Override
    public GameMode getGameMode() {
        return null;
    }

    @Override
    public void setGameMode(GameMode mode) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public boolean isBlocking() {
        return false;
    }

    @Override
    public boolean isHandRaised() {
        return false;
    }

    @Override
    public int getExpToLevel() {
        return 0;
    }

    @Override
    public boolean discoverRecipe(NamespacedKey recipe) {
        return false;
    }

    @Override
    public int discoverRecipes(Collection<NamespacedKey> recipes) {
        return 0;
    }

    @Override
    public boolean undiscoverRecipe(NamespacedKey recipe) {
        return false;
    }

    @Override
    public int undiscoverRecipes(Collection<NamespacedKey> recipes) {
        return 0;
    }

    @Override
    public Entity getShoulderEntityLeft() {
        return null;
    }

    @Override
    public void setShoulderEntityLeft(Entity entity) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public Entity getShoulderEntityRight() {
        return null;
    }

    @Override
    public void setShoulderEntityRight(Entity entity) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public double getEyeHeight() {
        return 0;
    }

    @Override
    public double getEyeHeight(boolean ignorePose) {
        return 0;
    }

    @Override
    public Location getEyeLocation() {
        return null;
    }

    @Override
    public List<Block> getLineOfSight(Set<Material> transparent, int maxDistance) {
        return null;
    }

    @Override
    public Block getTargetBlock(Set<Material> transparent, int maxDistance) {
        return null;
    }

    @Override
    public List<Block> getLastTwoTargetBlocks(Set<Material> transparent, int maxDistance) {
        return null;
    }

    @Override
    public Block getTargetBlockExact(int maxDistance) {
        return null;
    }

    @Override
    public Block getTargetBlockExact(int maxDistance, FluidCollisionMode fluidCollisionMode) {
        return null;
    }

    @Override
    public RayTraceResult rayTraceBlocks(double maxDistance) {
        return null;
    }

    @Override
    public RayTraceResult rayTraceBlocks(double maxDistance, FluidCollisionMode fluidCollisionMode) {
        return null;
    }

    @Override
    public int getRemainingAir() {
        return 0;
    }

    @Override
    public void setRemainingAir(int ticks) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public int getMaximumAir() {
        return 0;
    }

    @Override
    public void setMaximumAir(int ticks) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public int getMaximumNoDamageTicks() {
        return 0;
    }

    @Override
    public void setMaximumNoDamageTicks(int ticks) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public double getLastDamage() {
        return 0;
    }

    @Override
    public void setLastDamage(double damage) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public int getNoDamageTicks() {
        return 0;
    }

    @Override
    public void setNoDamageTicks(int ticks) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public Player getKiller() {
        return null;
    }

    @Override
    public boolean addPotionEffect(PotionEffect effect) {
        return false;
    }

    @Override
    public boolean addPotionEffect(PotionEffect effect, boolean force) {
        return false;
    }

    @Override
    public boolean addPotionEffects(Collection<PotionEffect> effects) {
        return false;
    }

    @Override
    public boolean hasPotionEffect(PotionEffectType type) {
        return false;
    }

    @Override
    public PotionEffect getPotionEffect(PotionEffectType type) {
        return null;
    }

    @Override
    public void removePotionEffect(PotionEffectType type) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public Collection<PotionEffect> getActivePotionEffects() {
        return null;
    }

    @Override
    public boolean hasLineOfSight(Entity other) {
        return false;
    }

    @Override
    public boolean getRemoveWhenFarAway() {
        return false;
    }

    @Override
    public void setRemoveWhenFarAway(boolean remove) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public EntityEquipment getEquipment() {
        return null;
    }

    @Override
    public boolean getCanPickupItems() {
        return false;
    }

    @Override
    public void setCanPickupItems(boolean pickup) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public boolean isLeashed() {
        return false;
    }

    @Override
    public Entity getLeashHolder() throws IllegalStateException {
        return null;
    }

    @Override
    public boolean setLeashHolder(Entity holder) {
        return false;
    }

    @Override
    public boolean isGliding() {
        return false;
    }

    @Override
    public void setGliding(boolean gliding) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public boolean isSwimming() {
        return false;
    }

    @Override
    public void setSwimming(boolean swimming) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public boolean isRiptiding() {
        return false;
    }

    @Override
    public boolean isSleeping() {
        return false;
    }

    @Override
    public void setAI(boolean ai) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public boolean hasAI() {
        return false;
    }

    @Override
    public boolean isCollidable() {
        return false;
    }

    @Override
    public void setCollidable(boolean collidable) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public <T> T getMemory(MemoryKey<T> memoryKey) {
        return null;
    }

    @Override
    public <T> void setMemory(MemoryKey<T> memoryKey, T memoryValue) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public AttributeInstance getAttribute(Attribute attribute) {
        return null;
    }

    @Override
    public void damage(double amount) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void damage(double amount, Entity source) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public double getHealth() {
        return 0;
    }

    @Override
    public void setHealth(double health) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public double getMaxHealth() {
        return 0;
    }

    @Override
    public void setMaxHealth(double health) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void resetMaxHealth() {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public String getCustomName() {
        return player.getCustomName();
    }

    @Override
    public void setCustomName(String name) {
        player.setCustomName(name);
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
    public boolean isPermissionSet(String name) {
        return false;
    }

    @Override
    public boolean isPermissionSet(Permission perm) {
        return false;
    }

    @Override
    public boolean hasPermission(String name) {
        return false;
    }

    @Override
    public boolean hasPermission(Permission perm) {
        return false;
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value) {
        return null;
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin) {
        return null;
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value, int ticks) {
        return null;
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, int ticks) {
        return null;
    }

    @Override
    public void removeAttachment(PermissionAttachment attachment) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void recalculatePermissions() {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public Set<PermissionAttachmentInfo> getEffectivePermissions() {
        return null;
    }

    @Override
    public boolean isOp() {
        return false;
    }

    @Override
    public void setOp(boolean value) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public PersistentDataContainer getPersistentDataContainer() {
        return null;
    }

    @Override
    public void sendPluginMessage(Plugin source, String channel, byte[] message) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public Set<String> getListeningPluginChannels() {
        return null;
    }

    @Override
    public <T extends Projectile> T launchProjectile(Class<? extends T> projectile) {
        return null;
    }

    @Override
    public <T extends Projectile> T launchProjectile(Class<? extends T> projectile, Vector velocity) {
        return null;
    }

}
