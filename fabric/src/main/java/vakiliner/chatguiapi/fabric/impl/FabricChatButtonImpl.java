package vakiliner.chatguiapi.fabric.impl;

import java.util.function.Function;
import net.minecraft.client.gui.components.AbstractButton;
import net.minecraft.network.chat.Component;
import vakiliner.chatcomponentapi.component.ChatComponent;
import vakiliner.chatcomponentapi.fabric.FabricParser;
import vakiliner.chatguiapi.fabric.ChatGuiAPIFabricParser;
import vakiliner.chatguiapi.fabric.FabricChatButton;

public class FabricChatButtonImpl implements FabricChatButton {
	@SuppressWarnings("unused")
	private final ChatGuiAPIFabricParser parser;
	private final ButtonImpl impl;

	public FabricChatButtonImpl(ChatGuiAPIFabricParser parser, int i, int j, int k, int l, ChatComponent component) {
		this.parser = parser;
		this.impl = new ButtonImpl(i, j, k, l, FabricParser.fabric(component));
	}

	public AbstractButton toFabric() {
		if (this.impl.onPress == null) {
			throw new UnsupportedOperationException("Unimplemented method onPress");
		}
		return this.impl;
	}

	public ChatComponent getMessage() {
		return FabricParser.fabric(this.impl.getMessage());
	}

	public int getHeight() {
		return this.impl.getHeight();
	}

	public int getWidth() {
		return this.impl.getWidth();
	}

	public boolean isFocused() {
		return this.impl.isFocused();
	}

	public void setMessage(ChatComponent component) {
		this.impl.setMessage(FabricParser.fabric(component));
	}

	public void setWidth(int i) {
		this.impl.setWidth(i);
	}

	public void setAlpha(float f) {
		this.impl.setAlpha(f);
	}

	public void onClick(Function<OnClick, OnClick> function) {
		this.impl.onClick = function.apply(this.impl.onClick);
	}

	public void onPress(Function<Runnable, Runnable> function) {
		this.impl.onPress = function.apply(this.impl.onPress);
	}

	public class ButtonImpl extends AbstractButton {
		private Runnable onPress;
		private OnClick onClick = super::onClick;

		private ButtonImpl(int i, int j, int k, int l, Component component) {
			super(i, j, k, l, component);
		}

		public void onPress() {
			this.onPress.run();
		}

		public void onClick(double d, double e) {
			this.onClick.onClick(d, e);
		}

		public FabricChatButtonImpl toChatGuiAPI() {
			return FabricChatButtonImpl.this;
		}
	}
}