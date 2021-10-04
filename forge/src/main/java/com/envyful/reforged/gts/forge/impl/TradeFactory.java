package com.envyful.reforged.gts.forge.impl;

import com.envyful.reforged.gts.api.Trade;
import com.envyful.reforged.gts.forge.impl.trade.ForgeTrade;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class TradeFactory {

    public static Trade fromResultSet(ResultSet resultSet) throws SQLException {
        return ForgeTrade.builder()
                .cost(resultSet.getDouble("cost"))
                .expiry(resultSet.getLong("expiry"))
                .owner(UUID.fromString(resultSet.getString("owner")))
                .content(resultSet.getString("content_type"))
                .contents(resultSet.getString("contents"))
                .build();
    }

}
