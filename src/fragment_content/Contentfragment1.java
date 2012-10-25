package fragment_content;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tabfragmentdemo.MyFragment;
import com.example.tabfragmentdemo.R;

public class Contentfragment1 extends MyFragment{
	public Contentfragment1(){
	}
	TextView mTextView; // 显示的内容
	ImageView img_netease_top;
	Button goNext;
	View innerView;
	View outerView;
	private FrameLayout fragment_frame1;
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
		// super.onCreateView(inflater, container, savedInstanceState);
		// Inflate the layout for this fragment
		// TextView testText = (TextView)findViewById(R.id.item_detail);
		
		return inflater.inflate(R.layout.fragment_frame1, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
			
		outerView  = getActivity().getLayoutInflater().inflate(R.layout.fragment_content10, null);
		
		fragment_frame1 = (FrameLayout) getActivity().findViewById(R.id.fragment_frame1);
		fragment_frame1.addView(outerView);
		
		mTextView = (TextView) getActivity().findViewById(
				R.id.fragment_context_context);
		
		img_netease_top =  (ImageView) getActivity().findViewById(
				R.id.img_netease_top);
		goNext = (Button) this.getActivity().findViewById(R.id.goNext);

		
		initHandler();
	}
	
	private void initHandler(){
		
	    img_netease_top.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
	
		goNext.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				outerView.setVisibility(View.GONE);
				innerView = getActivity().getLayoutInflater().inflate(R.layout.fragment_content11, null);
				fragment_frame1.addView(innerView);
			}
		});
	}
	
	public void onBackPressed() {
		if(innerView!=null && innerView.getVisibility()==View.VISIBLE){
			innerView.setVisibility(View.GONE);
			outerView.setVisibility(View.VISIBLE);
		}else{
			this.getActivity().finish();
		}
		return;
	}
}
