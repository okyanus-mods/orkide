package club.issizler.orkide.bukkit;

import club.issizler.orkide.bukkit.command.ConsoleCommandSenderImpl;
import club.issizler.orkide.bukkit.entity.PlayerImpl;
import club.issizler.orkide.bukkit.scheduler.BukkitSchedulerImpl;
import org.bukkit.*;
import org.bukkit.advancement.Advancement;
import org.bukkit.block.data.BlockData;
import org.bukkit.boss.*;
import org.bukkit.command.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.help.HelpMap;
import org.bukkit.inventory.*;
import org.bukkit.loot.LootTable;
import org.bukkit.map.MapView;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.SimpleServicesManager;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.plugin.messaging.StandardMessenger;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.util.CachedServerIcon;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;
import java.util.function.Consumer;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ServerImpl implements Server {

    public PluginManager pluginManager; // late init

    private club.issizler.okyanus.api.Server server;
    private BukkitScheduler scheduler = new BukkitSchedulerImpl();
    private ServicesManager servicesManager = new SimpleServicesManager();
    private Messenger messenger = new StandardMessenger();
    private ConsoleCommandSender consoleSender = new ConsoleCommandSenderImpl(this);
    public SimpleCommandMap commandMap = new SimpleCommandMap(this);

    public ServerImpl(club.issizler.okyanus.api.Server server) {
        this.server = server;
        Bukkit.setServer(this);
    }

    @Override
    public String getName() {
        return server.getName();
    }

    @Override
    public String getVersion() {
        return server.getVersion();
    }

    @Override
    public String getBukkitVersion() {
        return "1.14.3-R0.1-SNAPSHOT";
    } // Fake being Bukkit 1.14.3-R0.1-SNAPSHOT

    @Override
    public Collection<? extends Player> getOnlinePlayers() {
        return server.getPlayerList().stream().map(PlayerImpl::new).collect(Collectors.toList());
    }

    @Override
    public int getMaxPlayers() {
        return 0;
    }

    @Override
    public int getPort() {
        return 0;
    }

    @Override
    public int getViewDistance() {
        return 0;
    }

    @Override
    public String getIp() {
        return null;
    }

    @Override
    public String getWorldType() {
        return null;
    }

    @Override
    public boolean getGenerateStructures() {
        return false;
    }

    @Override
    public boolean getAllowEnd() {
        return false;
    }

    @Override
    public boolean getAllowNether() {
        return false;
    }

    @Override
    public boolean hasWhitelist() {
        return false;
    }

    @Override
    public void setWhitelist(boolean value) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public Set<OfflinePlayer> getWhitelistedPlayers() {
        return null;
    }

    @Override
    public void reloadWhitelist() {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public int broadcastMessage(String message) {
        return 0;
    }

    @Override
    public String getUpdateFolder() {
        return "update";
    }

    @Override
    public File getUpdateFolderFile() {
        return new File(getUpdateFolder());
    }

    @Override
    public long getConnectionThrottle() {
        return 0;
    }

    @Override
    public int getTicksPerAnimalSpawns() {
        return 0;
    }

    @Override
    public int getTicksPerMonsterSpawns() {
        return 0;
    }

    @Override
    public Player getPlayer(String name) {
        return null;
    }

    @Override
    public Player getPlayerExact(String name) {
        return null;
    }

    @Override
    public List<Player> matchPlayer(String name) {
        return null;
    }

    @Override
    public Player getPlayer(UUID id) {
        return null;
    }

    @Override
    public PluginManager getPluginManager() {
        return pluginManager;
    }

    @Override
    public BukkitScheduler getScheduler() {
        return scheduler;
    }

    @Override
    public ServicesManager getServicesManager() {
        return servicesManager;
    }

    @Override
    public List<World> getWorlds() {
        return server.getWorlds().stream().map(WorldImpl::new).collect(Collectors.toList());
    }

    @Override
    public World createWorld(WorldCreator creator) {
        return null;
    }

    @Override
    public boolean unloadWorld(String name, boolean save) {
        return false;
    }

    @Override
    public boolean unloadWorld(World world, boolean save) {
        return false;
    }

    @Override
    public World getWorld(String name) {
        return null;
    }

    @Override
    public World getWorld(UUID uid) {
        return null;
    }

    @Override
    public MapView getMap(int id) {
        return null;
    }

    @Override
    public MapView createMap(World world) {
        return null;
    }

    @Override
    public ItemStack createExplorerMap(World world, Location location, StructureType structureType) {
        return null;
    }

    @Override
    public ItemStack createExplorerMap(World world, Location location, StructureType structureType, int radius, boolean findUnexplored) {
        return null;
    }

    @Override
    public void reload() {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void reloadData() {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public Logger getLogger() {
        return Logger.getLogger("Orkide"); // TODO Use Log4J so formatting will fit in
    }

    @Override
    public PluginCommand getPluginCommand(String name) {
        Command command = commandMap.getCommand(name);

        if (command instanceof PluginCommand) {
            return (PluginCommand) command;
        } else {
            return null;
        }
    }

    @Override
    public void savePlayers() {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public boolean dispatchCommand(CommandSender sender, String commandLine) throws CommandException {
        return commandMap.dispatch(sender, commandLine);
    }

    @Override
    public boolean addRecipe(Recipe recipe) {
        return false;
    }

    @Override
    public List<Recipe> getRecipesFor(ItemStack result) {
        return null;
    }

    @Override
    public Iterator<Recipe> recipeIterator() {
        return null;
    }

    @Override
    public void clearRecipes() {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void resetRecipes() {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public Map<String, String[]> getCommandAliases() {
        return null;
    }

    @Override
    public int getSpawnRadius() {
        return 0;
    }

    @Override
    public void setSpawnRadius(int value) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public boolean getOnlineMode() {
        return false;
    }

    @Override
    public boolean getAllowFlight() {
        return false;
    }

    @Override
    public boolean isHardcore() {
        return false;
    }

    @Override
    public void shutdown() {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public int broadcast(String message, String permission) {
        return 0;
    }

    @Override
    public OfflinePlayer getOfflinePlayer(String name) {
        return null;
    }

    @Override
    public OfflinePlayer getOfflinePlayer(UUID id) {
        return null;
    }

    @Override
    public Set<String> getIPBans() {
        return null;
    }

    @Override
    public void banIP(String address) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public void unbanIP(String address) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public Set<OfflinePlayer> getBannedPlayers() {
        return null;
    }

    @Override
    public BanList getBanList(BanList.Type type) {
        return null;
    }

    @Override
    public Set<OfflinePlayer> getOperators() {
        return null;
    }

    @Override
    public GameMode getDefaultGameMode() {
        return null;
    }

    @Override
    public void setDefaultGameMode(GameMode mode) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public ConsoleCommandSender getConsoleSender() {
        return consoleSender;
    }

    @Override
    public File getWorldContainer() {
        return null;
    }

    @Override
    public OfflinePlayer[] getOfflinePlayers() {
        return new OfflinePlayer[0];
    }

    @Override
    public Messenger getMessenger() {
        return messenger;
    }

    @Override
    public HelpMap getHelpMap() {
        return null;
    }

    @Override
    public Inventory createInventory(InventoryHolder owner, InventoryType type) {
        return null;
    }

    @Override
    public Inventory createInventory(InventoryHolder owner, InventoryType type, String title) {
        return null;
    }

    @Override
    public Inventory createInventory(InventoryHolder owner, int size) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Inventory createInventory(InventoryHolder owner, int size, String title) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Merchant createMerchant(String title) {
        return null;
    }

    @Override
    public int getMonsterSpawnLimit() {
        return 0;
    }

    @Override
    public int getAnimalSpawnLimit() {
        return 0;
    }

    @Override
    public int getWaterAnimalSpawnLimit() {
        return 0;
    }

    @Override
    public int getAmbientSpawnLimit() {
        return 0;
    }

    @Override
    public boolean isPrimaryThread() {
        return Thread.currentThread().getName().equals("Server thread");
    }

    @Override
    public String getMotd() {
        return null;
    }

    @Override
    public String getShutdownMessage() {
        return null;
    }

    @Override
    public Warning.WarningState getWarningState() {
        return null;
    }

    @Override
    public ItemFactory getItemFactory() {
        return null;
    }

    @Override
    public ScoreboardManager getScoreboardManager() {
        return null;
    }

    @Override
    public CachedServerIcon getServerIcon() {
        return null;
    }

    @Override
    public CachedServerIcon loadServerIcon(File file) throws Exception {
        return null;
    }

    @Override
    public CachedServerIcon loadServerIcon(BufferedImage image) throws Exception {
        return null;
    }

    @Override
    public int getIdleTimeout() {
        return 0;
    }

    @Override
    public void setIdleTimeout(int threshold) {
        throw new RuntimeException("Orkide doesn't support this yet! Contact the devs asap!");
    }

    @Override
    public ChunkGenerator.ChunkData createChunkData(World world) {
        return null;
    }

    @Override
    public BossBar createBossBar(String title, BarColor color, BarStyle style, BarFlag... flags) {
        return null;
    }

    @Override
    public KeyedBossBar createBossBar(NamespacedKey key, String title, BarColor color, BarStyle style, BarFlag... flags) {
        return null;
    }

    @Override
    public Iterator<KeyedBossBar> getBossBars() {
        return null;
    }

    @Override
    public KeyedBossBar getBossBar(NamespacedKey key) {
        return null;
    }

    @Override
    public boolean removeBossBar(NamespacedKey key) {
        return false;
    }

    @Override
    public Entity getEntity(UUID uuid) {
        return null;
    }

    @Override
    public Advancement getAdvancement(NamespacedKey key) {
        return null;
    }

    @Override
    public Iterator<Advancement> advancementIterator() {
        return null;
    }

    @Override
    public BlockData createBlockData(Material material) {
        return null;
    }

    @Override
    public BlockData createBlockData(Material material, Consumer<BlockData> consumer) {
        return null;
    }

    @Override
    public BlockData createBlockData(String data) throws IllegalArgumentException {
        return null;
    }

    @Override
    public BlockData createBlockData(Material material, String data) throws IllegalArgumentException {
        return null;
    }

    @Override
    public <T extends Keyed> Tag<T> getTag(String registry, NamespacedKey tag, Class<T> clazz) {
        return null;
    }

    @Override
    public <T extends Keyed> Iterable<Tag<T>> getTags(String registry, Class<T> clazz) {
        return null;
    }

    @Override
    public LootTable getLootTable(NamespacedKey key) {
        return null;
    }

    @Override
    public List<Entity> selectEntities(CommandSender sender, String selector) throws IllegalArgumentException {
        return null;
    }

    @Override
    public UnsafeValues getUnsafe() {
        return new UnsafeValuesImpl();
    }

    @Override
    public Spigot spigot() {
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
}
