package com.lmz.pegadadecarnono.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lmz.pegadadecarnono.R;
import com.lmz.pegadadecarnono.databinding.FragmentQuestionThreeBinding;
import com.lmz.pegadadecarnono.interfaces.FragmentToActivity;


public class QuestionThree extends Fragment implements FragmentToActivity {
    private FragmentQuestionThreeBinding binding;
    private QuestionListener listener;
    public interface QuestionListener{
        void onQuestionThreeInput(String input);
    }

    public QuestionThree() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof QuestionListener){
            listener=(QuestionListener) context;
        }else{
            throw new RuntimeException(context.toString()
                    + " deve implementar a interface OnQuestionThreeDataListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentQuestionThreeBinding.inflate(inflater,container,false);
        binding.contaCombustivel.setText(String.valueOf(0.00f));
        binding.contaCombustivel.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                binding.contaCombustivel.setText("");
            }
        });
        return binding.getRoot();
    }



    @Override
    public boolean sendToActivity() {
        if(listener==null|| binding.contaCombustivel.getText().toString().isEmpty()){
            return false;
        }
        String text=binding.contaCombustivel.getText().toString();
        listener.onQuestionThreeInput(text);
        return true;
    }
}