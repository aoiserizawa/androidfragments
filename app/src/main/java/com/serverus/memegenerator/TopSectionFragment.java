package com.serverus.memegenerator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by alvinvaldez on 1/10/15.
 */
public class TopSectionFragment extends Fragment {

    private static EditText topTextInput;
    private static EditText bottomTextInput;

    //interface
    TopSectionListener activityCommander;

    //create an interface
    public interface TopSectionListener{
        public void createMeme(String top, String bottom);
    }

    @Override
    public void onAttach(Activity activity) {
       try{
           activityCommander = (TopSectionListener) activity;
       }catch (ClassCastException e){
           throw new ClassCastException(activity.toString());
       }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.top_section_fragment, container, false);

        topTextInput = (EditText) view.findViewById(R.id.topTextInput);
        bottomTextInput = (EditText) view.findViewById(R.id.bottomTextInput);

        final Button button = (Button) view.findViewById(R.id.button);

        button.setOnClickListener(
            new View.OnClickListener(){
                public void onClick(View v){
                    buttonClicked(v);
                }
            }
        );

        return view;
    }

    //Call this when button is clicked
    public void buttonClicked(View view){
        //use the interface
        activityCommander.createMeme(topTextInput.getText().toString(), bottomTextInput.getText().toString());
    }
}
