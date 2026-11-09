package dev.myclient.mixin;

import dev.myclient.module.modules.Freecam;
import net.minecraft.client.network.ClientCommonNetworkHandler;
import net.minecraft.network.packet.Packet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientCommonNetworkHandler.class)
public abstract class ClientCommonNetworkHandlerMixin implements MixinMarker {
    @Inject(method = "sendPacket", at = @At("HEAD"), cancellable = true, require = 0)
    private void myclient$send(Packet<?> packet, CallbackInfo ci) {
        if (Freecam.blockPacket(packet)) ci.cancel();
    }
}
