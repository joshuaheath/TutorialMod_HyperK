package net.HyperK.FirstTestMod.block;

import net.HyperK.FirstTestMod.TutorialMod;
import net.HyperK.FirstTestMod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    //---------------------------------------------------------------------------
    //REGISTERING A BLOCK

    //name param MUST match corrisponding name of the json file inside of the "blockstates" folder (ie. alexandrite_block.json)
    public static final RegistryObject<Block> ALEXANDRITE_BLOCK = registerBlock("alexandrite_block",
            //Giving our blocks our properties
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> RAW_ALEXANDRITE_BLOCK = registerBlock("raw_alexandrite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> TEST_BLOCK = registerBlock("test_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1f)
                    .sound(SoundType.NETHERITE_BLOCK)
                    .destroyTime(2f)));
    //---------------------------------------------------------------------------

    //---------------------------------------------------------------------------
    //MAKING HELPING METHODS

    //Registers our blocks
    //Returns a "RegistryObject" of type "T" - Method named "registerBlock"
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    //this register the block item that is assosiated with the block that is registerd
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    //---------------------------------------------------------------------------

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
