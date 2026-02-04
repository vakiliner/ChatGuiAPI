package vakiliner.chatguiapi.fabric.impl;

import net.minecraft.client.gui.screens.Screen;
import vakiliner.chatcomponentapi.component.ChatComponent;
import vakiliner.chatcomponentapi.fabric.FabricParser;
import vakiliner.chatguiapi.base.ChatScreen;
import vakiliner.chatguiapi.fabric.ChatGuiAPIFabricParser;

public class FabricChatScreen implements ChatScreen {
	private final ChatGuiAPIFabricParser parser;
	private final ScreenImpl screen;

	public FabricChatScreen(ChatGuiAPIFabricParser parser, ChatComponent chatComponent) {
		this.parser = parser;
		this.screen = new ScreenImpl(chatComponent);
	}

	public ChatGuiAPIFabricParser getParser() {
		return this.parser;
	}

	public Screen toFabric() {
		return this.screen;
	}

	public ChatComponent getTitle() {
		return FabricParser.fabric(this.screen.getTitle());
	}

	public boolean shouldCloseOnEsc() {
		return this.screen.shouldCloseOnEsc();
	}

	class ScreenImpl extends Screen {
		private boolean shouldCloseOnEsc = super.shouldCloseOnEsc();
		private Runnable onClose = super::onClose;
		private Runnable init = super::init;

		public ScreenImpl(ChatComponent chatComponent) {
			super(FabricParser.fabric(chatComponent));
		}

		public boolean shouldCloseOnEsc() {
			return this.shouldCloseOnEsc;
		}

		public void onClose() {
			this.onClose.run();
		}

		protected void init() {
			this.init.run();
		}
	}
}