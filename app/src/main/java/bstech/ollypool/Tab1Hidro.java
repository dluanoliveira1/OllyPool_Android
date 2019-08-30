package bstech.ollypool;

/**
 * Created by David on 28/01/2018.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Tab1Hidro extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.tab1hidro, container, false);


       /* NumberPicker picker = (NumberPicker) rootView.findViewById(R.id.numberPicker);
        picker.setMinValue(0);
        picker.setMaxValue(10);
        picker.getDisplay();

        NumberPicker picker2 = (NumberPicker) rootView.findViewById(R.id.numberPicker2);
        picker2.setMinValue(0);
        picker2.setMaxValue(59);
        picker2.getDisplay();*/

        return rootView;
    }

}
