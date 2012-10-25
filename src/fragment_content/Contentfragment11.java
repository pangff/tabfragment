package fragment_content;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tabfragmentdemo.MyFragment;
import com.example.tabfragmentdemo.R;

public class Contentfragment11 extends MyFragment {
	public Contentfragment11(){
	}
	TextView mTextView; // 显示的内容
	ImageView img_netease_top;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.v("Contentfragment", "Contentfragment_onCreate");
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.v("Contentfragment", "Contentfragment_onCreateView");
		return inflater.inflate(R.layout.fragment_content11, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		mTextView = (TextView) getActivity().findViewById(
				R.id.fragment_context_context);
		
		img_netease_top =  (ImageView) getActivity().findViewById(
				R.id.img_netease_top);
	}
	
	public void onBackPressed() {
		return;
	}


}
