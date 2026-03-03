package net.reconhalcyon.reconium.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.reconhalcyon.reconium.Reconium;
import net.reconhalcyon.reconium.item.ModItems;
import net.reconhalcyon.reconium.villager.ModVillagers;

import java.util.List;

@EventBusSubscriber(modid = Reconium.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if(event.getType() == ModVillagers.LAPIDARY_MASTER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 1),
                ModItems.MOONSTONE.get().getDefaultInstance().copyWithCount(2),
                    16, 6, 0.02f));
        }
    }
}




