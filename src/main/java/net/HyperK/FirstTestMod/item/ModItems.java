package net.HyperK.FirstTestMod.item;

import net.HyperK.FirstTestMod.TutorialMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.rmi.registry.Registry;

public class ModItems {
    //What we are registering, (Ie. an Item) this makes sure that we are doing that
    //
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    //We are registering an object of type "Item"
    //"ALEXANDRITE" is the items defered register
    public static final RegistryObject<Item> ALEXANDRITE = ITEMS.register("alexandrite",
            //Adding the item into the game
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
