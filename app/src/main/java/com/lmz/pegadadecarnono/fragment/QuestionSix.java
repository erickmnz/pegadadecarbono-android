package com.lmz.pegadadecarnono.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.lmz.pegadadecarnono.R;
import com.lmz.pegadadecarnono.databinding.FragmentQuestionSixBinding;
import com.lmz.pegadadecarnono.interfaces.FragmentToActivity;


public class QuestionSix extends Fragment implements FragmentToActivity {
    private FragmentQuestionSixBinding binding;
    private QuestionListener listener;
    @Override
    public boolean sendToActivity() {
        if(listener==null){
            return false;
        }
        boolean btn1 =binding.radioButton.isChecked();
        boolean btn2 = binding.radioButton4.isChecked();
        listener.onQuestionSixInput(btn1,btn2);
        return true;
    }

    public interface QuestionListener{
        void onQuestionSixInput(boolean input1, boolean input2);
    }

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

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof  QuestionListener){
            listener = (QuestionListener) context;
        }else{
            throw new RuntimeException(context.toString()
                    + " deve implementar a interface OnQuestionSixListener");
        }
    }
}