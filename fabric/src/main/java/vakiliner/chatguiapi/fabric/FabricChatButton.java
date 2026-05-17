package vakiliner.chatguiapi.fabric;

import net.minecraft.client.gui.components.AbstractButton;
import vakiliner.chatguiapi.base.ChatButton;

public interface FabricChatButton extends ChatButton, FabricChatWidget {
	AbstractButton toFabric();
}