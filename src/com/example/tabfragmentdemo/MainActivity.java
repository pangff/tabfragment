package com.example.tabfragmentdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import fragment_content.Contentfragment1;
import fragment_content.Contentfragment11;
import fragment_content.Contentfragment2;

public class MainActivity extends FragmentActivity {

	RadioGroup radioGroup;
	ImageView img;
	int startLeft;
	RelativeLayout bottom_layout;
	FrameLayout frameLayout;
	public MyFragment currentFragment;
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		bottom_layout = (RelativeLayout) findViewById(R.id.layout_bottom);

		frameLayout = (FrameLayout) findViewById(R.id.tabcontent);

		radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
		radioGroup.setOnCheckedChangeListener(checkedChangeListener);

		img = new ImageView(this);
		img.setImageResource(R.drawable.tab_front_bg);
		bottom_layout.addView(img);

		showDetails("news");
	}

	// 当Tab发生变化时，改变tab的标签的显示图片
	private OnCheckedChangeListener checkedChangeListener = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {

			switch (checkedId) {

			case R.id.radio_news:

				startLeft = 0;
				showDetails("news");
				Log.d("tag", "!!!! = " + 0);
				break;
			case R.id.radio_topic:
				// fragment.changeContent(1);
				// fragmentTopic.changeContent(1);

				// tabHost.setCurrentTabByTag("topic");
				// MoveBg.moveFrontBg(img, startLeft, img.getWidth(), 0, 0);
				startLeft = img.getWidth();
				showDetails("talk");
				break;
			case R.id.radio_pic:
				// fragment.changeContent(2);
				// fragmentTopic.changeContent(2);

				// tabHost.setCurrentTabByTag("picture");
				// MoveBg.moveFrontBg(img, startLeft, img.getWidth() * 2, 0, 0);
				startLeft = img.getWidth() * 2;
				Log.d("tag", "!!!! = " + 2);
				break;
			case R.id.radio_follow:
				// fragment.changeContent(3);
				// fragmentTopic.changeContent(3);

				// tabHost.setCurrentTabByTag("follow");
				// MoveBg.moveFrontBg(img, startLeft, img.getWidth() * 3, 0, 0);
				startLeft = img.getWidth() * 3;
				Log.d("tag", "!!!! = " + 3);
				break;
			case R.id.radio_vote:
				// fragment.changeContent(4);
				// fragmentTopic.changeContent(4);

				// tabHost.setCurrentTabByTag("vote");
				// MoveBg.moveFrontBg(img, startLeft, img.getWidth() * 4, 0, 0);
				startLeft = img.getWidth() * 4;
				Log.d("tag", "!!!! = " + 4);
				break;

			default:
				break;
			}
		}
	};

	/**
	 * 显示listview item 详情
	 */
	public void showDetails(String tag) {
		
		Fragment fragment = getSupportFragmentManager().findFragmentByTag(tag);
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		if(fragment==null){
			if(tag.equals("news")){
				fragment = new Contentfragment1();
			}else if(tag.equals("talk")){
				fragment = new Contentfragment2();
			}else if(tag.equals("content11")){
				fragment  = new Contentfragment11();
			}
			ft.add(R.id.tabcontent, fragment,tag);
			ft.setTransition(FragmentTransaction.TRANSIT_ENTER_MASK);
		}
		if(currentFragment!=null){
			ft.hide(currentFragment);
			ft.show(fragment);
			ft.commit();
		}else{
			ft.commit();
		}
		currentFragment = (MyFragment) fragment;
	}
	
	public void onBackPressed() {
		currentFragment.onBackPressed();
		return;
	}
}