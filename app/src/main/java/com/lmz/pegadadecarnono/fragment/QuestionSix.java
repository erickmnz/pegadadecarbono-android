package com.lmz.pegadadecarnono.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lmz.pegadadecarnono.R;
import com.lmz.pegadadecarnono.databinding.FragmentQuestionSixBinding;


public class QuestionSix extends Fragment {
    private FragmentQuestionSixBinding binding;


    public QuestionSix() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentQuestionSixBinding.inflate(inflater, container,false);
        return binding.getRoot();
    }
}