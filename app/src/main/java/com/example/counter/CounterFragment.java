package com.example.counter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class CounterFragment extends Fragment {
    private ImageView image_view;
    private TextView textView, cicleCount;
    private ImageView btn_plus;
    private TextView zero;
    private Animation mFadeInAnimation, mFadeOutAnimation;
    int count = 0;
    int count2 = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_counter, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn_plus = view.findViewById(R.id.btn_plus);
        zero = view.findViewById(R.id.zero);
        cicleCount = view.findViewById(R.id.cikle_count);
        image_view = view.findViewById(R.id.image_view);
        mFadeInAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.fadein);
        mFadeOutAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.fadeout);
        mFadeInAnimation.setAnimationListener(animationFadeInListener);
        mFadeOutAnimation.setAnimationListener(animationFadeOutListener);

        // при запуске начинаем с анимации исчезновения
        image_view.startAnimation(mFadeOutAnimation);
        btn_plus.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (count == 33){
                    count = 0;
                    count2++;
                    cicleCount.setText(String.valueOf(count2));
                }else {
                    count++;
                }
                zero.setText(String.valueOf(count));
            }
        });
    }



    @Override
    public void onPause() {
        super.onPause();
        image_view.clearAnimation();
    }

    Animation.AnimationListener animationFadeOutListener = new Animation.AnimationListener() {

        @Override
        public void onAnimationEnd(Animation animation) {
            image_view.startAnimation(mFadeInAnimation);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onAnimationStart(Animation animation) {
            // TODO Auto-generated method stub
        }

    };


    Animation.AnimationListener animationFadeInListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationEnd(Animation animation) {
            image_view.startAnimation(mFadeOutAnimation);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onAnimationStart(Animation animation) {
            // TODO Auto-generated method stub
        }

    };

}
