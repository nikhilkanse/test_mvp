package com.in.nyk.test_mvp.component;

import com.in.nyk.test_mvp.module.StoreModule;
import com.in.nyk.test_mvp.ui.MainActivity;

import dagger.Component;

/**
 * Created by nikhilkanse on 05/02/18.
 */

@Component(modules = StoreModule.class) public interface StoreComponent {

    void inject(MainActivity mainActivity);

}


