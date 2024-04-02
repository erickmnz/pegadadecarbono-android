package com.lmz.pegadadecarnono.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lmz.pegadadecarnono.R;
import com.lmz.pegadadecarnono.databinding.FragmentFinalPageBinding;


public class FinalPage extends Fragment {
    private FragmentFinalPageBinding binding;



    public FinalPage() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFinalPageBinding.inflate(inflater,container,false);
        Bundle bundle = getArguments();
        if (bundle != null) {
            String value = bundle.getString("value");
            if (value != null) {
                binding.result.setText(value);
            } else {
                Log.e("FinalPage", "Valor 'value' está ausente no Bundle.");
            }
        } else {
            Log.e("FinalPage", "Bundle está nulo.");
        }
        return binding.getRoot();
    }

}