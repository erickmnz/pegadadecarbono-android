package com.lmz.pegadadecarnono.activity;

import static android.app.ProgressDialog.show;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.lmz.pegadadecarnono.databinding.ActivityMainBinding;
import com.lmz.pegadadecarnono.fragment.FrontPage;
import com.lmz.pegadadecarnono.fragment.QuestionOne;
import com.lmz.pegadadecarnono.fragment.QuestionTwo;

public class MainActivity extends AppCompatActivity implements QuestionOne.QuestionListener, QuestionTwo.QuestionListener{
    private ActivityMainBinding binding;
    private int n;
    private float sum;
    private float[] nums=new float[9];
    private FrontPage fp;
    private QuestionOne q1;
    private QuestionTwo q2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        n=0;
        sum=0;
        fp=new FrontPage();
        q1=new QuestionOne();
        q2=new QuestionTwo();
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        binding.voltar.setVisibility(View.INVISIBLE);
        View view = binding.getRoot();
        setContentView(view);

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .addToBackStack(null)
                .add(binding.fragcontainer.getId(), fp,"FrontPage")
                .commit();
        binding.proximo.setOnClickListener(v -> {
            binding.voltar.setVisibility(View.VISIBLE);
            switch (n){
                case 0:{
                    fm.beginTransaction()
                            .addToBackStack(null)
                            .replace(binding.fragcontainer.getId(), q1,"Question1")
                            .commit();
                    n++;
                    break;
                }
                case 1:{
                    if(!q1.sendToActivity()){
                        Toast.makeText(this,"Insira um valor!",Toast.LENGTH_SHORT)
                                .show();
                        break;
                    }
                    fm.beginTransaction()
                            .addToBackStack(null)
                            .replace(binding.fragcontainer.getId(),q2,"Question2")
                            .commit();
                    n++;
                    break;
                }
                case 2:{
                    if(!q2.sendToActivity()){
                        Toast.makeText(this,"Insira um valor!",Toast.LENGTH_SHORT)
                                .show();
                        break;
                    }
                }
            }
        });
        binding.voltar.setOnClickListener(v -> {
          switch (n){
              case 1:{
                  fm.popBackStack();
                  nums[0]=0f;
                  binding.voltar.setVisibility(View.INVISIBLE);
                  n--;
                  break;
              }
              case 2:{
                  fm.popBackStack();
                  nums[1]=0f;
                  n--;
                  break;
              }
              case 3:{

              }
              case 4: {

              }
          }


        });
    }


    @Override
    public void onQuestionOneinput(String input) {
        nums[0]=Float.parseFloat(input)*105;
    }

    @Override
    public void onQuestionTwoInput(String input) {
        nums[1]=Float.parseFloat(input)*105;
    }
}