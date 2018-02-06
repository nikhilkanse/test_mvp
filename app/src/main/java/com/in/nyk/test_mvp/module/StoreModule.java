package com.in.nyk.test_mvp.module;

import com.in.nyk.test_mvp.contracter.IStore;
import com.in.nyk.test_mvp.model.Store;

import dagger.Module;
import dagger.Provides;

/**
 * Created by nikhilkanse on 05/02/18.
 */
@Module public class StoreModule {

    private final IStore.View view;

    private final Store person;

    public StoreModule(IStore.View view, Store person) {
        this.view = view;
        this.person = person;
    }

    @Provides
    IStore.View provideView() {
        return view;
    }

    @Provides
    Store provideStore() {
        return person;
    }

}
