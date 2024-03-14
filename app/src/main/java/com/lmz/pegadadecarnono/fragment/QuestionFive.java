package com.lmz.pegadadecarnono.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lmz.pegadadecarnono.R;
import com.lmz.pegadadecarnono.databinding.FragmentQuestionFiveBinding;
import com.lmz.pegadadecarnono.interfaces.FragmentToActivity;


public class QuestionFive extends Fragment implements FragmentToActivity {
    private FragmentQuestionFiveBinding binding;
    private QuestionListener listener;

    @Override
    public boolean sendToActivity() {
        if(listener==null||binding.voos3.getText().toString().isEmpty()||binding.voos4.getText()
                .toString().isEmpty()){
            return false;
        }
        String text1 = binding.voos3.getText().toString();
        String text2 = binding.voos4.getText().toString();
        listener.onQuestionFiveInput(text1,text2);
        return true;
    }

    public interface QuestionListener{
        void onQuestionFiveInput(String input1, String input2);
    }

    public QuestionFive() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentQuestionFiveBinding.inflate(inflater,container,false);
        binding.voos3.setText(String.valueOf(0.00f));
        binding.voos3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                binding.voos3.setText("");
            }
        });
        binding.voos4.setText(String.valueOf(0.00f));
        binding.voos4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                binding.voos4.setText("");
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof QuestionListener){
            listener=(QuestionListener) context;
        }else{
            throw new RuntimeException(context.toString()
                    + " deve implementar a interface OnQuestionFiveDataListener");
        }
    }
}