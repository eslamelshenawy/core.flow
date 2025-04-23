package com.core.flow.shared.data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExternalPartyStatus {

    ACTIVE("active"),
    INACTIVE("inactive"),
    BLOCK("block"),
    DELETED("deleted");

    private final String name;

}
