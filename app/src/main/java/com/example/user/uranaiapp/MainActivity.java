package com.example.user.uranaiapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

// Activity: 画面
// メイン画面の制御
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // 入力された名前に対応するキー名(定数)
    public static final String INPUT_NAME = "InputName";
    //占いの結果の計算値に対応するキー名(定数)
    public static final String RESURT_NUMBER = "ResultNumber";

    public static final String ADD_NUMBER = "add_number";

    public static final String ABO_NUMBER = "abo_number";

    public static final String INPUT_ABO = "InputAbo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 継承元(AppCompatActivity)のonCreateメソッドを呼び出す
        super.onCreate(savedInstanceState);
        // activity_main.xmlを読み込んでいる→画面が表示
        setContentView(R.layout.activity_main);
        // Log(ログ): 履歴、情報を残す
        // System.out.printlnみたいなもの
        Log.d("LifeCycle", "onCreate");

        // レイアウト(activity_main.xml)より、「占う」ボタン(IDがmain_btn_divine)を取得
        Button divineBtn = (Button) findViewById(R.id.main_btn_divine);

        // 占うボタンにリスナーを設定
        // this: このクラス(MainActivity)
        divineBtn.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycle", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycle", "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycle", "onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle", "onDestroy");
    }
    // view: 押されたビュー(テキスト、ボタン等)の情報
    @Override
    public void onClick(View v) {
        // 「占う」ボタンが押された時の処理を書く

        // Intentクラスのオブジェクトを生成
        // this:このクラス(MainActivity)自身
        // ResultActivity.class: 遷移先のクラス
        Intent intent = new Intent(this, ResultActivity.class);

        // レイアウト(activity_main.xml)より、「占う」ボタン(IDがmain_btn_divine)を取得
        EditText etx = (EditText) findViewById(R.id.main_etx_name);

        // 入力されている名前を文字列(String)として取得
        // toString(): Editable→Stringへ変換

        String inputName = etx.getText().toString();

        // 遷移先に渡すデータをセット
        //1. 取り出す時に指定するデータ
        //2. 実際のデータ
        intent.putExtra(INPUT_NAME,inputName);

        //0-9までのランダムな値を生成する
        int resultNumber=new java.util.Random().nextInt(11);
        intent.putExtra(RESURT_NUMBER, resultNumber);

        int addNumber=new java.util.Random().nextInt(11);
        intent.putExtra(ADD_NUMBER, addNumber);

        int aboNumber = new java.util.Random().nextInt(10);
        intent.putExtra(ABO_NUMBER, aboNumber);

        String bloodType = "A型";
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.main_abc_group);
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.main_abc_a:
                bloodType = "A型";
                break;
            case R.id.main_abc_b:
                bloodType = "B型";
                break;
            case R.id.main_abo_o:
                bloodType = "O型";
                break;
            case R.id.main_abo_ab:
                bloodType = "AB型";
        }
        intent.putExtra(INPUT_ABO, bloodType);


        // 画面遷移開始
        startActivity(intent);
    }
}
