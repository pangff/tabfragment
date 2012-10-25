package com.example.tabfragmentdemo;

import android.support.v4.app.Fragment;

public class MyFragment extends Fragment implements FragmentInterface{

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		this.getActivity().finish();
	}

}
