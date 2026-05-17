package vakiliner.chatguiapi.fabric.impl;

import java.util.function.Function;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import vakiliner.chatcomponentapi.component.ChatComponent;
import vakiliner.chatcomponentapi.fabric.FabricParser;
import vakiliner.chatguiapi.fabric.ChatGuiAPIFabricParser;
import vakiliner.chatguiapi.fabric.FabricChatScreen;

public class FabricChatScreenImpl implements FabricChatScreen {
	@SuppressWarnings("unused")
	private final ChatGuiAPIFabricParser parser;
	private final ScreenImpl impl;

	public FabricChatScreenImpl(ChatGuiAPIFabricParser parser, ChatComponent component) {
		this.parser = parser;
		this.impl = new ScreenImpl(FabricParser.fabric(component));
	}

	public Screen toFabric() {
		return this.impl;
	}

	public ChatComponent getTitle() {
		return FabricParser.fabric(this.impl.getTitle());
	}

	public boolean shouldCloseOnEsc() {
		return this.impl.shouldCloseOnEsc();
	}

	public void onInit(Function<Runnable, Runnable> function) {
		this.impl.init = function.apply(this.impl.init);
	}

	public class ScreenImpl extends Screen {
		private boolean shouldCloseOnEsc = super.shouldCloseOnEsc();
		private Runnable onClose = super::onClose;
		private Runnable init = super::init;

		private ScreenImpl(Component component) {
			super(component);
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

		public FabricChatScreenImpl toChatGuiAPI() {
			return FabricChatScreenImpl.this;
		}
	}
}