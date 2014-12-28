package com.swarup.kayhan.voice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Kayhan on 12/28/2014.
 */
public class Login extends Fragment {
    View view;
    MySqlHelper dbHelper;

    User user;
    EditText userId,password,userName;

    Button signUp;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.login,container,false);
        userId = (EditText)view.findViewById(R.id.userId_signup);
        password= (EditText)view.findViewById(R.id.password_signup);
        userName = (EditText)view.findViewById(R.id.fullname);
        dbHelper = new MySqlHelper(getActivity(),null,null,0);
        signUp = (Button)view.findViewById(R.id.sign_up_button);
        signUp.setOnClickListener(new MyListener());

        return view;
    }
    class MyListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if(v.getId()==R.id.sign_up){
                if(!userId.getText().equals("")&&!password.equals("")){
                    user = new User();
                    user.setUserId(userId.getText().toString());
                    user.setPassword(password.getText().toString());
                    user.setUserName(userName.getText().toString());
                    if(dbHelper!=null)
                    dbHelper.addUser(user);
                }
            }
        }
    }
}
