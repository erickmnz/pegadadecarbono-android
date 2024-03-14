package com.lmz.pegadadecarnono.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lmz.pegadadecarnono.R;
import com.lmz.pegadadecarnono.databinding.FragmentQuestionFourBinding;
import com.lmz.pegadadecarnono.interfaces.FragmentToActivity;


public class QuestionFour extends Fragment implements FragmentToActivity {
    private QuestionListener listener;
    private FragmentQuestionFourBinding binding;

    @Override
    public boolean sendToActivity() {
        if(listener==null||binding.quilometragem.getText().toString().isEmpty()){
            return false;
        }
        String text=binding.quilometragem.getText().toString();
        listener.onQuestionFourInput(text);
        return true;
    }

    public interface QuestionListener{
        void onQuestionFourInput(String input);
    }
    public QuestionFour() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentQuestionFourBinding.inflate(inflater,container,false);
        binding.quilometragem.setText(String.valueOf(0.00f));
        binding.quilometragem.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                binding.quilometragem.setText("");
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
                    + " deve implementar a interface OnQuestionFourDataListener");
        }
    }
}