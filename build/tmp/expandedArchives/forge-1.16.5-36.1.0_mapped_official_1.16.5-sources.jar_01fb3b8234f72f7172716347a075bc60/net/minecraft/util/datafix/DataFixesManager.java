package net.minecraft.util.datafix;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.DSL;
import com.mojang.datafixers.DataFixer;
import com.mojang.datafixers.DataFixerBuilder;
import com.mojang.datafixers.Typed;
import com.mojang.datafixers.schemas.Schema;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.UnaryOperator;
import net.minecraft.util.SharedConstants;
import net.minecraft.util.Util;
import net.minecraft.util.datafix.fixes.AddBedTileEntity;
import net.minecraft.util.datafix.fixes.AddNewChoices;
import net.minecraft.util.datafix.fixes.AdvancementRenamer;
import net.minecraft.util.datafix.fixes.AdvancementRenamer1501;
import net.minecraft.util.datafix.fixes.ArmorStandSilent;
import net.minecraft.util.datafix.fixes.AttributesFix;
import net.minecraft.util.datafix.fixes.BannerItemColor;
import net.minecraft.util.datafix.fixes.BedItemColor;
import net.minecraft.util.datafix.fixes.BiomeIdFix;
import net.minecraft.util.datafix.fixes.BiomeName;
import net.minecraft.util.datafix.fixes.BiomeRenames;
import net.minecraft.util.datafix.fixes.BitStorageAlignFix;
import net.minecraft.util.datafix.fixes.BlockEntityBannerColor;
import net.minecraft.util.datafix.fixes.BlockEntityKeepPacked;
import net.minecraft.util.datafix.fixes.BlockEntityUUID;
import net.minecraft.util.datafix.fixes.BlockNameFlattening;
import net.minecraft.util.datafix.fixes.BlockRename;
import net.minecraft.util.datafix.fixes.BlockStateFlattenGenOptions;
import net.minecraft.util.datafix.fixes.BlockStateFlattenStructures;
import net.minecraft.util.datafix.fixes.BlockStateFlattenVillageCrops;
import net.minecraft.util.datafix.fixes.BlockStateFlatternEntities;
import net.minecraft.util.datafix.fixes.BookPagesStrictJSON;
import net.minecraft.util.datafix.fixes.CatTypeFix;
import net.minecraft.util.datafix.fixes.ChunkGenStatus;
import net.minecraft.util.datafix.fixes.ChunkLightRemoveFix;
import net.minecraft.util.datafix.fixes.ChunkPaletteFormat;
import net.minecraft.util.datafix.fixes.ChunkStatusFix;
import net.minecraft.util.datafix.fixes.ChunkStatusFix2;
import net.minecraft.util.datafix.fixes.ChunkStructuresTemplateRenameFix;
import net.minecraft.util.datafix.fixes.ColorlessShulkerEntityFix;
import net.minecraft.util.datafix.fixes.CoralFansRenameList;
import net.minecraft.util.datafix.fixes.CustomNameStringToComponentEntity;
import net.minecraft.util.datafix.fixes.CustomNameStringToComponentFixTileEntity;
import net.minecraft.util.datafix.fixes.CustomNameStringToComponentItem;
import net.minecraft.util.datafix.fixes.DyeRenameMap;
import net.minecraft.util.datafix.fixes.ElderGuardianSplit;
import net.minecraft.util.datafix.fixes.EntityArmorAndHeld;
import net.minecraft.util.datafix.fixes.EntityCatSplitFix;
import net.minecraft.util.datafix.fixes.EntityCodSalmonFix;
import net.minecraft.util.datafix.fixes.EntityHealth;
import net.minecraft.util.datafix.fixes.EntityId;
import net.minecraft.util.datafix.fixes.EntityItemFrameFacing;
import net.minecraft.util.datafix.fixes.EntityRavagerRenameFix;
import net.minecraft.util.datafix.fixes.EntityRenaming1510;
import net.minecraft.util.datafix.fixes.EntityUUID;
import net.minecraft.util.datafix.fixes.ForceVBOOn;
import net.minecraft.util.datafix.fixes.FurnaceRecipes;
import net.minecraft.util.datafix.fixes.Gossip;
import net.minecraft.util.datafix.fixes.HeightmapRenamingFix;
import net.minecraft.util.datafix.fixes.HorseSaddle;
import net.minecraft.util.datafix.fixes.HorseSplit;
import net.minecraft.util.datafix.fixes.IglooMetadataRemoval;
import net.minecraft.util.datafix.fixes.ItemFilledMapMetadata;
import net.minecraft.util.datafix.fixes.ItemIntIDToString;
import net.minecraft.util.datafix.fixes.ItemLoreComponentizeFix;
import net.minecraft.util.datafix.fixes.ItemRename;
import net.minecraft.util.datafix.fixes.ItemSpawnEggSplit;
import net.minecraft.util.datafix.fixes.ItemStackDataFlattening;
import net.minecraft.util.datafix.fixes.ItemStackEnchantmentFix;
import net.minecraft.util.datafix.fixes.ItemStackUUID;
import net.minecraft.util.datafix.fixes.JigsawProperties;
import net.minecraft.util.datafix.fixes.JigsawRotation;
import net.minecraft.util.datafix.fixes.JukeboxRecordItem;
import net.minecraft.util.datafix.fixes.KeyOptionsTranslation;
import net.minecraft.util.datafix.fixes.LWJGL3KeyOptions;
import net.minecraft.util.datafix.fixes.LeavesFix;
import net.minecraft.util.datafix.fixes.LevelDataGeneratorOptionsFix;
import net.minecraft.util.datafix.fixes.LevelUUID;
import net.minecraft.util.datafix.fixes.MapIdFix;
import net.minecraft.util.datafix.fixes.MemoryExpiry;
import net.minecraft.util.datafix.fixes.MinecartEntityTypes;
import net.minecraft.util.datafix.fixes.MissingDimensionFix;
import net.minecraft.util.datafix.fixes.NamedEntityFix;
import net.minecraft.util.datafix.fixes.NewVillageFix;
import net.minecraft.util.datafix.fixes.ObjectiveDisplayName;
import net.minecraft.util.datafix.fixes.ObjectiveRenderType;
import net.minecraft.util.datafix.fixes.OminousBannerRenameFix;
import net.minecraft.util.datafix.fixes.OminousBannerTileEntityRenameFix;
import net.minecraft.util.datafix.fixes.OptionsAddTextBackgroundFix;
import net.minecraft.util.datafix.fixes.OptionsLowerCaseLanguage;
import net.minecraft.util.datafix.fixes.PaintingDirection;
import net.minecraft.util.datafix.fixes.PaintingMotive;
import net.minecraft.util.datafix.fixes.PistonPushedBlock;
import net.minecraft.util.datafix.fixes.PlayerUUID;
import net.minecraft.util.datafix.fixes.PointOfInterestRebuild;
import net.minecraft.util.datafix.fixes.PointOfInterestReorganizationFix;
import net.minecraft.util.datafix.fixes.PotionItems;
import net.minecraft.util.datafix.fixes.PotionWater;
import net.minecraft.util.datafix.fixes.ProjectileOwner;
import net.minecraft.util.datafix.fixes.PufferfishRename;
import net.minecraft.util.datafix.fixes.RecipeRenamer;
import net.minecraft.util.datafix.fixes.RecipeRenamer1502;
import net.minecraft.util.datafix.fixes.RecipeRenamer1510;
import net.minecraft.util.datafix.fixes.RedstoneConnections;
import net.minecraft.util.datafix.fixes.RedundantChanceTags;
import net.minecraft.util.datafix.fixes.RemoveGolemGossip;
import net.minecraft.util.datafix.fixes.RenameBeehivePointOfInterest;
import net.minecraft.util.datafix.fixes.RenamedCoral;
import net.minecraft.util.datafix.fixes.RidingToPassengers;
import net.minecraft.util.datafix.fixes.SavedDataUUID;
import net.minecraft.util.datafix.fixes.ShulkerBoxEntityColor;
import net.minecraft.util.datafix.fixes.ShulkerBoxItemColor;
import net.minecraft.util.datafix.fixes.ShulkerBoxTileColor;
import net.minecraft.util.datafix.fixes.ShulkerRotation;
import net.minecraft.util.datafix.fixes.SignStrictJSON;
import net.minecraft.util.datafix.fixes.SkeletonSplit;
import net.minecraft.util.datafix.fixes.SpawnEggNames;
import net.minecraft.util.datafix.fixes.SpawnerEntityTypes;
import net.minecraft.util.datafix.fixes.StatsRenaming;
import net.minecraft.util.datafix.fixes.StriderGravity;
import net.minecraft.util.datafix.fixes.StringToUUID;
import net.minecraft.util.datafix.fixes.StructureReferenceFix;
import net.minecraft.util.datafix.fixes.SwapHandsFix;
import net.minecraft.util.datafix.fixes.SwimStatsRename;
import net.minecraft.util.datafix.fixes.TeamDisplayName;
import net.minecraft.util.datafix.fixes.TileEntityId;
import net.minecraft.util.datafix.fixes.TippedArrow;
import net.minecraft.util.datafix.fixes.TrappedChestTileEntitySplit;
import net.minecraft.util.datafix.fixes.VillagerFollowRange;
import net.minecraft.util.datafix.fixes.VillagerLevelAndXpFix;
import net.minecraft.util.datafix.fixes.VillagerProfessionFix;
import net.minecraft.util.datafix.fixes.VillagerTrades;
import net.minecraft.util.datafix.fixes.WallProperty;
import net.minecraft.util.datafix.fixes.WolfCollarColor;
import net.minecraft.util.datafix.fixes.WorldGenSettings;
import net.minecraft.util.datafix.fixes.ZombieProfToType;
import net.minecraft.util.datafix.fixes.ZombieSplit;
import net.minecraft.util.datafix.fixes.ZombieVillagerXpFix;
import net.minecraft.util.datafix.fixes.ZombifiedPiglinRename;
import net.minecraft.util.datafix.versions.V0099;
import net.minecraft.util.datafix.versions.V0100;
import net.minecraft.util.datafix.versions.V0102;
import net.minecraft.util.datafix.versions.V0106;
import net.minecraft.util.datafix.versions.V0107;
import net.minecraft.util.datafix.versions.V0135;
import net.minecraft.util.datafix.versions.V0143;
import net.minecraft.util.datafix.versions.V0501;
import net.minecraft.util.datafix.versions.V0700;
import net.minecraft.util.datafix.versions.V0701;
import net.minecraft.util.datafix.versions.V0702;
import net.minecraft.util.datafix.versions.V0703;
import net.minecraft.util.datafix.versions.V0704;
import net.minecraft.util.datafix.versions.V0705;
import net.minecraft.util.datafix.versions.V0808;
import net.minecraft.util.datafix.versions.V1022;
import net.minecraft.util.datafix.versions.V1125;
import net.minecraft.util.datafix.versions.V1451;
import net.minecraft.util.datafix.versions.V1451_1;
import net.minecraft.util.datafix.versions.V1451_2;
import net.minecraft.util.datafix.versions.V1451_3;
import net.minecraft.util.datafix.versions.V1451_4;
import net.minecraft.util.datafix.versions.V1451_5;
import net.minecraft.util.datafix.versions.V1451_6;
import net.minecraft.util.datafix.versions.V1451_7;
import net.minecraft.util.datafix.versions.V1460;
import net.minecraft.util.datafix.versions.V1466;
import net.minecraft.util.datafix.versions.V1470;
import net.minecraft.util.datafix.versions.V1481;
import net.minecraft.util.datafix.versions.V1483;
import net.minecraft.util.datafix.versions.V1486;
import net.minecraft.util.datafix.versions.V1510;
import net.minecraft.util.datafix.versions.V1800;
import net.minecraft.util.datafix.versions.V1801;
import net.minecraft.util.datafix.versions.V1904;
import net.minecraft.util.datafix.versions.V1906;
import net.minecraft.util.datafix.versions.V1909;
import net.minecraft.util.datafix.versions.V1920;
import net.minecraft.util.datafix.versions.V1928;
import net.minecraft.util.datafix.versions.V1929;
import net.minecraft.util.datafix.versions.V1931;
import net.minecraft.util.datafix.versions.V2100;
import net.minecraft.util.datafix.versions.V2501;
import net.minecraft.util.datafix.versions.V2502;
import net.minecraft.util.datafix.versions.V2505;
import net.minecraft.util.datafix.versions.V2509;
import net.minecraft.util.datafix.versions.V2519;
import net.minecraft.util.datafix.versions.V2522;
import net.minecraft.util.datafix.versions.V2551;
import net.minecraft.util.datafix.versions.V2568;

public class DataFixesManager {
   private static final BiFunction<Integer, Schema, Schema> SAME = Schema::new;
   private static final BiFunction<Integer, Schema, Schema> SAME_NAMESPACED = NamespacedSchema::new;
   private static final DataFixer DATA_FIXER = createFixerUpper();

   private static DataFixer createFixerUpper() {
      DataFixerBuilder datafixerbuilder = new DataFixerBuilder(SharedConstants.getCurrentVersion().getWorldVersion());
      addFixers(datafixerbuilder);
      return datafixerbuilder.build(Util.bootstrapExecutor());
   }

   public static DataFixer getDataFixer() {
      return DATA_FIXER;
   }

   private static void addFixers(DataFixerBuilder p_210891_0_) {
      Schema schema = p_210891_0_.addSchema(99, V0099::new);
      Schema schema1 = p_210891_0_.addSchema(100, V0100::new);
      p_210891_0_.addFixer(new EntityArmorAndHeld(schema1, true));
      Schema schema2 = p_210891_0_.addSchema(101, SAME);
      p_210891_0_.addFixer(new SignStrictJSON(schema2, false));
      Schema schema3 = p_210891_0_.addSchema(102, V0102::new);
      p_210891_0_.addFixer(new ItemIntIDToString(schema3, true));
      p_210891_0_.addFixer(new PotionItems(schema3, false));
      Schema schema4 = p_210891_0_.addSchema(105, SAME);
      p_210891_0_.addFixer(new SpawnEggNames(schema4, true));
      Schema schema5 = p_210891_0_.addSchema(106, V0106::new);
      p_210891_0_.addFixer(new SpawnerEntityTypes(schema5, true));
      Schema schema6 = p_210891_0_.addSchema(107, V0107::new);
      p_210891_0_.addFixer(new MinecartEntityTypes(schema6, true));
      Schema schema7 = p_210891_0_.addSchema(108, SAME);
      p_210891_0_.addFixer(new StringToUUID(schema7, true));
      Schema schema8 = p_210891_0_.addSchema(109, SAME);
      p_210891_0_.addFixer(new EntityHealth(schema8, true));
      Schema schema9 = p_210891_0_.addSchema(110, SAME);
      p_210891_0_.addFixer(new HorseSaddle(schema9, true));
      Schema schema10 = p_210891_0_.addSchema(111, SAME);
      p_210891_0_.addFixer(new PaintingDirection(schema10, true));
      Schema schema11 = p_210891_0_.addSchema(113, SAME);
      p_210891_0_.addFixer(new RedundantChanceTags(schema11, true));
      Schema schema12 = p_210891_0_.addSchema(135, V0135::new);
      p_210891_0_.addFixer(new RidingToPassengers(schema12, true));
      Schema schema13 = p_210891_0_.addSchema(143, V0143::new);
      p_210891_0_.addFixer(new TippedArrow(schema13, true));
      Schema schema14 = p_210891_0_.addSchema(147, SAME);
      p_210891_0_.addFixer(new ArmorStandSilent(schema14, true));
      Schema schema15 = p_210891_0_.addSchema(165, SAME);
      p_210891_0_.addFixer(new BookPagesStrictJSON(schema15, true));
      Schema schema16 = p_210891_0_.addSchema(501, V0501::new);
      p_210891_0_.addFixer(new AddNewChoices(schema16, "Add 1.10 entities fix", TypeReferences.ENTITY));
      Schema schema17 = p_210891_0_.addSchema(502, SAME);
      p_210891_0_.addFixer(ItemRename.create(schema17, "cooked_fished item renamer", (p_207111_0_) -> {
         return Objects.equals(NamespacedSchema.ensureNamespaced(p_207111_0_), "minecraft:cooked_fished") ? "minecraft:cooked_fish" : p_207111_0_;
      }));
      p_210891_0_.addFixer(new ZombieProfToType(schema17, false));
      Schema schema18 = p_210891_0_.addSchema(505, SAME);
      p_210891_0_.addFixer(new ForceVBOOn(schema18, false));
      Schema schema19 = p_210891_0_.addSchema(700, V0700::new);
      p_210891_0_.addFixer(new ElderGuardianSplit(schema19, true));
      Schema schema20 = p_210891_0_.addSchema(701, V0701::new);
      p_210891_0_.addFixer(new SkeletonSplit(schema20, true));
      Schema schema21 = p_210891_0_.addSchema(702, V0702::new);
      p_210891_0_.addFixer(new ZombieSplit(schema21, true));
      Schema schema22 = p_210891_0_.addSchema(703, V0703::new);
      p_210891_0_.addFixer(new HorseSplit(schema22, true));
      Schema schema23 = p_210891_0_.addSchema(704, V0704::new);
      p_210891_0_.addFixer(new TileEntityId(schema23, true));
      Schema schema24 = p_210891_0_.addSchema(705, V0705::new);
      p_210891_0_.addFixer(new EntityId(schema24, true));
      Schema schema25 = p_210891_0_.addSchema(804, SAME_NAMESPACED);
      p_210891_0_.addFixer(new BannerItemColor(schema25, true));
      Schema schema26 = p_210891_0_.addSchema(806, SAME_NAMESPACED);
      p_210891_0_.addFixer(new PotionWater(schema26, false));
      Schema schema27 = p_210891_0_.addSchema(808, V0808::new);
      p_210891_0_.addFixer(new AddNewChoices(schema27, "added shulker box", TypeReferences.BLOCK_ENTITY));
      Schema schema28 = p_210891_0_.addSchema(808, 1, SAME_NAMESPACED);
      p_210891_0_.addFixer(new ShulkerBoxEntityColor(schema28, false));
      Schema schema29 = p_210891_0_.addSchema(813, SAME_NAMESPACED);
      p_210891_0_.addFixer(new ShulkerBoxItemColor(schema29, false));
      p_210891_0_.addFixer(new ShulkerBoxTileColor(schema29, false));
      Schema schema30 = p_210891_0_.addSchema(816, SAME_NAMESPACED);
      p_210891_0_.addFixer(new OptionsLowerCaseLanguage(schema30, false));
      Schema schema31 = p_210891_0_.addSchema(820, SAME_NAMESPACED);
      p_210891_0_.addFixer(ItemRename.create(schema31, "totem item renamer", createRenamer("minecraft:totem", "minecraft:totem_of_undying")));
      Schema schema32 = p_210891_0_.addSchema(1022, V1022::new);
      p_210891_0_.addFixer(new WriteAndReadDataFix(schema32, "added shoulder entities to players", TypeReferences.PLAYER));
      Schema schema33 = p_210891_0_.addSchema(1125, V1125::new);
      p_210891_0_.addFixer(new AddBedTileEntity(schema33, true));
      p_210891_0_.addFixer(new BedItemColor(schema33, false));
      Schema schema34 = p_210891_0_.addSchema(1344, SAME_NAMESPACED);
      p_210891_0_.addFixer(new LWJGL3KeyOptions(schema34, false));
      Schema schema35 = p_210891_0_.addSchema(1446, SAME_NAMESPACED);
      p_210891_0_.addFixer(new KeyOptionsTranslation(schema35, false));
      Schema schema36 = p_210891_0_.addSchema(1450, SAME_NAMESPACED);
      p_210891_0_.addFixer(new BlockStateFlattenStructures(schema36, false));
      Schema schema37 = p_210891_0_.addSchema(1451, V1451::new);
      p_210891_0_.addFixer(new AddNewChoices(schema37, "AddTrappedChestFix", TypeReferences.BLOCK_ENTITY));
      Schema schema38 = p_210891_0_.addSchema(1451, 1, V1451_1::new);
      p_210891_0_.addFixer(new ChunkPaletteFormat(schema38, true));
      Schema schema39 = p_210891_0_.addSchema(1451, 2, V1451_2::new);
      p_210891_0_.addFixer(new PistonPushedBlock(schema39, true));
      Schema schema40 = p_210891_0_.addSchema(1451, 3, V1451_3::new);
      p_210891_0_.addFixer(new BlockStateFlatternEntities(schema40, true));
      p_210891_0_.addFixer(new ItemFilledMapMetadata(schema40, false));
      Schema schema41 = p_210891_0_.addSchema(1451, 4, V1451_4::new);
      p_210891_0_.addFixer(new BlockNameFlattening(schema41, true));
      p_210891_0_.addFixer(new ItemStackDataFlattening(schema41, false));
      Schema schema42 = p_210891_0_.addSchema(1451, 5, V1451_5::new);
      p_210891_0_.addFixer(new AddNewChoices(schema42, "RemoveNoteBlockFlowerPotFix", TypeReferences.BLOCK_ENTITY));
      p_210891_0_.addFixer(new ItemSpawnEggSplit(schema42, false));
      p_210891_0_.addFixer(new WolfCollarColor(schema42, false));
      p_210891_0_.addFixer(new BlockEntityBannerColor(schema42, false));
      p_210891_0_.addFixer(new BlockStateFlattenGenOptions(schema42, false));
      Schema schema43 = p_210891_0_.addSchema(1451, 6, V1451_6::new);
      p_210891_0_.addFixer(new StatsRenaming(schema43, true));
      p_210891_0_.addFixer(new JukeboxRecordItem(schema43, false));
      Schema schema44 = p_210891_0_.addSchema(1451, 7, V1451_7::new);
      p_210891_0_.addFixer(new BlockStateFlattenVillageCrops(schema44, true));
      Schema schema45 = p_210891_0_.addSchema(1451, 7, SAME_NAMESPACED);
      p_210891_0_.addFixer(new VillagerTrades(schema45, false));
      Schema schema46 = p_210891_0_.addSchema(1456, SAME_NAMESPACED);
      p_210891_0_.addFixer(new EntityItemFrameFacing(schema46, false));
      Schema schema47 = p_210891_0_.addSchema(1458, SAME_NAMESPACED);
      p_210891_0_.addFixer(new CustomNameStringToComponentEntity(schema47, false));
      p_210891_0_.addFixer(new CustomNameStringToComponentItem(schema47, false));
      p_210891_0_.addFixer(new CustomNameStringToComponentFixTileEntity(schema47, false));
      Schema schema48 = p_210891_0_.addSchema(1460, V1460::new);
      p_210891_0_.addFixer(new PaintingMotive(schema48, false));
      Schema schema49 = p_210891_0_.addSchema(1466, V1466::new);
      p_210891_0_.addFixer(new ChunkGenStatus(schema49, true));
      Schema schema50 = p_210891_0_.addSchema(1470, V1470::new);
      p_210891_0_.addFixer(new AddNewChoices(schema50, "Add 1.13 entities fix", TypeReferences.ENTITY));
      Schema schema51 = p_210891_0_.addSchema(1474, SAME_NAMESPACED);
      p_210891_0_.addFixer(new ColorlessShulkerEntityFix(schema51, false));
      p_210891_0_.addFixer(BlockRename.create(schema51, "Colorless shulker block fixer", (p_207106_0_) -> {
         return Objects.equals(NamespacedSchema.ensureNamespaced(p_207106_0_), "minecraft:purple_shulker_box") ? "minecraft:shulker_box" : p_207106_0_;
      }));
      p_210891_0_.addFixer(ItemRename.create(schema51, "Colorless shulker item fixer", (p_207101_0_) -> {
         return Objects.equals(NamespacedSchema.ensureNamespaced(p_207101_0_), "minecraft:purple_shulker_box") ? "minecraft:shulker_box" : p_207101_0_;
      }));
      Schema schema52 = p_210891_0_.addSchema(1475, SAME_NAMESPACED);
      p_210891_0_.addFixer(BlockRename.create(schema52, "Flowing fixer", createRenamer(ImmutableMap.of("minecraft:flowing_water", "minecraft:water", "minecraft:flowing_lava", "minecraft:lava"))));
      Schema schema53 = p_210891_0_.addSchema(1480, SAME_NAMESPACED);
      p_210891_0_.addFixer(BlockRename.create(schema53, "Rename coral blocks", createRenamer(RenamedCoral.RENAMED_IDS)));
      p_210891_0_.addFixer(ItemRename.create(schema53, "Rename coral items", createRenamer(RenamedCoral.RENAMED_IDS)));
      Schema schema54 = p_210891_0_.addSchema(1481, V1481::new);
      p_210891_0_.addFixer(new AddNewChoices(schema54, "Add conduit", TypeReferences.BLOCK_ENTITY));
      Schema schema55 = p_210891_0_.addSchema(1483, V1483::new);
      p_210891_0_.addFixer(new PufferfishRename(schema55, true));
      p_210891_0_.addFixer(ItemRename.create(schema55, "Rename pufferfish egg item", createRenamer(PufferfishRename.RENAMED_IDS)));
      Schema schema56 = p_210891_0_.addSchema(1484, SAME_NAMESPACED);
      p_210891_0_.addFixer(ItemRename.create(schema56, "Rename seagrass items", createRenamer(ImmutableMap.of("minecraft:sea_grass", "minecraft:seagrass", "minecraft:tall_sea_grass", "minecraft:tall_seagrass"))));
      p_210891_0_.addFixer(BlockRename.create(schema56, "Rename seagrass blocks", createRenamer(ImmutableMap.of("minecraft:sea_grass", "minecraft:seagrass", "minecraft:tall_sea_grass", "minecraft:tall_seagrass"))));
      p_210891_0_.addFixer(new HeightmapRenamingFix(schema56, false));
      Schema schema57 = p_210891_0_.addSchema(1486, V1486::new);
      p_210891_0_.addFixer(new EntityCodSalmonFix(schema57, true));
      p_210891_0_.addFixer(ItemRename.create(schema57, "Rename cod/salmon egg items", createRenamer(EntityCodSalmonFix.RENAMED_EGG_IDS)));
      Schema schema58 = p_210891_0_.addSchema(1487, SAME_NAMESPACED);
      p_210891_0_.addFixer(ItemRename.create(schema58, "Rename prismarine_brick(s)_* blocks", createRenamer(ImmutableMap.of("minecraft:prismarine_bricks_slab", "minecraft:prismarine_brick_slab", "minecraft:prismarine_bricks_stairs", "minecraft:prismarine_brick_stairs"))));
      p_210891_0_.addFixer(BlockRename.create(schema58, "Rename prismarine_brick(s)_* items", createRenamer(ImmutableMap.of("minecraft:prismarine_bricks_slab", "minecraft:prismarine_brick_slab", "minecraft:prismarine_bricks_stairs", "minecraft:prismarine_brick_stairs"))));
      Schema schema59 = p_210891_0_.addSchema(1488, SAME_NAMESPACED);
      p_210891_0_.addFixer(BlockRename.create(schema59, "Rename kelp/kelptop", createRenamer(ImmutableMap.of("minecraft:kelp_top", "minecraft:kelp", "minecraft:kelp", "minecraft:kelp_plant"))));
      p_210891_0_.addFixer(ItemRename.create(schema59, "Rename kelptop", createRenamer("minecraft:kelp_top", "minecraft:kelp")));
      p_210891_0_.addFixer(new NamedEntityFix(schema59, false, "Command block block entity custom name fix", TypeReferences.BLOCK_ENTITY, "minecraft:command_block") {
         protected Typed<?> fix(Typed<?> p_207419_1_) {
            return p_207419_1_.update(DSL.remainderFinder(), CustomNameStringToComponentEntity::fixTagCustomName);
         }
      });
      p_210891_0_.addFixer(new NamedEntityFix(schema59, false, "Command block minecart custom name fix", TypeReferences.ENTITY, "minecraft:commandblock_minecart") {
         protected Typed<?> fix(Typed<?> p_207419_1_) {
            return p_207419_1_.update(DSL.remainderFinder(), CustomNameStringToComponentEntity::fixTagCustomName);
         }
      });
      p_210891_0_.addFixer(new IglooMetadataRemoval(schema59, false));
      Schema schema60 = p_210891_0_.addSchema(1490, SAME_NAMESPACED);
      p_210891_0_.addFixer(BlockRename.create(schema60, "Rename melon_block", createRenamer("minecraft:melon_block", "minecraft:melon")));
      p_210891_0_.addFixer(ItemRename.create(schema60, "Rename melon_block/melon/speckled_melon", createRenamer(ImmutableMap.of("minecraft:melon_block", "minecraft:melon", "minecraft:melon", "minecraft:melon_slice", "minecraft:speckled_melon", "minecraft:glistering_melon_slice"))));
      Schema schema61 = p_210891_0_.addSchema(1492, SAME_NAMESPACED);
      p_210891_0_.addFixer(new ChunkStructuresTemplateRenameFix(schema61, false));
      Schema schema62 = p_210891_0_.addSchema(1494, SAME_NAMESPACED);
      p_210891_0_.addFixer(new ItemStackEnchantmentFix(schema62, false));
      Schema schema63 = p_210891_0_.addSchema(1496, SAME_NAMESPACED);
      p_210891_0_.addFixer(new LeavesFix(schema63, false));
      Schema schema64 = p_210891_0_.addSchema(1500, SAME_NAMESPACED);
      p_210891_0_.addFixer(new BlockEntityKeepPacked(schema64, false));
      Schema schema65 = p_210891_0_.addSchema(1501, SAME_NAMESPACED);
      p_210891_0_.addFixer(new AdvancementRenamer1501(schema65, false));
      Schema schema66 = p_210891_0_.addSchema(1502, SAME_NAMESPACED);
      p_210891_0_.addFixer(new RecipeRenamer1502(schema66, false));
      Schema schema67 = p_210891_0_.addSchema(1506, SAME_NAMESPACED);
      p_210891_0_.addFixer(new LevelDataGeneratorOptionsFix(schema67, false));
      Schema schema68 = p_210891_0_.addSchema(1510, V1510::new);
      p_210891_0_.addFixer(BlockRename.create(schema68, "Block renamening fix", createRenamer(EntityRenaming1510.RENAMED_BLOCKS)));
      p_210891_0_.addFixer(ItemRename.create(schema68, "Item renamening fix", createRenamer(EntityRenaming1510.RENAMED_ITEMS)));
      p_210891_0_.addFixer(new RecipeRenamer1510(schema68, false));
      p_210891_0_.addFixer(new EntityRenaming1510(schema68, true));
      p_210891_0_.addFixer(new SwimStatsRename(schema68, false));
      Schema schema69 = p_210891_0_.addSchema(1514, SAME_NAMESPACED);
      p_210891_0_.addFixer(new ObjectiveDisplayName(schema69, false));
      p_210891_0_.addFixer(new TeamDisplayName(schema69, false));
      p_210891_0_.addFixer(new ObjectiveRenderType(schema69, false));
      Schema schema70 = p_210891_0_.addSchema(1515, SAME_NAMESPACED);
      p_210891_0_.addFixer(BlockRename.create(schema70, "Rename coral fan blocks", createRenamer(CoralFansRenameList.RENAMED_IDS)));
      Schema schema71 = p_210891_0_.addSchema(1624, SAME_NAMESPACED);
      p_210891_0_.addFixer(new TrappedChestTileEntitySplit(schema71, false));
      Schema schema72 = p_210891_0_.addSchema(1800, V1800::new);
      p_210891_0_.addFixer(new AddNewChoices(schema72, "Added 1.14 mobs fix", TypeReferences.ENTITY));
      p_210891_0_.addFixer(ItemRename.create(schema72, "Rename dye items", createRenamer(DyeRenameMap.RENAMED_IDS)));
      Schema schema73 = p_210891_0_.addSchema(1801, V1801::new);
      p_210891_0_.addFixer(new AddNewChoices(schema73, "Added Illager Beast", TypeReferences.ENTITY));
      Schema schema74 = p_210891_0_.addSchema(1802, SAME_NAMESPACED);
      p_210891_0_.addFixer(BlockRename.create(schema74, "Rename sign blocks & stone slabs", createRenamer(ImmutableMap.of("minecraft:stone_slab", "minecraft:smooth_stone_slab", "minecraft:sign", "minecraft:oak_sign", "minecraft:wall_sign", "minecraft:oak_wall_sign"))));
      p_210891_0_.addFixer(ItemRename.create(schema74, "Rename sign item & stone slabs", createRenamer(ImmutableMap.of("minecraft:stone_slab", "minecraft:smooth_stone_slab", "minecraft:sign", "minecraft:oak_sign"))));
      Schema schema75 = p_210891_0_.addSchema(1803, SAME_NAMESPACED);
      p_210891_0_.addFixer(new ItemLoreComponentizeFix(schema75, false));
      Schema schema76 = p_210891_0_.addSchema(1904, V1904::new);
      p_210891_0_.addFixer(new AddNewChoices(schema76, "Added Cats", TypeReferences.ENTITY));
      p_210891_0_.addFixer(new EntityCatSplitFix(schema76, false));
      Schema schema77 = p_210891_0_.addSchema(1905, SAME_NAMESPACED);
      p_210891_0_.addFixer(new ChunkStatusFix(schema77, false));
      Schema schema78 = p_210891_0_.addSchema(1906, V1906::new);
      p_210891_0_.addFixer(new AddNewChoices(schema78, "Add POI Blocks", TypeReferences.BLOCK_ENTITY));
      Schema schema79 = p_210891_0_.addSchema(1909, V1909::new);
      p_210891_0_.addFixer(new AddNewChoices(schema79, "Add jigsaw", TypeReferences.BLOCK_ENTITY));
      Schema schema80 = p_210891_0_.addSchema(1911, SAME_NAMESPACED);
      p_210891_0_.addFixer(new ChunkStatusFix2(schema80, false));
      Schema schema81 = p_210891_0_.addSchema(1917, SAME_NAMESPACED);
      p_210891_0_.addFixer(new CatTypeFix(schema81, false));
      Schema schema82 = p_210891_0_.addSchema(1918, SAME_NAMESPACED);
      p_210891_0_.addFixer(new VillagerProfessionFix(schema82, "minecraft:villager"));
      p_210891_0_.addFixer(new VillagerProfessionFix(schema82, "minecraft:zombie_villager"));
      Schema schema83 = p_210891_0_.addSchema(1920, V1920::new);
      p_210891_0_.addFixer(new NewVillageFix(schema83, false));
      p_210891_0_.addFixer(new AddNewChoices(schema83, "Add campfire", TypeReferences.BLOCK_ENTITY));
      Schema schema84 = p_210891_0_.addSchema(1925, SAME_NAMESPACED);
      p_210891_0_.addFixer(new MapIdFix(schema84, false));
      Schema schema85 = p_210891_0_.addSchema(1928, V1928::new);
      p_210891_0_.addFixer(new EntityRavagerRenameFix(schema85, true));
      p_210891_0_.addFixer(ItemRename.create(schema85, "Rename ravager egg item", createRenamer(EntityRavagerRenameFix.RENAMED_IDS)));
      Schema schema86 = p_210891_0_.addSchema(1929, V1929::new);
      p_210891_0_.addFixer(new AddNewChoices(schema86, "Add Wandering Trader and Trader Llama", TypeReferences.ENTITY));
      Schema schema87 = p_210891_0_.addSchema(1931, V1931::new);
      p_210891_0_.addFixer(new AddNewChoices(schema87, "Added Fox", TypeReferences.ENTITY));
      Schema schema88 = p_210891_0_.addSchema(1936, SAME_NAMESPACED);
      p_210891_0_.addFixer(new OptionsAddTextBackgroundFix(schema88, false));
      Schema schema89 = p_210891_0_.addSchema(1946, SAME_NAMESPACED);
      p_210891_0_.addFixer(new PointOfInterestReorganizationFix(schema89, false));
      Schema schema90 = p_210891_0_.addSchema(1948, SAME_NAMESPACED);
      p_210891_0_.addFixer(new OminousBannerRenameFix(schema90, false));
      Schema schema91 = p_210891_0_.addSchema(1953, SAME_NAMESPACED);
      p_210891_0_.addFixer(new OminousBannerTileEntityRenameFix(schema91, false));
      Schema schema92 = p_210891_0_.addSchema(1955, SAME_NAMESPACED);
      p_210891_0_.addFixer(new VillagerLevelAndXpFix(schema92, false));
      p_210891_0_.addFixer(new ZombieVillagerXpFix(schema92, false));
      Schema schema93 = p_210891_0_.addSchema(1961, SAME_NAMESPACED);
      p_210891_0_.addFixer(new ChunkLightRemoveFix(schema93, false));
      Schema schema94 = p_210891_0_.addSchema(1963, SAME_NAMESPACED);
      p_210891_0_.addFixer(new RemoveGolemGossip(schema94, false));
      Schema schema95 = p_210891_0_.addSchema(2100, V2100::new);
      p_210891_0_.addFixer(new AddNewChoices(schema95, "Added Bee and Bee Stinger", TypeReferences.ENTITY));
      p_210891_0_.addFixer(new AddNewChoices(schema95, "Add beehive", TypeReferences.BLOCK_ENTITY));
      p_210891_0_.addFixer(new RecipeRenamer(schema95, false, "Rename sugar recipe", createRenamer("minecraft:sugar", "sugar_from_sugar_cane")));
      p_210891_0_.addFixer(new AdvancementRenamer(schema95, false, "Rename sugar recipe advancement", createRenamer("minecraft:recipes/misc/sugar", "minecraft:recipes/misc/sugar_from_sugar_cane")));
      Schema schema96 = p_210891_0_.addSchema(2202, SAME_NAMESPACED);
      p_210891_0_.addFixer(new BiomeIdFix(schema96, false));
      Schema schema97 = p_210891_0_.addSchema(2209, SAME_NAMESPACED);
      p_210891_0_.addFixer(ItemRename.create(schema97, "Rename bee_hive item to beehive", createRenamer("minecraft:bee_hive", "minecraft:beehive")));
      p_210891_0_.addFixer(new RenameBeehivePointOfInterest(schema97));
      p_210891_0_.addFixer(BlockRename.create(schema97, "Rename bee_hive block to beehive", createRenamer("minecraft:bee_hive", "minecraft:beehive")));
      Schema schema98 = p_210891_0_.addSchema(2211, SAME_NAMESPACED);
      p_210891_0_.addFixer(new StructureReferenceFix(schema98, false));
      Schema schema99 = p_210891_0_.addSchema(2218, SAME_NAMESPACED);
      p_210891_0_.addFixer(new PointOfInterestRebuild(schema99, false));
      Schema schema100 = p_210891_0_.addSchema(2501, V2501::new);
      p_210891_0_.addFixer(new FurnaceRecipes(schema100, true));
      Schema schema101 = p_210891_0_.addSchema(2502, V2502::new);
      p_210891_0_.addFixer(new AddNewChoices(schema101, "Added Hoglin", TypeReferences.ENTITY));
      Schema schema102 = p_210891_0_.addSchema(2503, SAME_NAMESPACED);
      p_210891_0_.addFixer(new WallProperty(schema102, false));
      p_210891_0_.addFixer(new AdvancementRenamer(schema102, false, "Composter category change", createRenamer("minecraft:recipes/misc/composter", "minecraft:recipes/decorations/composter")));
      Schema schema103 = p_210891_0_.addSchema(2505, V2505::new);
      p_210891_0_.addFixer(new AddNewChoices(schema103, "Added Piglin", TypeReferences.ENTITY));
      p_210891_0_.addFixer(new MemoryExpiry(schema103, "minecraft:villager"));
      Schema schema104 = p_210891_0_.addSchema(2508, SAME_NAMESPACED);
      p_210891_0_.addFixer(ItemRename.create(schema104, "Renamed fungi items to fungus", createRenamer(ImmutableMap.of("minecraft:warped_fungi", "minecraft:warped_fungus", "minecraft:crimson_fungi", "minecraft:crimson_fungus"))));
      p_210891_0_.addFixer(BlockRename.create(schema104, "Renamed fungi blocks to fungus", createRenamer(ImmutableMap.of("minecraft:warped_fungi", "minecraft:warped_fungus", "minecraft:crimson_fungi", "minecraft:crimson_fungus"))));
      Schema schema105 = p_210891_0_.addSchema(2509, V2509::new);
      p_210891_0_.addFixer(new ZombifiedPiglinRename(schema105));
      p_210891_0_.addFixer(ItemRename.create(schema105, "Rename zombie pigman egg item", createRenamer(ZombifiedPiglinRename.RENAMED_IDS)));
      Schema schema106 = p_210891_0_.addSchema(2511, SAME_NAMESPACED);
      p_210891_0_.addFixer(new ProjectileOwner(schema106));
      Schema schema107 = p_210891_0_.addSchema(2514, SAME_NAMESPACED);
      p_210891_0_.addFixer(new EntityUUID(schema107));
      p_210891_0_.addFixer(new BlockEntityUUID(schema107));
      p_210891_0_.addFixer(new PlayerUUID(schema107));
      p_210891_0_.addFixer(new LevelUUID(schema107));
      p_210891_0_.addFixer(new SavedDataUUID(schema107));
      p_210891_0_.addFixer(new ItemStackUUID(schema107));
      Schema schema108 = p_210891_0_.addSchema(2516, SAME_NAMESPACED);
      p_210891_0_.addFixer(new Gossip(schema108, "minecraft:villager"));
      p_210891_0_.addFixer(new Gossip(schema108, "minecraft:zombie_villager"));
      Schema schema109 = p_210891_0_.addSchema(2518, SAME_NAMESPACED);
      p_210891_0_.addFixer(new JigsawProperties(schema109, false));
      p_210891_0_.addFixer(new JigsawRotation(schema109, false));
      Schema schema110 = p_210891_0_.addSchema(2519, V2519::new);
      p_210891_0_.addFixer(new AddNewChoices(schema110, "Added Strider", TypeReferences.ENTITY));
      Schema schema111 = p_210891_0_.addSchema(2522, V2522::new);
      p_210891_0_.addFixer(new AddNewChoices(schema111, "Added Zoglin", TypeReferences.ENTITY));
      Schema schema112 = p_210891_0_.addSchema(2523, SAME_NAMESPACED);
      p_210891_0_.addFixer(new AttributesFix(schema112));
      Schema schema113 = p_210891_0_.addSchema(2527, SAME_NAMESPACED);
      p_210891_0_.addFixer(new BitStorageAlignFix(schema113));
      Schema schema114 = p_210891_0_.addSchema(2528, SAME_NAMESPACED);
      p_210891_0_.addFixer(ItemRename.create(schema114, "Rename soul fire torch and soul fire lantern", createRenamer(ImmutableMap.of("minecraft:soul_fire_torch", "minecraft:soul_torch", "minecraft:soul_fire_lantern", "minecraft:soul_lantern"))));
      p_210891_0_.addFixer(BlockRename.create(schema114, "Rename soul fire torch and soul fire lantern", createRenamer(ImmutableMap.of("minecraft:soul_fire_torch", "minecraft:soul_torch", "minecraft:soul_fire_wall_torch", "minecraft:soul_wall_torch", "minecraft:soul_fire_lantern", "minecraft:soul_lantern"))));
      Schema schema115 = p_210891_0_.addSchema(2529, SAME_NAMESPACED);
      p_210891_0_.addFixer(new StriderGravity(schema115, false));
      Schema schema116 = p_210891_0_.addSchema(2531, SAME_NAMESPACED);
      p_210891_0_.addFixer(new RedstoneConnections(schema116));
      Schema schema117 = p_210891_0_.addSchema(2533, SAME_NAMESPACED);
      p_210891_0_.addFixer(new VillagerFollowRange(schema117));
      Schema schema118 = p_210891_0_.addSchema(2535, SAME_NAMESPACED);
      p_210891_0_.addFixer(new ShulkerRotation(schema118));
      Schema schema119 = p_210891_0_.addSchema(2550, SAME_NAMESPACED);
      p_210891_0_.addFixer(new WorldGenSettings(schema119));
      Schema schema120 = p_210891_0_.addSchema(2551, V2551::new);
      p_210891_0_.addFixer(new WriteAndReadDataFix(schema120, "add types to WorldGenData", TypeReferences.WORLD_GEN_SETTINGS));
      Schema schema121 = p_210891_0_.addSchema(2552, SAME_NAMESPACED);
      p_210891_0_.addFixer(new BiomeName(schema121, false, "Nether biome rename", ImmutableMap.of("minecraft:nether", "minecraft:nether_wastes")));
      Schema schema122 = p_210891_0_.addSchema(2553, SAME_NAMESPACED);
      p_210891_0_.addFixer(new BiomeRenames(schema122, false));
      Schema schema123 = p_210891_0_.addSchema(2558, SAME_NAMESPACED);
      p_210891_0_.addFixer(new MissingDimensionFix(schema123, false));
      p_210891_0_.addFixer(new SwapHandsFix(schema123, false, "Rename swapHands setting", "key_key.swapHands", "key_key.swapOffhand"));
      Schema schema124 = p_210891_0_.addSchema(2568, V2568::new);
      p_210891_0_.addFixer(new AddNewChoices(schema124, "Added Piglin Brute", TypeReferences.ENTITY));
   }

   private static UnaryOperator<String> createRenamer(Map<String, String> p_241301_0_) {
      return (p_241302_1_) -> {
         return p_241301_0_.getOrDefault(p_241302_1_, p_241302_1_);
      };
   }

   private static UnaryOperator<String> createRenamer(String p_241299_0_, String p_241299_1_) {
      return (p_241300_2_) -> {
         return Objects.equals(p_241300_2_, p_241299_0_) ? p_241299_1_ : p_241300_2_;
      };
   }
}
