package vakiliner.chatguiapi.fabric.impl;

import java.util.function.Function;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.network.chat.Component;
import vakiliner.chatcomponentapi.component.ChatComponent;
import vakiliner.chatcomponentapi.fabric.FabricParser;
import vakiliner.chatguiapi.base.ChatWidget;
import vakiliner.chatguiapi.fabric.ChatGuiAPIFabricParser;

public class FabricChatWidgetImpl implements ChatWidget {
	@SuppressWarnings("unused")
	private final ChatGuiAPIFabricParser parser;
	private final WidgetImpl impl;

	public FabricChatWidgetImpl(ChatGuiAPIFabricParser parser, int i, int j, int k, int l, ChatComponent component) {
		this.parser = parser;
		this.impl = new WidgetImpl(i, j, k, l, FabricParser.fabric(component));
	}

	public AbstractWidget toFabric() {
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

	public class WidgetImpl extends AbstractWidget {
		private OnClick onClick = super::onClick;

		public WidgetImpl(int i, int j, int k, int l, Component component) {
			super(i, j, k, l, component);
		}

		public void onClick(double d, double e) {
			this.onClick.onClick(d, e);
		}

		public FabricChatWidgetImpl toChatGuiAPI() {
			return FabricChatWidgetImpl.this;
		}
	}
}