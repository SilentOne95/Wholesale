package com.bobbiny.wholesale.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.bobbiny.wholesale.data.Injection;
import com.bobbiny.wholesale.data.WholesaleDataSource;
import com.bobbiny.wholesale.data.WholesaleRepository;
import com.bobbiny.wholesale.data.local.entity.Contractor;

public class DetailViewModel extends AndroidViewModel {

    private WholesaleRepository mRepository;
    private MutableLiveData<Contractor> mContractor;

    public MutableLiveData<String> firstName = new MutableLiveData<>();
    public MutableLiveData<String> lastName = new MutableLiveData<>();
    public MutableLiveData<String> country = new MutableLiveData<>();
    public MutableLiveData<String> currency = new MutableLiveData<>();

    public DetailViewModel(@NonNull Application application) {
        super(application);
        mRepository = Injection.provideWholesaleRepository(getApplication());
    }

    public MutableLiveData<Contractor> getContractors(int id) {
        if (mContractor == null) {
            mContractor = new MutableLiveData<>();
            getData(id);
        }

        return mContractor;
    }

    private void getData(int id) {
        mRepository.getSingleContractor(id, new WholesaleDataSource.GetSingleDataCallback() {
            @Override
            public void onDataLoaded(Object object) {
                mContractor.setValue((Contractor) object);
            }

            @Override
            public void onDataNotAvailable() { }
        });
    }
}
