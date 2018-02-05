package com.in.nyk.test_mvp.model;

/**
 * Created by nikhilkanse on 05/02/18.
 */

public class Store {

    private String storeName;
    private StoreType storeType;

    public Store(String storeName, StoreType storeType) {
        this.storeName = storeName;
        this.storeType = storeType;
    }

    public Store() {

    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public StoreType getStoreType() {
        return storeType;
    }

    public void setStoreType(StoreType storeType) {
        this.storeType = storeType;
    }
}
