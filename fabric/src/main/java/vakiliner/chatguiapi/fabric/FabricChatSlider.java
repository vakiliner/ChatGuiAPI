package vakiliner.chatguiapi.fabric;

import net.minecraft.client.gui.components.AbstractSliderButton;
import vakiliner.chatguiapi.base.ChatSlider;

public interface FabricChatSlider extends ChatSlider, FabricChatWidget {
	AbstractSliderButton toFabric();
}