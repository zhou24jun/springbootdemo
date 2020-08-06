package com.example.demo.framework;

public enum ChannelRuleEnum {
    TX("tencent", new TxChannelRule()),
    SINA("sina", new SinaChannelRule());

    private String name;

    private GeneralChannelRule channel;

    ChannelRuleEnum(String name, GeneralChannelRule channel) {
        this.name = name;
        this.channel = channel;
    }

    public static ChannelRuleEnum match(String name) {
        ChannelRuleEnum[] values = ChannelRuleEnum.values();
        for (ChannelRuleEnum value : values) {
            if (value.name.equals(name)) {
                return value;
            }
        }
        return null;
    }


}
