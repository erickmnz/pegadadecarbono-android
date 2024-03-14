package com.lmz.pegadadecarnono.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lmz.pegadadecarnono.databinding.FragmentQuestion2Binding;
import com.lmz.pegadadecarnono.interfaces.FragmentToActivity;


public class QuestionTwo extends Fragment implements FragmentToActivity {
    private FragmentQuestion2Binding binding;
    private QuestionListener listener;
    public interface QuestionListener{
        void onQuestionTwoInput(String input);
    }


    public QuestionTwo() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentQuestion2Binding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof QuestionOne.QuestionListener) {
            listener = (QuestionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " deve implementar a interface OnQuestion1DataListener");
        }
    }

    @Override
    public boolean sendToActivity() {
        if(listener==null||binding.contaGas.getText().toString().isEmpty()){
            return false;
        }
        String text = binding.contaGas.getText().toString();
        listener.onQuestionTwoInput(text);
        return true;
    }
}