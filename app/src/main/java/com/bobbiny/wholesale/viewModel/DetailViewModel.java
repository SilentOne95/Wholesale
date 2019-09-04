package com.bobbiny.wholesale.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.bobbiny.wholesale.data.Injection;
import com.bobbiny.wholesale.data.WholesaleDataSource;
import com.bobbiny.wholesale.data.WholesaleRepository;
import com.bobbiny.wholesale.data.local.entity.Contractor;

import java.util.List;

public class DetailViewModel extends AndroidViewModel {

    private WholesaleRepository mRepository;
    private MutableLiveData<List<Contractor>> mListContractor;

    public MutableLiveData<String> firstName = new MutableLiveData<>();
    public MutableLiveData<String> lastName = new MutableLiveData<>();
    public MutableLiveData<String> country = new MutableLiveData<>();
    public MutableLiveData<String> currency = new MutableLiveData<>();

    public DetailViewModel(@NonNull Application application) {
        super(application);
        mRepository = Injection.provideWholesaleRepository(getApplication());
    }

    public MutableLiveData<List<Contractor>> getContractors() {
        if (mListContractor == null) {
            mListContractor = new MutableLiveData<>();
            getData();
        }

        return mListContractor;
    }

    private void getData() {
        mRepository.getAllContractors(new WholesaleDataSource.LoadDataCallback() {
            @Override
            public void onDataLoaded(List<?> data) {
                mListContractor.setValue((List<Contractor>) data);
            }

            @Override
            public void onDataNotAvailable() { }
        });
    }
}
