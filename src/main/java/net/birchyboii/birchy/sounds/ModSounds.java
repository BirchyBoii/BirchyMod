package net.birchyboii.birchy.sounds;

import net.birchyboii.birchy.BirchyMod;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent LAMP_USE = registerSoundEvent("lamp_use");

    public static final SoundEvent STAL_BIRCHY_COVER = registerSoundEvent("stal_birchy_cover");
    public static final RegistryKey<JukeboxSong> STAL_BIRCHY_COVER_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(BirchyMod.MOD_ID, "stal_birchy_cover"));

    public static final SoundEvent BIRCHY_BOY_HURT = registerSoundEvent("birchy_boy_hurt");
    public static final SoundEvent BIRCHY_BOY_DEATH = registerSoundEvent("birchy_boy_death");
    public static final SoundEvent BIRCHY_BOY_LAUGH = registerSoundEvent("birchy_boy_laugh");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(BirchyMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        BirchyMod.LOGGER.info("Registering Mod Sounds for " + BirchyMod.MOD_ID);
    }
}
