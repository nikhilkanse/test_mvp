package com.in.nyk.test_mvp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.in.nyk.test_mvp.R;
import com.in.nyk.test_mvp.component.DaggerStoreComponent;
import com.in.nyk.test_mvp.contracter.IStore;
import com.in.nyk.test_mvp.model.Store;
import com.in.nyk.test_mvp.model.StoreType;
import com.in.nyk.test_mvp.module.StoreModule;
import com.in.nyk.test_mvp.presenter.StorePresenter;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements IStore.View,View.OnClickListener{

    @Inject
    StorePresenter presenter;
    //UI properties
    private TextView messageView;
    private EditText storeNameEditText;
    private RadioButton retailRadioButton;
    private RadioButton holeSaleRadioButtton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        // Creates presenter
        DaggerStoreComponent.builder().storeModule(new StoreModule(this,new Store())).build().inject(this);
    }

    private void initViews() {
        messageView = (TextView) findViewById(R.id.message);
        storeNameEditText = (EditText) findViewById(R.id.storeName);
        retailRadioButton = (RadioButton) findViewById(R.id.retail);
        holeSaleRadioButtton = (RadioButton) findViewById(R.id.holeSale);

        findViewById(R.id.update).setOnClickListener(this);
        findViewById(R.id.showMessage).setOnClickListener(this);

        retailRadioButton.setOnClickListener(this);
        holeSaleRadioButtton.setOnClickListener(this);

    }

    @Override
    public void showMessage(String message) {
        messageView.setText(message);
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.update:
                presenter.saveStore(storeNameEditText.getText().toString());
                break;
            case R.id.showMessage:
                presenter.loadMessage();
                break;
            case R.id.retail:
                holeSaleRadioButtton.setChecked(false);
                presenter.setStoretype(StoreType.StoreTypeRetail);
                break;
            case  R.id.holeSale:
                retailRadioButton.setChecked(false);
                presenter.setStoretype(StoreType.StoreTypeHolesale);
                break;
        }
    }
}
