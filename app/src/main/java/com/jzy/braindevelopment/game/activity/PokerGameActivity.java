package com.jzy.braindevelopment.game.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jzy.braindevelopment.R;
import com.jzy.braindevelopment.comment.InitActivity;
import com.jzy.braindevelopment.game.GameInitiator;
import com.jzy.braindevelopment.game.PokerGame;
import com.jzy.braindevelopment.view.CircleTimerView;
import com.jzy.braindevelopment.view.adapter.GridViewAdapter;
import java.util.ArrayList;
import java.util.List;

public class PokerGameActivity extends AppCompatActivity implements CircleTimerView.OnCountDownFinish {
    public static final String TAG = "Debug";
    private ConstraintLayout gameViewLayout;
    private int x = 0;
    private PokerGame pokerGame;
    private Integer phoneType = 1;
    private Integer gameGrade;
    private Integer currNum = 0;
    private Activity activity;

    private CircleTimerView mCircleTimerView;

    private GridView gridView;

    private List<Integer> idList = new ArrayList<>();
    //黑桃
    List<Integer> spadePoker = new ArrayList<>();

    //红心
    List<Integer> heartsPoker = new ArrayList<>();

    //方块
    List<Integer> diamondsPoker = new ArrayList<>();

    //梅花
    private List<Integer> clubsPoker = new ArrayList<>();

    private List<Integer> pokerList = new ArrayList<>();
    //适配器
    private GridViewAdapter adapter;
    //花色选择器
    private Toolbar pokerBar;
    private ConstraintSet constraintSet = new ConstraintSet();
    private int answerCount;
    //随机换牌
    final Integer[] pokerGroup = new Integer[]{
            R.drawable.poker3, R.drawable.poker4, R.drawable.poker5, R.drawable.poker6, R.drawable.poker7, R.drawable.poker8, R.drawable.poker9, R.drawable.poker10, R.drawable.poker11,
            R.drawable.poker12, R.drawable.poker13, R.drawable.poker14, R.drawable.poker15, R.drawable.poker16, R.drawable.poker17, R.drawable.poker18, R.drawable.poker19, R.drawable.poker20,
            R.drawable.poker22, R.drawable.poker23, R.drawable.poker24, R.drawable.poker25, R.drawable.poker26, R.drawable.poker27, R.drawable.poker28, R.drawable.poker29, R.drawable.poker30,
            R.drawable.poker31, R.drawable.poker32, R.drawable.poker32, R.drawable.poker33, R.drawable.poker34, R.drawable.poker35, R.drawable.poker36, R.drawable.poker37, R.drawable.poker38,
            R.drawable.poker39, R.drawable.poker40, R.drawable.poker41, R.drawable.poker42, R.drawable.poker43, R.drawable.poker44, R.drawable.poker45, R.drawable.poker46, R.drawable.poker47,
            R.drawable.poker48, R.drawable.poker49, R.drawable.poker50, R.drawable.poker51, R.drawable.poker52, R.drawable.poker53, R.drawable.poker54, R.drawable.poker21
    };

    //进入记忆扑克游戏活动
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poker_game);
        InitActivity.initTitle(this, "扑克记忆");
        activity=this;
        mCircleTimerView = (CircleTimerView) findViewById(R.id.circle_timer);
        //将牌初始化 全设置id
        clubsPoker.add(R.drawable.poker29);
        clubsPoker.add(R.drawable.poker30);
        clubsPoker.add(R.drawable.poker31);
        clubsPoker.add(R.drawable.poker32);
        clubsPoker.add(R.drawable.poker33);
        clubsPoker.add(R.drawable.poker34);
        clubsPoker.add(R.drawable.poker35);
        clubsPoker.add(R.drawable.poker36);
        clubsPoker.add(R.drawable.poker37);
        clubsPoker.add(R.drawable.poker38);
        clubsPoker.add(R.drawable.poker39);
        clubsPoker.add(R.drawable.poker40);
        clubsPoker.add(R.drawable.poker41);

        diamondsPoker.add(R.drawable.poker42);
        diamondsPoker.add(R.drawable.poker43);
        diamondsPoker.add(R.drawable.poker44);
        diamondsPoker.add(R.drawable.poker45);
        diamondsPoker.add(R.drawable.poker46);
        diamondsPoker.add(R.drawable.poker47);
        diamondsPoker.add(R.drawable.poker48);
        diamondsPoker.add(R.drawable.poker49);
        diamondsPoker.add(R.drawable.poker50);
        diamondsPoker.add(R.drawable.poker51);
        diamondsPoker.add(R.drawable.poker52);
        diamondsPoker.add(R.drawable.poker53);
        diamondsPoker.add(R.drawable.poker54);


        spadePoker.add(R.drawable.poker3);
        spadePoker.add(R.drawable.poker4);
        spadePoker.add(R.drawable.poker5);
        spadePoker.add(R.drawable.poker6);
        spadePoker.add(R.drawable.poker7);
        spadePoker.add(R.drawable.poker8);
        spadePoker.add(R.drawable.poker9);
        spadePoker.add(R.drawable.poker10);
        spadePoker.add(R.drawable.poker11);
        spadePoker.add(R.drawable.poker12);
        spadePoker.add(R.drawable.poker13);
        spadePoker.add(R.drawable.poker14);
        spadePoker.add(R.drawable.poker15);


        heartsPoker.add(R.drawable.poker16);
        heartsPoker.add(R.drawable.poker17);
        heartsPoker.add(R.drawable.poker18);
        heartsPoker.add(R.drawable.poker19);
        heartsPoker.add(R.drawable.poker20);
        heartsPoker.add(R.drawable.poker21);
        heartsPoker.add(R.drawable.poker22);
        heartsPoker.add(R.drawable.poker23);
        heartsPoker.add(R.drawable.poker24);
        heartsPoker.add(R.drawable.poker25);
        heartsPoker.add(R.drawable.poker26);
        heartsPoker.add(R.drawable.poker27);
        heartsPoker.add(R.drawable.poker28);
        pokerList = clubsPoker;
        pokerGame = (PokerGame) getIntent().getSerializableExtra("initData");
        gameGrade = Integer.valueOf(getIntent().getStringExtra("gameGrade"));
        phoneType = Integer.valueOf(getIntent().getStringExtra("phoneType"));
        adapter = new GridViewAdapter(getApplicationContext(), clubsPoker);     //默认梅花花色
        nextPoker();
        pokerBar.inflateMenu(R.menu.poker_color_menu);
        initView();
    }

    public void nextPoker() {    //下一组牌

        Log.d(TAG, "pokerGameObject" + pokerGame.getSecond() + "" + pokerGame.getEachShowCardNum());
        Log.d(TAG, "手机类型" + phoneType);
        //隐藏选牌模块
        pokerBar = findViewById(R.id.poker_color_bar);
        pokerBar.setVisibility(View.GONE);
        gridView = findViewById(R.id.diary_gridview);
        gridView.setVisibility(View.GONE);

        gameViewLayout = findViewById(R.id.game_view);
        mCircleTimerView.setVisibility(View.VISIBLE);
        TextView currPokerTxtNum = findViewById(R.id.poker_curr_num_txt);

        //结束计时回调
        currNum++;
        currPokerTxtNum.setText(currNum.toString());

        if (phoneType == 1) {      /*1080*1920类型手机*/
            x = 55;
            if (gameGrade == 2) {
                x -= 25;
            } else if (gameGrade == 3) {
                x -= 38;
            } else if (gameGrade == 4) {
                x = 3;
            }
        } else if (phoneType == 2) { /*1440*2560*/
            x = 70;
            if (gameGrade == 2) {
                x -= 7;
            } else if (gameGrade == 3) {
                x -= 30;
            } else if (gameGrade == 4) {
                x = 0;
            }
        } else if (phoneType == 3) {
            x = 45;
            if (gameGrade == 2) {
                x -= 20;
            } else if (gameGrade == 3) {
                x -= 30;
            } else if (gameGrade == 4) {
                x = 0;
            }
        }
        if (gameViewLayout.getChildCount() > 0) {
            gameViewLayout.removeAllViews();
        }

        //填充扑克牌
        fillPoker();
        if (idList.size() < 5) {
            fillPoker();
        }
    }

    public void fillPoker() {
        int random = 0;
        int randomId = 0;
        int cardNum = pokerGame.getEachShowCardNum();
        for (int i = 0; i < cardNum & idList.size() < cardNum; i++) {
            random = (int) (Math.random() * (53 - 0)) + 0;//end结束的值，start开始的值
            randomId = pokerGroup[random];
            if (idList.contains(randomId)) {
                i--;
                continue;
            } else {
                idList.add(randomId);
            }


            ImageView imageView = new ImageView(PokerGameActivity.this);
            int pokerId = i == 0 ? ConstraintSet.PARENT_ID : idList.get(i - 1);
            Log.d(TAG, "pokerId positions" + pokerId);
            imageView.setImageResource(pokerGroup[random]);
            imageView.setId(randomId);

            constraintSet.clone(gameViewLayout);
            //右对右
            Log.d(TAG, "oldImageId = " + pokerId + "; newImageId = " + imageView.getId());
            constraintSet.constrainHeight(imageView.getId(), 1600);
            constraintSet.connect(imageView.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, x, getResources().getDisplayMetrics()));
            constraintSet.connect(imageView.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP);
            constraintSet.connect(imageView.getId(), ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM);
            gameViewLayout.addView(imageView);
            constraintSet.applyTo(gameViewLayout);
            Log.d(TAG, " imageView.getHeight()" + imageView.getHeight() + " imageView.getWidth()" + imageView.getWidth());
            if (gameGrade == 1) {
                x += 40;
            } else if (gameGrade == 2) {
                x += 25;
            } else if (gameGrade == 3) {
                x += 25;
            } else if (gameGrade == 4) {
                x += 22;
            }
            Log.d(TAG, "i=" + i + "size=" + idList.size());

        }
    }

    //将牌翻面
    public void answerPoker() {
        //将牌翻到背面
        ImageView imageView = null;
        for (int i = 0; i < pokerGame.getEachShowCardNum(); i++) {
            if (gameViewLayout.getChildAt(i) instanceof ImageView) {
                imageView = (ImageView) gameViewLayout.getChildAt(i);
                imageView.setImageResource(R.drawable.poker_back);
                imageView.setId(idList.get(i));
                ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) imageView.getLayoutParams();
                params.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 150, getResources().getDisplayMetrics());
                params.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 105, getResources().getDisplayMetrics());
                imageView.setLayoutParams(params);

            }
        }

        findViewById(R.id.circle_timer).setVisibility(View.GONE);       //隐藏计时器
        initSelectPokerBar();
    }

    //初始化花色栏switchPokerColor
    public void initSelectPokerBar() {

        pokerBar.setVisibility(View.VISIBLE);

        pokerBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.item_plum) {       //梅花
                    Log.d(TAG, "梅花");
                    /*adapter = new GridViewAdapter(getApplicationContext(), dayList);*/
                    pokerList = clubsPoker;
                } else if (menuItem.getItemId() == R.id.item_square) {
                    Log.d(TAG, "方块");
                    /*adapter = new GridViewAdapter(getApplicationContext(),diamondsPoker);*/
                    pokerList = diamondsPoker;
                } else if (menuItem.getItemId() == R.id.item_peach) {    //黑桃
                    /* adapter = new GridViewAdapter(getApplicationContext(),spadePoker);*/
                    pokerList = spadePoker;
                    Log.d(TAG, "黑桃");
                } else {  //红心
                    /* adapter = new GridViewAdapter(getApplicationContext(),heartsPoker);*/
                    pokerList = heartsPoker;
                    Log.d(TAG, "红心");
                }
                switchPoker();
                return false;
            }
        });
        switchPoker();     //初始化颜色选择工具栏
    }

    //选牌区
    public void switchPoker() {
        //显示选牌控件

        gridView.setVisibility(View.VISIBLE);
        int size = pokerList.size();
        int length = 40;
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        /*float density = dm.density;*/
        /*int gridviewWidth = (int) (size * (length+5) * density);  // GridView的宽度*/


        int itemWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 81, getResources().getDisplayMetrics());
        int gridviewWidth = 13 * itemWidth + (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 18, getResources().getDisplayMetrics());  // GridView的宽度
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(gridviewWidth, LinearLayout.LayoutParams.FILL_PARENT);
        gridView.setLayoutParams(params); // 设置GirdView布局参数,横向布局的关键
        gridView.setPadding(0, 0, 0, 0);
        gridView.setColumnWidth(itemWidth); // 设置列表项宽
        gridView.setHorizontalSpacing(5); // 设置列表项水平间距
        gridView.setStretchMode(GridView.NO_STRETCH);
        gridView.setNumColumns(size); // 设置列数量=列表集合数

        gridView.setOnItemClickListener(new PokerGridClickListenner());

        Log.d(TAG, "barcount" + adapter.getCount());
        adapter = new GridViewAdapter(getApplicationContext(), pokerList);
        gridView.setAdapter(adapter);
    }

    public class PokerGridClickListenner implements GridView.OnItemClickListener {

        private ImageView ts;
        private ImageView ts1;

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            int selectId = pokerList.get(i);

            for (int id : idList) {
                Log.d(TAG, "覆盖的牌id" + id);
            }
            Log.d(TAG, "你选择的id" + selectId);
            if (idList.get(answerCount) == selectId) {
                Log.d(TAG, "分数" + pokerGame.getScore());

               /* ts.setImageResource(selectId);
                ts1.setImageResource(idList.get(0));*/
                ((ImageView) findViewById(selectId)).setImageResource(selectId);
                answerCount++;
                if (answerCount == pokerGame.getEachShowCardNum()) {

                    if (currNum == 1) {        //游戏结束
                        Toast.makeText(PokerGameActivity.this, "游戏结束,您的分数是" + pokerGame.getScore() + "你记错了" + pokerGame.getJudgmentNum() + "张牌", Toast.LENGTH_SHORT).show();
                        GameInitiator.isOver=0;
                        showNormalDialog();
                    }
                    if(GameInitiator.isOver==0)
                        return;
                    idList.removeAll(idList);
                    nextPoker();
                    initView();
                }

            } else {
                pokerGame.setScore(pokerGame.getScore() - 10);
                pokerGame.setJudgmentNum(pokerGame.getJudgmentNum() + 1);
                if (pokerGame.getScore() < 10) {
                    Toast.makeText(PokerGameActivity.this, "游戏结束,您的分数是" + pokerGame.getScore() + "你记错了" + pokerGame.getJudgmentNum() + "张牌", Toast.LENGTH_SHORT).show();
                    /*finish();*/
                    GameInitiator.isOver = 0;   //结束游戏
                    showNormalDialog();
                }
            }
        }

    }

    //开始计时
    private void initView() {

        mCircleTimerView = (CircleTimerView) findViewById(R.id.circle_timer);
        Log.d(TAG, "second---"+pokerGame.getSecond());
        mCircleTimerView.setmTimeLength(pokerGame.getSecond());
        mCircleTimerView.setOnCountDownFinish(this);
        mCircleTimerView.start();
    }

    @Override
    public void onFinish() {
        /*nextPoker();*/
        answerPoker();
    }

    private void showNormalDialog() {
        /*
 @setIcon 设置对话框图标
         *
 @setTitle 设置对话框标题
         *
 @setMessage 设置对话框消息提示
         *
 setXXX方法返回Dialog对象，因此可以链式设置属性
         */
        final AlertDialog.Builder
                normalDialog =
                new AlertDialog.Builder(PokerGameActivity.this);
        normalDialog.setIcon(R.drawable.button_logo);
        normalDialog.setTitle("游戏结束");
        normalDialog.setMessage("得分："+ pokerGame.getScore()+"\n"+"记错的牌数："+pokerGame.getJudgmentNum()+"\n下次请再接再厉");
        normalDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        activity.finish();
                    }
                });
        normalDialog.setCancelable(false);
        normalDialog.show();
    }
}


