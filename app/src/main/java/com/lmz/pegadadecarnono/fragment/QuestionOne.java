package com.lmz.pegadadecarnono.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lmz.pegadadecarnono.databinding.FragmentQuestionOneBinding;
import com.lmz.pegadadecarnono.interfaces.FragmentToActivity;


public class QuestionOne extends Fragment implements FragmentToActivity {
    private FragmentQuestionOneBinding binding;
    private QuestionListener listener;

    public interface QuestionListener{
        void onQuestionOneinput(String input);
    }


    public QuestionOne() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof QuestionListener) {
            listener = (QuestionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " deve implementar a interface OnQuestionOneDataListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentQuestionOneBinding.inflate(inflater, container, false);
        binding.contaLuz.setText(String.valueOf(0.00f));
        binding.contaLuz.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                binding.contaLuz.setText("");
            }
        });
        return binding.getRoot();
    }

    @Override
    public boolean sendToActivity(){
        if(listener==null||binding.contaLuz.getText().toString().isEmpty()){
            return false;
        }
        String text = binding.contaLuz.getText().toString();
        listener.onQuestionOneinput(text);
        return true;
    }

}




