package com.yadhukrishnane.navigation;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private AppCompatEditText edtUsername;

    public MainFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {

        edtUsername = view.findViewById(R.id.edt_main_username);

        AppCompatTextView tvGoToFirstPage = view.findViewById(R.id.tv_main_go_to_first_page);
        tvGoToFirstPage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (edtUsername == null || edtUsername.getText() == null) return;

                String username = edtUsername.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString(Constants.BundleKeys.MAIN_USERNAME, username);
                NavController controller = Navigation.findNavController(view);
                controller.navigate(R.id.action_mainFragment_to_firstFragment, bundle);
            }
        });

    }
}
