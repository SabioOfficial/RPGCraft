package net.sabio.rpgcraft.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.CameraType;

public class RpgcraftClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player != null && client.options.getCameraType() != CameraType.FIRST_PERSON) {
                client.options.setCameraType(CameraType.FIRST_PERSON);
            }
        });
    }
}
