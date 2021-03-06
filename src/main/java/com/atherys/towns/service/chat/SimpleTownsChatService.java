package com.atherys.towns.service.chat;

import com.atherys.towns.api.chat.TownsChatService;
import com.atherys.towns.chat.NationMessageChannel;
import com.atherys.towns.chat.TownMessageChannel;
import com.atherys.towns.entity.Nation;
import com.atherys.towns.entity.Town;
import com.google.inject.Singleton;
import org.spongepowered.api.text.Text;

@Singleton
public class SimpleTownsChatService implements TownsChatService {

    @Override
    public TownMessageChannel getChannel(Town town) {
        if (town.getMessageChannel() == null) {
            town.setMessageChannel(new TownMessageChannel(town));
        }

        return town.getMessageChannel();
    }

    @Override
    public NationMessageChannel getChannel(Nation nation) {
        if (nation.getMessageChannel() == null) {
            nation.setMessageChannel(new NationMessageChannel(nation));
        }

        return nation.getMessageChannel();
    }

    @Override
    public void broadcast(Town town, Object... message) {
        broadcast(town, Text.of(message));
    }

    @Override
    public void broadcast(Town town, Text text) {
        town.getMessageChannel().send(text);
    }

    @Override
    public void broadcast(Nation nation, Object... message) {
        broadcast(nation, Text.of(message));
    }

    @Override
    public void broadcast(Nation nation, Text text) {
        nation.getMessageChannel().send(text);
    }
}
