package assaf.zfani.parsingandasynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;
import java.security.spec.ECField;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    int result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView)findViewById(R.id.textView);
        Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }
    class NyLoader extends AsyncTask<String,String,Integer>
    {

        @Override
        protected Integer doInBackground(String... params) {
            String urlString = params[0];
            try {
                URL url = new URL(urlString);
            }catch (Exception e)
            {
                Log.i("ex","parse");
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            Toast.makeText(MainActivity.this,"Start Parsing",Toast.LENGTH_LONG).show();
            //super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Integer integer) {
            //get the info from doInBackground Method
            //super.onPostExecute(integer);
            Toast.makeText(MainActivity.this,"total "+result+" articles found",Toast.LENGTH_LONG).show();
        }

        @Override
        protected void onProgressUpdate(String... values) {
            //super.onProgressUpdate(values);
            tv.setText(tv.getText()+"..."+values[0]);
        }
    }
}
