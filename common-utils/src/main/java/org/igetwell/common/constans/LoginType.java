package org.igetwell.common.constans;

public enum LoginType {

    WECHAT(1), ALI_PAY(2);

    LoginType(int value) {
        this.value = value;
    }

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
