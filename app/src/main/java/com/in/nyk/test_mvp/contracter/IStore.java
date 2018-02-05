package com.in.nyk.test_mvp.contracter;

import com.in.nyk.test_mvp.model.StoreType;

/**
 *  * Helps us track the relationship between the View and the Presenter in a central place.
 * Created by nikhilkanse on 05/02/18.
 */

public interface IStore {

    /** Represents the View in MVP. */
    interface View {
        void showMessage(String message);

        void showError(String error);
    }

    /** Represents the Presenter in MVP. */
    interface Presenter {
        void loadMessage();

        void saveStore(String storeName);

        void setStoretype(StoreType storetype);
    }

}
