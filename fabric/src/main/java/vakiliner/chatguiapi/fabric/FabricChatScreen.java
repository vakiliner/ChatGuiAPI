package vakiliner.chatguiapi.fabric;

import net.minecraft.client.gui.screens.Screen;
import vakiliner.chatguiapi.base.ChatScreen;

public interface FabricChatScreen extends ChatScreen {
	Screen toFabric();
}