package com.lmz.pegadadecarnono.activity;

import static android.app.ProgressDialog.show;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.lmz.pegadadecarnono.databinding.ActivityMainBinding;
import com.lmz.pegadadecarnono.fragment.FinalPage;
import com.lmz.pegadadecarnono.fragment.FrontPage;
import com.lmz.pegadadecarnono.fragment.QuestionFive;
import com.lmz.pegadadecarnono.fragment.QuestionFour;
import com.lmz.pegadadecarnono.fragment.QuestionOne;
import com.lmz.pegadadecarnono.fragment.QuestionSix;
import com.lmz.pegadadecarnono.fragment.QuestionThree;
import com.lmz.pegadadecarnono.fragment.QuestionTwo;

public class MainActivity extends AppCompatActivity implements QuestionOne.QuestionListener,
        QuestionTwo.QuestionListener, QuestionThree.QuestionListener, QuestionFour.QuestionListener,
        QuestionFive.QuestionListener, QuestionSix.QuestionListener{
    private ActivityMainBinding binding;
    private int n;
    private float sum;
    private float[] nums=new float[8];
    private FrontPage fp;
    private QuestionOne q1;
    private QuestionTwo q2;
    private QuestionThree q3;
    private QuestionFour q4;
    private  QuestionFive q5;
    private QuestionSix q6;
    private FinalPage ep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        n=0;
        sum=0;
        fp=new FrontPage();
        q1=new QuestionOne();
        q2=new QuestionTwo();
        q3=new QuestionThree();
        q4=new QuestionFour();
        q5=new QuestionFive();
        q6=new QuestionSix();
        ep=new FinalPage();
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
                    fm.beginTransaction()
                            .addToBackStack(null)
                            .replace(binding.fragcontainer.getId(),q3,"Question3")
                            .commit();
                    n++;
                    break;
                }
                case 3:{
                    if(!q3.sendToActivity()){
                        Toast.makeText(this,"Insira um valor!",Toast.LENGTH_SHORT)
                                .show();
                        break;
                    }
                    fm.beginTransaction()
                            .addToBackStack(null)
                            .replace(binding.fragcontainer.getId(),q4,"Question4")
                            .commit();
                    n++;
                    break;
                }
                case 4:{
                    if(!q4.sendToActivity()){
                        Toast.makeText(this,"Insira um valor!",Toast.LENGTH_SHORT)
                                .show();
                        break;
                    }
                    fm.beginTransaction()
                            .addToBackStack(null)
                            .replace(binding.fragcontainer.getId(),q5,"Question5")
                            .commit();
                    n++;
                    break;
                }
                case 5:{
                    if(!q5.sendToActivity()){
                        Toast.makeText(this,"Insira um valor!",Toast.LENGTH_SHORT)
                                .show();
                        break;
                    }
                    fm.beginTransaction()
                            .addToBackStack(null)
                            .replace(binding.fragcontainer.getId(),q6,"Question6")
                            .commit();
                    binding.proximo.setText("Confirmar");
                    n++;
                    break;
                }
                case 6:{
                    if(!q6.sendToActivity()){
                        Toast.makeText(this,"Insira um valor!",Toast.LENGTH_SHORT)
                                .show();
                        break;
                    }

                    binding.proximo.setVisibility(View.INVISIBLE);
                    for(float num:nums){
                        sum+=num;
                    }
                    sum/=907.2f;
                    Bundle bundle = new Bundle();
                    bundle.putString("value",String.format("%.2f",sum));
                    ep.setArguments(bundle);
                    fm.beginTransaction()
                            .addToBackStack(null)
                            .replace(binding.fragcontainer.getId(),ep,"FinalPage")
                            .commit();
                    n++;
                    break;
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
                  fm.popBackStack();
                  nums[2]=0f;
                  n--;
                  break;
              }
              case 4: {
                  fm.popBackStack();
                  nums[3]=0f;
                  n--;
                  break;
              }
              case 5:{
                  fm.popBackStack();
                  nums[4]=0f;
                  nums[5]=0f;
                  n--;
                  break;
              }
              case 6:{
                  fm.popBackStack();
                  nums[6]=0f;
                  nums[7]=0f;
                  binding.proximo.setText("Próximo");
                  n--;
                  break;
              }
              case 7:{
                  binding.proximo.setVisibility(View.VISIBLE);
                  fm.popBackStack();
                  n--;
                  break;
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
        nums[1]=Float.parseFloat(input)*105f;
    }

    @Override
    public void onQuestionThreeInput(String input) {
        nums[2]=(Float.parseFloat(input)/1609)*113f;
    }

    @Override
    public void onQuestionFourInput(String input) {
        nums[3]=Float.parseFloat(input)*0.79f;
    }
    @Override
    public void onQuestionFiveInput(String input1, String input2) {
        nums[4]=Float.parseFloat(input1)*1100f;
        nums[5]=Float.parseFloat(input2)*4400f;
    }

    @Override
    public void onQuestionSixInput(boolean input1, boolean input2) {
        nums[6]=0f;
        nums[7]=0f;
        if(!input1){
            nums[6]=184;
        }
        if(!input2){
            nums[7]=166;
        }
    }
}