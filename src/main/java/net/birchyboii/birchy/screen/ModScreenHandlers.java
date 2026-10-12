package net.birchyboii.birchy.screen;

import net.birchyboii.birchy.BirchyMod;
import net.birchyboii.birchy.screen.custom.BirchisizerScreenHandler;
import net.birchyboii.birchy.screen.custom.PedestalScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {
    public static final ScreenHandlerType<PedestalScreenHandler> PEDESTAL_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(BirchyMod.MOD_ID, "pedestal_screen_handler"),
                    new ExtendedScreenHandlerType<>(PedestalScreenHandler::new, BlockPos.PACKET_CODEC));

    public static final ScreenHandlerType<BirchisizerScreenHandler> BIRCHISIZER_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(BirchyMod.MOD_ID, "birchisizer_screen_handler"),
                    new ExtendedScreenHandlerType<>(BirchisizerScreenHandler::new, BlockPos.PACKET_CODEC));

    public static void registerScreenHandlers() {
        BirchyMod.LOGGER.info("Registering Screen Handlers for " + BirchyMod.MOD_ID);
    }
}
