package com.in.nyk.test_mvp.presenter;

import com.in.nyk.test_mvp.contracter.IStore;
import com.in.nyk.test_mvp.model.Store;
import com.in.nyk.test_mvp.model.StoreType;

/**
 * Created by nikhilkanse on 05/02/18.
 */

public class StorePresenter implements IStore.Presenter {

    private Store store;
    private IStore.View view;
    private StoreType storeType;

    public StorePresenter(IStore.View view) {
        this.store = new Store();
        this.view = view;
        storeType = StoreType.StoreTypeRetail;
    }

    @Override
    public void loadMessage() {
        if (store.getStoreName() == null || store.getStoreName().isEmpty()) {
            view.showError("No store name found.");
            return;
        }

        String message = "Welcome to " + store.getStoreName()  + " " + "shop.";
        view.showMessage(message);
    }

    @Override
    public void saveStore(String storeName) {
        store.setStoreName(storeName);
        store.setStoreType(storeType);
    }

    @Override
    public void setStoretype(StoreType storetype) {
        this.storeType = storetype;
    }

}
